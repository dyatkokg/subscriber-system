package me.dyatkokg.subscribersystem.mapper;

import me.dyatkokg.subscribersystem.dto.SubscriberDTO;
import me.dyatkokg.subscribersystem.entity.Subscriber;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubscriberMapper {

    @Mapping(source = "subscriberBalance.tariff.name", target = "tariff")
    @Mapping(source = "subscriberBalance.balance",target = "balance")
    SubscriberDTO toDTO(Subscriber subscriber);


    @Mapping(target = "subscriberBalance", ignore = true)
    Subscriber toEntity(SubscriberDTO subscriberDTO);
}
