package com.ce2tech.neuralnetwork;

import com.ce2tech.neuralnetwork.functions.IActivationFunction;
import com.ce2tech.neuralnetwork.functions.Linear;
import com.ce2tech.neuralnetwork.functions.Sigmoid;

import java.util.ArrayList;

public class ConsoleTest {
    public static void main(String[] args) {

        int numberOfNetworkInputs = 2;
        int [] numberOfHiddenNeurons = {3};
        int numberOfNetworkOutputs = 1;
        IActivationFunction[] hiddenActivationFunctions = {new Sigmoid()};
        IActivationFunction outputActivationFunction = new Linear();

        ArrayList<Double> nnInputs = new ArrayList<>(2);
        nnInputs.add(3.0);
        nnInputs.add(2.0);


        NeuralNetwork nn = new NeuralNetwork(   numberOfNetworkInputs,
                                                numberOfHiddenNeurons,
                                                numberOfNetworkOutputs,
                                                hiddenActivationFunctions,
                                                outputActivationFunction    );
        nn.setNetworkInputs(nnInputs);
        nn.calc();


        System.out.println(nn.getNetworkOutputs());
        System.out.println(nn.toString());
    }
}