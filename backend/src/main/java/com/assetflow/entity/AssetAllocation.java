package com.assetflow.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.LocalDate;

@Entity @Table(name = "asset_allocations")
@Getter @Setter @NoArgsConstructor
public class AssetAllocation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) @ManyToOne(optional = false, fetch = FetchType.LAZY) private Asset asset;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) @ManyToOne(optional = false, fetch = FetchType.LAZY) private Employee employee;
    @Column(nullable = false) private LocalDate allocatedOn;
    private LocalDate expectedReturnDate;
    private LocalDate returnedOn;
}
