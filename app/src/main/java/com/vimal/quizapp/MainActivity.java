package com.vimal.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.vimal.quizapp.model.Questions;
import com.vimal.quizapp.viewmodel.QuestionsViewModel;

public class MainActivity extends AppCompatActivity {

    ViewModel viewModel;
    TextView question, option1, option2, option3, option4;
    String correct_ans;
    Button submit;
    RadioGroup radioGroupAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.text_view_question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        submit=findViewById(R.id.buttonSubmit);
        radioGroupAnswer=findViewById(R.id.radioGroup);

        ViewModelProviders.of(this).get(QuestionsViewModel.class)
                .getAllQuestions()
                .observe(this, questions -> {

                    for (Questions questions1 : questions) {
                        correct_ans=questions1.getCorrect_option();
                        question.setText(new StringBuilder().append(questions1.getQuestion_number()).append(". ").append(questions1.getQuestion()).toString());
                        option1.setText(questions1.getOption_1());
                        option2.setText(questions1.getOption_2());
                        option3.setText(questions1.getOption_3());
                        option4.setText(questions1.getOption_4());
                    }
                });
        submit.setOnClickListener(v -> {
            int ans=radioGroupAnswer.getCheckedRadioButtonId();
            Toast.makeText(this, "answer is"+radioGroupAnswer.getCheckedRadioButtonId(), Toast.LENGTH_SHORT).show();

            if(correct_ans.equals("")){
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Incorrect Answer:", Toast.LENGTH_SHORT).show();
        });

//        ViewModelProviders.of(this).get(HighScoreViewModel.class)
//                .allHighScore.observe(this, new Observer<List<HighScore>>() {
//            @Override
//            public void onChanged(List<HighScore> highScores) {
//
//            }
//        });
    }
}