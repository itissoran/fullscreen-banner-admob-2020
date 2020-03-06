package com.rewass.fullscreenbanneradmob2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(Ads.admobFull);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    //  Toast.makeText(A001.this, "no", Toast.LENGTH_SHORT).show();
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        },4000);
        //after 4 sec thic code will be played
    }
}
