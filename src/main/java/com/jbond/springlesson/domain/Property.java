package com.jbond.springlesson.domain;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Property {
    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Getter
    @NonNull
    private String propName;

    @Setter
    @Getter
    @NonNull
    private String propType;



}
