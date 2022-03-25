package com.skf.labs.graphqlbase.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;

import java.util.Optional;

import com.skf.labs.graphqlbase.entity.Post;
import com.skf.labs.graphqlbase.entity.User;

import com.skf.labs.graphqlbase.repository.PostRepository;
import com.skf.labs.graphqlbase.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Mutation implements GraphQLMutationResolver {
    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public Mutation(UserRepository userRepository, PostRepository postRepository){
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }


    public Post createPost(String title, String body, int user_id) throws org.hibernate.exception.GenericJDBCException{
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setUser(new User(user_id));
        postRepository.save(post);
        return post;

    }

    public boolean deletePost(int id){
        postRepository.deleteById(id);
        return true;
    }

    public Post updatePost(int id, String title, String body) throws Exception{
        Optional<Post> optPost = postRepository.findById(id);
        if(optPost.isPresent()){
            Post post = optPost.get();
            if(null!=title){
                post.setTitle(title);
            }
            if(null!=body){
                post.setBody(body);
            }
            postRepository.save(post);
            return post;
        }
        throw new Exception("Not found Post to update!");
    }
}


