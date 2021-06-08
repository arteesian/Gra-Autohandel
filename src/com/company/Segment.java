package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Segment {
    BUDGET,
    STANDARD,
    PREMIUM,
    TRUCK;

    private static final List<Segment> values = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int size = values.size();
    private static final Random random = new Random();

    public static Segment randomSegment(){
        Double probability = random.nextDouble();
        if(probability >= 0.0 && probability < 0.35){
            return BUDGET;
        }
        if(probability >= 0.35 && probability < 0.7){
            return STANDARD;
        }
        if(probability >= 0.7 && probability < 0.85){
            return PREMIUM;
        }
        if(probability >= 0.85 && probability <= 1){
            return TRUCK;
        }
        return null;
    }
}
