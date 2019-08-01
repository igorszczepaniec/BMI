package com.example.Bmi.Controller;


import com.example.Bmi.Model.User;
import com.example.Bmi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TableController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/table")
    private String all(ModelMap map) {
        map.put("data", userRepository.findAll());
        return "table";
    }

    @GetMapping("/table/{id}")
    public String show(@PathVariable Integer id, ModelMap map) {
        map.put("user", userRepository.findById(id).get());
        return "show";
    }


}
