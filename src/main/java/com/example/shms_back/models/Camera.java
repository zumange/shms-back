package com.example.shms_back.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "device_id")
public class Camera extends Device {
  private boolean state;
  private boolean recording;

  public Camera() {
    super();
  }

  public Camera(String name, boolean state, boolean recording) {
    super(name, DeviceType.CAMERA);
    this.state = state;
    this.recording = recording;
  }

  public boolean isState() {
    return state;
  }

  public void setState(boolean state) {
    this.state = state;
  }

  public boolean isRecording() {
    return recording;
  }

  public void setRecording(boolean recording) {
    this.recording = recording;
  }

  @Override
  public void update(Device device) {
    Camera camera = (Camera) device;

    setName(camera.getName());
    setState(camera.isState());
    setRecording(camera.isRecording());
  }
}
