package com.vimal.quizapp.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.vimal.quizapp.dao.HighScoreDao;
import com.vimal.quizapp.dao.QuestionsDao;
import com.vimal.quizapp.model.HighScore;
import com.vimal.quizapp.model.Questions;

import org.jetbrains.annotations.NotNull;

@Database(entities = {Questions.class, HighScore.class}, version = 1)
public abstract class QuizDatabase extends RoomDatabase {

    public abstract QuestionsDao questionsDao();

    public abstract HighScoreDao highScoreDao();

    private static QuizDatabase instance;

    public static synchronized QuizDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), QuizDatabase.class,
                    "quiz_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDatabase(instance).execute();
        }

        @Override
        public void onOpen(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }

        @Override
        public void onDestructiveMigration(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onDestructiveMigration(db);
        }
    };


    public static class PopulateDatabase extends AsyncTask<Void, Void, Void> {

        QuestionsDao dao;
        HighScoreDao highScoreDao;

        PopulateDatabase(QuizDatabase quizDatabase) {
            dao = quizDatabase.questionsDao();
            highScoreDao = quizDatabase.highScoreDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.insertQuestion(new Questions(1, "1+1", "1", "2", "3", "4", "2"));
            highScoreDao.insertHighScore(new HighScore(10));
            return null;
        }

    }
}
