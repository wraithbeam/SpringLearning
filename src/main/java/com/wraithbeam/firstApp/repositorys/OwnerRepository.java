package com.wraithbeam.firstApp.repositorys;

import com.wraithbeam.firstApp.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}