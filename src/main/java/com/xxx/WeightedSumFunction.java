package com.xxx;

import java.sql.Connection;
import java.util.List;

public class WeightedSumFunction implements InputSummingFunction{
    @Override
    public double collectOutput(List<NeuronsConnection> inputConnections) {
        double weightedSum = 0d;
        for (NeuronsConnection connection : inputConnections) {
            weightedSum += connection.getWeightedInput();
        }
        return weightedSum;
    }
}
