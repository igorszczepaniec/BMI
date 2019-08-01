package com.example.Bmi.Controller;


import com.example.Bmi.Model.User;
import com.example.Bmi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String main(ModelMap map) {
        map.put("user", new User());
        return "home";
    }

    @PostMapping("/bmi")
    public String bmi(@ModelAttribute User user, ModelMap map){
        map.put("bmi",user.bmiCalculator(user.getWeight(), user.getHeight()));
        userRepository.save(user);
        return "bmi";
    }

    @PostMapping("/kcal")
    public String kcal(@ModelAttribute User user, ModelMap map){
        map.put("kcal",user.kcalCalculator(user.getWeight(),user.getHeight(),user.getAge(),user.getGender()));
        userRepository.save(user);
        return "kcal";
    }


}
