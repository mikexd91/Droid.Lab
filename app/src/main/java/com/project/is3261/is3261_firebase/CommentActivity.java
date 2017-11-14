package com.project.is3261.is3261_firebase;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.is3261.is3261_firebase.Model.Status.CustomAdapter;
import com.project.is3261.is3261_firebase.Model.Status.Status;

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

import static android.content.ContentValues.TAG;
import static com.project.is3261.is3261_firebase.R.id.charCount;
import static com.project.is3261.is3261_firebase.R.id.postButton;
import static com.project.is3261.is3261_firebase.R.id.recyclerView;
import static com.project.is3261.is3261_firebase.R.id.statusText;
import static com.project.is3261.is3261_firebase.R.id.swipeContainerLayout;
import static com.project.is3261.is3261_firebase.SignUpActivity.MY_SHAREDPREF_NAME1;

public class CommentActivity extends Activity {
    String uid;
    FirebaseDatabase database;
    DatabaseReference myRef;
    protected SwipeRefreshLayout swipeContainer;
    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected List<Status> data;
    protected EditText mStatusAdd;
    protected Button mPostButton;
    protected TextView charCounts;
    int commentNumber=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        uid = getIntent().getStringExtra("uid");
        mRecyclerView = (RecyclerView) findViewById(recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        data = fill_with_data();
        mAdapter = new CustomAdapter(this,data);
        mRecyclerView.setAdapter(mAdapter);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(itemAnimator);

        refreshComments();
        Runnable drawRunnable = new Runnable() {
            public void run() {
                refreshComments();
            }
        };

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleAtFixedRate(drawRunnable , 0, 2, TimeUnit.MINUTES);

        // Lookup the swipe container view
        swipeContainer = findViewById(swipeContainerLayout);
//
//        swipeContainer.post(new Runnable() {
//            @Override public void run() {
//                swipeContainer.setRefreshing(true);
//            }
//        });
//
//        //swipeContainer.setRefreshing(true);
//        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                //fetchTimelineAsync();
                refreshComments();
            }
        });
//        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        //post
        mStatusAdd = findViewById(statusText);
        mStatusAdd.setHint("Write a comment...");
        mPostButton = findViewById(postButton);
        mPostButton.setText("Comment");
        charCounts = findViewById(charCount);

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
                postComment();
            }

        });

        DatabaseReference myRef1 = database.getReference()
                .child("users")
                .child("status")
                .child(uid)
                .child("comments");


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference()
                .child("users")
                .child("status")
                .child(uid);

        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data.clear();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                commentNumber = ((int) dataSnapshot.getChildrenCount());
                myRef.child("commentNum").setValue(commentNumber);
                refreshComments();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
//                List<Status> data = new ArrayList<>();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                    Log.d("snappy", snapshot.toString());
                    if(snapshot.hasChild("authorText") && snapshot.hasChild("statusText") && snapshot.hasChild("timeText")){
                        final String authorText = snapshot.child("authorText").getValue().toString();
                        String statusText = snapshot.child("statusText").getValue().toString();
                        String timePosted = snapshot.child("timeText").getValue().toString();
                        final List nameList = (List) snapshot.child("likeUsers").getValue();
                        int likes = Integer.valueOf(snapshot.child("like").getValue().toString());
                        int comments = Integer.valueOf(snapshot.child("commentNum").getValue().toString());
                        final String uid1 = snapshot.getKey().toString();

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

                        final Status dataItem = new Status(statusText,authorText,ago,timePosted,uid1,likes,comments,nameList);

                        TextView title = (TextView) findViewById(R.id.title);
                        TextView description = (TextView) findViewById(R.id.description);
                        TextView time = (TextView) findViewById(R.id.time);
                        Button like  = (Button) findViewById((R.id.likeButton));
                        Button comment  = (Button) findViewById((R.id.commentButton));

                        title.setText(authorText);
                        description.setText(statusText);
                        time.setText(ago);
                        if (dataItem.getLike() == 1) {
                            like.setText(String.valueOf(likes) + " like");
                        } else {
                            like.setText(String.valueOf(likes) + " likes");
                        }
                        if (dataItem.getComment() == 1) {
                            comment.setText(String.valueOf(comments) + " comment");
                        } else {
                            comment.setText(String.valueOf(comments) + " comments");
                        }

                        like.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                if (user != null) {
                                    // Write a message to the database
                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    DatabaseReference myRef = database.getReference()
                                            .child("users")
                                            .child("status")
                                            .child(uid1)
                                            .child("likeUsers");

                                    DatabaseReference myRef2 = database.getReference()
                                            .child("users")
                                            .child("status")
                                            .child(uid1)
                                            .child("like");

                                    if(nameList.contains(authorText) && dataItem.getLike()!=0){
                                        List name = nameList;
                                        name.remove(authorText);
                                        myRef.setValue(name);
                                        int likeNum = dataItem.getLike() - 1;
                                        myRef2.setValue(String.valueOf(likeNum));
                                    }else{
                                        List name = nameList;
                                        name.add(authorText);
                                        myRef.setValue(name);
                                        int likeNum = dataItem.getLike() + 1;
                                        myRef2.setValue(String.valueOf(likeNum));
                                    }
                                }
                            }
                        });
                    }
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }


    public void postComment(){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Write a message to the database
            database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference()
                    .child("users")
                    .child("status")
                    .child(uid)
                    .child("comments");

            String uniqueID = UUID.randomUUID().toString();

            myRef.child(uniqueID).child("commentText").setValue(mStatusAdd.getText().toString());
            SharedPreferences prefs = this.getSharedPreferences(MY_SHAREDPREF_NAME1,MODE_PRIVATE);
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

    public void refreshComments(){
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference()
                .child("users")
                .child("status")
                .child(uid)
                .child("comments");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data.clear();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                long commentNumber = dataSnapshot.getChildrenCount();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Log.d("snappy", snapshot.toString());
                    if(snapshot.hasChild("authorText") && snapshot.hasChild("commentText") && snapshot.hasChild("timeText") && snapshot.hasChild("like") && snapshot.hasChild("commentNum")){
                        String authorText = snapshot.child("authorText").getValue().toString();
                        String statusText = snapshot.child("commentText").getValue().toString();
                        String timePosted = snapshot.child("timeText").getValue().toString();
                        int like = Integer.valueOf(snapshot.child("like").getValue().toString());
                        int comment = Integer.valueOf(snapshot.child("commentNum").getValue().toString());
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

                        //Toast.makeText(getApplicationContext(), "asdasd", Toast.LENGTH_SHORT).show();
                        Status dataItem = new Status(statusText,authorText,ago,timePosted,uid,like,comment,true);
                        data.add(dataItem);

                        mAdapter.notifyDataSetChanged();

                        Collections.sort(data, new Comparator<Status>() {
                            public int compare(Status o1, Status o2) {
                                return o1.getTimePosted().compareTo(o2.getTimePosted());
                            }
                        });

                    }

                }
                mRecyclerView.scrollToPosition(data.size()-1);
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
        if(this.getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public List<Status> fill_with_data() {

        List<Status> data = new ArrayList<>();
        return data;
    }
}
