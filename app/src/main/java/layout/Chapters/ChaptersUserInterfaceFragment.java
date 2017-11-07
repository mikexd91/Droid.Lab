package layout.Chapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import static com.project.is3261.is3261_firebase.R.id.recyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChaptersUserInterfaceFragment extends Fragment {
    private ListView mListView;
    private ChaptersCardArrayAdapter chaptersCardArrayAdapter;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseUser user;

    protected RecyclerView mRecyclerView;
    protected CustomAdapterLesson mAdapter;
    List<ChapterCard> mList;

    private static String TAG ="chapters";
    public ChaptersUserInterfaceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chapters_user_interface, container, false);
        //mListView = (ListView) view.findViewById(R.id.listView);
        mList = new ArrayList<>();
        chaptersCardArrayAdapter = new ChaptersCardArrayAdapter(getActivity(), R.layout.card_chapter);
        ChapterCard card;
        String title, description;

        //Building Layouts: Part 1
        //card1
        title = "Introduction";
        description = "We'll discuss how to create a user interface through a series of short videos and hands-on practice.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card2
        title = "Views";
        description = "The first thing in Android you need to learn.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card3
        title = "Using a TextView";
        description = "Let's learn how to create an TextView.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card4
        title = "XML Syntax";
        description = "Rules that define what a valid XML is.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card5
        title = "Change the TextView";
        description = "Modifying the TextView.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card6
        title = "Setting Wrap Content";
        description = "Arranging and aligning texts.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card7
        title = "TextView Text Size";
        description = "How to change the text size.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card8
        title = "TextView Text color";
        description = "How to change the text color.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card9
        title = "Simple ImageView";
        description = "Let's now learn how to create an ImageView.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //Building Layouts: Part 2
        //card10
        title = "ViewGroups";
        description = "We'll introduce what a ViewGroup is.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card11
        title = "Types of ViewGroups";
        description = "The different types of ViewGroups.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card12
        title = "LinearLayout";
        description = "A very simple layout.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card13
        title = "Width and Height";
        description = "Changing the size of views.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card14
        title = "Evenly Spacing out Children Views";
        description = "How to evenly space out different views.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card15
        title = "Layout Weight";
        description = "Spacing out views equally.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card16
        title = "Relative Layout";
        description = "Let's build more flexible layouts.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card17
        title = "Relative to Other Views";
        description = "Positioning children relative to other views.";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        //card18
        title = "Padding vs Margin";
        description = "What's the difference?";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

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
                i.putExtra("title","userInterface");
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
                    .child("lesson")
                    .child("userInterface");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    //String value = dataSnapshot.getValue(String.class);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String isComplete = snapshot.child("isComplete").getValue().toString();
                        if(isComplete.equalsIgnoreCase("true")){
                            Log.d(TAG, "Value is: " + snapshot.getValue().toString() + " " + snapshot.getKey().toString());
                            mAdapter.getList().get(Integer.valueOf(snapshot.getKey().toString())).setIsCompleted(true);
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });

        }


        return view;


    }



}
