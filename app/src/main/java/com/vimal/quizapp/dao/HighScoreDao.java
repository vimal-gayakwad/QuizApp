package com.vimal.quizapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vimal.quizapp.model.HighScore;

import java.util.List;

@Dao
public interface HighScoreDao {

    @Insert
    public void insertHighScore(HighScore highScore);

    @Update
    public void updateHighScore(HighScore highScore);

    @Query("SELECT * FROM high_score")
    LiveData<List<HighScore>> getAllHighScore();
}
