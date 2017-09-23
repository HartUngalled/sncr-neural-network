package com.ce2tech.neuralnetwork.layers;

import com.ce2tech.neuralnetwork.neurons.Neuron;
import com.ce2tech.neuralnetwork.functions.IActivationFunction;

import java.util.ArrayList;

public abstract class NeuralLayer {

    //FIELDS
    private IActivationFunction layerActivationFunction;
    protected NeuralLayer previousLayer;
    protected NeuralLayer nextLayer;
    protected int numberOfNeuronsInLayer;
    protected ArrayList<Neuron> neuronsInLayer;
    protected int numberOfLayerNeuronsInputs;
    protected ArrayList<Double> layerNeuronsInputs;
    private ArrayList<Double> layerOutputs;

    //CONSTRUCTORS
    public NeuralLayer(int numberOfNeuronsInLayer, int numberOfNeuronsInputs, IActivationFunction layerActivationFunction) {
        this.numberOfLayerNeuronsInputs = numberOfNeuronsInputs;
        layerNeuronsInputs = new ArrayList<>(numberOfNeuronsInputs);
        this.numberOfNeuronsInLayer = numberOfNeuronsInLayer;
        neuronsInLayer = new ArrayList<>(numberOfNeuronsInLayer);
        layerOutputs = new ArrayList<>(numberOfNeuronsInLayer);
        this.layerActivationFunction = layerActivationFunction;

        init();
    }

    //METHODS
    public void init() {
        for (int i=0; i<numberOfNeuronsInLayer; i++) {
            try {
                neuronsInLayer.set(i, new Neuron(numberOfLayerNeuronsInputs, layerActivationFunction));
            } catch (IndexOutOfBoundsException e) {
                neuronsInLayer.add(new Neuron(numberOfLayerNeuronsInputs, layerActivationFunction));
            }
        }
    }

    public void calcLayerOutput() {
        for (int i=0; i<numberOfNeuronsInLayer; i++) {
            neuronsInLayer.get(i).calcNeuronOutput();
            try {
                layerOutputs.set(i, neuronsInLayer.get(i).getNeuronOutput());
            } catch (IndexOutOfBoundsException e) {
                layerOutputs.add(neuronsInLayer.get(i).getNeuronOutput());
            }
        }
    }

    @Override
    public String toString() {
        return "\n\tLayer activation function: " + layerActivationFunction +
                "\n\tNumber of neurons in layer: " + numberOfNeuronsInLayer +
                "\n\tLayer neurons inputs: " + layerNeuronsInputs +
                "\n\tLayer outputs: " + layerOutputs;
    }

    //GETTERS, SETTERS
    public int getNumberOfNeuronsInLayer() {
        return numberOfNeuronsInLayer;
    }

    public NeuralLayer getPreviousLayer() {
        return previousLayer;
    }

    public ArrayList<Double> getLayerOutputs() {
        return layerOutputs;
    }

    public void setPreviousLayer(NeuralLayer previousLayer) {
        this.previousLayer = previousLayer;
    }

    public void setNextLayer(NeuralLayer nextLayer) {
        this.nextLayer = nextLayer;
    }

    public void setLayerNeuronsInputs(ArrayList<Double> layerNeuronsInputs) {
        this.layerNeuronsInputs = layerNeuronsInputs;
        for (int i=0; i<numberOfNeuronsInLayer; i++) {
            neuronsInLayer.get(i).setNeuronInputs(layerNeuronsInputs);
        }
    }

    public ArrayList<Neuron> getNeuronsInLayer() {
        return neuronsInLayer;
    }
}
