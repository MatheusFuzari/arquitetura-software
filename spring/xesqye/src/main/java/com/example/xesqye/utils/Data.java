package com.example.xesqye.utils;

import java.math.BigDecimal;
import java.util.Objects;

public class Data {

    public static BigDecimal nullSafe(BigDecimal input){
        return Objects.isNull(input) ? BigDecimal.ZERO : input;
    }
}

