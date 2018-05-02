package com.coinage.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Coinage {
    private String currency;
    private String code;
    private Double mid;
}
