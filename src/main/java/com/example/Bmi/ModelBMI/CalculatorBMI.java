package com.example.Bmi.ModelBMI;

public class CalculatorBMI {
    public Double bmiCalculator(Integer weight, Integer height) {
        Double a = (double) weight / (height * height) * 10000;
        Double b = Math.round(a * 100.0) / 100.0;
        return b;
    }
}
