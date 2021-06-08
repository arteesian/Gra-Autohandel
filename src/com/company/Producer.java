package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Producer {
    VOLKSWAGEN,
    AUDI,
    MERCEDES,
    BMW,
    FIAT,
    FERRARI,
    KIA,
    BUGATTI,
    CHEVROLET,
    FORD;

    private static final List<Producer> values = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int size = values.size();
    private static final Random random = new Random();

    public static Producer randomProducer(){
        return values.get(random.nextInt(size));
    }
}
