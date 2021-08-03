package com.vimal.quizapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.vimal.quizapp.dao.QuestionsDao;
import com.vimal.quizapp.database.QuizDatabase;
import com.vimal.quizapp.model.Questions;

import java.util.List;

public class QuestionsRepository {
    private QuestionsDao dao;
    public LiveData<List<Questions>> allQuestions;

    public QuestionsRepository(Application application) {
        QuizDatabase db = QuizDatabase.getInstance(application);
        dao = db.questionsDao();
        allQuestions = dao.allQuestions();
    }

    public void insertQuestions(Questions questions) {
        new InsertAsyncTask(dao).execute(questions);
    }

    private static class InsertAsyncTask extends AsyncTask<Questions, Void, Void> {

        private QuestionsDao dao;

        InsertAsyncTask(QuestionsDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Questions... questions) {
            dao.insertQuestion(questions[0]);
            return null;
        }
    }


    public LiveData<List<Questions>> allQuestions() {
        return allQuestions;
    }
}
