package com.xxx;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Neuron  {

    /*
    神经元标识符
     */
    private String id;
    /*
    神经元输入连接集合
     */
    protected List<NeuronsConnection> inputConnects;

    /*
    神经元输出连接集合
     */
    protected List<NeuronsConnection> outputConnects;

    /*
    该神经元的输入和函数
     */

    protected InputSummingFunction inputSummingFunction;

    /*
    这个神经元的激活函数
     */
    protected ActivationFunction activationFunction;

    public Neuron(){
        this.inputConnects=new ArrayList<>();
        this.outputConnects=new ArrayList<>();
    }

    /*
    计算神经元输出
     */
    public double calculateOutput(){

        double totalInput=inputSummingFunction.collectOutput(inputConnects);
        return activationFunction.calculateOutput(totalInput);
    }


}
