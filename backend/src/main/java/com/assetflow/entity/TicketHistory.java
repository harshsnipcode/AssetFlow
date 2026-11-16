package com.assetflow.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name = "ticket_history")
@Getter @Setter @NoArgsConstructor
public class TicketHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) @ManyToOne(optional = false, fetch = FetchType.LAZY) private SupportTicket ticket;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private TicketStatus status;
    private String note;
    @Column(nullable = false) private LocalDateTime changedAt = LocalDateTime.now();
}
