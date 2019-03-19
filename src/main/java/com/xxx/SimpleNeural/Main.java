package com.xxx.SimpleNeural;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        NeuralNet neuralNet = new NeuralNet(0.001);
        List<NeuralNet.Data> exercise = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            Random random = new Random();
            double x1 = random.nextDouble();
            double x2 = random.nextDouble();
            double[] data = {x1,x2};
            NeuralNet.Data d =  neuralNet.new Data(data,2,x2 > x1+0.5 ? 1 : -1);
            exercise.add(d);
        }

        neuralNet.input(exercise);
        neuralNet.fit();
        neuralNet.showWeights();
    }
}
