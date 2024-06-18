package com.API.EasyMoney.BackEnd.Repositories;

import com.API.EasyMoney.BackEnd.Entities.WorkingInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingInformationRepository extends JpaRepository<WorkingInformation, Long> {
}
