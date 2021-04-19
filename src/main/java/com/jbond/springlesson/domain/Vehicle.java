package com.jbond.springlesson.domain;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle {
    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Getter
    @NonNull
    private String vehName;
}
