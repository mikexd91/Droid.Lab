package layout;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

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
                //Toast.makeText(getActivity(), "hello " + this.fragNum + " lesson num: "+ this.lessonNum, Toast.LENGTH_SHORT).show();
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
                    .child(lessonType);
            if (this.fragNum == 0) {
                myRef.child(String.valueOf(this.fragNum)).child("isComplete").setValue("true");
            } else if ((this.fragNum+1) % 2 == 0) {
                if (this.lessonType.equalsIgnoreCase("userInterface")) {
                    if(this.lessonNum >= 17){
                        myRef.child(String.valueOf(17)).child("isComplete").setValue("true");
                    }else{
                        int lesson = (this.fragNum+1) / 2;
                        myRef.child(String.valueOf(lesson)).child("isComplete").setValue("true");

                    }

                } else if (this.lessonType.equalsIgnoreCase("userInput")) {
                    if (this.lessonNum >= 21) {
                        myRef.child(String.valueOf(21)).child("isComplete").setValue("true");
                    } else {
                        int lesson = (this.fragNum + 1) / 2;
                        myRef.child(String.valueOf(lesson)).child("isComplete").setValue("true");
                    }
                }
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

    private Spanned getSpannedText(String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT);
        } else {
            return Html.fromHtml(text);
        }
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
        ((TextView) tv).setText(mLesson.getTitle().toString() + "                                ");

        View tv1 = layoutView.findViewById(R.id.text1);
        switch (lessonType) {
            case "userInterface":
                String[] mLessonOne = getResources().getStringArray(R.array.lesson_1_array);
                ((TextView) tv1).setText(getSpannedText(mLessonOne[fragNum].toString()));
                tv1.setVisibility(View.VISIBLE);
                //Toast.makeText(getActivity(), "hello " + mLessonOne[fragNum], Toast.LENGTH_SHORT).show();
                break;
            case "userInput":
                String[] mLessonTwo = getResources().getStringArray(R.array.lesson_2_array);
                ((TextView) tv1).setText(getSpannedText(mLessonTwo[fragNum]));
                tv1.setVisibility(View.VISIBLE);
                break;
        }

        View view = getActivity().findViewById(R.id.lessonProgress);
        if (view instanceof ProgressBar) {
            ProgressBar progress = (ProgressBar) view;
            setMax(progress);
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

    private void setMax(ProgressBar progressBar) {
        switch (this.lessonType) {
            case "userInterface":
                progressBar.setMax(35);
                break;
            case "userInput":
                progressBar.setMax(43);
                break;
        }

    }
}
