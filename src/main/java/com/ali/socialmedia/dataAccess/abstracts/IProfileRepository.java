package com.ali.socialmedia.dataAccess.abstracts;

import com.ali.socialmedia.entities.concretes.Profile;
import com.ali.socialmedia.projections.profile.IDetailProfileProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends JpaRepository<Profile,Integer> {
    boolean existsById(int id);


    @Query("SELECT p.id as id,p.location as location,p.bio as bio,u.firstName as firstName,u.username as username,p.followers as followers FROM Profile p INNER JOIN User u ON u.id=p.user.id WHERE p.id=:id")
    IDetailProfileProjection findByWithId(int id);
    @EntityGraph(attributePaths = {"followers", "followings","user"})
    Profile findByUserId(int id);

}
