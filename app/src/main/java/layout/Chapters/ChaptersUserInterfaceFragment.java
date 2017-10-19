package layout.Chapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.project.is3261.is3261_firebase.Model.Chapters.ChapterCard;
import com.project.is3261.is3261_firebase.Model.Chapters.ChaptersCardArrayAdapter;
import com.project.is3261.is3261_firebase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChaptersUserInterfaceFragment extends Fragment {

    public ChaptersUserInterfaceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chapters_user_interface, container, false);
        ListView mListView = (ListView) view.findViewById(R.id.listview);

        ChaptersCardArrayAdapter chaptersCardArrayAdapter = new ChaptersCardArrayAdapter(getActivity(), R.layout.card_chapter);

        for (int i = 0; i < 10; i++) {
            ChapterCard card = new ChapterCard("newTitle", "newDescription");
            chaptersCardArrayAdapter.add(card);
        }

        mListView.setAdapter(chaptersCardArrayAdapter);

        return view;
    }
}