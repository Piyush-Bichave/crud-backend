package com.piyush.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piyush.crud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
