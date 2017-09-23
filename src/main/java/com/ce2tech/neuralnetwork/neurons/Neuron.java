package com.ce2tech.neuralnetwork.neurons;

import com.ce2tech.neuralnetwork.functions.IActivationFunction;

import java.util.ArrayList;
import java.util.Random;

public class Neuron {

    //FIELDS
    private final int WEIGHT_DIVIDER = 1;
    private IActivationFunction activationFunction;
    private int numberOfInputs;
    private ArrayList<Double> neuronInputs;
    protected ArrayList<Double> neuronWeights;
    protected double bias = 1.0;
    private double neuronOutput;

    //CONSTRUCTORS
    public Neuron(int numberOfInputs, IActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
        this.numberOfInputs = numberOfInputs;
        neuronWeights = new ArrayList<>(numberOfInputs+1);       //+1 because of bias
        neuronInputs = new ArrayList<>(numberOfInputs);

        init();
    }

    //METHODS
    public void init() {
        Random random = new Random();
        for (int i=0; i<=numberOfInputs; i++) {
            try {
                neuronWeights.set(i, random.nextDouble()/WEIGHT_DIVIDER);
            } catch (IndexOutOfBoundsException e) {
                neuronWeights.add(random.nextDouble()/WEIGHT_DIVIDER);
            }
        }
    }

    public double calcNeuronOutput() {
        double outputBeforeActivation = 0.0;

        for (int i = 0; i< neuronWeights.size(); i++) {
            outputBeforeActivation += neuronWeights.get(i) * (i==numberOfInputs ? bias : neuronInputs.get(i));
        }

        neuronOutput = activationFunction.calc(outputBeforeActivation);
        return neuronOutput;
    }

    //GETTERS, SETTERS
    public ArrayList<Double> getNeuronWeights() {
        return neuronWeights;
    }

    public void setNeuronWeights(ArrayList<Double> listOfWeight) {
        this.neuronWeights = listOfWeight;
    }

    public ArrayList<Double> getNeuronInputs() {
        return neuronInputs;
    }

    public void setNeuronInputs(ArrayList<Double> neuronInputs) {
        for (int i=0; i<numberOfInputs; i++) {
            try {
                this.neuronInputs.set(i, neuronInputs.get(i));
            } catch (IndexOutOfBoundsException e) {
                this.neuronInputs.add(neuronInputs.get(i));
            }
        }
    }

    public double getNeuronOutput() {
        return neuronOutput;
    }

    public IActivationFunction getActivationFunction() {
        return activationFunction;
    }

    public void setActivationFunction(IActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

}
