package com.vimal.quizapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vimal.quizapp.model.HighScore;
import com.vimal.quizapp.repository.HighScoreRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HighScoreViewModel extends AndroidViewModel {
    private HighScoreRepository highScoreRepository;
    public LiveData<List<HighScore>> allHighScore;

    public HighScoreViewModel(@NonNull @NotNull Application application) {
        super(application);
        highScoreRepository = new HighScoreRepository(application);
        allHighScore = highScoreRepository.allHighScore();
    }

    public void insertHightScore(HighScore highScore) {
        highScoreRepository.insertHighScore(highScore);
    }

    public void updateHighScore(HighScore highScore) {
        highScoreRepository.updateHighScore(highScore);
    }

    public LiveData<List<HighScore>> getAllHighScore() {
        return allHighScore;
    }
}
