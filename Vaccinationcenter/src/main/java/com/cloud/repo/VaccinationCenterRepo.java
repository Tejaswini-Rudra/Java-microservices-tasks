package com.cloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.model.VaccinationCenter;
@Repository
public interface VaccinationCenterRepo extends JpaRepository<VaccinationCenter, Integer> {

}
