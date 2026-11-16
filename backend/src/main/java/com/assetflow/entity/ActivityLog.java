package com.assetflow.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name = "activity_logs")
@Getter @Setter @NoArgsConstructor
public class ActivityLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false) private String action;
    private String entityType;
    private Long entityId;
    @Column(nullable = false) private LocalDateTime createdAt = LocalDateTime.now();
}
