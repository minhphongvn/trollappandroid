package com.minhphongvn.edge.nex;

import android.os.Bundle;
import android.app.Activity;
import android.media.MediaPlayer;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Troll extends Activity {
    float count = 100;

    MediaPlayer mp = new MediaPlayer();
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.troll);
        mp.setVolume(count, count);
        mp.setLooping(false);
        mp = MediaPlayer.create(this, R.raw.troll);
        mp.start();
    }
}