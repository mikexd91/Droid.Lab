package layout.Activity;


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
import com.project.is3261.is3261_firebase.DetailQuizActivity;
import com.project.is3261.is3261_firebase.HomeActivity;
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
public class QuizFragment extends Fragment {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseUser user;

    private ListView mListView;
    private ChaptersCardArrayAdapter chaptersCardArrayAdapter;
    protected RecyclerView mRecyclerView;
    protected CustomAdapterLesson mAdapter;
    List<ChapterCard> mList;

    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        ((HomeActivity) getActivity()).setActionBarTitle("Quiz");

        mList = new ArrayList<>();
        mListView = (ListView) view.findViewById(R.id.listView);
        chaptersCardArrayAdapter = new ChaptersCardArrayAdapter(getActivity(), R.layout.card_chapter);
        ChapterCard card;
        String title, description;

        //Quiz cards
        title = "User Interface";
        description = "Test your user interface skills here!";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        title = "User Input";
        description = "Test your user input skills here!";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        title = "Multiple Screen";
        description = "Test your multiple screen skills here!";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);
        mList.add(card);

        title = "Extra Questions";
        description = "Extra Quesitons to spice up your life!";
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

                Intent i = new Intent(getActivity(), DetailQuizActivity.class);

                switch (position) {
                    case 0:
                        i.putExtra("title","userInterface");
                        i.putExtra("quiz",position);
                        break;
                    case 1:
                        i.putExtra("title","userInput");
                        i.putExtra("quiz",position);
                        break;
                    case 2:
                        i.putExtra("title","multipleScreen");
                        i.putExtra("quiz",position);
                        break;
                    case 3:
                        i.putExtra("title","extraQuestions");
                        i.putExtra("quiz",position);
                        break;
                }

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
                    .child("quiz");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    //String value = dataSnapshot.getValue(String.class);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Log.d(TAG, "entireeeee Value is: " + snapshot.getValue().toString());
//                        for (DataSnapshot snapshot2 : dataSnapshot.getChildren()) {
                            String isComplete = snapshot.child("isComplete").getValue().toString();
                            if(isComplete.equalsIgnoreCase("true")){
                                Log.d(TAG, "Value is: " + snapshot.getValue().toString() + " " + snapshot.getKey().toString());
                                mAdapter.getList().get(Integer.valueOf(snapshot.getKey().toString())).setIsCompleted(true);
                                mAdapter.notifyDataSetChanged();
                            }
//                        }

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

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }
}
