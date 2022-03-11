package com.skf.labs.graphqlidor;

import java.io.IOException;
import java.util.List;

import com.skf.labs.graphqlidor.GraphQLService;
import com.skf.labs.graphqlidor.GraphqlIdorModel;
import com.skf.labs.graphqlidor.User;
import com.skf.labs.graphqlidor.UserInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import graphql.ExecutionResult;
import org.json.JSONObject;
import org.json.JSONException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;





@Controller
public class GraphqlIdorController {
    @Autowired 
    GraphQLService graphQLService;

    @Autowired
    GraphqlIdorModel graphqlModel;

    @GetMapping("/")
    public String home(@CookieValue(name = "X-Api-Key", required = false) String apiKey, Model model) throws IOException, JSONException{
        UserInfo userInfo = verifyAPIKey(apiKey);
        if(null != userInfo){
            model.addAttribute("content", userInfo.getName() +" "+ userInfo.getSurname());
            return "index";
        }else{
            return "login";
        }
    }

    @GetMapping("/login")
    public String loginPage() throws IOException, JSONException{
        return "login";
    }

    @PostMapping("/login")
	public String login(@RequestParam(name="username", required=true) String username,@RequestParam(name="password", required=true) String password,Model model, HttpServletRequest request,HttpServletResponse response) {
        List<User> users = graphqlModel.getUser(username);
        if(users.size() > 0 && (users.get(0).getPassword().equals(password))){
            List<UserInfo> userInfos = graphqlModel.getUserInfo(users.get(0).getId());

            response.addCookie(new Cookie("X-Api-Key",userInfos.get(0).getApiKey()));
            response.addCookie(new Cookie("uuid",String.valueOf(userInfos.get(0).getUserId())));
        
            return "redirect:/";
        }
        model.addAttribute("content", "username or password are not correct");

       	return "login";
      }

    @GetMapping("/settings")
    public String settings(@CookieValue(name = "X-Api-Key", required = false) String apiKey, Model model) throws IOException, JSONException{
        UserInfo userInfo = verifyAPIKey(apiKey);
        if(null != userInfo){
            model.addAttribute("content", userInfo.getName());
            return "settings";
        }else{
            return "login";
        }
    }

    @PostMapping(value="/graphql", 
                consumes = "application/json", 
                produces = "application/json")
	public ResponseEntity<Object> graphql(@RequestBody String query,@CookieValue(name = "X-Api-Key", required = false) String apiKey,Model model) {
        UserInfo userInfo = verifyAPIKey(apiKey);
        if(null != userInfo){
            ExecutionResult execute = graphQLService.initiateGraphQL().execute(query);
            Map<String, String> obj = (Map<String,String>) execute.getData();
            JSONObject jsonObject = new JSONObject(obj);
            return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toMap());
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("FORBIDDEN"); 
        }
      }


    private UserInfo verifyAPIKey(String apiKey){
       List<UserInfo> usersInfo =  graphqlModel.getUserInfo(apiKey);
       if(usersInfo.size() > 0){
        return usersInfo.get(0);
       }else{
           return null;
       }
    }
    
}
