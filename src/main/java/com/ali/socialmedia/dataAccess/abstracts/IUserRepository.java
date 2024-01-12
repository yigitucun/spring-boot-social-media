package com.ali.socialmedia.dataAccess.abstracts;

import com.ali.socialmedia.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository  extends JpaRepository<User,Integer> {
}
