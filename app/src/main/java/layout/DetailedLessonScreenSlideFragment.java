package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.project.is3261.is3261_firebase.Model.Lessons.Lesson;
import com.project.is3261.is3261_firebase.Model.Lessons.LessonGenerator;
import com.project.is3261.is3261_firebase.Model.Lessons.YoutubeHelper;
import com.project.is3261.is3261_firebase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedLessonScreenSlideFragment extends Fragment implements YouTubePlayer.OnInitializedListener {
    private Lesson mLesson;
    private int fragNum;
    private int lessonNum;
    private String lessonType;
    private YouTubePlayer youTubePlayer;
    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;
    public DetailedLessonScreenSlideFragment(){

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
        Toast.makeText(getActivity(), "hello "+ this.fragNum, Toast.LENGTH_SHORT).show();
        this.lessonType = getArguments() != null ? getArguments().getString("title"): "userInterface";
        this.lessonNum = getArguments() != null ? getArguments().getInt("lesson"): 1;
        LessonGenerator newLesson = new LessonGenerator(fragNum, lessonType, lessonNum);
        this.mLesson = newLesson.getLesson();

        if(this.fragNum==0) {
            youTubePlayerSupportFragment = new YouTubePlayerSupportFragment().newInstance();
            if (getUserVisibleHint()) {
                // Log.v (TAG, "Committing transaction, URL : " + getArguments().getString(KeyConstant.KEY_VIDEO_URL));
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_fragment, youTubePlayerSupportFragment).commit();
                youTubePlayerSupportFragment.initialize(YoutubeHelper.getApiKey(), this);
            }
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        this.youTubePlayer = youTubePlayer;
        this.youTubePlayer.loadVideo("W4hTJybfU7s");
        this.youTubePlayer.play();
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

        View tv = layoutView.findViewById(R.id.text);
        ((TextView) tv).setText("Truiton Fragment #" + fragNum);
        View tv1 = layoutView.findViewById(R.id.text1);
        ((TextView) tv1).setText(mLesson.getTitle().toString());
        View tv2 = layoutView.findViewById(R.id.text2);
        ((TextView) tv2).setText(mLesson.getDescription().toString());

            //getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            //getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        return layoutView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (!isVisibleToUser && youTubePlayer != null) {
            //Log.v(TAG, "Releasing youtube player, URL : " + getArguments().getString(KeyConstant.KEY_VIDEO_URL));
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
