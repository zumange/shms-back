package com.example.shms_back.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "device_id")
public class Light extends Device {
  private boolean state;
  private int brightness;

  public Light() {
    super();
  }

  public Light(String name, boolean state, int brightness) {
    super(name, DeviceType.LIGHT);
    this.state = state;
    this.brightness = brightness;
  }

  public boolean isState() {
    return state;
  }

  public void setState(boolean state) {
    this.state = state;
  }

  public int getBrightness() {
    return brightness;
  }

  public void setBrightness(int brightness) {
    this.brightness = brightness;
  }

  @Override
  public void update(Device device) {
    Light light = (Light) device;

    setName(light.getName());
    setState(light.isState());
    setBrightness(light.getBrightness());
  }
}
