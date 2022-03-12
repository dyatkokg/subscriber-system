package me.dyatkokg.subscribersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String tariff;
    private BigDecimal balance;
}
