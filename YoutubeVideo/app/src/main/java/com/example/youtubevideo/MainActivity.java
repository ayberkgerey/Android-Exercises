package com.example.youtubevideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends YouTubeBaseActivity {

    private YouTubePlayerView mYoutubePlayerView;
    private Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListiner;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        mYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);
        Log.d(TAG, "onCreate: Starting");
        mOnInitializedListiner = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onInitializationSuccess: Successfull");

              /*
                List<String> videoList = new ArrayList<>();
                videoList.add("4P6Lw8xNtH4");
                videoList.add("CMm8SW8_hl8");
                youTubePlayer.loadVideos(videoList);
              */
              youTubePlayer.loadVideo("4P6Lw8xNtH4");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onInitializationFailure: Failed to initialize");
            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Initializing Youtube Player");
                mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(),mOnInitializedListiner);
            }
        });

    }
}
