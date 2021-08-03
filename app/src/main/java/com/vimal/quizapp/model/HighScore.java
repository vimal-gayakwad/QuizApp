package com.vimal.quizapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "high_score")
public class HighScore {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int highScore;

    public HighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getId() {
        return id;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setId(int id) {
        this.id = id;
    }
}
