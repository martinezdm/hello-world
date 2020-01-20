package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/button")
public class ButtonController {
    
    @Autowired
    private ButtonService buttonService;
    
    @GetMapping("/map")
    public Map<Integer, Button> getButton(Model model) {
        return buttonService.getMap();
    }
    @GetMapping("/list")
    public List<Button> getList(Model model) {
        return buttonService.getList();
    }
    @GetMapping("/create")
    public Button createButton(@RequestParam(name="cmd", required=true) String cmd, Model model) {
        return buttonService.createButton(cmd);
    }
}
