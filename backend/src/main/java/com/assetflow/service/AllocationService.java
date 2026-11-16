package com.assetflow.service;

import com.assetflow.entity.*;
import com.assetflow.exception.ResourceNotFoundException;
import com.assetflow.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service @RequiredArgsConstructor
public class AllocationService {
    private final AssetAllocationRepository allocationRepository;
    private final AssetRepository assetRepository;
    private final EmployeeRepository employeeRepository;
    public List<AssetAllocation> all() { return allocationRepository.findAll(); }
    @Transactional
    public AssetAllocation allocate(Long assetId, Long employeeId, LocalDate expectedReturnDate) {
        Asset asset = assetRepository.findById(assetId).orElseThrow(() -> new ResourceNotFoundException("Asset not found: " + assetId));
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + employeeId));
        if (asset.getStatus() != AssetStatus.AVAILABLE) throw new IllegalArgumentException("Only available assets can be allocated.");
        asset.setStatus(AssetStatus.ASSIGNED);
        assetRepository.save(asset);
        AssetAllocation allocation = new AssetAllocation(); allocation.setAsset(asset); allocation.setEmployee(employee); allocation.setAllocatedOn(LocalDate.now()); allocation.setExpectedReturnDate(expectedReturnDate);
        return allocationRepository.save(allocation);
    }
    @Transactional
    public AssetAllocation returnAsset(Long id) {
        AssetAllocation allocation = allocationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Allocation not found: " + id));
        if (allocation.getReturnedOn() == null) { allocation.setReturnedOn(LocalDate.now()); allocation.getAsset().setStatus(AssetStatus.AVAILABLE); assetRepository.save(allocation.getAsset()); }
        return allocationRepository.save(allocation);
    }
}
