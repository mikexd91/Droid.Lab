package layout.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.is3261.is3261_firebase.HomeActivity;
import com.project.is3261.is3261_firebase.R;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseUser user;
    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

}
