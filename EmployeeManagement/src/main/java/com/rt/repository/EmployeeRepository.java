package com.rt.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rt.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "SELECT e FROM Employee e WHERE e.name = :name AND e.id = :id")
	Optional<Employee> findByNameById(@Param("name") String name, @Param("id") int id);

	@Modifying
	@Transactional
	@Query("DELETE FROM Employee e WHERE e.name = :name")
	void deleteByName(@Param("name") String name);

	@Query(value = "SELECT SUM(mark) FROM stdinfo", nativeQuery = true)
	Integer sumOfMark();;
}
