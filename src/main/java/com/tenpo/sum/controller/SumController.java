package com.tenpo.sum.controller;

import com.tenpo.sum.dto.Sum;
import com.tenpo.sum.service.SumService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("sumController")
@RequestMapping("/sum")
@RateLimiter(name = "sumRateLimit")
public class SumController {

    @Autowired
    private SumService sumService;

    @GetMapping
    public Sum getSum(
            @RequestParam("first") double first,
            @RequestParam("second") double second) {

        return sumService.sumAddingFee(first, second);
    }
}
