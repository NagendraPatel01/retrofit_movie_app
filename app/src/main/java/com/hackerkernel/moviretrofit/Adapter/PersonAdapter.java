package com.hackerkernel.moviretrofit.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hackerkernel.moviretrofit.R;

import Model.PersonModel;
import de.hdodenhof.circleimageview.CircleImageView;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private static final String TAG = "PersonAdapter";
    Context context;
   PersonModel personModel;

    public PersonAdapter(Context context, PersonModel personModel) {
        this.context = context;
        this.personModel = personModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.recycle1,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull  PersonAdapter.ViewHolder holder, int position) {

        holder.text.setText(personModel.getResults().get(position).getName());

        Glide.with(context).load("https://image.tmdb.org/t/p/w185"+personModel.getResults().get(position).getProfilePath()).into(holder.img);

        Log.d(TAG, "lkjhgfdfghjkjhgfgh "+personModel.getResults().get(position).getProfilePath());
    }


    @Override

    public int getItemCount() {
        return personModel.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView img;
        TextView text;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img);
            text=itemView.findViewById(R.id.text);
        }
    }
}
