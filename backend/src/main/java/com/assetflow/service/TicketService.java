package com.assetflow.service;

import com.assetflow.entity.*;
import com.assetflow.exception.ResourceNotFoundException;
import com.assetflow.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service @RequiredArgsConstructor
public class TicketService {
    private final SupportTicketRepository tickets;
    private final TicketHistoryRepository history;
    public List<SupportTicket> all() { return tickets.findAll(); }
    public SupportTicket one(Long id) { return tickets.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket not found: " + id)); }
    public SupportTicket save(SupportTicket ticket) { return tickets.save(ticket); }
    @Transactional public SupportTicket updateStatus(Long id, TicketStatus status, String note) { SupportTicket ticket = one(id); ticket.setStatus(status); ticket.setUpdatedAt(LocalDateTime.now()); tickets.save(ticket); TicketHistory event = new TicketHistory(); event.setTicket(ticket); event.setStatus(status); event.setNote(note); history.save(event); return ticket; }
}
