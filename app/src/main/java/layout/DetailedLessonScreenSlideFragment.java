package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.is3261.is3261_firebase.Model.Lessons.Lesson;
import com.project.is3261.is3261_firebase.Model.Lessons.LessonGenerator;
import com.project.is3261.is3261_firebase.Model.Lessons.YoutubeHelper;
import com.project.is3261.is3261_firebase.R;

import java.util.ArrayList;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedLessonScreenSlideFragment extends Fragment implements YouTubePlayer.OnInitializedListener {
    private Lesson mLesson;
    private ArrayList<Lesson> mLessonList;
    private int fragNum;
    private int lessonNum;
    private String lessonType;
    private String youtubeLink;
    private YouTubePlayer youTubePlayer;
    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    public DetailedLessonScreenSlideFragment() {

    }

    public static DetailedLessonScreenSlideFragment init(int val, String lessonType, int lessonNum) {
        DetailedLessonScreenSlideFragment mLessonFragment = new DetailedLessonScreenSlideFragment();

        // Supply val input as an argument.
        Bundle args = new Bundle();
        args.putInt("val", val);
        args.putString("title", lessonType);
        args.putInt("lesson", lessonNum);
        mLessonFragment.setArguments(args);
        return mLessonFragment;
    }

    /**
     * Retrieving this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.fragNum = getArguments() != null ? getArguments().getInt("val") : 0;
       // Toast.makeText(getActivity(), "hello " + this.fragNum, Toast.LENGTH_SHORT).show();
        this.lessonType = getArguments() != null ? getArguments().getString("title") : "userInterface";
        this.lessonNum = getArguments() != null ? getArguments().getInt("lesson") : 1;
        LessonGenerator newLesson = new LessonGenerator(fragNum, lessonType, lessonNum);
        this.mLesson = newLesson.getLesson();
        this.mLessonList = newLesson.getLessonList();

        if (this.mLesson.isVideoAvailable) {
            if (getUserVisibleHint()) {
                Toast.makeText(getActivity(), "hello " + this.fragNum + " lesson num: "+ this.lessonNum, Toast.LENGTH_SHORT).show();
                this.youtubeLink = this.mLesson.getYoutube();
                youTubePlayerSupportFragment = new YouTubePlayerSupportFragment().newInstance();
                // Log.v (TAG, "Committing transaction, URL : " + getArguments().getString(KeyConstant.KEY_VIDEO_URL));
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_fragment, youTubePlayerSupportFragment).commit();
                youTubePlayerSupportFragment.initialize(YoutubeHelper.getApiKey(), this);
            }
        }
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                // Write a message to the database
                database = FirebaseDatabase.getInstance();
                myRef = database.getReference()
                        .child("users")
                        .child(user.getUid())
                        .child("lesson")
                        .child(lessonType)
                        .child(String.valueOf(lessonNum));
                myRef.child("fragNum").setValue(String.valueOf(fragNum));
                myRef.child("isComplete").setValue("false");
                if (this.fragNum == mLessonList.size() - 1) {
                    myRef.child("isComplete").setValue("true");
                }
            }


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        this.youTubePlayer = youTubePlayer;
        this.youTubePlayer.loadVideo(youtubeLink);
        this.youTubePlayer.pause();
        this.youTubePlayer.setShowFullscreenButton(false);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    /**
     * The Fragment's UI is a simple text view showing its instance number and
     * an associated list.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutView = inflater.inflate(R.layout.fragment_detailed_lesson_screen_slide,
                container, false);

        View tv = layoutView.findViewById(R.id.header1);
        ((TextView) tv).setText(mLesson.getTitle().toString()+ " - Fragment #" + fragNum);

        for(int i=0; i< mLesson.getDescription().length;i++){
            switch(i){
                case 0:
                    View tv2 = layoutView.findViewById(R.id.header2);
                    ((TextView) tv2).setText(mLesson.getDescription()[0]);
                    tv2.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    View tv3 = layoutView.findViewById(R.id.text1);
                    ((TextView) tv3).setText(mLesson.getDescription()[1].toString());
                    tv3.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    View tv4 = layoutView.findViewById(R.id.text2);
                    ((TextView) tv4).setText(mLesson.getDescription()[2].toString());
                    tv4.setVisibility(View.VISIBLE);
            }
        }

        View view = getActivity().findViewById(R.id.lessonProgress);
        if(view instanceof ProgressBar){
            ProgressBar progress = (ProgressBar) view;
            progress.setProgress(this.fragNum);
        }

        //getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        return layoutView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (!isVisibleToUser && youTubePlayer != null) {
            Log.v(TAG, "Releasing youtube player, URL : " + this.youtubeLink);
            youTubePlayer.release();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.remove(youTubePlayerSupportFragment).commit();
        }
        if (isVisibleToUser && youTubePlayerSupportFragment != null) {
            //Log.v(TAG, "Initializing youtube player, URL : " + getArguments().getString(KeyConstant.KEY_VIDEO_URL));
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_fragment, youTubePlayerSupportFragment).commit();
            youTubePlayerSupportFragment.initialize(YoutubeHelper.getApiKey(), this);
        }
    }

}
