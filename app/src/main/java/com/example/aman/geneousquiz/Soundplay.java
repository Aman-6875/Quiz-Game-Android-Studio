package com.example.aman.geneousquiz;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class Soundplay {
    private static SoundPool sound;
    private static int correctsound;
    private static  int wrongsound;


    public Soundplay(Context context){
        sound = new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        correctsound = sound.load(context,R.raw.cans,1);
        wrongsound = sound.load(context, R.raw.wans,1);

    }
    public void playcorrectsound(){
        sound.play(correctsound,1.0f,1.0f,1,0,1.0f);
    }
    public void playwrongsound(){
        sound.play(wrongsound,1.0f,1.0f,1,0,1.0f);
    }
}
