package me.dyatkokg.subscribersystem.mapper;

import me.dyatkokg.subscribersystem.dto.SubscriberDTO;
import me.dyatkokg.subscribersystem.entity.Subscriber;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubscriberMapper {


    @Mapping(source = "subscriberBalance.balance",target = "balance")
    @Mapping(source = "subscriberBalance.tariff.name", target = "tariff")
    SubscriberDTO toDTO(Subscriber subscriber);


    @Mapping(source = "balance",target = "subscriberBalance.balance")
    @Mapping(source = "tariff", target = "subscriberBalance.tariff.name")
    Subscriber toEntity(SubscriberDTO subscriberDTO);
}
