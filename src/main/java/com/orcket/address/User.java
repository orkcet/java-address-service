package com.orcket.address;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity(name = "user_info")
class User {

  @Id
  private UUID id;
  @NotBlank
  private String first_name;
  @NotBlank
  private String last_name;
  @NotBlank
  private String email;
  @NotBlank
  private String street;
  @NotBlank
  private String city;
  @NotBlank
  private String country;

  private String zip_code;

  public User() {
  }

  public User(UUID id, @NotBlank String first_name,
      @NotBlank String last_name, @NotBlank String email,
      @NotBlank String street, @NotBlank String city,
      @NotBlank String country, String zip_code) {
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.email = email;
    this.street = street;
    this.city = city;
    this.country = country;
    this.zip_code = zip_code;
  }

  public User(String[] cols) {
    int size = cols.length;
    if(size > 0) this.id = UUID.fromString(cols[0]);
    if(size > 1) this.first_name = cols[1];
    if(size > 2) this.last_name = cols[2];
    if(size > 3) this.email = cols[3];
    if(size > 4) this.street = cols[4];
    if(size > 5) this.city = cols[5];
    if(size > 6) this.country = cols[6];
    if(size > 7) this.zip_code = cols[7];
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getZip_code() {
    return zip_code;
  }

  public void setZip_code(String zip_code) {
    this.zip_code = zip_code;
  }
}