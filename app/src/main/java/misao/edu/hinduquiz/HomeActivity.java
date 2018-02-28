package misao.edu.hinduquiz;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button btnStart;

    SoundPool soundPool;
    int startSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );

        imageView = findViewById( R.id.iv_home );
        btnStart = findViewById( R.id.btnStart );

        btnStart.setOnClickListener( this );

        imageView.setImageResource( R.drawable.home );

    }

    @Override
    public void onClick(View view) {

//        soundPool.play( startSound,1.0f,1.0f,0,0,1.0f );
//        onResume();
//        onPause();

        Intent intent = new Intent( HomeActivity.this,MainActivity.class );
        startActivity( intent );
    }


    protected void onResume(){
        super.onResume();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool( 2, AudioManager.STREAM_ALARM, 0 );
        }else {
            AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage( AudioAttributes.USAGE_ALARM ).build();
            soundPool = new SoundPool.Builder(  ).setMaxStreams( 1 ).setAudioAttributes( audioAttributes ).build();
        }
        startSound = soundPool.load( this,R.raw.yes,1 );
    }

    protected void onPause(){
        super.onPause();
        soundPool.release();
    }


}
