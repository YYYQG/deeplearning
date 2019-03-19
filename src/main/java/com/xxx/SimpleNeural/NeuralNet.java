package com.xxx.SimpleNeural;

import java.util.Arrays;
import java.util.List;

public class NeuralNet {


    private double learnRate;
    private List<Data> exercise;
    private double w0 = 0;
    private double x0 = 1;
    private double[] weights;
    private int error = 0;

    NeuralNet(double learnRate) {
        this.learnRate = learnRate;
    }


    public void input(List<Data> exercise) {

        this.exercise = exercise;
        weights = new double[exercise.get(0).dimention + 1];
        weights[0] = w0;

    }


    public void fit() {

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < exercise.size(); j++) {

                int realResult = exercise.get(j).type;
                int calculateResult = calculateResult(exercise.get(j));
                double rate = learnRate * (realResult - calculateResult);
                w0 = w0 + rate;
                weights[0] = w0;
                for (int k = 0; k < exercise.get(j).dimention; k++) {
                    double ra = learnRate * (realResult - calculateResult) * exercise.get(j).vector[k];
                    weights[k + 1] = weights[k + 1] + ra;
                }

            }
        }
    }

    public void predict(Data data) {
        int result = calculateResult(data);
        if (result == data.getType()) {

        } else {
            error++;
        }

    }

    public void showWeights() {
        for (double w : weights)
            System.out.println(w);
    }

    private int calculateResult(Data data) {

        double z = w0 * x0;
        for (int i = 0; i < data.dimention; i++) {
            z = z + data.vector[i] * weights[i + 1];
        }
        if (z >= 0)
            return 1;
        else
            return -1;

    }

    class Data {

        private double[] vector;
        private int dimention;
        private int type;

        public double[] getVector() {
            return vector;
        }

        public void setVector(double[] vector) {
            this.vector = vector;
        }

        public int getDimention() {
            return dimention;
        }

        public void setDimention(int dimention) {
            this.dimention = dimention;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Data(double[] vector, int dimention, int type) {
            super();
            this.vector = vector;
            this.dimention = dimention;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "vector=" + Arrays.toString(vector) +
                    ", dimention=" + dimention +
                    ", type=" + type +
                    '}';
        }
    }


}
