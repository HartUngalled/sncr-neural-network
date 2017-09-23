package com.ce2tech.neuralnetwork.layers;

import com.ce2tech.neuralnetwork.functions.IActivationFunction;

public class OutputLayer extends NeuralLayer {

    //CONSTRUCTORS
    public OutputLayer(int numberOfNeuronsInLayer, int numberOfNeuronsInputs, IActivationFunction layerActivationFunction) {
        super(numberOfNeuronsInLayer, numberOfNeuronsInputs, layerActivationFunction);
        nextLayer = null;

        init();
    }

}
