package com.coinage.project.structure;

import com.coinage.project.domain.Coinage;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OuterObj {
    private List<Coinage> rates = new ArrayList<>();
}
