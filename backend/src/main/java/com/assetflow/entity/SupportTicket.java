package com.assetflow.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name = "support_tickets", indexes = @Index(name = "idx_ticket_status", columnList = "status"))
@Getter @Setter @NoArgsConstructor
public class SupportTicket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false) private String subject;
    @Column(nullable = false, length = 3000) private String description;
    private String category;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private TicketPriority priority = TicketPriority.MEDIUM;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private TicketStatus status = TicketStatus.OPEN;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) @ManyToOne(optional = false, fetch = FetchType.LAZY) private Employee requester;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) @ManyToOne(fetch = FetchType.LAZY) private Employee assignee;
    @Column(length = 3000) private String resolutionNotes;
    @Column(nullable = false) private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
}
