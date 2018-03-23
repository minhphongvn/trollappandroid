package com.minhphongvn.edge.nex;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.VolumeProvider;
import android.os.Bundle;
import android.app.Activity;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static com.minhphongvn.edge.nex.R.id.progress_circular;
import static com.minhphongvn.edge.nex.R.id.seekBar;

public class NexMain extends Activity {
    private SeekBar seekbar = null;
    AudioManager e = null;
    AdView mAdView;

    private static int DELTA_VALUE = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        setContentView(R.layout.activity_nex_main);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-1985952117875294~5687531760");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        initControls();


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
                e.setStreamVolume(AudioManager.STREAM_MUSIC,
                        progress, 0);
                if (progress == 15) {
                    startActivity(new Intent(arg0.getContext(), Troll.class));
                }
            }
        });
    }

    private void initControls() {
        try {
            seekbar = (SeekBar) findViewById(seekBar);
            e = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            seekbar.setMax(e
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            seekbar.setProgress(e
                    .getStreamVolume(AudioManager.STREAM_MUSIC));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
