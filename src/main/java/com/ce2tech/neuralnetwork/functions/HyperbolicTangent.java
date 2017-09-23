package com.ce2tech.neuralnetwork.functions;

import static java.lang.Math.exp;

public class HyperbolicTangent implements IActivationFunction {

    //FIELDS
    private double a;

    //CONSTRUCTORS
    public HyperbolicTangent() {
        a = 1.0;
    }

    public HyperbolicTangent(double aConst) {
        a = aConst;
    }

    //METHODS
    @Override
    public double calc(double x) {
        return (1-exp(-a*x))/(1+exp(-a*x));
    }

    @Override
    public String toString() {
        return "Hyperbolic tangent function, a=" + a;
    }
}
