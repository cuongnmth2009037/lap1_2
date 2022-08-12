package com.example.lap1.repository;

import com.example.lap1.entity.TblClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblClassRepository extends JpaRepository<TblClass, Long> {
}
