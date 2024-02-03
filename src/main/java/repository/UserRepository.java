package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	
}
