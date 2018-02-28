package misao.edu.hinduquiz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String[] names = {
            "アグニ(Agni)",
            "ブラフマー(Brahma)",
            "ブッダ(Budha)",
            "ダーキニー(Dakini)",
            "ドゥルガー(Durga)",
            "ガネーシャ(Ganesa)",
            "ガンガー(Ganga)",
            "ハヌマーン(Hanuman)",
            "インドラ(Indra)",
            "ジャガンナート(Jagannatha)",
            "カーリー(Kali)",
            "カーマ(Kama)",
            "クリシュナ(Krsna)",
            "クベーラ(Kubera)",
            "クールマ(Kurma)",
            "ラクシュミー(Lakshmi)",
            "マツヤ(Matsya)",
            "ミーナクシー(Minakshi)",
            "ナーガ(Naga)",
            "ナンディン(Nandin)",
            "ナラシンハ(Nrisimha)",
            "パラシューマ(Parasurama)",
            "パールヴァティ(Parvathi)",
            "ラーマ(Rama)",
            "サラスヴァティ(Sarasvati)",
            "シヴァ(Shiva)",
            "スカンダ(Skanda)",
            "ソーマ(Soma)",
            "スーリヤ(Surya)",
            "ヴァマーナ(Vamana)",
            "ヴァラーハ(Varaha)",
            "ヴァルナ(Varuna)",
            "ヴァーユ(Vayu)",
            "ヴィシュヌ(Vishnu)",
            "ヤマ(Yama)"
    };

    private static final int[] photos = {
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
            R.drawable.yama
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list );

        // ListViewのインスタンスを生成
        ListView listView = findViewById( R.id.myListView );

        listView.setOnItemClickListener( this );

        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を activity_main.xml に
        // inflate するためにadapterに引数として渡す
        BaseAdapter adapter = new ListAdapter( this.getApplicationContext(),
                R.layout.list_item, names, photos );


        listView.setAdapter( adapter );
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        Intent intent = new Intent( this.getApplicationContext(),TitleActivity.class );
        // clickされたpositionのtextとphotoのID
        String selectedText = names[position];
        int selectedPhoto = photos[position];
        // インテントにセット
        intent.putExtra("Text", selectedText);
        intent.putExtra("Photo", selectedPhoto);
        // Activity をスイッチする
        startActivity(intent);
    }
}


//        //②データを装備(今回はArrayリストにUserを入れる)
//        ArrayList<ListItem> listItems = new ArrayList<>(  );
//
//        int[] icons ={R.drawable.agni,
//                R.drawable.brahma,
//                R.drawable.budha,
//                R.drawable.dakini,
//                R.drawable.durga,
//                R.drawable.ganesa,
//                R.drawable.ganga,
//                R.drawable.hanuman,
//                R.drawable.indra,
//                R.drawable.jagannatha,
//                R.drawable.kali,
//                R.drawable.kama,
//                R.drawable.krsna,
//                R.drawable.kubera,
//                R.drawable.kurma,
//                R.drawable.lakshmi,
//                R.drawable.matsya,
//                R.drawable.minakshi,
//                R.drawable.naga,
//                R.drawable.nandin,
//                R.drawable.nrisimha,
//                R.drawable.parasurama,
//                R.drawable.parvathi,
//                R.drawable.rama,
//                R.drawable.sarasvati,
//                R.drawable.shiva,
//                R.drawable.skanda,
//                R.drawable.soma,
//                R.drawable.surya,
//                R.drawable.vamana,
//                R.drawable.varaha,
//                R.drawable.varuna,
//                R.drawable.vayu,
//                R.drawable.vishnu,
//                R.drawable.yama };
//
//        String[]names =
//
//
//        //for文で1度回す
//        for (int i = 0; i < icons.length; i++){
//
//            Bitmap bmp = BitmapFactory.decodeResource( getResources(),icons[i] );
//            ListItem item = new ListItem( bmp,names[i] );
//            listItems.add( item );
//
//
////            //userをインスタンス化
////            User user = new User();
////            //BitmapFactoryで画像を縮小してsetで読み込む
////            user.setIcon( BitmapFactory.decodeResource( getResources(),icons[i] ));
////            user.setName(names[i]);
////            users.add( user );
//        }
//
//        ListAdapter adapter = new ListAdapter(this, R.layout.list_item,listItems);
//        mylistView.setAdapter( adapter );
//        }
//
//
////        //③Adapterを用意、データが複雑のためArrayAdapterを継承して、UserAdapterを作る
////        UserAdapter adapter = new UserAdapter(this,0,users);
////
////        //⑦ListViewに(adapterを)表示
////        mylistView.setAdapter( adapter );
////
////        //⑧画面遷移
//////        mylistView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
//////            @Override
//////            public void onItemClick(
//////                    AdapterView<?>adapterView, View view, int position, long id) {
//////
//////                Intent intent = new Intent( ListActivity.this,TitleActivity.class );
//////                startActivity( intent );
//////
//////            }
//////        } );
////
////
////        }
////
////    //④UserAdapterを作る
////    public class UserAdapter extends ArrayAdapter<User> {
////        //LayoutInflater→動的にLayout.xmlファイルをセットすることができる。
////        private LayoutInflater layoutInflater;//メンバ変数を宣言
////
////        //コンストラクタを作る
////        public UserAdapter(Context c, int id, ArrayList<User> users) {
////            //親クラスのコンストラクタを呼ぶ
////            super( c, id, users );
////            this.layoutInflater = (LayoutInflater) c.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
////        }
////
////        //⑤getViewをoverrideする
////        @Override
////        public View getView(int pos, View convertView, ViewGroup parent) {
////            //再利用できるviewがあるかどうかを判断
////            if (convertView == null) {
////                //nullだった場合には layoutInflatorでViewを作る
////                convertView = layoutInflater.inflate(
////                        //作ったものをconvertView に入れる
////                        R.layout.list_item, parent, false
////                );
////            }
////            //⑥convertViewにUserのデータをsetして、返す
////            User user = (User) getItem( pos );//getItemはadapterが持つメソッドでviewが呼ばれたアイテムを取得する
////            ((ImageView) convertView.findViewById( R.id.icon )).setImageBitmap( user.getIcon() );
////            ((TextView) convertView.findViewById( R.id.name )).setText( user.getName() );
////            return convertView;
////        }
////    }
////
////    //①Userクラスを作る(構造が複雑のため)
////    public class User {
////        //メンバ変数を宣言
////        private Bitmap icon;
////        private String name;
////
////        //↑のメンバ変数にアクセスするためのgetterとsetterが必要
////        public Bitmap getIcon() {
////            return icon;
////        }
////        public void setIcon(Bitmap icon) {
////            this.icon = icon;
////        }
////
////        public String getName() {
////            return name;
////        }
////        public void setName(String name) {
////            this.name = name;
////        }
////
////
////    }
//
//
//}
