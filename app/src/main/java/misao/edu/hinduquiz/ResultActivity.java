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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_result, tv_msg;
    ImageView iv_god;
    List<StateModel> list;
    Locale locale = Locale.getDefault();
    Button btnReplay ;

    SoundPool soundPool;
    int startSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_result );

        tv_result = findViewById( R.id.tv_result );
        tv_msg = findViewById( R.id.tv_msg );
        iv_god = findViewById( R.id.iv_god );
        btnReplay = findViewById( R.id.btnReplay );

        btnReplay.setOnClickListener( this );

        String lang = locale.getLanguage();
        list = new ArrayList<>();
        int turn = 1;


        for (int i = 0; i < new Database().answers.length; i++) {
            list.add( new StateModel( new Database().answers[i], new Database().gods[i] ) );
        }
        //shuffle the data
        Collections.shuffle( list );

        imagescore(turn);

        int score = getIntent().getIntExtra( "rightAnswers",0 );
        tv_result.setText( score *10 + " !" );

        if (score == 0){
            if (lang.equals("ja")) {
                tv_msg.setText( "問題外です" );
            } else
            tv_msg.setText( "Out of the question." );

        }else if(score == 1){
            if (lang.equals("ja")) {
                tv_msg.setText("残念でした" );
            } else
            tv_msg.setText( "That's too bad." );

        }else if(score == 2){
            if (lang.equals("ja")) {
                tv_msg.setText("修行が足りない" );
            } else
            tv_msg.setText( "Study harder." );

        }else if(score == 3){
            if (lang.equals("ja")) {
                tv_msg.setText("まだまだです" );
            } else
            tv_msg.setText( "Lack of learning." );

        }else if(score == 4){
            if (lang.equals("ja")) {
                tv_msg.setText("もっと頑張りましょう" );
            } else
            tv_msg.setText( "Not there yet." );

        }else if(score == 5){
            if (lang.equals("ja")) {
                tv_msg.setText("もう少し頑張りましょう" );
            } else
            tv_msg.setText( "Believe in yourself." );

        }else if(score == 6){
            if (lang.equals("ja")) {
                tv_msg.setText("あと少し！" );
            } else
            tv_msg.setText( "You can do it!" );

        }else if(score == 7){
            if (lang.equals("ja")) {
                tv_msg.setText("おめでとう！" );
            } else
            tv_msg.setText( "Good!" );

        }else if(score == 8){
            if (lang.equals("ja")) {
                tv_msg.setText("素晴らしい！" );
            } else
            tv_msg.setText( "Great!" );

        }else if(score == 9){
            if (lang.equals("ja")) {
                tv_msg.setText("おしい、あと1問！" );
            } else
            tv_msg.setText( "Amazing!" );

        }else{
            if (lang.equals("ja")) {
                tv_msg.setText("神レベル！" );
            } else
            tv_msg.setText( "Congratulations!" );
        }
    }

    private void imagescore (int number) {
        //set new God image
        iv_god.setImageResource( list.get( number ).getImage() );
    }

    @Override
    public void onClick(View view) {

//        soundPool.play( startSound,1.0f,1.0f,0,0,1.0f );
//        onResume();
//        onPause();

        Intent intent = new Intent( ResultActivity.this,HomeActivity.class );
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
        startSound = soundPool.load( this,R.raw.restart,1 );
    }

    protected void onPause(){
        super.onPause();
        soundPool.release();
    }

}
