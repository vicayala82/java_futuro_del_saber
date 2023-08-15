package com.prueba.futuro_del_saber.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @Column(name ="ID")
    private Long id;

    @Column(name = "CITY", length = 100)
    private String city;

    @Column(name = "ADDRESS",length = 100)
    private String address;
}
