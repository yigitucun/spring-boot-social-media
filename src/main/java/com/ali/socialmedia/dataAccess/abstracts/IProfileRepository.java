package com.ali.socialmedia.dataAccess.abstracts;

import com.ali.socialmedia.entities.concretes.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends JpaRepository<Profile,Integer> {
    boolean existsById(int id);
    Profile findById(int id);

}
