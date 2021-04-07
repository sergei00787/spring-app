package com.jbond.springlesson.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class EventHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private LocalDateTime time;

    @NonNull
    @Column(nullable = false)
    private LocalDateTime timeCreate;

    @NonNull
    @Column(nullable = false)
    private String eventDescription;

    @NonNull
    @ManyToOne
    private Vehicle vehicle;

    @NonNull
    @ManyToOne
    private EventType eventType;

}
