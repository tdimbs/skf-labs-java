package com.skf.labs.graphqlidor;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.skf.labs.graphqlidor.UsersDataFetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.io.ClassPathResource;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import javax.annotation.PostConstruct;








@Service
public class GraphQLService {
    private GraphQL graphQL;

    @Autowired
    UsersDataFetcher usersDataFetcher;

    @Autowired
    UserDetailsDataFetcher userDetailsDataFetcher;

    @Value("data.graphqls")
    private ClassPathResource classPathLoader;

    @PostConstruct
    private void loadSchema() throws IOException{
        InputStream st = classPathLoader.getInputStream();
        Reader targetReader = new InputStreamReader(st);
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(targetReader);
        RuntimeWiring runtimeWiring = buildRuntimeWiring();

        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry,runtimeWiring);
        graphQL = GraphQL.newGraphQL(graphQLSchema).build();

        

    }

    private RuntimeWiring buildRuntimeWiring(){
        return RuntimeWiring.newRuntimeWiring()
        .type("Query",typeWiring->typeWiring
            .dataFetcher("users", usersDataFetcher)
            .dataFetcher("singleUser", userDetailsDataFetcher))
        .build();
    }

    public GraphQL initiateGraphQL(){
        return graphQL;
    }
    
}
