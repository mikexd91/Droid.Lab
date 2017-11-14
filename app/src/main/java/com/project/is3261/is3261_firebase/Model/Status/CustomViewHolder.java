package com.project.is3261.is3261_firebase.Model.Status;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.is3261.is3261_firebase.R;

/**
 * Created by xunda on 6/10/17.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "ViewHolder";
    CardView cv;
    TextView uid;
    TextView title;
    TextView description;
    TextView time;
    TextView publishedAt;
    ImageView imageView;
    Button like;
    Button comment;


    CustomViewHolder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
//        uid = (TextView) itemView.findViewById(R.id.uid);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
        time = (TextView) itemView.findViewById(R.id.time);
        like  = (Button) itemView.findViewById((R.id.likeButton));
        comment  = (Button) itemView.findViewById((R.id.commentButton));
//        publishedAt = (TextView) itemView.findViewById(R.id.publishedAt);
//        imageView = (ImageView) itemView.findViewById(R.id.urlImageView);


//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
//            }
//        });

    }
}
