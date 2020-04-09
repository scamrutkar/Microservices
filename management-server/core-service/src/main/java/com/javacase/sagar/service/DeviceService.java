package com.javacase.sagar.service;

import com.javacase.sagar.model.Device;
import com.javacase.sagar.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public Device getDevice(Long deviceId){
        return deviceRepository.findById(deviceId).get();
    }

    public List<Device> getAllDevice(){
        List<Device> deviceList = new ArrayList<>();
        deviceRepository.findAll().forEach(deviceList::add);
        return  deviceList;
    }

    public void saveDevice(Device device){
        deviceRepository.save(device);
    }

    public void deleteDevice(Long deviceId){
        deviceRepository.deleteById(deviceId);
    }

}
