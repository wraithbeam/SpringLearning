package com.wraithbeam.firstApp.repositorys;

import com.wraithbeam.firstApp.models.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepository extends JpaRepository<Flat, Long> {
}