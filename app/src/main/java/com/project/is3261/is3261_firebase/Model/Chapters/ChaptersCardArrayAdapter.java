package com.project.is3261.is3261_firebase.Model.Chapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.project.is3261.is3261_firebase.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bowen on 19/10/2017.
 */

public class ChaptersCardArrayAdapter extends ArrayAdapter<ChapterCard> {

    private List<ChapterCard> cardList = new ArrayList<ChapterCard>();

    public ChaptersCardArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(ChapterCard object) {
        cardList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.cardList.size();
    }

    @Override
    public ChapterCard getItem(int index) {
        return this.cardList.get(index);
    }

    @Override

    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        row = LayoutInflater.from(getContext()).inflate(R.layout.card_chapter, parent, false);
//        if (row == null) {
//            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            row = inflater.inflate(R.layout.card_chapter, parent, false);
//           // row = LayoutInflater.from(getContext()).inflate(R.layout.card_chapter, parent, false);
//        }

        ChapterCard card = getItem(position);

//        if (card != null) {
//            TextView title = (TextView) row.findViewById(R.id.title);
//            TextView description = (TextView) row.findViewById(R.id.description);
//            ImageView completion = (ImageView) row.findViewById(R.id.checkbox2);
//            if(card.getIsCompleted()){
//                completion.setVisibility(View.VISIBLE);
//            }
//            title.setText(card.getTitle());
//            description.setText(card.getDescription());
//
//        }

        return row;
    }

}
