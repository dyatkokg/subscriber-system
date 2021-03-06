package me.dyatkokg.subscribersystem.mapper;

import me.dyatkokg.subscribersystem.dto.TariffDTO;
import me.dyatkokg.subscribersystem.entity.Tariff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TariffMapper {

    @Mapping(source = "name", target = "name")
    TariffDTO toDTO(Tariff tariff);

    @Mapping(source = "price",target = "price")
    Tariff toEntity(TariffDTO tariffDTO);

}
