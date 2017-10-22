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
        description = "Let's look at an overview for this lesson.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card2
        title = "Overview of the Miwok App";
        description = "Let's look at an overview for the Miwok app.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card3
        title = "Import an Existing Project";
        description = "We've created an initial version for you to start off with.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card4
        title = "Checking the build.gradle file";
        description = "A build configuration script for the project.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card5
        title = "Read MainActivity.java file";
        description = "MainActivity and other activities.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card6
        title = "Create New Activities";
        description = "Activities, activities and more activities";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card7
        title = "The AndroidManifest.xml file";
        description = "A table of contents for the app.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card8
        title = "Use an Intent to Open Another Activity";
        description = "Navigating to other activities.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card9
        title = "Implicit vs Explicit Intents";
        description = "What's the difference?";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card10
        title = "Modifying the Activity Name";
        description = "Changing the name for different activities.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card11
        title = "Event Listeners in Android";
        description = "Listening for user input events";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card12
        title = "OnClickListener";
        description = "Using boxes to explain onClickListener";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card13
        title = "What is an Interface?";
        description = "Interfaces Vs classes.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card14
        title = "How to Create an Event Listener";
        description = "Let's learn to setup an event listener.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card15
        title = "Use OnClickListeners For all Categories";
        description = "Another way to setup an event listener.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card16
        title = "OnClickListener Vs onClick";
        description = "What's the difference?";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //Lesson 2
        //card17
        title = "Memory is a Limited Resource";
        description = "How to manage memory when building an Android app.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card18
        title = "View Recycling";
        description = "Making efficient use of memory.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card19
        title = "Analogy for ListView";
        description = "When to recycle views?";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card20
        title = "Switch to Using ListView and ArrayAdapter";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card21
        title = "ListView and ArrayAdapter";
        description = "What to do when there are too many items on screen?";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card22
        title = "ListView and ArrayAdapter Code";
        description = "Let's look at the code for a ListView and an ArrayAdapter.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card23
        title = "Build List Item Layout";
        description = "Using a layout for an item repeatedly.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card24
        title = "Custom Word Class";
        description = "Defining a custom class for our app.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card25
        title = "Need a Custom ArrayAdapter";
        description = "Implementing a custom ArrayAdapter.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card26
        title = "Example App with Custom ArrayAdapter";
        description = "An example using custom ArrayAdapter.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card27
        title = "Custom ArrayAdapter";
        description = "Let's start using our custom ArrayAdapter.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //Images and Visual Polish
        //card28
        title = "Scope Out Work for a New Feature";
        description = "Looking at what we have to do and how for new features.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card29
        title = "What Order to Make Changes In";
        description = "A plan for making changes.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card30
        title = "Modify List Item Layout";
        description = "Modifying the layout to add images.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card31
        title = "Asset Drop";
        description = "What's an asset?";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card32
        title = "Add Image Assets to the App";
        description = "Different sizes for an image asset.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card33
        title = "Plan How to Modify Word Class";
        description = "How do we go about modifying the word class to support images?";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card35
        title = "Multiple Constructors for Word Class";
        description = "Creating different constructors.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card36
        title = "Modify the WordAdapter Class";
        description = "Modify instructions to set correct images on ImageView.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card37
        title = "Fix PhrasesActivity to Hide Images";
        description = "Changing view visibility.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card38
        title = "Visual Polish";
        description = "Time to polish our app!";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card39
        title = "Different Background Colors for List Items";
        description = "Changing colors for list items.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //Activity Lifecycle and Audio Playback

        //Fragments
        //card40
        title = "Navigation Patterns in Android";
        description = "There are many ways to navigate around apps.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card41
        title = "Up Button";
        description = "Up button Vs Back button.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card42
        title = "Upcoming Changes";
        description = "We're going to approach several changes in multiple stages.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card43
        title = "Sample ViewPager";
        description = "What is a ViewPager?";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card44
        title = "Intro to Fragments";
        description = "Let's take a look at fragments.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card45
        title = "Fragment Lifecycle";
        description = "A fragment has its own lifecycle.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card46
        title = "Refactor Category Activities";
        description = "Changing activities to fragments.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card47
        title = "ViewPager and FragmentPagerAdapter";
        description = "Modifying MainActivity so that it uses a ViewPager.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        //card48
        title = "Add Tabs to ViewPager";
        description = "Now let's add tabs to know there are more pages to swipe to.";
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
