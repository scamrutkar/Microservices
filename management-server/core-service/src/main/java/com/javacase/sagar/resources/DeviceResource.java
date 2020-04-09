package com.javacase.sagar.resources;

import com.javacase.sagar.model.Device;
import com.javacase.sagar.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceResource {

    private static final String DEVICE_GET_API= "/api/v1/devices/{deviceId}";
    private static final String DEVICE_API = "/api/v1/devices";

    @Autowired
    DeviceService deviceService;

    @GetMapping(path = "/api/v1/devices/{deviceId}")
    public Device getDevice(@PathVariable("deviceId") Long deviceId){
        return deviceService.getDevice(deviceId);
    }

    @GetMapping(path = "/api/v1/devices")
    public List<Device> getAllDevice(){
        return deviceService.getAllDevice();
    }

    @PostMapping(path = "/api/v1/devices")
    public void addDevice(@RequestBody Device device){
         deviceService.saveDevice(device);
    }

    @PutMapping(path = "/api/v1/devices")
    public void updateDevice(@RequestBody Device device){
        deviceService.saveDevice(device);
    }

    @DeleteMapping(path = "/api/v1/devices/{deviceId}")
    public void deleteDevice(@PathVariable("deviceId") Long deviceId){
        deviceService.deleteDevice(deviceId);
    }
}
