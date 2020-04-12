package com.javacase.sagar.service;

import com.javacase.sagar.exceptions.DeviceNotFound;
import com.javacase.sagar.dto.Device;
import com.javacase.sagar.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public Device getDevice(Long deviceId) {
        return deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceNotFound(String.format("Device is not present with device id : %s ", deviceId)));
    }

    public List<Device> getAllDevice() {
        List<Device> deviceList = new ArrayList<>();
        deviceRepository.findAll().forEach(deviceList::add);
        return deviceList;
    }

    public Device saveDevice(Device device) {
        device = deviceRepository.save(
                device.updateAuthenticationDeviceId()
                        .updateAwsDeviceId()
                        .updateSnmpDeviceId()
        );
        return device;
    }

    public void deleteDevice(Long deviceId) {
        deviceRepository.deleteById(deviceId);
    }

}
