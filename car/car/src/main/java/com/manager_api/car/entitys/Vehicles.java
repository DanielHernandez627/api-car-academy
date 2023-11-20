package com.manager_api.car.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "vehiculos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "id_marca", nullable = false)
    private Long id_marca;

    @Column(name = "numero_bastidor", nullable = false)
    private String numero_bastidor;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "precio", nullable = false)
    private int precio;

    @Column(name = "descuento", nullable = false)
    private int descuento;

    @Column(name = "info_adicional", nullable = false)
    private String info_adicional;

    @Column(name = "valor_adicional", nullable = false)
    private int valor_adicional;

    @Column(name = "placa", nullable = false)
    private String placa;

}
