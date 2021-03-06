package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class FifthTask {
    public static <K> Map<K, Integer> countValues(K[] ks) {
        Map<K, Integer> map = new HashMap<>();
        for (K k : ks)
        {
            map.compute(k, (k1, count) -> count == null ? 1 : count +1);
        }
        return map;
    }
}
