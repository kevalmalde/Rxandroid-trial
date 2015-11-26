package com.keval.rxandroid.presenters;

import com.keval.rxandroid.models.Post;
import com.keval.rxandroid.services.ForumService;
import com.keval.rxandroid.views.ListActivity;

import java.util.List;
import java.util.concurrent.ScheduledFuture;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by keval on 26/11/15.
 */
public class ListPresenter {
    ListActivity mView;
    ForumService mForum;

    public ListPresenter(ListActivity mView, ForumService mForum) {
        this.mView = mView;
        this.mForum = mForum;
    }

    public void loadPosts(){
        mForum.getApi().getPosts()
                .subscribeOn(Schedulers.newThread() )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        mView.displayPosts(posts);
                    }
                });
    }
}
