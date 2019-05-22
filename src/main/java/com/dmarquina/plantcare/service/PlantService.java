package com.dmarquina.plantcare.service;

import com.dmarquina.plantcare.model.Plant;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface PlantService {

  List<Plant> findAllMyPlants(String ownerId);

  Plant findById(Long id);

  Plant create(Plant plant);

  Plant update(Plant plant, List<Long> remindersToDelete);

  void delete(Long id);

  Plant addImagePlant(Long plantId, String ownerId, MultipartFile newImage);

  int updateImagePlant(Long plantId, String ownerId, String imageURL, MultipartFile newImage);
}
