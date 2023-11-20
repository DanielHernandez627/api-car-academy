package com.manager_api.car.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "marcas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "sigla_resumida", nullable = false)
    private String sigla_resumida;

}
