package com.user.blog.example.freeNowIT;

import com.blog.example.model.Comment;
import com.blog.example.model.Post;
import com.blog.example.model.User;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import org.testng.ITestContext;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static com.blog.example.controller.ApiController.get;
import static com.blog.example.controller.ApiController.getWithParams;
import static com.blog.example.reporting.ExtentManager.createExtentTest;

public class UserBlogPostAndCommentsIntegrationTest {


    @BeforeMethod
    public void startReport() {
        createExtentTest("Freenow integration test case");
    }


    @Getter
    @Setter
    class UserBlogUtil {
        public  int userId;
        public Set<Integer> posts = new HashSet<>();;
    }

    private UserBlogUtil userBlogUtil;


    @BeforeTest
    public void init() {
        userBlogUtil = new UserBlogUtil();
    }


    @Test(priority=1)
    public void should_return_list_of_users_by_name_samantha()
    {
        Response response =get("/users");
        List<User> responseList = Arrays.asList(response.getBody().as(User[].class));
        for(User user : responseList) {
            if(user.getUsername().equals("Samantha"))
            {
                userBlogUtil.setUserId(user.getId());
            }
        }
        Assert.assertTrue(responseList.size() > 0);
    }

    @Test(dependsOnMethods = {"should_return_list_of_users_by_name_samantha"})
    public void should_return_list_of_post_by_user_id()
    {
        Response response =getWithParams("/posts",Map.of("userId",userBlogUtil.getUserId()));
        List<Post> responseList = Arrays.asList(response.getBody().as(Post[].class));
        Set<Integer> postSet = responseList.stream().map(it -> it.getId()).collect(Collectors.toSet());
        userBlogUtil.setPosts(postSet);
        Assert.assertTrue(userBlogUtil.getPosts().size()>0);
    }

    @Test(dependsOnMethods = {"should_return_list_of_post_by_user_id"})
    public void should_return_comments_by_post_id()
    {

        for(Integer postId:userBlogUtil.getPosts()){
            Response response =getWithParams("/comments",Map.of("postId",postId));
            List<Comment> responseList = Arrays.asList(response.getBody().as(Comment[].class));
            for(Comment comment:responseList)
            {
                Assert.assertTrue(EmailValidator.getInstance().isValid(comment.getEmail()));
            }
        }

    }
}
