package fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hackerkernel.moviretrofit.Adapter.Trendingmovieinfoadapter;
import com.hackerkernel.moviretrofit.MyInterface;
import com.hackerkernel.moviretrofit.R;
import com.hackerkernel.moviretrofit.RetrofitClint;

import Model.TrendingmovietrailorModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingmovieinfoFragment extends Fragment {

    String persion_id;
    RecyclerView recycle;

    public TrendingmovieinfoFragment(String persion_id) {
        this.persion_id = persion_id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_trendingmovieinfo, container, false);

        recycle=view.findViewById(R.id.recycle);

        RetrofitClint.getRetrofit().create(MyInterface.class).gettrailortrendingmovie(""+persion_id,"c4824776bf6f08433a4c4e7cd75a6acc")
                .enqueue(new Callback<TrendingmovietrailorModel>() {
                    @Override
                    public void onResponse(Call<TrendingmovietrailorModel> call, Response<TrendingmovietrailorModel> response) {

                        Log.d("gnhgfdfg", "fghjkjhgfghj: "+response);
                        Log.d("fghjhgfg", "onResponse: "+response.body());

                        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
                        recycle.setLayoutManager(linearLayoutManager);

                        Trendingmovieinfoadapter trendingmovieinfoadapter=new Trendingmovieinfoadapter(getContext(),response.body());
                        recycle.setAdapter(trendingmovieinfoadapter);
                    }

                    @Override
                    public void onFailure(Call<TrendingmovietrailorModel> call, Throwable t) {

                        Log.d("fghgfd", "onFailure: "+t.getMessage());
                    }
                });
        return view;
    }
}