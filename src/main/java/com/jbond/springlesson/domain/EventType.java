package com.jbond.springlesson.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @NonNull
    private String name;
}
