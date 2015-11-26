package com.keval.rxandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

//import com.keval.rxandroid.R;
import com.keval.rxandroid.R;
import com.keval.rxandroid.models.Post;

import java.util.ArrayList;

/**
 * Created by keval on 26/11/15.
 */
public class PostsAdapter extends ArrayAdapter<Post> {
    public PostsAdapter(Context context, ArrayList<Post> posts) {
        super(context, 0, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Post post = getItem(position);

        if(convertView == null)
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.layout_post_item,parent,false);

        TextView title = (TextView) convertView.findViewById(R.id.textViewItemTitle);
        title.setText(post.title);

        return convertView;
    }
}
