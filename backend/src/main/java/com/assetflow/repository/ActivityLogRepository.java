package com.assetflow.repository;
import com.assetflow.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {}
