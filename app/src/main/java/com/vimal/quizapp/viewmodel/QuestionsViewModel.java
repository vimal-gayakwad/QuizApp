package com.vimal.quizapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vimal.quizapp.model.Questions;
import com.vimal.quizapp.repository.QuestionsRepository;

import java.util.List;

public class QuestionsViewModel extends AndroidViewModel {

    private QuestionsRepository repository;
    LiveData<List<Questions>> allQuestions;

    public QuestionsViewModel(@NonNull Application application) {
        super(application);
        repository = new QuestionsRepository(application);
        allQuestions = repository.allQuestions();
    }


    public void insertQuestions(Questions questions) {
        repository.insertQuestions(questions);
    }

    public LiveData<List<Questions>> getAllQuestions() {
        return allQuestions;
    }
}
