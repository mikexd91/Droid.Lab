package com.project.is3261.is3261_firebase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import static com.project.is3261.is3261_firebase.R.id.card_listView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChaptersUserInterfaceFragment extends Fragment {

    private ChaptersCardArrayAdapter chaptersCardArrayAdapter;
    private View rootView;
    private ListView listView;

    public ChaptersUserInterfaceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_chapters_user_interface, container, false);
        listView = (ListView) rootView.findViewById(card_listView);

        chaptersCardArrayAdapter = new ChaptersCardArrayAdapter(getActivity().getApplicationContext(), R.layout.card_chapter);

        for (int i = 0; i < 10; i++) {
            ChapterCard card = new ChapterCard("newTitle", "newDescription");
            chaptersCardArrayAdapter.add(card);
        }

        listView.setAdapter(chaptersCardArrayAdapter);

        return listView;
    }
}
