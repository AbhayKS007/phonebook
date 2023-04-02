package com.absa.application.phonebook.repository;

import com.absa.application.phonebook.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBook, Integer>{
}
