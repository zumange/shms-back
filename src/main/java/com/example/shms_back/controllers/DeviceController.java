package com.example.shms_back.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shms_back.models.Blinds;
import com.example.shms_back.models.Camera;
import com.example.shms_back.models.Device;
import com.example.shms_back.models.Light;
import com.example.shms_back.models.Thermostat;
import com.example.shms_back.repositories.BlindsRepository;
import com.example.shms_back.repositories.CameraRepository;
import com.example.shms_back.repositories.DeviceRepository;
import com.example.shms_back.repositories.LightRepository;
import com.example.shms_back.repositories.ThermostatRepository;

@RestController
@RequestMapping("/api/device")
public class DeviceController {
  @Autowired
  private DeviceRepository deviceRepository;

  @Autowired
  private LightRepository lightRepository;

  @Autowired
  private ThermostatRepository thermostatRepository;

  @Autowired
  private CameraRepository cameraRepository;

  @Autowired
  private BlindsRepository blindsRepository;

  @GetMapping
  public ResponseEntity<List<Device>> getAllDevices() {
    return ResponseEntity.ok(deviceRepository.findAll());
  }

  @PostMapping
  public ResponseEntity<Device> addDevice(@RequestBody Device device) {
    try {
      Device createdDevice = saveDevice(device);
      return ResponseEntity.status(HttpStatus.CREATED).body(createdDevice);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
  }

  @PutMapping
  public ResponseEntity<Device> updateDevice(@RequestBody Device device) {
    Optional<Device> existingDeviceOpt = deviceRepository.findById(device.getId());

    if(existingDeviceOpt.isPresent()) {
      Device existingDevice = existingDeviceOpt.get();
      existingDevice.update(device);
      try {
        saveDevice(existingDevice);
        return ResponseEntity.status(HttpStatus.CREATED).body(existingDevice);
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
      }
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteDevice(@PathVariable long id) {
    try {
      deviceRepository.deleteById(id);
      return ResponseEntity.ok("Device deleted successfully.");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Device is not deleted. Error occured.");
    }
  }

  private Device saveDevice(Device device) {
    switch (device.getType()) {
        case LIGHT:
            return lightRepository.save((Light) device);
        case THERMOSTAT:
            return thermostatRepository.save((Thermostat) device);
        case CAMERA:
            return cameraRepository.save((Camera) device);
        case BLINDS:
            return blindsRepository.save((Blinds) device);
        default:
            throw new IllegalArgumentException("Unknown device type");
    }
  }
}
