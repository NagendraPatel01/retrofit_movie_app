package com.hackerkernel.moviretrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hackerkernel.moviretrofit.PopularmovieActivity;
import com.hackerkernel.moviretrofit.R;

import Model.PopularMovieModel;

public class PopularMovieAdapter extends RecyclerView.Adapter<PopularMovieAdapter.ViewHolder> {

    Context context;
    PopularMovieModel popularMovieModel;

    public PopularMovieAdapter(Context context, PopularMovieModel popularMovieModel) {
        this.context = context;
        this.popularMovieModel = popularMovieModel;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycle2,parent,false);
       return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        holder.text.setText(popularMovieModel.getResults().get(position).getTitle());
        Log.d("fdfgfdfg", "onBindViewHolder: "+popularMovieModel.getResults().get(position).getTitle());

        Glide.with(context).load("https://image.tmdb.org/t/p/w185"+popularMovieModel.getResults().get(position).getPosterPath()).into(holder.img);
        Log.d("gfdsasdfgh", "onBindViewHolder: "+popularMovieModel.getResults().get(position).getPosterPath());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, PopularmovieActivity.class);
                intent.putExtra("persion_id",popularMovieModel.getResults().get(position).getId()+"");


                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return popularMovieModel.getResults().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardview;
        ImageView img;
        TextView text;
        public ViewHolder( View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img);
            cardview=itemView.findViewById(R.id.cardview);
            text=itemView.findViewById(R.id.text);
        }
    }
}
