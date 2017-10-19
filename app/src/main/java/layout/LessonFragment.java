package layout;


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
import com.project.is3261.is3261_firebase.ChapterActivity;
import com.project.is3261.is3261_firebase.HomeActivity;
import com.project.is3261.is3261_firebase.Model.CustomAdapter;
import com.project.is3261.is3261_firebase.Model.CustomRVItemTouchListener;
import com.project.is3261.is3261_firebase.Model.Data;
import com.project.is3261.is3261_firebase.Model.RecyclerViewItemClickListener;
import com.project.is3261.is3261_firebase.R;

import java.util.ArrayList;
import java.util.List;

import static com.project.is3261.is3261_firebase.R.id.progress_bar;
import static com.project.is3261.is3261_firebase.R.id.recyclerView;
import static com.project.is3261.is3261_firebase.R.id.swipeContainerLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class LessonFragment extends Fragment {

    private FirebaseDatabase mDatabase;
    private DatabaseReference myRef;
    private DatabaseReference news1;


    private static final String TAG = "RecyclerViewFragment";
    protected ProgressBar mProgressBar;
    protected SwipeRefreshLayout swipeContainer;
    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected List<Data> data;


    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("Batman vs Superman", "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman ", R.drawable.ic_menu_gallery));
        data.add(new Data("X-Men: Apocalypse", "X-Men: Apocalypse is an upcoming American superhero film based on the X-Men characters that appear in Marvel Comics ", R.drawable.ic_menu_gallery));
        data.add(new Data("Captain America: Civil War", "A feud between Captain America and Iron Man leaves the Avengers in turmoil.  ", R.drawable.ic_menu_gallery));
        data.add(new Data("Kung Fu Panda 3", "After reuniting with his long-lost father, Po  must train a village of pandas", R.drawable.ic_menu_gallery));
        data.add(new Data("Warcraft", "Fleeing their dying home to colonize another, fearsome orc warriors invade the peaceful realm of Azeroth. ", R.drawable.ic_menu_gallery));
        data.add(new Data("Alice in Wonderland", "Alice in Wonderland: Through the Looking Glass ", R.drawable.ic_menu_gallery));

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

        data = fill_with_data();
        mAdapter = new CustomAdapter(getActivity(),data);
        mRecyclerView.setAdapter(mAdapter);
        // Set CustomAdapter as the adapter for RecyclerView.

        mRecyclerView.addOnItemTouchListener(new CustomRVItemTouchListener(getActivity(), mRecyclerView, new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                List<Data> list = mAdapter.getList();
                Data data = list.get(position);

                Intent i = new Intent(getActivity(), ChapterActivity.class);
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


        // Lookup the swipe container view
        swipeContainer = rootView.findViewById(swipeContainerLayout);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                //fetchTimelineAsync();
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        return rootView;
    }

}
