package com.vimal.quizapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.vimal.quizapp.dao.HighScoreDao;
import com.vimal.quizapp.database.QuizDatabase;
import com.vimal.quizapp.model.HighScore;

import java.util.List;

public class HighScoreRepository {
    private HighScoreDao dao;
    public LiveData<List<HighScore>> allHighScore;

    public HighScoreRepository(Application application) {
        QuizDatabase db = QuizDatabase.getInstance(application);
        dao = db.highScoreDao();
        allHighScore = dao.getAllHighScore();
    }

    public void insertHighScore(HighScore highScore) {
        new InsertHighScoreAsync(dao).execute(highScore);
    }

    public void updateHighScore(HighScore highScore) {

    }



    public LiveData<List<HighScore>> allHighScore() {
        return allHighScore;
    }

    //insert high score aynctask class
    private static class InsertHighScoreAsync extends AsyncTask<HighScore, Void, Void> {

        HighScoreDao dao;

        public InsertHighScoreAsync(HighScoreDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(HighScore... highScores) {
            dao.insertHighScore(highScores[0]);
            return null;

        }
    }

    // update highscore asynctask class
    private static class UpdateHighScoreAsync extends AsyncTask<HighScore, Void, Void> {

        HighScoreDao dao;

        public UpdateHighScoreAsync(HighScoreDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(HighScore... highScores) {
            dao.updateHighScore(highScores[0]);
            return null;

        }
    }
}
