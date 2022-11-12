package com.abc.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.insurance.entity.MedicalPolicies;

@Repository
public interface MedicalPoliciesRepository  extends JpaRepository<MedicalPolicies, Integer> ,IMedicalPoliciesCustomRepository {

}
