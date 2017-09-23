package com.ce2tech.neuralnetwork.functions;

public class Linear implements IActivationFunction {

    //FIELDS
    private double a;

    //CONSTRUCTORS
    public Linear() {
        a = 1.0;
    }

    public Linear(double aConst) {
        a = aConst;
    }

    //METHODS
    @Override
    public double calc(double x) {
        return a*x;
    }

    @Override
    public String toString() {
        return "Linear function, a=" + a;
    }
}
