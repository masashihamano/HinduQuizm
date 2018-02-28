package misao.edu.hinduquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_screen );
        Handler handler = new Handler(  );
        handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent( ScreenActivity.this, HomeActivity.class );
                startActivity( intent );
                finish();
            }
        },2500);

    }
}
