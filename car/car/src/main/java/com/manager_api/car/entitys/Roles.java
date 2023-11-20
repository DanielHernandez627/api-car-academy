package com.manager_api.car.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles_usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

}
