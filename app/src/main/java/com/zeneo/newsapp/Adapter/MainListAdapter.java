package com.zeneo.newsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zeneo.newsapp.Activities.R;
<<<<<<< HEAD
=======

>>>>>>> b36c8c45a96fc4dfdcc9a0d2f1cc743e3efee5d7
import com.zeneo.newsapp.Model.WebSites;

import java.util.List;

public class MainListAdapter extends BaseAdapter {

<<<<<<< HEAD
    Context context;
    List<WebSites> list ;
    ImageView imageView;
=======

    Context context;
    List<WebSites> list ;
>>>>>>> b36c8c45a96fc4dfdcc9a0d2f1cc743e3efee5d7

    public MainListAdapter(Context context, List<WebSites> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
<<<<<<< HEAD
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater.from(context));
        view = inflater.inflate(R.layout.mainlist_item,null,false);}
        imageView = (ImageView)view.findViewById(R.id.mainlistimg);
=======
        LayoutInflater inflater=(LayoutInflater.from(context));
        view = inflater.inflate(R.layout.mainlist_item,null);
        ImageView imageView = (ImageView)view.findViewById(R.id.mainlistimg);
        TextView textView = (TextView)view.findViewById(R.id.mainlisttxt);
        textView.setText(list.get(i).getName());
>>>>>>> b36c8c45a96fc4dfdcc9a0d2f1cc743e3efee5d7
        imageView.setImageResource(list.get(i).getImage());
        return view;
    }
}
