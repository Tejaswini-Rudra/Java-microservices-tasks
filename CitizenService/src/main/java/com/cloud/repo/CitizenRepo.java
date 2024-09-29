package com.cloud.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.model.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {
    public Citizen save(Citizen newCitizen);
	List<Citizen> findByVaccinationCenterId(Integer id);

}