package com.tpe.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30,nullable = false)
    private String brand;

    @Column(length = 30,nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer doors;

    @Column(nullable = false)
    private Double pricePerHour;

    @Column(nullable = false)
    private Integer age;






}
