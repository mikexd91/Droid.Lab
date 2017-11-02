package com.project.is3261.is3261_firebase.Model.News;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.is3261.is3261_firebase.Model.Chapters.ChapterCard;
import com.project.is3261.is3261_firebase.R;

import java.util.List;

/**
 * Created by xunda on 6/10/17.
 */

public class CustomAdapterLesson extends RecyclerView.Adapter<CustomViewHolder> {
    private List<ChapterCard> feedItemList;
    private Context mContext;

    public CustomAdapterLesson(Context context, List<ChapterCard> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_chapter, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        ChapterCard feedItem = feedItemList.get(i);

        //Render image using Picasso library
//        if (!TextUtils.isEmpty(feedItem.getImageUrl())) {
//            Picasso.with(mContext).load(feedItem.getImageUrl())
//                    .error(R.drawable.placeholder)
//                    .placeholder(R.drawable.placeholder)
//                    .into(customViewHolder.imageView);
//        }

        //Setting text view title
        //customViewHolder.author.setText(feedItem.());
        customViewHolder.title.setText(feedItem.getTitle());
        customViewHolder.description.setText(feedItem.getDescription());
        //customViewHolder.url.setText(feedItem.getUrl());
        //customViewHolder.publishedAt.setText(feedItem.getPublishedAt());

//        if(i>1){
//            customViewHolder.cv.setCardBackgroundColor(GRAY);
//        }

    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    public List<ChapterCard> getList(){
        return feedItemList;
    }

    // Clean all elements of the recycler
    public void clear() {
        feedItemList.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<ChapterCard> list) {
        feedItemList.addAll(list);
        notifyDataSetChanged();
    }

}
