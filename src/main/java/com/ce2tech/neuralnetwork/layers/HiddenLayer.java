package com.ce2tech.neuralnetwork.layers;

import com.ce2tech.neuralnetwork.functions.IActivationFunction;

public class HiddenLayer extends NeuralLayer {

    //CONSTRUCTORS
    public HiddenLayer(int numberOfNeuronsInLayer, int numberOfNeuronsInputs, IActivationFunction layerActivationFunction) {
        super(numberOfNeuronsInLayer, numberOfNeuronsInputs, layerActivationFunction);

        init();
    }

}
