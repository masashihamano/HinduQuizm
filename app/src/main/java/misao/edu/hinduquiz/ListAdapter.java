package misao.edu.hinduquiz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by masashihamano on 2018/02/28.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    ArrayList godNames;
    ArrayList godImages;
    Context context;
    public ListAdapter(Context context, ArrayList godNames, ArrayList godImages) {
        this.context = context;
        this.godNames = godNames;
        this.godImages = godImages;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.name.setText( (CharSequence) godNames.get(position) );
        holder.image.setImageResource( (Integer) godImages.get(position) );
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                Toast.makeText(context, (CharSequence) godNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return godNames.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;

        public MyViewHolder(View itemView) {
            super( itemView );

            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

}

