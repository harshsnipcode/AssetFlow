package com.assetflow.controller;
import com.assetflow.entity.AssetRequest;
import com.assetflow.service.AssetRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/asset-requests") @RequiredArgsConstructor
public class AssetRequestController {
    private final AssetRequestService service;
    @GetMapping public List<AssetRequest> all() { return service.all(); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public AssetRequest create(@RequestBody AssetRequest request) { return service.save(request); }
    @PutMapping("/{id}/approve") public AssetRequest approve(@PathVariable Long id) { return service.review(id, true); }
    @PutMapping("/{id}/reject") public AssetRequest reject(@PathVariable Long id) { return service.review(id, false); }
}
