package fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hackerkernel.moviretrofit.Adapter.PopularMovieinfoAdapter;
import com.hackerkernel.moviretrofit.MyInterface;
import com.hackerkernel.moviretrofit.R;
import com.hackerkernel.moviretrofit.RetrofitClint;

import Model.PopularmovietrailorModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularmovieinfoFragment extends Fragment {

    RecyclerView recycle;
    String persion_id;

    public PopularmovieinfoFragment(String persion_id) {
        this.persion_id = persion_id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_popularmovieinfo, container, false);
        recycle=view.findViewById(R.id.recycle);

        RetrofitClint.getRetrofit().create(MyInterface.class)
                .gettrailorpopularmovie(""+persion_id,"c4824776bf6f08433a4c4e7cd75a6acc")
                .enqueue(new Callback<PopularmovietrailorModel>() {
                    @Override
                    public void onResponse(Call<PopularmovietrailorModel> call, Response<PopularmovietrailorModel> response) {

                        Log.d("dfghgfdfgh", "onResponse: "+response.body());

                        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
                        recycle.setLayoutManager(linearLayoutManager);

                        PopularMovieinfoAdapter popularMovieinfoAdapter=new PopularMovieinfoAdapter(getContext(),response.body());
                        recycle.setAdapter(popularMovieinfoAdapter);

                    }

                    @Override
                    public void onFailure(Call<PopularmovietrailorModel> call, Throwable t) {
                        Log.d("cfghhgfdfgh", "onFailure: "+t.getMessage());

                    }
                });

        return view;
    }
}