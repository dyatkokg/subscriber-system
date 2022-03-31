package me.dyatkokg.subscribersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Double balance;
}
