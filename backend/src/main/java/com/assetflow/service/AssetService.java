package com.assetflow.service;

import com.assetflow.entity.*;
import com.assetflow.exception.ResourceNotFoundException;
import com.assetflow.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class AssetService {
    private final AssetRepository repository;
    public List<Asset> all() { return repository.findAll(); }
    public List<Asset> available() { return repository.findByStatus(AssetStatus.AVAILABLE); }
    public Asset one(Long id) { return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Asset not found: " + id)); }
    public Asset save(Asset asset) { return repository.save(asset); }
    public void delete(Long id) { repository.delete(one(id)); }
}
