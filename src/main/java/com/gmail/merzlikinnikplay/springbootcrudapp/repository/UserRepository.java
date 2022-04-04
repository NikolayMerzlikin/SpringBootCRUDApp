package com.gmail.merzlikinnikplay.springbootcrudapp.repository;
import com.gmail.merzlikinnikplay.springbootcrudapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
