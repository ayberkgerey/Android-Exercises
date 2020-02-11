package com.example.noteslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.noteslist.models.Note;

public class NotesListActivity extends AppCompatActivity {
    private static final String TAG = "NotesListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Note note = new Note("some title", "some content", "timestamp");

        Note note2 = new Note();
        note2.setTitle("some other title");
        note2.setContent("some other content");
        note2.setTimestamp("other timestamp");

        Log.d(TAG, "onCreate: " + note.toString());
    }
}
