package com.github.jactorrises.junit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PocBean {
    private final PocApi pocMock;

    public PocBean(PocApi pocMock) {
        this.pocMock = pocMock;
    }

    Integer doStuff(String action) {
        return pocMock.doStuff(action.toUpperCase());
    }

    List<String> doStuff(PocEnum pocEnum) {
        if (pocEnum == PocEnum.NOT_SUPPORTED) {
            throw new IllegalArgumentException(pocEnum.name());
        }

        return Stream.of(pocEnum.getAcronyms()).collect(Collectors.toList());
    }
}
