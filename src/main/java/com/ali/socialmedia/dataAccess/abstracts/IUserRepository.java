package com.ali.socialmedia.dataAccess.abstracts;

import com.ali.socialmedia.projections.user.IUserProjection;
import com.ali.socialmedia.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository  extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsById(int id);

    @Query("SELECT u.id as id FROM User u WHERE id=:id")
    IUserProjection findUserById(int id);

}
