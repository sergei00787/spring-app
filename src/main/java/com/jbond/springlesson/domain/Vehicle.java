package com.jbond.springlesson.domain;

import lombok.*;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor()
@RequiredArgsConstructor
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Getter
    @NonNull
    private String vehName;
}
