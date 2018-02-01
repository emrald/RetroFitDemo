package com.trivediinfoway.retrofitdemo.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.trivediinfoway.retrofitdemo.R;
import com.trivediinfoway.retrofitdemo.dataclass.Hero;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TI A1 on 12-10-2017.
 */
public class CustomAdapter extends BaseAdapter {

   List<Hero> arraylist = new ArrayList<Hero>();
    Activity activity;
    LayoutInflater inflater;

    public CustomAdapter(Activity activity, int res, List<Hero> arraylist) {
        this.arraylist = arraylist;
        this.activity = activity;
        this.inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return arraylist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder
    {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null)
        {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row,null);

            holder.imageView = (ImageView)view.findViewById(R.id.imageView);
            holder.textView = (TextView) view.findViewById(R.id.textView);
            holder.textView2 = (TextView)view.findViewById(R.id.textView2);
            holder.textView3 = (TextView)view.findViewById(R.id.textView3);
            holder.textView4 = (TextView)view.findViewById(R.id.textView4);
            holder.textView5 = (TextView)view.findViewById(R.id.textView5);
            holder.textView6 = (TextView)view.findViewById(R.id.textView6);

            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)view.getTag();
        }

        Hero hero = arraylist.get(i);
        holder.textView.setText(hero.getName());
        holder.textView2.setText(hero.getRealname());
        holder.textView3.setText(hero.getFirstappearance());
        holder.textView4.setText(hero.getCreatedby());
        holder.textView5.setText(hero.getPublisher());
        holder.textView6.setText(hero.getTeam());

        Picasso.with(activity).load(hero.getImageurl()).fit().centerInside().placeholder(activity.getResources().getDrawable(R.mipmap.ic_launcher)).error(activity.getResources().getDrawable(R.mipmap.ic_launcher)).into(holder.imageView);

        return view;
    }
}
