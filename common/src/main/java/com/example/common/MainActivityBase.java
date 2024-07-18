package com.example.common;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityBase extends AppCompatActivity {

    private TextView mainTitle, subTitle;
    private ImageView musicalInstruments;
    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_base);

        mainTitle = findViewById(R.id.main_title);
        subTitle = findViewById(R.id.sub_title);
        musicalInstruments = findViewById(R.id.musical_instruments);

        buttons = new Button[]{
                findViewById(R.id.button_a),
                findViewById(R.id.button_b),
                findViewById(R.id.button_c),
                findViewById(R.id.button_d),
                findViewById(R.id.button_e),
                findViewById(R.id.button_f),
                findViewById(R.id.button_g),
                findViewById(R.id.button_h),
                findViewById(R.id.button_i),
                findViewById(R.id.button_j)
        };

        for (int i = 0; i < buttons.length; i++) {
            final int position = i;
            buttons[i].setOnClickListener(v -> navigateToChord(position));
        }
    }

    protected void navigateToChord(int position) {
        Intent intent = new Intent(this, ChordActivityBase.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
