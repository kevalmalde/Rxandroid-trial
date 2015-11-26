package com.keval.rxandroid.services;

import com.keval.rxandroid.models.Comment;
import com.keval.rxandroid.models.Post;

import java.util.List;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

import rx.Observable;
/**
 * Created by keval on 26/11/15.
 */
public class ForumService {
    private static final String FORUM_SERVER_URL = "http://jsonplaceholder.typicode.com";
    private ForumApi mForumApi;

    public ForumService() {
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept","application/json");
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(FORUM_SERVER_URL)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        mForumApi = restAdapter.create(ForumApi.class);
    }

    public ForumApi getApi() {
        return mForumApi;
    }

    public interface ForumApi{
        @GET("/posts")
        public Observable<List<Post>> getPosts();

        @GET("/posts/{id}")
        public Observable<Post> getPosts(@Path("id") int postId);

        @GET("/comments")
        public Observable<List<Comment>> getComments(@Query("postId") int postId);

        @POST("/posts")
        public Observable<Post> postPost(Post post);
    }
}
