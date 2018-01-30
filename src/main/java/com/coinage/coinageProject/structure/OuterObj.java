package com.coinage.coinageProject.structure;

import com.coinage.coinageProject.domain.Coinage;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OuterObj {
    private String table;

    private List<Coinage> rates = new ArrayList<>();
}
