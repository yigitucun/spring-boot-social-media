package com.ali.socialmedia.dataAccess.abstracts;

import com.ali.socialmedia.projections.post.IFindPostByIdAndUserIdProjection;
import com.ali.socialmedia.entities.concretes.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPostRepository extends JpaRepository<Post,Integer> {
    boolean existsById(int id);
    @Query("SELECT p.id as id, u.id as userId FROM Post p INNER JOIN User u ON u.id=p.user.id WHERE p.id=:postId AND p.user.id=:userId ")
    Optional<IFindPostByIdAndUserIdProjection> findByIdAndUserId(int postId, int userId);

}
