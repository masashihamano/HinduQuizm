package misao.edu.hinduquiz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_answer1,b_answer2,b_answer3, b_answer4 ;

    ImageView iv_god ;
    TextView q_tv, scoreText;
    Context context ;

    List<StateModel> list;

    Vibrator vibrator;

    Random r;
    int turn = 1;
    int rightAnswers = 0;
    int count = 1;

    private static final int SHORT_DELAY = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        r = new Random(  );

        iv_god = findViewById( R.id.iv_god );
        q_tv = findViewById( R.id.qText );
        scoreText = findViewById( R.id.scoreText );

        context = getApplicationContext();

        b_answer1 = findViewById( R.id.b_answer1 );
        b_answer2 = findViewById( R.id.b_answer2 );
        b_answer3 = findViewById( R.id.b_answer3 );
        b_answer4 = findViewById( R.id.b_answer4 );

        Intent intent = getIntent();
        int position = intent.getExtras(  ).getInt( "quiz",0 );

        list = new ArrayList<>();


        //add all Gods to the list
        for (int i = 0; i < new Database().answers.length; i++) {
            list.add( new StateModel( new Database().answers[i], new Database().gods[i] ) );
        }

        //shuffle the data
        Collections.shuffle( list );

        newQuestion( turn );


        b_answer1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //check if the answer is correct
                if (b_answer1.getText().toString().equalsIgnoreCase( list.get( turn -1 ).getName() )){
                    rightAnswers = rightAnswers +1;

                    yes_toastMake(context);
                    vibrator = (Vibrator)getSystemService( VIBRATOR_SERVICE );
                    vibrator.vibrate( 300 );

                    //check if the last question
                    if (turn < 10){
                        turn ++;

                    Handler handler = new Handler(  );
                    handler.postDelayed( new Runnable() {
                        @Override
                        public void run() {
                            newQuestion( turn );
                        }
                    },500 );

                    }else{
                        getResults();
                    }
                }else{

                    no_toastMake(context);

                    //check if the last question
                    if(turn < 10){
                        turn ++;
                        Handler handler = new Handler(  );
                        handler.postDelayed( new Runnable() {
                            @Override
                            public void run() {
                                newQuestion( turn );
                            }
                        },500 );
                    }else{
                        getResults();
                    }
                }

            }
        } );


        b_answer2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if the answer is correct
                if (b_answer2.getText().toString().equalsIgnoreCase( list.get( turn -1 ).getName() )){
                    rightAnswers = rightAnswers +1;

                    yes_toastMake(context);
                    vibrator = (Vibrator)getSystemService( VIBRATOR_SERVICE );
                    vibrator.vibrate( 300 );

                    //check if the last question
                    if (turn < 10){
                        turn ++;
                        Handler handler = new Handler(  );
                        handler.postDelayed( new Runnable() {
                            @Override
                            public void run() {
                                newQuestion( turn );
                            }
                        },500 );
                    }else{
                        getResults();
                    }
                }else{

                    no_toastMake(context);

                    //check if the last question
                    if(turn < 10){
                        turn ++;
                        Handler handler = new Handler(  );
                        handler.postDelayed( new Runnable() {
                            @Override
                            public void run() {
                                newQuestion( turn );
                            }
                        },500 );
                    }else{
                        getResults();

                    }
                }

            }
        } );


        b_answer3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if the answer is correct
                if (b_answer3.getText().toString().equalsIgnoreCase( list.get( turn -1 ).getName() )){
                    rightAnswers = rightAnswers +1;

                    yes_toastMake(context);
                    vibrator = (Vibrator)getSystemService( VIBRATOR_SERVICE );
                    vibrator.vibrate( 300 );

                    //check if the last question
                    if (turn < 10){
                        turn ++;
                        Handler handler = new Handler(  );
                        handler.postDelayed( new Runnable() {
                            @Override
                            public void run() {
                                newQuestion( turn );
                            }
                        },500 );
                    }else{
                        getResults();

                    }
                }else{

                    no_toastMake(context);

                    //check if the last question
                    if(turn < 10){
                        turn ++;
                        Handler handler = new Handler(  );
                        handler.postDelayed( new Runnable() {
                            @Override
                            public void run() {
                                newQuestion( turn );
                            }
                        },500 );
                    }else{
                        getResults();

                    }
                }

            }
        } );


        b_answer4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if the answer is correct
                if (b_answer4.getText().toString().equalsIgnoreCase( list.get( turn -1 ).getName() )){
                    rightAnswers = rightAnswers +1;

                    yes_toastMake(context);
                    vibrator = (Vibrator)getSystemService( VIBRATOR_SERVICE );
                    vibrator.vibrate( 300 );

                    //check if the last question
                    if (turn < 10){
                        turn ++;
                        Handler handler = new Handler(  );
                        handler.postDelayed( new Runnable() {
                            @Override
                            public void run() {
                                newQuestion( turn );
                            }
                        },500 );
                    }else{
                        getResults();
                    }
                }else{

                    no_toastMake(context);

                    //check if the last question
                    if(turn < 10){
                        turn ++;
                        Handler handler = new Handler(  );
                        handler.postDelayed( new Runnable() {
                            @Override
                            public void run() {
                                newQuestion( turn );
                            }
                        },500 );
                    }else{
                        getResults();

                    }
                }

            }
        } );

    }


        private void newQuestion(final int number) {


            //set new God image
            iv_god.setImageResource( list.get( number - 1 ).getImage() );

            //decide on which button to place the correct answer
            int correct_answer = r.nextInt(4) +1;

            int firstButton = number - 1 ;
            int secondButton;
            int thirdButton;
            int fourthButton;

            switch (correct_answer){
                case 1:
                    b_answer1.setText( list.get( firstButton ).getName() );

                    do {
                        secondButton = r.nextInt(list.size());
                    }while (secondButton == firstButton);

                    do {
                        thirdButton = r.nextInt(list.size());
                    }while (thirdButton == firstButton || thirdButton == secondButton);

                    do {
                        fourthButton = r.nextInt(list.size());
                    }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton );

                    b_answer2.setText( list.get( secondButton ).getName() );
                    b_answer3.setText( list.get( thirdButton ).getName() );
                    b_answer4.setText( list.get( fourthButton ).getName() );

                    break;


                case 2:
                    b_answer2.setText( list.get( firstButton ).getName() );

                    do {
                        secondButton = r.nextInt(list.size());
                    }while (secondButton == firstButton);

                    do {
                        thirdButton = r.nextInt(list.size());
                    }while (thirdButton == firstButton || thirdButton == secondButton);

                    do {
                        fourthButton = r.nextInt(list.size());
                    }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton );

                    b_answer1.setText( list.get( secondButton ).getName() );
                    b_answer3.setText( list.get( thirdButton ).getName() );
                    b_answer4.setText( list.get( fourthButton ).getName() );
                    break;


                case 3:
                    b_answer3.setText( list.get( firstButton ).getName() );

                    do {
                        secondButton = r.nextInt(list.size());
                    }while (secondButton == firstButton);

                    do {
                        thirdButton = r.nextInt(list.size());
                    }while (thirdButton == firstButton || thirdButton == secondButton);

                    do {
                        fourthButton = r.nextInt(list.size());
                    }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton );

                    b_answer2.setText( list.get( secondButton ).getName() );
                    b_answer1.setText( list.get( thirdButton ).getName() );
                    b_answer4.setText( list.get( fourthButton ).getName() );
                    break;

                case 4:
                    b_answer4.setText( list.get( firstButton ).getName() );

                    do {
                        secondButton = r.nextInt(list.size());
                    }while (secondButton == firstButton);

                    do {
                        thirdButton = r.nextInt(list.size());
                    }while (thirdButton == firstButton || thirdButton == secondButton);

                    do {
                        fourthButton = r.nextInt(list.size());
                    }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton );

                    b_answer2.setText( list.get( secondButton ).getName() );
                    b_answer3.setText( list.get( thirdButton ).getName() );
                    b_answer1.setText( list.get( fourthButton ).getName() );
                    break;
            }
        }




    //正解の◯を表示するメソッド
    public void yes_toastMake(Context cont){
        final Toast toast = new Toast( cont );

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup viewGroup = findViewById( R.id.relative_layout );

        View view = inflater.inflate( R.layout.yes_toast, viewGroup );
        toast.setView( view );

//        CustomToast.makeText(this, "correct", 100).show();

        toast.setDuration( Toast.LENGTH_SHORT );

        toast.setGravity( Gravity.CENTER,0,-100 );

        toast.show();

        Handler handler = new Handler(  );
        handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        },300 );
    }

    //不正解の✕を表示するメソッド
    public void no_toastMake(Context cont){
        final Toast toast = new Toast( cont );

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup viewGroup = findViewById( R.id.relative_layout );

        View view = inflater.inflate( R.layout.no_toast, viewGroup );
        toast.setView( view );

  //      CustomToast.makeText(this, "miss", 100).show();

        toast.setDuration( Toast.LENGTH_SHORT );

        toast.setGravity( Gravity.CENTER,0,-100 );


        toast.show();

        Handler handler = new Handler(  );
        handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        },300 );

    }

//    public void questiontitle(){
//        q_tv.setText( "Q." + count );
//        count ++;
//    }


    public void getResults(){
        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        intent.putExtra("rightAnswers", rightAnswers );
        startActivity(intent);
    }

}


//HOMEからリストactivityへIntent　→　時間あればexpをDATAベースへ登録してTitleActivityに詳細画面を表示

//多言語化できない(databaseだから)　→　英語にする
