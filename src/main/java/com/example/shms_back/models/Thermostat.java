package com.example.shms_back.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "device_id")
public class Thermostat extends Device {
  private double temperature;

  @Enumerated(EnumType.STRING)
  private ThermostatsMode mode;

  public Thermostat() {
    super();
  }

  public Thermostat(String name, double temperature, ThermostatsMode mode) {
    super(name, DeviceType.THERMOSTAT);
    this.temperature = temperature;
    this.mode = mode;
  }

  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }

  public ThermostatsMode getMode() {
    return mode;
  }

  public void setMode(ThermostatsMode mode) {
    this.mode = mode;
  }

  @Override
  public void update(Device device) {
    Thermostat thermostat = (Thermostat) device;

    setName(thermostat.getName());
    setMode(thermostat.getMode());
    setTemperature(thermostat.getTemperature());
  }
}
