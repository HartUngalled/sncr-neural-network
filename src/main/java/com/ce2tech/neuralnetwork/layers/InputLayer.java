package com.ce2tech.neuralnetwork.layers;

import com.ce2tech.neuralnetwork.neurons.InputNeuron;
import com.ce2tech.neuralnetwork.functions.Linear;

import java.util.ArrayList;

public class InputLayer extends NeuralLayer {

    //CONSTRUCTORS
    public InputLayer(int numberOfNeuronsInLayer) {
        super(numberOfNeuronsInLayer, numberOfNeuronsInLayer, new Linear(1.0));
        previousLayer = null;

        init();
    }

    //METHODS
    @Override
    public void init() {
        for (int i=0; i<numberOfNeuronsInLayer; i++) {
            try {
                neuronsInLayer.set(i, new InputNeuron());
            } catch (IndexOutOfBoundsException e) {
                neuronsInLayer.add(new InputNeuron());
            }
        }
    }

    @Override
    public void setLayerNeuronsInputs(ArrayList<Double> layerInputs) {
        for (int i = 0; i< numberOfLayerNeuronsInputs; i++) {
            try {
                layerNeuronsInputs.set(0, layerInputs.get(i));
            } catch (IndexOutOfBoundsException e) {
                layerNeuronsInputs.add(layerInputs.get(i));
            }
            neuronsInLayer.get(i).setNeuronInputs(layerNeuronsInputs);
        }
    }

}
