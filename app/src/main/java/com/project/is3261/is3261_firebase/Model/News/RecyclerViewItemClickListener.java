package com.project.is3261.is3261_firebase.Model.News;

import android.view.View;

/**
 * Created by xunda on 6/10/17.
 */

public interface RecyclerViewItemClickListener {
    public void onClick(View view, int position);

    public void onLongClick(View view, int position);
}