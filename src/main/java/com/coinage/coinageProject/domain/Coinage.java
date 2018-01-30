package com.coinage.coinageProject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Coinage {
    private String currency;
    private String code;
    private Double mid;
}
