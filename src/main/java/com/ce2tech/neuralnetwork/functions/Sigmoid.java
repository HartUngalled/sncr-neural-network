package com.ce2tech.neuralnetwork.functions;

import static java.lang.Math.exp;

public class Sigmoid implements IActivationFunction {

    //FIELDS
    private double a;

    //CONSTRUCTORS
    public Sigmoid() {
        a = 1.0;
    }

    public Sigmoid (double aConst) {
        a = aConst;
    }

    //METHODS
    @Override
    public double calc(double x) {
        return 1.0/( 1.0+exp(-a*x) );
    }

    @Override
    public String toString() {
        return "Sigmoid function, a=" + a;
    }
}
