package com.hackerkernel.moviretrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hackerkernel.moviretrofit.R;

import Model.TrendingmovietrailorModel;

public class Trendingmovieinfoadapter extends RecyclerView.Adapter<Trendingmovieinfoadapter.ViewHolder>{

    Context context;
    TrendingmovietrailorModel trendingmovietrailorModel;

    public Trendingmovieinfoadapter(Context context, TrendingmovietrailorModel trendingmovietrailorModel) {
        this.context = context;
        this.trendingmovietrailorModel = trendingmovietrailorModel;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.trailot,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder( Trendingmovieinfoadapter.ViewHolder holder, int position) {


        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v="+trendingmovietrailorModel.getResults().get(position).getKey()));
                context.startActivity(intent);
            }
        });

        Glide.with(context).load("https://img.youtube.com/vi/"+trendingmovietrailorModel.getResults().get(position).getKey()+"/sddefault.jpg").into(holder.img);
        Log.d("vbvbvcvb", "ghjhgfghjhgh: "+trendingmovietrailorModel.getResults().get(position));

    }


    @Override
    public int getItemCount() {
        return trendingmovietrailorModel.getResults().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        ImageView img;
        public ViewHolder( View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img);
        }
    }
}
