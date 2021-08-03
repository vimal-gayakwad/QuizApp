package com.vimal.quizapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "questions_table")
public class Questions {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private  int question_number;

    private String question;

    private String option_1;

    private String option_2;

    private String option_3;

    private String option_4;

    private String correct_option;

    public Questions( int question_number, String question, String option_1, String option_2, String option_3, String option_4, String correct_option) {

        this.question_number = question_number;
        this.question = question;
        this.option_1 = option_1;
        this.option_2 = option_2;
        this.option_3 = option_3;
        this.option_4 = option_4;
        this.correct_option = correct_option;
    }

    public int getQuestion_number() {
        return question_number;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption_1() {
        return option_1;
    }

    public String getOption_2() {
        return option_2;
    }

    public String getOption_3() {
        return option_3;
    }

    public String getOption_4() {
        return option_4;
    }

    public String getCorrect_option() {
        return correct_option;
    }

    public void setId(int id) {
        this.id = id;
    }
}
