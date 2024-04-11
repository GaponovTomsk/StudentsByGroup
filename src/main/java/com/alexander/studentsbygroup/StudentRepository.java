package com.alexander.studentsbygroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s order by s.fullName")
    List<Student> findAllSortByFullName();

    @Query("select s from Student s order by s.gender")
    List<Student> findAllSortByGender();

    @Query("select s from Student s order by s.status desc")
    List<Student> findAllSortByStatus();

    @Query("select s from Student s order by s.fundingType")
    List<Student> findAllSortByFundingType();

    @Query("select s from Student s order by s.groupStudent")
    List<Student> findAllSortByGroupStudent();

}
