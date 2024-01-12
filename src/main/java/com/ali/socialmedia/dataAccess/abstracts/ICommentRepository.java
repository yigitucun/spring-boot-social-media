package com.ali.socialmedia.dataAccess.abstracts;

import com.ali.socialmedia.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment,Integer> {
}
