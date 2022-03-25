package com.skf.labs.graphqlbase.repository;
import com.skf.labs.graphqlbase.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post,Integer>{
    
}
