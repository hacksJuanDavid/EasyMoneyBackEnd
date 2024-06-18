package com.API.EasyMoney.BackEnd.Repositories;

import com.API.EasyMoney.BackEnd.Entities.CreditLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditLineRepository extends JpaRepository<CreditLine, Long> {
}
