package com.manager_api.car.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_documentos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class typeDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "sigla", nullable = false)
    private String sigla;

    @Column(name = "estado", nullable = false)
    private int estado;
}
