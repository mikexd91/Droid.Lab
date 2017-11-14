package com.project.is3261.is3261_firebase.Model.Status;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.is3261.is3261_firebase.CommentActivity;
import com.project.is3261.is3261_firebase.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by xunda on 6/10/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private List<Status> feedItemList;
    private Context mContext;

    public CustomAdapter(Context context, List<Status> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_status, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder customViewHolder, int i) {
        final Status feedItem = feedItemList.get(i);

        //Render image using Picasso library
        if (!TextUtils.isEmpty(feedItem.getImageUrl())) {
            Picasso.with(mContext).load(feedItem.getImageUrl())
                    .error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(customViewHolder.imageView);
        }

        customViewHolder.title.setText(feedItem.getAuthor());
        customViewHolder.description.setText(feedItem.getDescription());
        customViewHolder.time.setText(feedItem.getTime());
        if (feedItem.getLike() <= 1) {
            customViewHolder.like.setText(String.valueOf(feedItem.getLike()) + " like");
        } else {
            customViewHolder.like.setText(String.valueOf(feedItem.getLike()) + " likes");
        }

        if (feedItem.getComment() <= 1) {
            customViewHolder.comment.setText(String.valueOf(feedItem.getComment()) + " comment");
        } else {
            customViewHolder.comment.setText(String.valueOf(feedItem.getComment()) + " comments");
        }
        customViewHolder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference()
                            .child("users")
                            .child("status")
                            .child(feedItem.getUid())
                            .child("likeUsers");

                    DatabaseReference myRef2 = database.getReference()
                            .child("users")
                            .child("status")
                            .child(feedItem.getUid())
                            .child("like");

                    if(feedItem.getNameList().contains(feedItem.getAuthor()) && feedItem.getLike()!=0){
                        List name = feedItem.getNameList();
                        name.remove(feedItem.getAuthor());
                        myRef.setValue(name);
                        int likeNum = feedItem.getLike() - 1;
                        myRef2.setValue(String.valueOf(likeNum));
                    }else{
                        List name = feedItem.getNameList();
                        name.add(feedItem.getAuthor());
                        myRef.setValue(name);
                        int likeNum = feedItem.getLike() + 1;
                        myRef2.setValue(String.valueOf(likeNum));
                    }
                }
            }
        });

        customViewHolder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, CommentActivity.class);
                i.putExtra("uid", feedItem.getUid());
                mContext.startActivity(i);
            }
        });

        if(feedItem.getHideButton()){
            customViewHolder.like.setVisibility(View.GONE);
            customViewHolder.comment.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    public List<Status> getList() {
        return feedItemList;
    }

    // Clean all elements of the recycler
    public void clear() {
        feedItemList.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Status> list) {
        feedItemList.addAll(list);
        notifyDataSetChanged();
    }

}
