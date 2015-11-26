package com.keval.rxandroid.presenters;

import com.keval.rxandroid.models.Comment;
import com.keval.rxandroid.models.Post;
import com.keval.rxandroid.services.ForumService;
import com.keval.rxandroid.views.DetailActivity;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by keval on 26/11/15.
 */
public class DetailPresenter {
    DetailActivity mView;
    ForumService mForum;

    public DetailPresenter(DetailActivity mView, ForumService mForum) {
        this.mView = mView;
        this.mForum = mForum;
    }

    public void loadPost() {

        mForum.getApi()
                .getPost(mView.getPostId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Post>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Post post) {

                        mView.displayPost(post);
                    }
                });
    }

    public void loadComments() {

        mForum.getApi()
                .getComments(mView.getPostId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Comment>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Comment> comments) {

                        mView.displayComments(comments);
                    }
                });
    }
}
