package layout.Chapters;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.project.is3261.is3261_firebase.DetailLessonActivity;
import com.project.is3261.is3261_firebase.Model.Chapters.ChapterCard;
import com.project.is3261.is3261_firebase.Model.Chapters.ChaptersCardArrayAdapter;
import com.project.is3261.is3261_firebase.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChaptersUserInputFragment extends Fragment {

    private ListView mListView;
    private ChaptersCardArrayAdapter chaptersCardArrayAdapter;
    public ChaptersUserInputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chapters_user_input, container, false);
        mListView = (ListView) view.findViewById(R.id.listView);

        chaptersCardArrayAdapter = new ChaptersCardArrayAdapter(getActivity(), R.layout.card_chapter);
        ChapterCard card;
        String title, description;

        //Making an App Interactive: Part 1
        //card1
        title = "Introduction";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card2
        title = "Plan How to Build the Layout";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card3
        title = "Build Layout";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card4
        title = "Do Something When the Button is Clicked";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card5
        title = "Modifying First Lines of Java Code";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card6
        title = "Add TextViews for Price";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card7
        title = "Debugging a Crash";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card8
        title = "Hook Up Two Buttons";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card9
        title = "Debug Mode in Android Studio";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //Making an App Interactive: Part 2
        //card10
        title = "Nested ViewGroups";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card11
        title = "View Hierarchy Diagrams";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card12
        title = "Build the Quantity Picker Layout";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //Object-Oriented Programming: Part 1
        //card13
        title = "Resources";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card14
        title = "Resource IDs";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card15
        title = "From XML to Java";
        description = "What's happening between XML & Java.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card16
        title = "Inheriting Behaviour";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card17
        title = "Find View by Id";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card18
        title = "Casting with findViewById";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //Object-Oriented Programming: Part 2
        //card19
        title = "Practice With Intents";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card20
        title = "Localization";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card21
        title = "Styles";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card22
        title = "Themes";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        mListView.setAdapter(chaptersCardArrayAdapter);

        mListView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), DetailLessonActivity.class);
                i.putExtra("title","userInput");
                i.putExtra("lesson",position+1);
                startActivity(i);
            }
        });
        return view;
    }

}
