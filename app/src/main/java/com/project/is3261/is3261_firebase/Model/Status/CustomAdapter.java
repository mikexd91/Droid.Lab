package com.project.is3261.is3261_firebase.Model.Status;

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
    private List<Status> feedItemList;
    private Context mContext;

    public CustomAdapter(Context context, List<Status> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_status, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Status feedItem = feedItemList.get(i);

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

    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    public List<Status> getList(){
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
