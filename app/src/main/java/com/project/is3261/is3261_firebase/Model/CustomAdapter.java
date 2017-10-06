package com.project.is3261.is3261_firebase.Model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.is3261.is3261_firebase.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by xunda on 6/10/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private List<Data> feedItemList;
    private Context mContext;

    public CustomAdapter(Context context, List<Data> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Data feedItem = feedItemList.get(i);

        //Render image using Picasso library
        if (!TextUtils.isEmpty(feedItem.getImageUrl())) {
            Picasso.with(mContext).load(feedItem.getImageUrl())
                    .error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(customViewHolder.imageView);
        }

        //Setting text view title
        customViewHolder.author.setText(feedItem.getAuthor());
        customViewHolder.title.setText(feedItem.getTitle());
        customViewHolder.description.setText(feedItem.getDescription());
        customViewHolder.url.setText(feedItem.getUrl());
        customViewHolder.publishedAt.setText(feedItem.getPublishedAt());

    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    public List<Data> getList(){
        return feedItemList;
    }

    // Clean all elements of the recycler
    public void clear() {
        feedItemList.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Data> list) {
        feedItemList.addAll(list);
        notifyDataSetChanged();
    }

}
