package com.tenpo.sum.repository;

import com.tenpo.sum.model.AuditLog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends PagingAndSortingRepository<AuditLog, Long> {
}
