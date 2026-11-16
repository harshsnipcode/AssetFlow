package com.assetflow.repository;
import com.assetflow.entity.AssetAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AssetAllocationRepository extends JpaRepository<AssetAllocation, Long> { List<AssetAllocation> findByReturnedOnIsNull(); }
