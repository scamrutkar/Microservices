package com.javacase.sagar.resources;

import com.javacase.sagar.exceptions.DeviceNotFound;
import com.javacase.sagar.model.Device;
import com.javacase.sagar.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceResource {

    private static final String DEVICE_GET_API = "/api/v1/devices/{deviceId}";
    private static final String DEVICE_API = "/api/v1/devices";

    private static final Logger LOG = LoggerFactory.getLogger(DeviceResource.class);

    @Autowired
    DeviceService deviceService;

    @GetMapping(path = "/api/v1/devices/{deviceId}")
    public ResponseEntity getDevice(@PathVariable("deviceId") Long deviceId) {
        Device device = deviceService.getDevice(deviceId);
        if (device == null)
            return new ResponseEntity<>(String.format("Device is not present with device id : %s ", deviceId), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(device);
    }

    @GetMapping(path = "/api/v1/devices")
    public List<Device> getAllDevice() {
        return deviceService.getAllDevice();
    }

    @PostMapping(path = "/api/v1/devices")
    public void addDevice(@RequestBody Device device) {
        LOG.info(String.format("Adding device : %s", device.toString()));
        deviceService.saveDevice(device);
    }

    @PutMapping(path = "/api/v1/devices")
    public void updateDevice(@RequestBody Device device) {
        deviceService.saveDevice(device);
    }

    @DeleteMapping(path = "/api/v1/devices/{deviceId}")
    public void deleteDevice(@PathVariable("deviceId") Long deviceId) {
        deviceService.deleteDevice(deviceId);
    }
}
