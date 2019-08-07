package com.example.Bmi.ControllerBMI;


import com.example.Bmi.ModelBMI.CalculatorBMI;
import com.example.Bmi.ModelBMI.CalculatorKCAL;
import com.example.Bmi.ModelBMI.UserBMI;
import com.example.Bmi.RepositoryBMI.UserRepositoryBMI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    private UserRepositoryBMI userRepositoryBMI;

    @GetMapping("/")
    public String main(ModelMap map) {
        map.put("userBMI", new UserBMI());
        return "homeBMI";
    }

    @PostMapping("/bmi")
    public String bmi(@ModelAttribute UserBMI userBMI, ModelMap map){
        CalculatorBMI calculatorBMI = new CalculatorBMI();
        map.put("bmi", calculatorBMI.bmiCalculator(userBMI.getWeight(),userBMI.getHeight()));
        userRepositoryBMI.save(userBMI);
        return "bmi";
    }

    @PostMapping("/kcal")
    public String kcal(@ModelAttribute UserBMI userBMI, ModelMap map){

        CalculatorKCAL calculatorKCAL = new CalculatorKCAL();
        map.put("kcal", calculatorKCAL.kcalCalculator(userBMI.getWeight(),userBMI.getHeight(),userBMI.getAge(),userBMI.getGender()));
        userRepositoryBMI.save(userBMI);
        return "kcal";
    }




}
