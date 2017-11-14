package layout.Activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.is3261.is3261_firebase.HomeActivity;
import com.project.is3261.is3261_firebase.Model.Status.CustomAdapter;
import com.project.is3261.is3261_firebase.Model.Status.Status;
import com.project.is3261.is3261_firebase.R;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.content.Context.MODE_PRIVATE;
import static com.project.is3261.is3261_firebase.R.id.charCount;
import static com.project.is3261.is3261_firebase.R.id.postButton;
import static com.project.is3261.is3261_firebase.R.id.progress_bar;
import static com.project.is3261.is3261_firebase.R.id.recyclerView;
import static com.project.is3261.is3261_firebase.R.id.statusText;
import static com.project.is3261.is3261_firebase.R.id.swipeContainerLayout;
import static com.project.is3261.is3261_firebase.SignUpActivity.MY_SHAREDPREF_NAME1;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoryFragment extends Fragment {


    private FirebaseDatabase mDatabase;
    private DatabaseReference myRef;
    private DatabaseReference news1;


    private static final String TAG = "RecyclerViewFragment";
    protected ProgressBar mProgressBar;
    protected EditText mStatusAdd;
    protected Button mPostButton;
    protected TextView charCounts;
    protected SwipeRefreshLayout swipeContainer;
    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected List<Status> data;
    private FirebaseDatabase database;

    public StoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_story, container, false);
        ((HomeActivity) getActivity()).setActionBarTitle("Status Feed");
        rootView.setTag(TAG);

        mProgressBar = rootView.findViewById(progress_bar);
        mRecyclerView = (RecyclerView) rootView.findViewById(recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        Runnable drawRunnable = new Runnable() {
            public void run() {
                refreshStatus();
            }
        };

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleAtFixedRate(drawRunnable , 0, 2, TimeUnit.MINUTES);

        data = fill_with_data();
        mAdapter = new CustomAdapter(getActivity(),data);
        mRecyclerView.setAdapter(mAdapter);
        // Set CustomAdapter as the adapter for RecyclerView.

//        mRecyclerView.addOnItemTouchListener(new CustomRVItemTouchListener(getActivity(), mRecyclerView, new RecyclerViewItemClickListener() {
//            @Override
//            public void onClick(View view, int position) {
////                List<Status> list = mAdapter.getList();
////                Status data = list.get(position);
////                Toast.makeText(getActivity(), data.title.toString(),
////                        Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(itemAnimator);


        // Lookup the swipe container view
        swipeContainer = rootView.findViewById(swipeContainerLayout);

        swipeContainer.post(new Runnable() {
            @Override public void run() {
                swipeContainer.setRefreshing(true);
            }
        });
        swipeContainer.setRefreshing(true);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                //fetchTimelineAsync();
                refreshStatus();
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        //post
        mStatusAdd = rootView.findViewById(statusText);
        mPostButton = rootView.findViewById(postButton);
        charCounts = rootView.findViewById(charCount);

        mStatusAdd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                charCounts.setText(s.length()+"/140");
            }
        });

        mPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postStatus();
            }

        });
        return rootView;
    }

    public void postStatus(){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Write a message to the database
            database = FirebaseDatabase.getInstance();
            DatabaseReference userRef=database.getReference().child("users").child(user.getUid()).child("name");
            myRef = database.getReference()
                    .child("users")
                    .child("status");

            String uniqueID = UUID.randomUUID().toString();
            myRef.child(uniqueID).child("statusText").setValue(mStatusAdd.getText().toString());
            SharedPreferences prefs = getActivity().getSharedPreferences(MY_SHAREDPREF_NAME1,MODE_PRIVATE);
            String name = prefs.getString("name", "user");
            myRef.child(uniqueID).child("authorText").setValue(name);
            myRef.child(uniqueID).child("like").setValue("0");
            myRef.child(uniqueID).child("commentNum").setValue("0");
            String[] names = {""};
            List nameList = new ArrayList<String>(Arrays.asList(names));
            myRef.child(uniqueID).child("likeUsers").setValue(nameList);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String time = sdf.format(Calendar.getInstance().getTime());
            myRef.child(uniqueID).child("timeText").setValue(time);

            mStatusAdd.setText("");
            hideSoftKeyboard();

        }
    }

    public void refreshStatus(){
        database = FirebaseDatabase.getInstance();

        myRef = database.getReference()
                .child("users")
                .child("status");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data.clear();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Log.d("snappy", snapshot.toString());
                    if(snapshot.hasChild("authorText") && snapshot.hasChild("statusText") && snapshot.hasChild("timeText")){
                        String authorText = snapshot.child("authorText").getValue().toString();
                        String statusText = snapshot.child("statusText").getValue().toString();
                        String timePosted = snapshot.child("timeText").getValue().toString();
                        final List nameList = (List) snapshot.child("likeUsers").getValue();
                        int like = Integer.valueOf(snapshot.child("like").getValue().toString());
                        int comment = ((int) snapshot.child("comments").getChildrenCount());
                        String uid = snapshot.getKey().toString();

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date = new Date();
                        try {
                            date = sdf.parse(timePosted);
                        }catch (ParseException e) {
                            e.printStackTrace();
                        }

                        PrettyTime prettyTime = new PrettyTime(new Date(date.getTime()));

                        TimeZone timeZone = TimeZone.getTimeZone("Asia/Singapore");
                        Calendar calendar = new GregorianCalendar();
                        calendar.setTimeZone(timeZone);

                        String ago = prettyTime.format(calendar.getTime());

                        Status dataItem = new Status(statusText,authorText,ago,timePosted,uid,like,comment,nameList);
                        data.add(dataItem);
                        mAdapter.notifyDataSetChanged();

                        Collections.sort(data, new Comparator<Status>() {
                            public int compare(Status o1, Status o2) {
                                return o2.getTimePosted().compareTo(o1.getTimePosted());
                            }
                        });

                    }

                }
                swipeContainer.setRefreshing(false);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    public void hideSoftKeyboard() {
        if(getActivity().getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }
    }

    public List<Status> fill_with_data() {

        List<Status> data = new ArrayList<>();
        return data;
    }








}
