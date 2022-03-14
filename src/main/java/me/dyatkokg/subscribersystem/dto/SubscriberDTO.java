package me.dyatkokg.subscribersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String tariff;
    private Double balance;
}
