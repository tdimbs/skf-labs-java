package com.skf.labs.graphqlbase.resolver;
import graphql.kickstart.tools.GraphQLResolver;
import com.skf.labs.graphqlbase.entity.User;
import com.skf.labs.graphqlbase.entity.UserInfo;
import com.skf.labs.graphqlbase.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoResolver implements GraphQLResolver<UserInfo> {
    @Autowired
    private UserRepository userRepository;

    public UserInfoResolver(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User user(UserInfo userInfo){
        return userRepository.findById(userInfo.getUser().getId()).orElseThrow(null);
    }
    
}
