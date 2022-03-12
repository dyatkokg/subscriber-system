package me.dyatkokg.subscribersystem.repository;

import me.dyatkokg.subscribersystem.entity.Subscriber;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubscriberRepository extends PagingAndSortingRepository<Subscriber,Long> {
}
