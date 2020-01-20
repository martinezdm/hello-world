package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ButtonService {
    @Autowired
    public final ButtonRepository buttonRepository;
    
    public ButtonService(ButtonRepository buttonRepository){
        this.buttonRepository = buttonRepository;
    }
    public void createButton( Button pultButton){
        buttonRepository.save(pultButton);
    }
    
    public List<Button> getList() {
        var list = buttonRepository.findAll();
        return list;
    }
    public Map<Integer, Button> getMap() {
        var list = buttonRepository.findAll();
        Map<Integer, Button> map = list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x));
        return map;
    }
    public Button getButton(int id) {
        Map<Integer, Button> map = getMap();
        Button button = map.get(id);
        return button;
    }
    public Button createButton(String cmd) {
        Button btn = new Button();
        btn.setCmd(cmd);
        createButton(btn);
        return btn;
    }
}
