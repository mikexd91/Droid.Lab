package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.is3261.is3261_firebase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedLessonScreenSlideFragment extends Fragment {


    public DetailedLessonScreenSlideFragment() {
        // Required empty public constructor
    }


    public static DetailedLessonScreenSlideFragment newInstance(String lessonTitle) {
        DetailedLessonScreenSlideFragment lessonFragment = new DetailedLessonScreenSlideFragment();

        Bundle args = new Bundle();
        args.putString("lesson", lessonTitle);
        lessonFragment.setArguments(args);

        return lessonFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailed_lesson_screen_slide, container, false);
    }

}
