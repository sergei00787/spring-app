package com.jbond.springlesson.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.Parent;

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
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy'T'HH:mm:ss")
    private LocalDateTime time;

    @NonNull
    @Column(nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy'T'HH:mm:ss")
    private LocalDateTime timeCreate;

    @NonNull
    @Column(nullable = false)
    private String eventDescription;

    @NonNull
    @ManyToOne(optional = false)
    private Vehicle vehicle;

    @NonNull
    @ManyToOne(optional = false)
    private EventType eventType;

}
