package com.skf.labs.graphqlbase.repository;
import com.skf.labs.graphqlbase.entity.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserInfoRepository extends JpaRepository<UserInfo,Integer>{
    
}
