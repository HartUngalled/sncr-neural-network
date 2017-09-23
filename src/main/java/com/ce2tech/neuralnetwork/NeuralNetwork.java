package com.ce2tech.neuralnetwork;

import com.ce2tech.neuralnetwork.functions.IActivationFunction;
import com.ce2tech.neuralnetwork.layers.HiddenLayer;
import com.ce2tech.neuralnetwork.layers.InputLayer;
import com.ce2tech.neuralnetwork.layers.OutputLayer;

import java.util.ArrayList;

public class NeuralNetwork {

    //FIELDS
    private InputLayer inputLayer;
    private ArrayList<HiddenLayer> hiddenLayers;
    private OutputLayer outputLayer;
    private int numberOfNetworkInputs;
    private int numberOfHiddenLayers;
    private int numberOfNetworkOutputs;
    private ArrayList<Double> networkInputs;
    private ArrayList<Double> networkOutputs;

    //CONSTRUCTORS
    public NeuralNetwork(   int numberOfNetworkInputs,
                            int[] numberOfHiddenNeurons,
                            int numberOfNetworkOutputs,
                            IActivationFunction[] hiddenActivationFunction,
                            IActivationFunction outputActivationFunction    ) {

        this.numberOfNetworkInputs = numberOfNetworkInputs;
        this.numberOfNetworkOutputs = numberOfNetworkOutputs;
        numberOfHiddenLayers = numberOfHiddenNeurons.length;
        networkInputs = new ArrayList<>(numberOfNetworkInputs);

        inputLayer = new InputLayer(numberOfNetworkInputs);

        hiddenLayers = new ArrayList<>(numberOfHiddenLayers);
        for (int i=0; i<numberOfHiddenLayers; i++) {
            if (i==0) {
                HiddenLayer hiddenLayer = new HiddenLayer(  numberOfHiddenNeurons[i],
                                                            inputLayer.getNumberOfNeuronsInLayer(),
                                                            hiddenActivationFunction[i] );
                hiddenLayers.add(i, hiddenLayer);
                hiddenLayer.setPreviousLayer(inputLayer);
                inputLayer.setNextLayer(hiddenLayer);
            } else {
                HiddenLayer hiddenLayer = new HiddenLayer(  numberOfHiddenNeurons[i],
                                                            numberOfHiddenNeurons[i-1],
                                                            hiddenActivationFunction[i] );
                hiddenLayers.add(i, hiddenLayer);
                hiddenLayer.setPreviousLayer(hiddenLayers.get(i-1));
                hiddenLayers.get(i-1).setNextLayer(hiddenLayer);
            }
        }

        if (numberOfHiddenLayers>0) {
            outputLayer = new OutputLayer(  numberOfNetworkOutputs,
                                            numberOfHiddenNeurons[numberOfHiddenNeurons.length-1],
                                            outputActivationFunction    );
            outputLayer.setPreviousLayer(hiddenLayers.get(numberOfHiddenLayers-1));
            hiddenLayers.get(numberOfHiddenLayers-1).setNextLayer(outputLayer);
        } else {
            outputLayer = new OutputLayer(  numberOfNetworkOutputs,
                                            numberOfNetworkInputs,
                                            outputActivationFunction    );
            outputLayer.setPreviousLayer(inputLayer);
            inputLayer.setNextLayer(outputLayer);
        }

    }
    //METHODS
    public ArrayList<Double> calc() {
        inputLayer.setLayerNeuronsInputs(networkInputs);
        inputLayer.calcLayerOutput();

        for (int i=0; i<numberOfHiddenLayers; i++) {
            HiddenLayer hiddenLayer = hiddenLayers.get(i);
            hiddenLayer.setLayerNeuronsInputs(hiddenLayer.getPreviousLayer().getLayerOutputs());
            hiddenLayer.calcLayerOutput();
        }

        outputLayer.setLayerNeuronsInputs(outputLayer.getPreviousLayer().getLayerOutputs());
        outputLayer.calcLayerOutput();

        networkOutputs = outputLayer.getLayerOutputs();
        return networkOutputs;
    }

    @Override
    public String toString() {
        return "Neural Network" +
                "\nInputLayer : " + inputLayer +
                "\nHidden Layers: " + hiddenLayers +
                "\nOutput Layer: " + outputLayer;
    }

    //GETTERS, SETTERS
    public void setNetworkInputs(ArrayList<Double> networkInputs) {
        this.networkInputs = networkInputs;
    }

    public ArrayList<Double> getNetworkOutputs() {
        return networkOutputs;
    }
}
