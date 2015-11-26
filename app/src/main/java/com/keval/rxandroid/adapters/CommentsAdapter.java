package com.keval.rxandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.keval.rxandroid.R;
import com.keval.rxandroid.models.Comment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by keval on 26/11/15.
 */
public class CommentsAdapter extends ArrayAdapter<Comment> {
    public CommentsAdapter(Context context, ArrayList<Comment> posts) {
        super(context, 0,posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Comment comment = getItem(position);

        if( convertView == null )
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_comment_item, parent, false);

        CommentViewWrapper view = new CommentViewWrapper();
        ButterKnife.inject(view,convertView);
        view.load(comment);

        return convertView;
    }

    class CommentViewWrapper {

        @InjectView(R.id.textViewCommentName)
        protected TextView name;

        @InjectView(R.id.textViewCommentEmail)
        protected TextView email;

        @InjectView(R.id.textViewCommentBody)
        protected TextView body;

        public void load(Comment comment) {

            name.setText(comment.name);
            email.setText(comment.email);
            body.setText(comment.body);
        }
    }
}
