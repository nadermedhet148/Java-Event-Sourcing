package com.accountService.Rest.requests;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChangeBalanceRequest {
    private Integer userId;
    private Float newBalance;
}
