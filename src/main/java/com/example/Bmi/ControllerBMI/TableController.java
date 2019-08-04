package com.example.Bmi.ControllerBMI;



import com.example.Bmi.RepositoryBMI.UserRepositoryBMI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TableController {

    @Autowired
    private UserRepositoryBMI userRepositoryBMI;

    @GetMapping("/table")
    private String all(ModelMap map) {
        map.put("data", userRepositoryBMI.findAll());
        return "table";
    }

    @GetMapping("/table/{id}")
    public String show(@PathVariable Integer id, ModelMap map) {
        map.put("user", userRepositoryBMI.findById(id).get());
        return "show";
    }


}
