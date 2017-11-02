package layout.Chapters;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.is3261.is3261_firebase.DetailLessonActivity;
import com.project.is3261.is3261_firebase.Model.Chapters.ChapterCard;
import com.project.is3261.is3261_firebase.Model.Chapters.ChaptersCardArrayAdapter;
import com.project.is3261.is3261_firebase.Model.News.CustomAdapterLesson;
import com.project.is3261.is3261_firebase.Model.News.CustomRVItemTouchListener;
import com.project.is3261.is3261_firebase.Model.News.RecyclerViewItemClickListener;
import com.project.is3261.is3261_firebase.R;

import java.util.ArrayList;
import java.util.List;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;
import static com.project.is3261.is3261_firebase.R.id.recyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChaptersUserInputFragment extends Fragment {

    private ListView mListView;
    private ChaptersCardArrayAdapter chaptersCardArrayAdapter;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseUser user;

    protected RecyclerView mRecyclerView;
    protected CustomAdapterLesson mAdapter;
    List<ChapterCard> mList;
    public ChaptersUserInputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chapters_user_input, container, false);
       // mListView = (ListView) view.findViewById(R.id.listView);
        mList = new ArrayList<>();
        chaptersCardArrayAdapter = new ChaptersCardArrayAdapter(getActivity(), R.layout.card_chapter);
        ChapterCard card;
        String title, description;
        //Making an App Interactive: Part 1
        //card1
        title = "Introduction";
        description = "We'll teach you how to build an app with buttons and text fields that you can interact with.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card2
        title = "Plan How to Build the Layout";
        description = "Selecting, positioning and styling the views.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card3
        title = "Build Layout";
        description = "It's time to build the layout.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card4
        title = "Do Something When the Button is Clicked";
        description = "Adding a Button XML attribute.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card5
        title = "Modifying First Lines of Java Code";
        description = "Looking at the code and modifying it.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card6
        title = "Add TextViews for Price";
        description = "Adding TextViews to the layout.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card7
        title = "Debugging a Crash";
        description = "Oh no! The app crashed! What do I do?";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card8
        title = "Hook Up Two Buttons";
        description = "Buttons, buttons and more buttons.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card9
        title = "Debug Mode in Android Studio";
        description = "Identifying and fixing errors in your code.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //Making an App Interactive: Part 2
        //card10
        title = "Nested ViewGroups";
        description = "Building interesting and complex layouts.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card11
        title = "View Hierarchy Diagrams";
        description = "Understanding the arrangement of different layouts.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card12
        title = "Build the Quantity Picker Layout";
        description = "Writing XML for a layout.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //Object-Oriented Programming: Part 1
        //card13
        title = "Resources";
        description = "Images, colors, dimensions, raw media files, etc.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card14
        title = "Resource IDs";
        description = "Accessing resources using IDs.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card15
        title = "From XML to Java";
        description = "What's happening between XML & Java.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card16
        title = "Inheriting Behaviour";
        description = "Extension of functionalities.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card17
        title = "Find View by Id";
        description = "Accessing views using IDs.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card18
        title = "Casting with findViewById";
        description = "Type casting views obtained from findViewById.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //Object-Oriented Programming: Part 2
        //card19
        title = "Practice With Intents";
        description = "Sending and receiving intents.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card20
        title = "Localization";
        description = "Adapting your app to different locales.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card21
        title = "Styles";
        description = "Changing the design of a view.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card22
        title = "Themes";
        description = "Styles for an activity or application.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

//        mListView.setAdapter(chaptersCardArrayAdapter);
//
//        mListView.setOnItemClickListener(new OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent i = new Intent(getActivity(), DetailLessonActivity.class);
//                i.putExtra("title","userInput");
//                i.putExtra("lesson",position);
//                startActivity(i);
//            }
//        });

        mRecyclerView = (RecyclerView) view.findViewById(recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new CustomAdapterLesson(getActivity(),mList);
        mRecyclerView.setAdapter(mAdapter);
        // Set CustomAdapter as the adapter for RecyclerView.

        mRecyclerView.addOnItemTouchListener(new CustomRVItemTouchListener(getActivity(), mRecyclerView, new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                List<ChapterCard> list = mAdapter.getList();
                ChapterCard data = list.get(position);
                Intent i = new Intent(getActivity(), DetailLessonActivity.class);
                i.putExtra("title","userInput");
                i.putExtra("lesson",position);
                startActivity(i);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(itemAnimator);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Write a message to the database
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference().child("users")
                    .child(user.getUid())
                    .child("lesson");
            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    //String value = dataSnapshot.getValue(String.class);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Log.d(TAG, "Value is: " + snapshot.getValue().toString());
                        int i = 0;
                        for(DataSnapshot snap : snapshot.getChildren()){
                            Log.d(TAG, "Value is: " + snap.getValue().toString() + " " + i);
                            String isComplete = snap.child("isComplete").getValue().toString();
                            if(isComplete.equalsIgnoreCase("true")){
                                Log.d(TAG, "Value is: " + snap.getValue().toString() + " " + i);
                                chaptersCardArrayAdapter.getItem(i++).setIsCompleted(true);
                            }
//                            String fragNum = snap.child("fragNum").getValue().toString();
//                            Log.d(TAG, "fragment: " + fragNum);
                        }
                    }

                    //Log.d(TAG, "Value is: " + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });


//            myRef = database.getReference()
//                    .child("users")
//                    .child(user.getUid());

        }
        return view;
    }

}
