package com.example.shms_back.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "device_id")
public class Blinds extends Device{
  private boolean state;
  private int position;

  public Blinds() {
    super();
  }

  public Blinds(String name, boolean state, int position) {
    super(name, DeviceType.BLINDS);
    this.state = state;
    this.position = position;
  }

  public boolean isState() {
    return state;
  }

  public void setState(boolean state) {
    this.state = state;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  @Override
  public void update(Device device) {
    Blinds blinds = (Blinds) device;
    
    setName(blinds.getName());
    setState(blinds.isState());
    setPosition(blinds.getPosition());
  }
}
