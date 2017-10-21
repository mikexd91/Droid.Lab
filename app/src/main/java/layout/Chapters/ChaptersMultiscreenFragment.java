package layout.Chapters;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import com.project.is3261.is3261_firebase.DetailLessonActivity;
import com.project.is3261.is3261_firebase.Model.Chapters.ChapterCard;
import com.project.is3261.is3261_firebase.Model.Chapters.ChaptersCardArrayAdapter;
import com.project.is3261.is3261_firebase.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChaptersMultiscreenFragment extends Fragment {

    private ListView mListView;
    private ChaptersCardArrayAdapter chaptersCardArrayAdapter;
    public ChaptersMultiscreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chapters_multiscreen, container, false);
        mListView = (ListView) view.findViewById(R.id.listView);

        chaptersCardArrayAdapter = new ChaptersCardArrayAdapter(getActivity(), R.layout.card_chapter);
        ChapterCard card;
        String title, description;

        //Intents and Activities
        //card1
        title = "Course Map";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card2
        title = "Overview of the Miwok App";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card3
        title = "Import an Existing Project";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card4
        title = "Checking the build.gradle file";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card5
        title = "Read MainActivity.java file";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card6
        title = "Create New Activities";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card7
        title = "The AndroidManifest.xml file";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card8
        title = "Use an Intent to Open Another Activity";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card9
        title = "Implicit vs Explicit Intents";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card10
        title = "Modifying the Activity Name";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card11
        title = "Event Listeners in Android";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card12
        title = "OnClickListener";
        description = "Using boxes to explain onClickListener";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card13
        title = "What is an Interface?";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card14
        title = "How to Create an Event Listener";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card15
        title = "Use OnClickListeners For all Categories";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card16
        title = "OnClickListener Vs onClick";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //Lesson 2
        //card17
        title = "Memory is a Limited Resource";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card18
        title = "View Recycling";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card19
        title = "Analogy for ListView";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card20
        title = "Switch to Using ListView and ArrayAdapter";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card21
        title = "ListView and ArrayAdapter";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card22
        title = "ListView and ArrayAdapter Code";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card23
        title = "Build List Item Layout";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card24
        title = "Custom Word Class";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card25
        title = "Need a Custom ArrayAdapter";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card26
        title = "Example App with Custom ArrayAdapter";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card27
        title = "Custom ArrayAdapter";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //Images and Visual Polish
        //card28
        title = "Scope Out Work for a New Feature";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card29
        title = "What Order to Make Changes In";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card30
        title = "Modify List Item Layout";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card31
        title = "Asset Drop";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card32
        title = "Add Image Assets to the App";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card33
        title = "Plan How to Modify Word Class";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card34
        title = "Modify Word Class";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card35
        title = "Multiple Constructors for Word Class";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card36
        title = "Modify the WordAdapter Class";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card37
        title = "Fix PhrasesActivity to Hide Images";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card38
        title = "Visual Polish";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card39
        title = "Different Background Colors for List Items";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //Activity Lifecycle and Audio Playback

        //Fragments
        //card40
        title = "Navigation Patterns in Android";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card41
        title = "Up Button";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card42
        title = "Upcoming Changes";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card43
        title = "Sample ViewPager";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card44
        title = "Intro to Fragments";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card45
        title = "Fragment Lifecycle";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card46
        title = "Refactor Category Activities";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card47
        title = "ViewPager and FragmentPagerAdapter";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card48
        title = "Add Tabs to ViewPager";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        mListView.setAdapter(chaptersCardArrayAdapter);
        mListView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"hello",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(), DetailLessonActivity.class);
                i.putExtra("title","multipleScreen");
                i.putExtra("lesson",position+1);
                startActivity(i);
            }
        });
        return view;
    }

}
