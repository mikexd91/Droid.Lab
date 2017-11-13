package layout.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.project.is3261.is3261_firebase.ChaptersActivity;
import com.project.is3261.is3261_firebase.HomeActivity;
import com.project.is3261.is3261_firebase.Model.News.CustomAdapter;
import com.project.is3261.is3261_firebase.Model.News.CustomRVItemTouchListener;
import com.project.is3261.is3261_firebase.Model.News.Data;
import com.project.is3261.is3261_firebase.Model.News.RecyclerViewItemClickListener;
import com.project.is3261.is3261_firebase.R;

import java.util.ArrayList;
import java.util.List;

import static com.project.is3261.is3261_firebase.R.id.progress_bar;
import static com.project.is3261.is3261_firebase.R.id.recyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LessonFragment extends Fragment {

    private FirebaseDatabase mDatabase;
    private DatabaseReference myRef;
    private DatabaseReference news1;
    private FirebaseStorage storage;

    private StorageReference storageRef;

    private static final String TAG = "RecyclerViewFragment";
    protected ProgressBar mProgressBar;
    protected SwipeRefreshLayout swipeContainer;
    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected List<Data> data;


    public List<Data> fill_with_data() {

        // Create a storage reference from our app
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        List<Data> data = new ArrayList<>();

        String userInterface = "https://firebasestorage.googleapis.com/v0/b/is3261-50f58.appspot." +
                "com/o/Lesson%20Menu%2Fuser_interface.jpg?alt=media&token=74b3453e-da87-434e-8119-6c274243a7ec";
        String userInput = "https://firebasestorage.googleapis.com/v0/b/is3261-50f58.appspot." +
                "com/o/Lesson%20Menu%2Fuser_input.jpg?alt=media&token=845256ab-bb50-426e-8269-4e5ba5454616";
        String multipleScreen = "https://firebasestorage.googleapis.com/v0/b/is3261-50f58.appspot.com" +
                "/o/Lesson%20Menu%2Fmultiple_screen.jpg?alt=media&token=ccc638f2-b896-437b-97fb-84c6deaf1f7e";
        String dataStorage = "https://firebasestorage.googleapis.com/v0/b/is3261-50f58.appspot.com/o/" +
                "Lesson%20Menu%2Fdata_storage.jpg?alt=media&token=46654c25-16e5-4805-937a-6893efa2c490";
        String networking = "https://firebasestorage.googleapis.com/v0/b/is3261-50f58.appspot.com/o/" +
                "Lesson%20Menu%2Fnetworking.jpg?alt=media&token=7a17e1bb-21b1-4fff-9eab-898763bca5ef";
        data.add(new Data("User Interface", "By the end of this course, you’ll know how to make " +
                "a single-screen Android app with text and images. We’ll discuss " +
                "how to create a user interface through a series of short videos " +
                "with lots of hands-on practice.", userInterface));
        data.add(new Data("User Input", "By the end of this course, you’ll know how to make " +
                "a single-screen Android app with text and images. We’ll discuss " +
                "how to create a user interface through a series of short videos " +
                "with lots of hands-on practice.", userInput));
        data.add(new Data("Multiple Screen (Coming Soon)", "By the end of this course, you’ll know how to make " +
                "a single-screen Android app with text and images. We’ll discuss " +
                "how to create a user interface through a series of short videos " +
                "with lots of hands-on practice.", multipleScreen));
        data.add(new Data("Data Storage (Coming Soon)", "In this course, you'll learn the basics of data " +
                "storage in Andriod, building your first database and an app " +
                "that could be used for any small business!", dataStorage));
        data.add(new Data("Networking (Coming Soon)", "By the end of this course, you’ll know how to make " +
                "a single-screen Android app with text and images. We’ll discuss " +
                "how to create a user interface through a series of short videos " +
                "with lots of hands-on practice.", networking));

        return data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lesson, container, false);
        ((HomeActivity) getActivity()).setActionBarTitle("Lessons");
        rootView.setTag(TAG);

        mProgressBar = rootView.findViewById(progress_bar);
        mRecyclerView = (RecyclerView) rootView.findViewById(recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        data=fill_with_data();
        mAdapter = new CustomAdapter(getActivity(),data);
        mRecyclerView.setAdapter(mAdapter);
        // Set CustomAdapter as the adapter for RecyclerView.

        mRecyclerView.addOnItemTouchListener(new CustomRVItemTouchListener(getActivity(), mRecyclerView, new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                List<Data> list = mAdapter.getList();
                Data data = list.get(position);
                if(position<2) {
                    Intent i = new Intent(getActivity(), ChaptersActivity.class);
                    i.putExtra("title", data.getTitle().toString());
                    startActivity(i);
                }

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(itemAnimator);
        return rootView;
    }

}
