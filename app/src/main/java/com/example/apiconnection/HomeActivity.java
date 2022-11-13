package com.example.apiconnection;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apiconnection.ModelResponses.HomeResponses.Datum;
import com.example.apiconnection.ModelResponses.HomeResponses.Homeresponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    TextView a1,a2,a3,a4;
    SharedPrefManager sharedPrefManager;
    RecyclerView recyclerView;
    RecycleAdapterPag recycleAdapter;
    ArrayAdapter arrayAdapter;
    ArrayList <Datum> contactArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView=findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        a1=findViewById(R.id.accesstoken);
//        a2=findViewById(R.id.type);
//        a3=findViewById(R.id.first_name);
//        a4=findViewById(R.id.refereshtoken);
//        sharedPrefManager=new SharedPrefManager(getApplicationContext());
//        a1.setText(sharedPrefManager.getData().getAccessToken());
//        a2.setText(sharedPrefManager.getData().getType());
//        a3.setText(sharedPrefManager.getData().getFirstName());
//        a4.setText(sharedPrefManager.getData().getRefreshToken());
        listingdata();
    }

    private void listingdata() {
        Api api=RetrofitClient.getInstance().getApi();
        Call<Homeresponse> listingdata=api.getData();
        listingdata.enqueue(new Callback<Homeresponse>() {
            @Override
            public void onResponse(Call<Homeresponse> call, Response<Homeresponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Succesfull response ",Toast.LENGTH_SHORT).show();
                    Homeresponse homeresponse= response.body();
                    RecycleAdapterPag adapter =new RecycleAdapterPag(HomeActivity.this,homeresponse.getData());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Homeresponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();

            }
        });
    }

//    class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.MyViewHolder>{
//        List<Homeresponse.Datum> list;
//
//        @NonNull
//        @Override
//        public recycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,null);
//            recycleAdapter.MyViewHolder viewHolder= new MyViewHolder(view);
//            return viewHolder;
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull recycleAdapter.MyViewHolder holder, int position) {
//            holder.category.setText(list.get(position).getData().getName());
//            Picasso.with(getApplicationContext())
//                    .load(list.get(position).getImage().getSmallPath())
//                    .placeholder(R.id.catimg)
//                    .fit()
//                    .into(holder.catimg);
//        }
//
//        @Override
//        public int getItemCount() {
//            return list.size()>0 ? list.size():1;
//        }
//
//        public class MyViewHolder extends RecyclerView.ViewHolder {
//            TextView category;
//            ImageView catimg;
//            public MyViewHolder(@NonNull View itemView) {
//                super(itemView);
//                catimg = itemView.findViewById(R.id.catimg);
//                category =itemView.findViewById(R.id.category);
//            }
//        }
//    }


}