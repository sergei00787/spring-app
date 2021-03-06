package com.jbond.springlesson.domain;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @NonNull
    private String name;
}
