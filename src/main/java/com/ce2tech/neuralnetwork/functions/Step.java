package com.ce2tech.neuralnetwork.functions;

public class Step implements IActivationFunction {

    //FIELDS
    private double treshold;

    //CONSTRUCTORS
    public Step() {
        treshold = 0.0;
    }

    public Step(double treshold) {
        this.treshold = treshold;
    }

    //METHODS
    @Override
    public double calc(double x) {
        return (x < treshold) ? 0 : 1;
    }

    @Override
    public String toString() {
        return "Step function, treshold=" + treshold;
    }
}
