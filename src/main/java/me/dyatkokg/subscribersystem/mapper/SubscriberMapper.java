package me.dyatkokg.subscribersystem.mapper;

import me.dyatkokg.subscribersystem.dto.SubscriberDTO;
import me.dyatkokg.subscribersystem.entity.Subscriber;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubscriberMapper {

    @Mapping(source = "balance.tariff.name", target = "balance")
    SubscriberDTO toDTO(Subscriber subscriber);


    @Mapping(target = "balance", ignore = true)
    Subscriber toEntity(SubscriberDTO subscriberDTO);
}
