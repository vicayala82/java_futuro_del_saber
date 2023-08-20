package com.prueba.futuro_del_saber.dto;

import com.prueba.futuro_del_saber.entities.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long id;
    private String city;
    private String address;

    public static AddressDTO convertToDTO(AddressEntity addressEntity){
        return AddressDTO.builder()
                .id(addressEntity.getId())
                .city(addressEntity.getCity())
                .address(addressEntity.getAddress())
                .build();
    }

    public static AddressEntity convertToEntity(AddressDTO addressDTO) {
        return AddressEntity.builder()
                .id(addressDTO.getId())
                .city(addressDTO.getCity())
                .address(addressDTO.getAddress())
                .build();
    }
}
