package com.ce2tech.neuralnetwork.neurons;

import com.ce2tech.neuralnetwork.functions.Linear;

public class InputNeuron extends Neuron {

    //CONSTRUCTORS
    public InputNeuron() {
        super(1, new Linear());
        bias = 0.0;

        init();
    }

    //METHODS
    @Override
    public void init(){
        try{
            neuronWeights.set(0, 1.0);
            neuronWeights.set(1, 0.0);      //bias weight
        }
        catch(IndexOutOfBoundsException e){
            neuronWeights.add(1.0);
            neuronWeights.add(0.0);         //bias weight
        }
    }

}
