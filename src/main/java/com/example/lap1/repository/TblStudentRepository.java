package com.example.lap1.repository;

import com.example.lap1.entity.TblStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblStudentRepository extends JpaRepository<TblStudent, Long> {
}
