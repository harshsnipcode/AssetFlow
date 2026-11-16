package com.assetflow.controller;
import com.assetflow.entity.AssetStatus;
import com.assetflow.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/dashboard") @RequiredArgsConstructor
public class DashboardController {
    private final EmployeeRepository employees; private final AssetRepository assets; private final SupportTicketRepository tickets; private final AssetRequestRepository requests;
    @GetMapping("/stats") public Map<String, Long> stats() { return Map.of("employees", employees.count(), "assets", assets.count(), "availableAssets", (long) assets.findByStatus(AssetStatus.AVAILABLE).size(), "openTickets", (long) tickets.findByStatus(com.assetflow.entity.TicketStatus.OPEN).size(), "assetRequests", requests.count()); }
}
