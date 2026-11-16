package com.assetflow.repository;
import com.assetflow.entity.TicketHistory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TicketHistoryRepository extends JpaRepository<TicketHistory, Long> {}
