package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Color {
    WHITE,
    BLACK,
    GREY,
    RED,
    BLUE,
    YELLOW,
    BROWN,
    GREEN;

    private static final List<Color> values = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int size = values.size();
    private static final Random random = new Random();

    public static Color randomColor(){
        return values.get(random.nextInt(size));
    }
}
