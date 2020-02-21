package com.dmarquina.plantcare.dto.request;

import com.dmarquina.plantcare.util.AWSUtils;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class MemoryRequest {

  private long plantId;
  @NotEmpty(message = "Es necesaria una imagen")
  private String image;
  private String status;

  public String getImage() {
    return this.image != null ? AWSUtils.getImageNameFromURL(this.image) : "";
  }
}