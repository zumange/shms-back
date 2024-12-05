package com.example.shms_back.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum ThermostatsMode {
  HEATING,
  COOLING,
  OFF;

  @JsonCreator
  public static ThermostatsMode fromString(@JsonProperty("mode") String value) {
    return ThermostatsMode.valueOf(value.toUpperCase());
  }
}
