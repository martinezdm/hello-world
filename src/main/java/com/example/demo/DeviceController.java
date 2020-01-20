package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    public DeviceService deviceService;
    
    @GetMapping("/map")
    public Map<Integer, Device> getMap(Model model) {
        return deviceService.getMap();
    }
    @GetMapping("/volup")
    public Device volUp(@RequestParam(name="device_id", required=true) Integer device_id, Model model) {
        Device device = deviceService.getDevice(device_id);
        device.volUp();
        deviceService.saveDevice(device);
        return device;
    }
    @GetMapping("/voldown")
    public Device volDown(@RequestParam(name="device_id", required=true) Integer device_id, Model model) {
        Device device = deviceService.getDevice(device_id);
        device.volDown();
        deviceService.saveDevice(device);
        return device;
    }
    @GetMapping("/undo")
    public Device undo(@RequestParam(name="device_id", required=true) Integer device_id, Model model) {
        Device device = deviceService.getDevice(device_id);
        device.undo();
        deviceService.saveDevice(device);
        return device;
    }
    @GetMapping("/cmd")
    public Device undo(@RequestParam(name="device_id", required=true) Integer device_id,
            @RequestParam(name="cmd", required=true) String cmd, Model model) {
        Device device = deviceService.getDevice(device_id);
        device.Cmd(cmd);
        deviceService.saveDevice(device);
        return device;
    }
    @GetMapping("/switch")
    public Device setVol(@RequestParam(name="device_id", required=true) Integer device_id, Model model) {
        
        Device device = deviceService.getDevice(device_id);
        device.onOff();
        deviceService.saveDevice(device);
        return device;
    }
}