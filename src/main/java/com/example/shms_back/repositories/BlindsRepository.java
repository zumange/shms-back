package com.example.shms_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shms_back.models.Blinds;

@Repository
public interface BlindsRepository extends JpaRepository<Blinds, Long> {}
