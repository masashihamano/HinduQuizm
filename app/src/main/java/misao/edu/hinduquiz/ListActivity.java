package misao.edu.hinduquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListActivity extends AppCompatActivity  {

    ArrayList godNames = new ArrayList<>( Arrays.asList(
            "Agni \nअग्नि",
            "Brahma \nब्रह्मा" ,
            "Budha \nबुद्ध",
            "Dakini \nडाकिनी" ,
            "Durga \nदुर्गा",
            "Ganesa \nगणेश",
            "Ganga \nगंगा",
            "Hanuman \nहनुमान",
            "Indra \nइंद्र",
            "Jagannatha \nजगन्नाथ",
            "Kali \nकाली",
            "Kama \nकामदेव",
            "Krsna \nकृष्",
            "Kubera \nकुबेर",
            "Kurma \nकुर्म",
            "Lakshmi \nलक्ष्मी",
            "Matsya \nमत्",
            "Minakshi \nमीनाक्षी",
            "Naga \nनागा",
            "Nandin \nनन्दी",
            "Nrisimha \nनरसिंह",
            "Parasurama \nपरशुराम",
            "Parvathi \nपार्वती",
            "Rama \nराम",
            "Sarasvati \nसरस्वती",
            "Shiva \nशिव",
            "Skanda \nकंद",
            "Soma \nसोमा",
            "Surya \nसूर्य",
            "Vamana \nवामन",
            "Varaha \nवराह",
            "Varuna \nवार्ना",
            "Vayu \nवायु",
            "Vishnu \nविष्णु",
            "Yama \nयम"));

    ArrayList godImages = new ArrayList<>(Arrays.asList(
            R.drawable.agni,
            R.drawable.brahma,
            R.drawable.budha,
            R.drawable.dakini,
            R.drawable.durga,
            R.drawable.ganesa,
            R.drawable.ganga,
            R.drawable.hanuman,
            R.drawable.indra,
            R.drawable.jagannatha,
            R.drawable.kali,
            R.drawable.kama,
            R.drawable.krsna,
            R.drawable.kubera,
            R.drawable.kurma,
            R.drawable.lakshmi,
            R.drawable.matsya,
            R.drawable.minakshi,
            R.drawable.naga,
            R.drawable.nandin,
            R.drawable.nrisimha,
            R.drawable.parasurama,
            R.drawable.parvathi,
            R.drawable.rama,
            R.drawable.sarasvati,
            R.drawable.shiva,
            R.drawable.skanda,
            R.drawable.soma,
            R.drawable.surya,
            R.drawable.vamana,
            R.drawable.varaha,
            R.drawable.varuna,
            R.drawable.vayu,
            R.drawable.vishnu,
            R.drawable.yama));




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list );

        Intent intent = getIntent();
        int position = intent.getExtras(  ).getInt( "list",0 );



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        ListAdapter listAdapter = new ListAdapter(ListActivity.this, godNames,godImages);
        recyclerView.setAdapter(listAdapter);




//        // ListViewのインスタンスを生成
//        RecyclerView recyclerView  = findViewById( R.id.recyclerView );
//
//        recyclerView.setOnItemClickListener( this );
//
//        // BaseAdapter を継承したadapterのインスタンスを生成
//        // レイアウトファイル list.xml を activity_main.xml に
//        // inflate するためにadapterに引数として渡す
//        BaseAdapter adapter = new ListAdapter(this.getApplicationContext(), R.layout.list_item, godNames, godImages);
//
//        recyclerView.setAdapter( adapter );
//
//        // クリックリスナーをセット
//        recyclerView.setOnItemClickListener(this);
    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//
//        Intent intent = new Intent( this.getApplicationContext(),TitleActivity.class );
//
//        // clickされたpositionのtextとphotoのID
//        String selectedText = (String) godNames.get( position );
//        int selectedPhoto = (int) godImages.get( position );
//
//        // インテントにセット
//        intent.putExtra("Text", selectedText);
//        intent.putExtra("Photo", selectedPhoto);
//
//        // TitleActivityへ遷移
//        startActivity(intent);
//    }
}

