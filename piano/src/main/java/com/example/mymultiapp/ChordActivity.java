package com.example.mymultiapp;

import android.os.Bundle;

import com.example.common.ChordActivityBase;

public class ChordActivity extends ChordActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
    }


}
