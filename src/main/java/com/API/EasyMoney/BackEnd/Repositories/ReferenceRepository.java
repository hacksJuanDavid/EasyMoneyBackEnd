package com.API.EasyMoney.BackEnd.Repositories;

import com.API.EasyMoney.BackEnd.Entities.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceRepository extends JpaRepository<Reference, Long> {
}
