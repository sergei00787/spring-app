package com.jbond.springlesson.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EventHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    @Column
    private LocalDateTime time;

    @Getter
    @Setter
    @Column
    private LocalDateTime timeCreate;

    @Getter
    @Setter
    @Column
    private String eventDescription;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private EventType eventType;

}
