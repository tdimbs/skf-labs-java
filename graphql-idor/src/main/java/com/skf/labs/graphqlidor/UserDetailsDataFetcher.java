package com.skf.labs.graphqlidor;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import com.skf.labs.graphqlidor.GraphqlIdorModel;
import com.skf.labs.graphqlidor.User;

@Repository
public class UserDetailsDataFetcher implements DataFetcher<List<UserInfo>> {
    @Autowired
    private GraphqlIdorModel graphqlIdorModel;
    @Override
    public List<UserInfo> get(DataFetchingEnvironment dataFetchingEnvironment){
        int userId = dataFetchingEnvironment.getArgument("userId");
        return graphqlIdorModel.getUserInfo(userId);
    }
    
}
