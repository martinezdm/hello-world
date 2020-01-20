package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    @Autowired
    public final DeviceRepository deviceRepository;
    
    public DeviceService(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }
    public void saveDevice( Device device){
        deviceRepository.save(device);
    }
    
    public Map<Integer, Device> getMap() {
        var list = deviceRepository.findAll();
        Map<Integer, Device> map = list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x));
        return map;
        //return list.get(0);
    }
    public Device getDevice(int id) {
        Map<Integer, Device> map = getMap();
        Device device = map.get(id);
        return device;
    }
    public List<Device> getList() {
        var list = deviceRepository.findAll();
        return list;
    }
}
