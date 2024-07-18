package com.example.common;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

public class ChordActivityBase extends AppCompatActivity {

    protected TextView chordTitle, chordText;
    public ImageView chordImage;
    protected ImageButton buttonLeft, buttonRight, buttonHome;

    protected int position;
    public int[] chordImages;
    protected String[] chordTitles;
    protected String[] chordDescriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_base);

        chordTitles = getResources().getStringArray(R.array.chord_titles);
        chordDescriptions = getResources().getStringArray(R.array.chord_descriptions);

        chordImage = findViewById(R.id.chord_image);
        chordTitle = findViewById(R.id.chord_title);
        chordText = findViewById(R.id.chord_text);
        buttonLeft = findViewById(R.id.button_left);
        buttonRight = findViewById(R.id.button_right);
        buttonHome = findViewById(R.id.button_home);
        chordImages = new int[]{
                R.drawable.chord_a_image,
                R.drawable.chord_b_image,
                R.drawable.chord_c_image,
                R.drawable.chord_d_image,
                R.drawable.chord_e_image,
                R.drawable.chord_f_image,
                R.drawable.chord_g_image,
                R.drawable.chord_h_image,
                R.drawable.chord_i_image,
                R.drawable.chord_j_image
        };

        position = getIntent().getIntExtra("position", 0);
        updateChordContent(position);

        buttonLeft.setOnClickListener(v -> navigateToChord(position - 1));
        buttonRight.setOnClickListener(v -> navigateToChord(position + 1));
        buttonHome.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivityBase.class);
            startActivity(intent);
            finish();
        });
    }

    protected void navigateToChord(int newPosition) {
        if (newPosition >= 0 && newPosition < chordTitles.length) {
            position = newPosition;
            updateChordContent(position);
        } else {
            if (newPosition < 0) {
                position = 0;
            } else {
                position = chordTitles.length - 1;
            }
            updateChordContent(position);
        }
    }

    protected void updateChordContent(int position) {
        chordTitle.setText(chordTitles[position]);
        chordText.setText(chordDescriptions[position]);
        chordImage.setImageResource(chordImages[position]);

    }
}
