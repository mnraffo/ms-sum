package com.tenpo.sum.filter;

import com.tenpo.sum.model.AuditLog;
import com.tenpo.sum.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuditLogFilter extends OncePerRequestFilter {

    @Autowired
    private AuditLogService auditLogService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

        filterChain.doFilter(wrappedRequest, wrappedResponse);

        String requestRemoteAddress = request.getRemoteAddr();
        String requestMethod = request.getMethod();
        String requestUri = request.getRequestURI();
        int requestStatus = response.getStatus();
        String requestBody = new String(wrappedRequest.getContentAsByteArray(), wrappedRequest.getCharacterEncoding());
        String responseBody = new String(wrappedResponse.getContentAsByteArray(), wrappedResponse.getCharacterEncoding());

        auditLogService.log(requestRemoteAddress, requestMethod, requestUri, requestStatus, requestBody, responseBody);
        wrappedResponse.copyBodyToResponse();
    }
}
