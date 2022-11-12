package com.abc.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.insurance.entity.MedicalInsurance;

@Repository
public interface MedicalInsuranceRepository extends JpaRepository<MedicalInsurance, Integer> ,IMedicalInsuranceCustomRepository{

}

