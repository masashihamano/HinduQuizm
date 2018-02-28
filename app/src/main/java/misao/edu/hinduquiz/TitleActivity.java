package misao.edu.hinduquiz;

import android.app.ListActivity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class TitleActivity extends AppCompatActivity {

//    private static final String TAG = "TitleActivity";
//    SectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_title );

        Intent intent = getIntent();
        String selectedText = intent.getStringExtra("Text");
        int selectedPhoto = intent.getIntExtra("Photo", 0);

        TextView textView = findViewById(R.id.selected_text);
        textView.setText(selectedText);
        ImageView imageView = findViewById(R.id.selected_photo);
        imageView.setImageResource(selectedPhoto);

    }
}





//        sectionsPagerAdapter = new SectionsPagerAdapter( getSupportFragmentManager() );
//
//        BottomNavigationView bottomNavigationView = findViewById( R.id.bottom_Nav_View_Bar );
//        BottomNavigationViewHelper.disableShiftMode( bottomNavigationView );
//        Menu menu = bottomNavigationView.getMenu();
//        MenuItem menuItem = menu.getItem( 0 );
//        menuItem.setChecked( true );
//
//
//        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//
//
//
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId())
//                {
//                    case R.drawable.ic_quiz:
//                        Intent intent =new Intent( TitleActivity.this,MainActivity.class );
//                        startActivity( intent );
//                        break;
//                    case R.drawable.ic_list:
//                        Intent intent1 = new Intent( TitleActivity.this, ListActivity.class );
//                        startActivity( intent1 );
//                        break;
//                }
//                return false;
//            }
//        } );
//
//    }
//
//
//}