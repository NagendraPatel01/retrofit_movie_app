package com.hackerkernel.moviretrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hackerkernel.moviretrofit.R;
import com.hackerkernel.moviretrofit.TrendingmovieActivity;

import Model.TrendingMovieModel;

public class TrendingMovieAdapter extends RecyclerView.Adapter<TrendingMovieAdapter.ViewHolder> {

    Context context;
    TrendingMovieModel trendingMovieModel;

    public TrendingMovieAdapter(Context context, TrendingMovieModel trendingMovieModel) {
        this.context = context;
        this.trendingMovieModel = trendingMovieModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycle2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  TrendingMovieAdapter.ViewHolder holder, int position) {

        holder.text.setText(trendingMovieModel.getResults().get(position).getOriginalTitle());

        Log.d("hgfgh", "onBindViewHolder: "+trendingMovieModel.getResults().get(position).getOriginalTitle());

        Glide.with(context).load("https://image.tmdb.org/t/p/w185"+trendingMovieModel.getResults().get(position).getPosterPath()).into(holder.img);

        Log.d("mnbvbn", "lkjhgfdfghjkjhgfgh "+trendingMovieModel.getResults().get(position).getPosterPath());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, TrendingmovieActivity.class);


                intent.putExtra("persion_id",trendingMovieModel.getResults().get(position).getId()+"");
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return trendingMovieModel.getResults().size();
    }

   public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
       CardView cardView;
        TextView text;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            cardView=itemView.findViewById(R.id.cardview);
            img=itemView.findViewById(R.id.img);
            text=itemView.findViewById(R.id.text);
        }
    }
}
