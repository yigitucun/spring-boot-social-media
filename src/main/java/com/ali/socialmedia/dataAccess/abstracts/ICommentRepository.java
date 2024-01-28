package com.ali.socialmedia.dataAccess.abstracts;

import com.ali.socialmedia.entities.concretes.Comment;
import com.ali.socialmedia.projections.comment.ICommentGetByIdAndUserIdProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICommentRepository extends JpaRepository<Comment,Integer> {
    boolean existsById(int id);
    @Query("SELECT c.id as id  FROM Comment c INNER JOIN User u ON u.id=c.user.id WHERE c.id=:commentId AND c.user.id=:userId")
    Optional<ICommentGetByIdAndUserIdProjection> findByIdAndUserId(int commentId, int userId);
    @Modifying
    @Query("DELETE FROM Comment c where c.id=:id")
    void deleteById(int id);

}
