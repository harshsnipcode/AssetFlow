package com.assetflow.controller;
import com.assetflow.entity.AssetAllocation;
import com.assetflow.service.AllocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
@RestController @RequestMapping("/api/allocations") @RequiredArgsConstructor
public class AllocationController {
    private final AllocationService service;
    @GetMapping public List<AssetAllocation> all() { return service.all(); }
    @PostMapping public AssetAllocation allocate(@RequestBody Map<String, Object> body) { Long assetId = ((Number) body.get("assetId")).longValue(); Long employeeId = ((Number) body.get("employeeId")).longValue(); LocalDate expected = body.get("expectedReturnDate") == null ? null : LocalDate.parse(body.get("expectedReturnDate").toString()); return service.allocate(assetId, employeeId, expected); }
    @PutMapping("/{id}/return") public AssetAllocation returnAsset(@PathVariable Long id) { return service.returnAsset(id); }
}
