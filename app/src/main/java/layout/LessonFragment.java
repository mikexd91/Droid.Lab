package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.is3261.is3261_firebase.HomeActivity;
import com.project.is3261.is3261_firebase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LessonFragment extends Fragment {


    public LessonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((HomeActivity) getActivity()).setActionBarTitle("Lesson");
        return inflater.inflate(R.layout.fragment_lesson, container, false);

    }

}
