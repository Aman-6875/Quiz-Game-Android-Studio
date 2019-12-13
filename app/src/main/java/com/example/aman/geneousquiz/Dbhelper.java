package com.example.aman.geneousquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.aman.geneousquiz.Contract.*;

import java.util.ArrayList;
import java.util.List;

public class Dbhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "GiniusQuiz.db";
    private static final int DATABASE_VERSION = 4;

    private SQLiteDatabase db;

    public Dbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Questions q1 = new Questions("which letters make a girl into a woman?", "A,E,G", "B,A,W", "W,E,O", 1);
        addQuestion(q1);
        Questions q2 = new Questions("Which of the following is the lowest prime number?", "1", "2", "3", 2);
        addQuestion(q2);
        Questions q3 = new Questions("Approximately how many birthdays does the average men in the world have? ", "1", "37", "74", 1);
        addQuestion(q3);
        Questions q4 = new Questions("How many times can you subtract 10 from 100?", "10", "9", "1", 3);
        addQuestion(q4);
        Questions q5 = new Questions("Which one of the numbers dose not belong in the series(2->3->6->7->8->14->15->30)  ", "8", "14", "30", 1);
        addQuestion(q5);
        Questions q6 = new Questions("If you rearrage the word PLEPINAPE you would have the name of ", "Fruit", "Novel", "Movie", 1);
        addQuestion(q6);
        Questions q7 = new Questions("OCEAN is as AENCO as 89573 is to   ", "37598", "75398", "57839", 2);
        addQuestion(q7);
        Questions q8 = new Questions("What temperature is the same in Celsius and Fahrenheit?", "-40C", "-40F", "40F", 1);
        addQuestion(q8);
        Questions q9 = new Questions("What is the largest planet in our Solar System?", "Pluto", "Jupiter", "Earth", 2);
        addQuestion(q9);
        Questions q10 = new Questions("Which of the following can be into 5 letter English word ", "H R G S T", "R I L S A", "W Q R G S", 2);
        addQuestion(q10);
    }

    private void addQuestion(Questions question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionTable.TABLE_NAME, null, cv);
    }

    public List<Questions> getAllQuestions() {
        List<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}