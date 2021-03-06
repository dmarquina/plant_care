package com.dmarquina.plantcare.repository;

import com.dmarquina.plantcare.model.Memory;
import com.dmarquina.plantcare.model.Plant;
import com.dmarquina.plantcare.model.User;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

  @Query(
      "SELECT DISTINCT p FROM Plant p JOIN FETCH p.reminders WHERE p.ownerId= :ownerId ORDER BY p.id DESC")
  List<Plant> getAllPlantsAndRemindersByOwnerIdOrderByIdDesc(@Param("ownerId") String ownerId);

  @Query("SELECT COUNT(p) FROM Plant p WHERE p.ownerId = :ownerId")
  Integer getPlantsQuantity(@Param("ownerId") String ownerId);

  @Query(
      "SELECT COUNT(m.id) FROM User u INNER JOIN Plant p ON p.ownerId = u.id RIGHT JOIN Memory m on m.plantId = p.id  WHERE u.id = :ownerId ")
  Integer getMemoriesQuantity(@Param("ownerId") String ownerId);

  @Query(
      "SELECT m FROM User u INNER JOIN Plant p ON p.ownerId = u.id RIGHT JOIN Memory m on m.plantId = p.id  WHERE u.id = :ownerId ")
  List<Memory> getMemoriesByUserId(@Param("ownerId") String ownerId);

  @Query("SELECT m FROM Plant p INNER JOIN Memory m ON p.id = m.plantId WHERE p.id IN :plantIds")
  List<Memory> getMyPlantsMemories(@Param("plantIds") Collection<Long> plantIds);



  //  @Query("SELECT u FROM User u INNER JOIN Plant p ON p.ownerId = u.id WHERE p.id = :plantId")
  //  User getUserByPlantId(@Param("plantId") long plantId);
}
