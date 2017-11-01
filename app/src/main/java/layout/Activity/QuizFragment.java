package layout.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.project.is3261.is3261_firebase.R;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseUser user;

    private ListView mListView;
    private ChaptersCardArrayAdapter chaptersCardArrayAdapter;

    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        ((HomeActivity) getActivity()).setActionBarTitle("Quiz");


        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Write a message to the database
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference().child("users")
                    .child(user.getUid())
                    .child("lesson");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    //String value = dataSnapshot.getValue(String.class);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Log.d(TAG, "Value is: " + snapshot.getValue().toString());
                        for(DataSnapshot snap : snapshot.getChildren()){
                            Log.d(TAG, "Value is: " + snap.getValue().toString());

                            String isComplete = snap.child("isComplete").getValue().toString();
                            Log.d(TAG, "Value is: " + isComplete);
                            String fragNum = snap.child("fragNum").getValue().toString();
                            Log.d(TAG, "fragment: " + fragNum);
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

        mListView = (ListView) view.findViewById(R.id.listView);
        chaptersCardArrayAdapter = new ChaptersCardArrayAdapter(getActivity(), R.layout.card_chapter);
        ChapterCard card;
        String title, description;

        //Quiz cards
        title = "User Interface";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        title = "User Input";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        title = "Multiscreen";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        title = "Extra Questions";
        description = "";
        card = new ChapterCard(title, description);
        chaptersCardArrayAdapter.add(card);

        mListView.setAdapter(chaptersCardArrayAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
                        i.putExtra("title","multiscreen");
                        i.putExtra("quiz",position);
                        break;
                    case 3:
                        i.putExtra("title","extraQuestions");
                        i.putExtra("quiz",position);
                        break;
                }

                startActivity(i);
            }
        });

        return view;
    }

}
