package com.example.shms_back.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum DeviceType {
  LIGHT,
  THERMOSTAT,
  CAMERA,
  BLINDS;

  @JsonCreator
  public static DeviceType fromString(@JsonProperty("type") String value) {
    return DeviceType.valueOf(value.toUpperCase());
  }
}
