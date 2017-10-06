package layout;


import android.content.Intent;
import android.os.AsyncTask;
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
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.is3261.is3261_firebase.Model.CustomAdapter;
import com.project.is3261.is3261_firebase.Model.CustomRVItemTouchListener;
import com.project.is3261.is3261_firebase.Model.Data;
import com.project.is3261.is3261_firebase.Model.RecyclerViewItemClickListener;
import com.project.is3261.is3261_firebase.R;
import com.project.is3261.is3261_firebase.WebViewActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.project.is3261.is3261_firebase.R.id.progress_bar;
import static com.project.is3261.is3261_firebase.R.id.recyclerView;
import static com.project.is3261.is3261_firebase.R.id.swipeContainerLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
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

//        data.add(new Data("Batman vs Superman", "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman ", R.drawable.ic_menu_gallery));
//        data.add(new Data("X-Men: Apocalypse", "X-Men: Apocalypse is an upcoming American superhero film based on the X-Men characters that appear in Marvel Comics ", R.drawable.ic_menu_gallery));
//        data.add(new Data("Captain America: Civil War", "A feud between Captain America and Iron Man leaves the Avengers in turmoil.  ", R.drawable.ic_menu_gallery));
//        data.add(new Data("Kung Fu Panda 3", "After reuniting with his long-lost father, Po  must train a village of pandas", R.drawable.ic_menu_gallery));
//        data.add(new Data("Warcraft", "Fleeing their dying home to colonize another, fearsome orc warriors invade the peaceful realm of Azeroth. ", R.drawable.ic_menu_gallery));
//        data.add(new Data("Alice in Wonderland", "Alice in Wonderland: Through the Looking Glass ", R.drawable.ic_menu_gallery));

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
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
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
                Toast.makeText(getActivity(), data.title.toString(),
                        Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getActivity(), WebViewActivity.class);
                i.putExtra("url", data.getUrl().toString());
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        String url = "https://newsapi.org/v1/articles?source=techcrunch&sortBy=latest&apiKey=50a47a7a618a4cceb06b66a198d310cd";
        new DownloadTask().execute(url);

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
                fetchTimelineAsync();
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        return rootView;
    }

    public class DownloadTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Integer doInBackground(String... str) {
            Integer result = 0;
            //Toast.makeText(getActivity(), str[0], Toast.LENGTH_SHORT).show();
            URL url = convertToUrl(str[0]);
            HttpURLConnection httpURLConnection = null;
            int responseCode;
            StringBuilder response = new StringBuilder();
            String line;
            try {
                httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
                if (responseCode == httpURLConnection.HTTP_OK) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    while ((line = reader.readLine())!=null) {
                        response.append(line);
                    }
                    inputStream.close();
                }
                parseResult(response.toString());
                result=1;
                //Toast.makeText(getActivity(), responseCode, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                System.out.println("Error XUNDA: " + e.getMessage());
                e.printStackTrace();
                result=0;
            } finally {
                httpURLConnection.disconnect();
            }

            return result; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(Integer result) {
            mProgressBar.setVisibility(View.GONE);

            if (result == 1) {
                mAdapter = new CustomAdapter(getActivity(),data);
                mRecyclerView.setAdapter(mAdapter);
                swipeContainer.setRefreshing(false);
            } else {
                Toast.makeText(getActivity(), "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void parseResult(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            String source = jsonObject.getString("source");
            String sortBy = jsonObject.getString("sortBy");
            JSONArray sourcesArray = jsonObject.getJSONArray("articles");
            for (int i=0; i <sourcesArray.length(); i++)
            {
                try {
                    JSONObject oneObject = sourcesArray.getJSONObject(i);
                    // Pulling items from the array
                    String author = oneObject.getString("author");
                    String title = oneObject.getString("title");
                    String description = oneObject.getString("description");
                    String url = oneObject.getString("url");
                    String urlToImage = oneObject.getString("urlToImage");
                    String publishedAt = oneObject.getString("publishedAt");
                    publishedAt = publishedAt.substring(0,publishedAt.indexOf("T"));
                    Data dataItem = new Data(getActivity(),author,title,description,url,urlToImage,publishedAt);
                    data.add(dataItem);
                    //Toast.makeText(getActivity(),title,Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // from internet
    private URL convertToUrl(String urlStr) {
        try {
            URL url = new URL(urlStr);
            URI uri = new URI(url.getProtocol(), url.getUserInfo(),
                    url.getHost(), url.getPort(), url.getPath(),
                    url.getQuery(), url.getRef());
            url = uri.toURL();
            return url;
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void fetchTimelineAsync() {
        String url = "https://newsapi.org/v1/articles?source=techcrunch&sortBy=latest&apiKey=50a47a7a618a4cceb06b66a198d310cd";
        new DownloadTask().execute(url);

    }



}
