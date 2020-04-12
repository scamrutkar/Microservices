package com.javacase.sagar.resources;

import com.javacase.sagar.dto.Device;
import com.javacase.sagar.exceptions.DeviceNotFound;
import com.javacase.sagar.exceptions.ErrorResponse;
import com.javacase.sagar.exceptions.SuccessResponse;
import com.javacase.sagar.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(DeviceResource.DEVICE_BASE_API)
public class DeviceResource {

    protected static final String DEVICE_BASE_API = "/api/v1/devices";

    @Autowired
    DeviceService deviceService;

    @GetMapping(path = "/{deviceId}")
    public ResponseEntity getDevice(@PathVariable("deviceId") Long deviceId) {
        Device device;
        try {
            device = deviceService.getDevice(deviceId);
        } catch (DeviceNotFound ex) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .details(ex.getMessage())
                    .timestamp(Timestamp.from(Instant.now())).build();
            return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(device);
    }

    @GetMapping
    public List<Device> getAllDevice() {
        return deviceService.getAllDevice();
    }

    @PostMapping
    public ResponseEntity addDevice(@RequestBody Device device) {
        device = deviceService.saveDevice(device);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(DEVICE_BASE_API + "/{id}")
                .buildAndExpand(device.getId()).toUri();

        SuccessResponse successResponse = SuccessResponse.builder()
                .message(String.format("Device is created with DeviceId : %s", device.getId()))
                .uri(uri).build();

        return new ResponseEntity(successResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateDevice(@RequestBody Device device) {
        device = deviceService.saveDevice(device);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(DEVICE_BASE_API + "/{id}")
                .buildAndExpand(device.getId()).toUri();

        SuccessResponse successResponse = SuccessResponse.builder()
                .message(String.format("Successfully updated device with DeviceId : %s", device.getId()))
                .uri(uri)
                .object(device).build();

        return new ResponseEntity(successResponse, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{deviceId}")
    public void deleteDevice(@PathVariable("deviceId") Long deviceId) {
        deviceService.deleteDevice(deviceId);
    }
}
