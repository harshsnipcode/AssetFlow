package com.assetflow.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name = "asset_requests")
@Getter @Setter @NoArgsConstructor
public class AssetRequest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) @ManyToOne(optional = false, fetch = FetchType.LAZY) private Employee requester;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private AssetCategory category;
    @Column(length = 1000) private String reason;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private RequestStatus status = RequestStatus.PENDING;
    @Column(nullable = false) private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime reviewedAt;
}
