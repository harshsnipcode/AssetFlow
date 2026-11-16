package com.assetflow.service;
import com.assetflow.entity.AssetRequest;
import com.assetflow.exception.ResourceNotFoundException;
import com.assetflow.repository.AssetRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
@Service @RequiredArgsConstructor
public class AssetRequestService {
    private final AssetRequestRepository repository;
    public List<AssetRequest> all() { return repository.findAll(); }
    public AssetRequest one(Long id) { return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Request not found: " + id)); }
    public AssetRequest save(AssetRequest request) { return repository.save(request); }
    public AssetRequest review(Long id, boolean approve) { AssetRequest request = one(id); request.setStatus(approve ? com.assetflow.entity.RequestStatus.APPROVED : com.assetflow.entity.RequestStatus.REJECTED); request.setReviewedAt(LocalDateTime.now()); return repository.save(request); }
}
