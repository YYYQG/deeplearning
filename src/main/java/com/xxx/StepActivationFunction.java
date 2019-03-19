package com.xxx;

public class StepActivationFunction implements ActivationFunction{

    private double yAbove=1d;

    private double yBellow=0d;

    private double threshold=0d;

    @Override
    public double calculateOutput(double totalInput) {

        if(totalInput>=threshold){
            return yAbove;
        }
        return yBellow;
    }
}
