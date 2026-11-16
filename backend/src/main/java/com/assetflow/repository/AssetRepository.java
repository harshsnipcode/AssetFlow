package com.assetflow.repository;
import com.assetflow.entity.*;
import org.springframework.data.jpa.repository.*;
import java.util.*;
public interface AssetRepository extends JpaRepository<Asset, Long> {
    List<Asset> findByStatus(AssetStatus status);
    Optional<Asset> findByAssetTag(String assetTag);
}
