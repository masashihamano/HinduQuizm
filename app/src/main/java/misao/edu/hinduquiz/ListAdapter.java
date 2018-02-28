package misao.edu.hinduquiz;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by masashihamano on 2018/02/28.
 */

public class ListAdapter extends BaseAdapter {

    static class ViewHolder{
        TextView textView;
        ImageView imageView;
    }

    private LayoutInflater inflater;
    private int itemLayoutId;
    private String[] titles;
    private int[]ids;

    ListAdapter(Context context, int itemLayoutId, String[]names, int[]photos ){

        super();
        this.inflater = (LayoutInflater)context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        this.itemLayoutId = itemLayoutId;
        this.titles = names;
        this.ids = photos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // 最初だけ View を inflate して、それを再利用する
        if (convertView == null) {
            // activity_main.xml に list.xml を inflate して convertView とする
            convertView = inflater.inflate(itemLayoutId, parent, false);
            // ViewHolder を生成
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.name);
            holder.imageView = convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        }
        // holder を使って再利用
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        // holder の imageView にセット
        holder.imageView.setImageResource(ids[position]);
        // 現在の position にあるファイル名リストを holder の textView にセット
        holder.textView.setText(titles[position]);

        return convertView;
    }

    @Override
    public int getCount() {
        // texts 配列の要素数
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}



//    private int mResource;
//    private List<ListItem> mItems;
//    private LayoutInflater mInflater;
//
//    public ListAdapter(Context context, int resource, List<ListItem> items) {
//        super(context, resource, items);
//
//        mResource = resource;
//        mItems = items;
//        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view;
//
//        if (convertView != null){
//            view = convertView;
//        }
//        else{
//            view = mInflater.inflate( mResource,null );
//        }
//
//        ListItem item = mItems.get( position );
//
//        ImageView thumbnail = (ImageView)view.findViewById( R.id.thumbnail );
//        thumbnail.setImageBitmap( item.getThumbnail() );
//
//        TextView title = (TextView)view.findViewById( R.id.title );
//        title.setText( item.getTitle() );
//
//        return view;
//    }
//
//}
