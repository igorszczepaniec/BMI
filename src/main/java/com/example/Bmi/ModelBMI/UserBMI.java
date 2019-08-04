package com.example.Bmi.ModelBMI;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user_BMI")
public class UserBMI {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer height;
    private Integer weight;
    private Integer age;
    private String gender;


    public Double bmiCalculator(Integer weight, Integer height) {


        Double a = (double) weight / (height * height) * 10000;
        Double b = Math.round(a * 100.0) / 100.0;
        return b;

    }

    // Women BMR = 655.0955 + (9.5634 x weight in kg) + (1.8496 x height in cm) – (4.6756 x age in years)
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

