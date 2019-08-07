package com.example.Bmi.ModelBMI;

public class CalculatorKCAL {

    public Double kcalCalculator(Integer weight, Integer height, Integer age, String gender) {

        if (gender.equals("MEN")) {
            Double a = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
            return a;
        } else {
            Double b = 655 + (9.56 * weight) + (1.84 * height) - (4.67 * age);
            return b;
        }
    }


}
