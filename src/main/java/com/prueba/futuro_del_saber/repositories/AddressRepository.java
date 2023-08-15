package com.prueba.futuro_del_saber.repositories;

import com.prueba.futuro_del_saber.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}