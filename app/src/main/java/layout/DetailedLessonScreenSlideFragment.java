package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.is3261.is3261_firebase.Model.Lessons.Lesson;
import com.project.is3261.is3261_firebase.Model.Lessons.LessonGenerator;
import com.project.is3261.is3261_firebase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedLessonScreenSlideFragment extends Fragment {
    private Lesson mLesson;
    private int fragNum;
    private int lessonNum;
    private String lessonType;
    public DetailedLessonScreenSlideFragment(){

    }

//    public static DetailedLessonScreenSlideFragment init(int val) {
//        DetailedLessonScreenSlideFragment mLessonFragment = new DetailedLessonScreenSlideFragment();
//
//        // Supply val input as an argument.
//        Bundle args = new Bundle();
//        args.putInt("val", val);
//        mLessonFragment.setArguments(args);
//        return mLessonFragment;
//    }

    /**
     * Retrieving this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.fragNum = getArguments() != null ? getArguments().getInt("val") : 1;
        this.lessonType = getArguments() != null ? getArguments().getString("title"): "userInterface";
        this.lessonNum = getArguments() != null ? getArguments().getInt("lesson"): 1;
        LessonGenerator newLesson = new LessonGenerator(fragNum, lessonType, lessonNum);
        this.mLesson = newLesson.getLesson();
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
        return layoutView;
    }

}
