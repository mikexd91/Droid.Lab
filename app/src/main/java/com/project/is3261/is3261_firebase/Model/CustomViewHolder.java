package com.project.is3261.is3261_firebase.Model;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.is3261.is3261_firebase.R;

/**
 * Created by xunda on 6/10/17.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "ViewHolder";
    CardView cv;
    TextView author;
    TextView title;
    TextView description;
    TextView url;
    TextView publishedAt;
    ImageView imageView;

    CustomViewHolder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        author = (TextView) itemView.findViewById(R.id.author);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
        url = (TextView) itemView.findViewById(R.id.url);
        publishedAt = (TextView) itemView.findViewById(R.id.publishedAt);
        imageView = (ImageView) itemView.findViewById(R.id.urlImageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
            }
        });

    }
}
