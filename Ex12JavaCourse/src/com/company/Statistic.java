package com.company;

import java.util.Set;
import java.util.TreeMap;

public interface Statistic {
    public class Statistics
    {
        public int count;
        public double frequency;
        public Statistics()
        {
            count = 0;
            frequency = 0;
        }
    }
    public TreeMap<String,Statistic> getMap();
    public String selectMaxFreqToken( Set<String> tokens );

}
