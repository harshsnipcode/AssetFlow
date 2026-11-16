package com.assetflow.repository;
import com.assetflow.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> { List<SupportTicket> findByStatus(TicketStatus status); }
