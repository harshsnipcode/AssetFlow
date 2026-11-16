package com.assetflow.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity @Table(name = "assets", indexes = @Index(name = "idx_asset_status", columnList = "status"))
@Getter @Setter @NoArgsConstructor
public class Asset {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(name = "asset_tag", nullable = false, unique = true) private String assetTag;
    @Column(nullable = false) private String name;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private AssetCategory category;
    private String brand;
    private String model;
    @Column(unique = true) private String serialNumber;
    private LocalDate purchaseDate;
    private BigDecimal purchasePrice;
    private LocalDate warrantyExpiry;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private AssetStatus status = AssetStatus.AVAILABLE;
    @Column(length = 1000) private String description;
}
