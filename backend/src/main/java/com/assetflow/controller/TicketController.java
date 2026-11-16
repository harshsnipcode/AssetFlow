package com.assetflow.controller;
import com.assetflow.entity.*;
import com.assetflow.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController @RequestMapping("/api/tickets") @RequiredArgsConstructor
public class TicketController {
    private final TicketService service;
    @GetMapping public List<SupportTicket> all() { return service.all(); }
    @GetMapping("/{id}") public SupportTicket one(@PathVariable Long id) { return service.one(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public SupportTicket create(@RequestBody SupportTicket ticket) { return service.save(ticket); }
    @PutMapping("/{id}/status") public SupportTicket status(@PathVariable Long id, @RequestBody Map<String, String> body) { return service.updateStatus(id, TicketStatus.valueOf(body.get("status")), body.get("note")); }
}
