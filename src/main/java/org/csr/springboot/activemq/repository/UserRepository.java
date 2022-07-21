package org.csr.springboot.activemq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.csr.springboot.activemq.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
