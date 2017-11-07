package layout;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.is3261.is3261_firebase.Model.Quiz.Quiz;
import com.project.is3261.is3261_firebase.Model.Quiz.QuizGenerator;
import com.project.is3261.is3261_firebase.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedQuizSlideFragment extends Fragment {


    private Quiz mQuiz;
    private ArrayList<Quiz> mQuizList;
    private int fragNum;
    private int QuizNum;
    private String QuizType;
    private String youtubeLink;
    private YouTubePlayer youTubePlayer;
    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    public DetailedQuizSlideFragment() {

    }

    public static DetailedQuizSlideFragment init(int val, String QuizType, int QuizNum) {
        DetailedQuizSlideFragment mQuizFragment = new DetailedQuizSlideFragment();

        // Supply val input as an argument.
        Bundle args = new Bundle();
        args.putInt("val", val);
        args.putString("title", QuizType);
        args.putInt("quiz", QuizNum);
        mQuizFragment.setArguments(args);
        return mQuizFragment;
    }

    /**
     * Retrieving this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.fragNum = getArguments() != null ? getArguments().getInt("val") : 0;
        this.QuizType = getArguments() != null ? getArguments().getString("title") : "userInterface";
        this.QuizNum = getArguments() != null ? getArguments().getInt("quiz") : 1;

//        Toast.makeText(getActivity(), "fragNum " + this.fragNum
//                                    + "QuizType " + this.QuizType
//                                    + "QuizNum " + this.QuizNum, Toast.LENGTH_LONG).show();
        QuizGenerator newQuiz = new QuizGenerator(fragNum, QuizType, QuizNum);
        this.mQuiz = newQuiz.getQuiz();
        this.mQuizList = newQuiz.getQuizList();
        //Toast.makeText(getActivity(), "quiz " + this.mQuiz.getQuizQuestion().toString(), Toast.LENGTH_SHORT).show();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Write a message to the database
            int quizNum2 = 0;
            switch(QuizType){
                case "userInterface":
                    quizNum2=0;
                    break;
                case "userInput":
                    quizNum2=1;
                    break;
                case "multipleScreen":
                    quizNum2=2;
                    break;
                case "extraQuestions":
                    quizNum2=3;
                    break;
            }

            database = FirebaseDatabase.getInstance();
            myRef = database.getReference()
                    .child("users")
                    .child(user.getUid())
                    .child("quiz")
                    .child(String.valueOf(quizNum2));
            if (this.fragNum == 5) {
                myRef.child("isComplete").setValue("true");
            }

        }

    }

    /**
     * The Fragment's UI is a simple text view showing its instance number and
     * an associated list.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutView = inflater.inflate(R.layout.fragment_detailed_quiz_slide,
                container, false);

//        View tv = layoutView.findViewById(R.id.header1);
//        ((TextView) tv).setText("Fragment #" + fragNum);
        View tv1 = layoutView.findViewById(R.id.header2);
        ((TextView) tv1).setText(mQuiz.getQuizQuestion().toString());
        //Toast.makeText(getActivity(), "quiz 2 " + mQuiz.getQuizQuestion().toString(), Toast.LENGTH_SHORT).show();

        final View tv2 = layoutView.findViewById(R.id.text2);
        ((TextView) tv2).setText(mQuiz.getQuizOptions()[0].toString());

        final View tv3 = layoutView.findViewById(R.id.text3);
        ((TextView) tv3).setText(mQuiz.getQuizOptions()[1].toString());

        final View tv4 = layoutView.findViewById(R.id.text4);
        ((TextView) tv4).setText(mQuiz.getQuizOptions()[2].toString());

        final View tv5 = layoutView.findViewById(R.id.text5);
        ((TextView) tv5).setText(mQuiz.getQuizOptions()[3].toString());


        //getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Check user radio button input
        final RadioButton radioButton1 = (RadioButton) layoutView.findViewById(R.id.radioButton1);
        final RadioButton radioButton2 = (RadioButton) layoutView.findViewById(R.id.radioButton2);
        final RadioButton radioButton3 = (RadioButton) layoutView.findViewById(R.id.radioButton3);
        final RadioButton radioButton4 = (RadioButton) layoutView.findViewById(R.id.radioButton4);
        final ArrayList<RadioButton> radioButtonArrayList = new ArrayList<>(Arrays.asList(radioButton1, radioButton2, radioButton3, radioButton4));

        final Button submitAnsButton = (Button) layoutView.findViewById(R.id.buttonSubmitAns);
        final TextView resultText = (TextView) layoutView.findViewById(R.id.textResult);

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton1.setChecked(true);
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                radioButton4.setChecked(false);
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton1.setChecked(false);
                radioButton2.setChecked(true);
                radioButton3.setChecked(false);
                radioButton4.setChecked(false);
            }
        });

        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton1.setChecked(false);
                radioButton2.setChecked(false);
                radioButton3.setChecked(true);
                radioButton4.setChecked(false);
            }
        });

        radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton1.setChecked(false);
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                radioButton4.setChecked(true);
            }
        });

        submitAnsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isCorrect = false;
                int checkedOption =0;

                for (int i=0; i<radioButtonArrayList.size(); i++) {
                    if (radioButtonArrayList.get(i).isChecked() && (mQuiz.getQuizAnswer() == (i+1))) {
                        switch(i){
                            case 0:
                                ((TextView) tv2).setTextColor(Color.parseColor("#A4C639"));
                                break;
                            case 1:
                                ((TextView) tv3).setTextColor(Color.parseColor("#A4C639"));
                                break;
                            case 2:
                                ((TextView) tv4).setTextColor(Color.parseColor("#A4C639"));
                                break;
                            case 3:
                                ((TextView) tv5).setTextColor(Color.parseColor("#A4C639"));
                                break;
                        }
                        checkedOption = i;
                        //resultText.setText("Correct!");
                        isCorrect = true;
                        break;
                    }
                }
                if (!isCorrect) {
                    for (int i=0; i<radioButtonArrayList.size(); i++) {
                        if (radioButtonArrayList.get(i).isChecked()){
                            switch(i){
                                case 0:
                                    ((TextView) tv2).setTextColor(Color.RED);
                                    break;
                                case 1:
                                    ((TextView) tv3).setTextColor(Color.RED);
                                    break;
                                case 2:
                                    ((TextView) tv4).setTextColor(Color.RED);
                                    break;
                                case 3:
                                    ((TextView) tv5).setTextColor(Color.RED);
                                    break;
                            }
                        }
                    }

                    //resultText.setText("Try Again!");
                }else{
                    if(fragNum==5){
                        submitAnsButton.setVisibility(View.GONE);
                        resultText.setText("Congratulation on completing the quiz!");
                        resultText.setGravity(Gravity.CENTER);
                        resultText.setVisibility(View.VISIBLE);
                    }else{
                        submitAnsButton.setVisibility(View.GONE);
                        resultText.setText("Swipe Left to Proceed!");
                        resultText.setVisibility(View.VISIBLE);
                    }

                }
                //resultText.setVisibility(View.VISIBLE);
            }
        });

        return layoutView;
    }


}
