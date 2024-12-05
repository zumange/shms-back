package com.example.shms_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shms_back.models.Light;

@Repository
public interface LightRepository extends JpaRepository<Light, Long> {}
