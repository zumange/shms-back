package com.example.shms_back.models;

import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Light.class, name = "LIGHT"),
    @JsonSubTypes.Type(value = Thermostat.class, name = "THERMOSTAT"),
    @JsonSubTypes.Type(value = Camera.class, name = "CAMERA"),
    @JsonSubTypes.Type(value = Blinds.class, name = "BLINDS")
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Device {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @Column(unique = true)
  private String name;

  @NotNull
  @Enumerated(EnumType.STRING)
  private DeviceType type;

  public Device() {

  }

  public Device(String name, DeviceType type) {
    this.name = name;
    this.type = type;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DeviceType getType() {
    return type;
  }

  public void setType(DeviceType type) {
    this.type = type;
  }

  public abstract void update(Device device);

}
