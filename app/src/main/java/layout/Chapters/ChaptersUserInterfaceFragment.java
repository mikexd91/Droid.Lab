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
public class ChaptersUserInterfaceFragment extends Fragment {
    private ListView mListView;
    private ChaptersCardArrayAdapter chaptersCardArrayAdapter;
    public ChaptersUserInterfaceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chapters_user_interface, container, false);
        mListView = (ListView) view.findViewById(R.id.listView);
        chaptersCardArrayAdapter = new ChaptersCardArrayAdapter(getActivity(), R.layout.card_chapter);
        ChapterCard card;
        String title, description;

        //Building Layouts: Part 1
        //card1
        title = "Introduction";
        description = "We'll discuss how to create a user interface through a series of short videos and hands-on practice.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card2
        title = "Views";
        description = "The first thing in Android you need to learn.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card3
        title = "Using a TextView";
        description = "Let's learn how to create an TextView.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card4
        title = "XML Syntax";
        description = "Rules that define what a valid XML is.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card5
        title = "Change the TextView";
        description = "Modifying the TextView.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card6
        title = "Setting Wrap Content";
        description = "Arranging and aligning texts.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card7
        title = "TextView Text Size";
        description = "How to change the text size.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card8
        title = "TextView Text color";
        description = "How to change the text color.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card9
        title = "Simple ImageView";
        description = "Let's now learn how to create an ImageView.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //Building Layouts: Part 2
        //card10
        title = "ViewGroups";
        description = "We'll introduce what a ViewGroup is.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card11
        title = "Types of ViewGroups";
        description = "The different types of ViewGroups.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card12
        title = "LinearLayout";
        description = "A very simple layout.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card13
        title = "Width and Height";
        description = "Changing the size of views.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card14
        title = "Evenly Spacing out Children Views";
        description = "How to evenly space out different views.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card15
        title = "Layout Weight";
        description = "Spacing out views equally.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card16
        title = "Relative Layout";
        description = "Let's build more flexible layouts.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card17
        title = "Relative to Other Views";
        description = "Positioning children relative to other views.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card18
        title = "Padding vs Margin";
        description = "What's the difference?";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        mListView.setAdapter(chaptersCardArrayAdapter);

        mListView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), DetailLessonActivity.class);
                i.putExtra("title","userInterface");
                i.putExtra("lesson",position+1);
                startActivity(i);
            }
        });

        return view;


    }



}
