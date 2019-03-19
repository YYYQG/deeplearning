package com.xxx;

/**
 * Represents a connection between two neurons an the associated weight.
 * 表示两个神经元之间的连接以及相关的权重
 */
public class NeuronsConnection {
    /**
     * From neuron for this connection (source neuron). This connection is
     * output connection for from neuron.
     * 从神经元中获取这个连接(源神经元)。此连接是来自神经元的输出连接
     */
    protected Neuron fromNeuron;
    /**
     * To neuron for this connection (target, destination neuron) This
     * connection is input connection for to neuron.
     * 对于用于此连接的神经元(目标，目标神经元)，此连接是神经元的输入连接
     */
    protected Neuron toNeuron;
    /**
     * Connection weight
     * 连接权重
     */
    protected double weight;
    /**
     * Creates a new connection between specified neurons with random weight.
     * 在具有随机权重的指定神经元之间创建一个新的连接
     * @param fromNeuron
     *            neuron to connect from
     * @param toNeuron
     *            neuron to connect to
     */
    public NeuronsConnection(Neuron fromNeuron, Neuron toNeuron) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;
        this.weight = Math.random();
    }
    /**
     * Creates a new connection to specified neuron with specified weight object
     * 创建与指定权重对象的指定神经元的新连接
     *
     * @param fromNeuron
     *            neuron to connect from
     * @param toNeuron
     *            neuron to connect to
     * @param weight
     *            weight for this connection
     */
    public NeuronsConnection(Neuron fromNeuron, Neuron toNeuron, double weight) {
        this(fromNeuron, toNeuron);
        this.weight = weight;
    }
    /**
     * Returns weight for this connection
     * 返回此连接的权重
     * @return weight for this connection
     */
    public double getWeight() {
        return weight;
    }
    /**
     * Set the weight of the connection.
     * 设置连接的权值
     * @param weight
     *            The new weight of the connection to be set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
    /**
     * Returns input of this connection - the activation function result
     * calculated in the input neuron of this connection.
     * 返回此连接的输入 - 在此连接输入神经元中激活函数计算的结果
     * @return input received through this connection
     */
    public double getInput() {
        return fromNeuron.calculateOutput();
    }
    /**
     * Returns the weighted input of this connection
     * 返回此连接的权值输入
     * @return weighted input of the connection
     */
    public double getWeightedInput() {
        return fromNeuron.calculateOutput() * weight;
    }
    /**
     * Gets from neuron for this connection
     * 从神经元获取此连接
     * @return from neuron for this connection
     */
    public Neuron getFromNeuron() {
        return fromNeuron;
    }
    /**
     * Gets to neuron for this connection
     * 获取用于此连接的神经元
     * @return neuron to set as to neuron
     */
    public Neuron getToNeuron() {
        return toNeuron;
    }

}