package com.iset.repository;

import com.iset.entity.Nutritioniste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionisteRepository extends JpaRepository<Nutritioniste, Long> {
}
