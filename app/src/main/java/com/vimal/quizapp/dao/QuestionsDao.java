package com.vimal.quizapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vimal.quizapp.model.Questions;

import java.util.List;

@Dao
public interface QuestionsDao {

    @Insert
    public void insertQuestion(Questions questions);

    @Update
    public void updateQeustion(Questions questions);

    @Query("SELECT * FROM questions_table")
    public LiveData<List<Questions>> allQuestions();

}
