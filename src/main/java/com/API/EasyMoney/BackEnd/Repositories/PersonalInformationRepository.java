package com.API.EasyMoney.BackEnd.Repositories;

import com.API.EasyMoney.BackEnd.Entities.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Long> {
}
