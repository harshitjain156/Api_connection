package com.example.apiconnection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apiconnection.ModelResponses.Search.SearchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class search_medicine extends AppCompatActivity {
    EditText search;
    RecyclerView recyclerView2;
    SharedPrefManager sharedPrefManager;
    Button search_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_medicine);
        search=findViewById(R.id.search_medicine);
        sharedPrefManager=new SharedPrefManager(getApplicationContext());
        search_btn=findViewById(R.id.searchbtn);
        sharedPrefManager=new SharedPrefManager(getApplicationContext());
        recyclerView2=findViewById(R.id.recylerview2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchMedicine();
            }
        });
    }

    private void searchMedicine() {
//        Toast.makeText(search_medicine.this,sharedPrefManager.getData().getAccessToken(),Toast.LENGTH_SHORT).show();
        String srch=search.getText().toString();
//
        Call<SearchResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .search(1,srch,sharedPrefManager.getData().getAccessToken());

        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
//                Toast.makeText(search_medicine.this,"response aa rha h"+response.toString(),Toast.LENGTH_SHORT).show();
                SearchResponse searchResponse= response.body();

                if (response.isSuccessful()){
                    searchMedicineAdapter adapter =new searchMedicineAdapter(search_medicine.this,searchResponse.getData().getItems());
                    recyclerView2.setAdapter(adapter);
//                    Toast.makeText(search_medicine.this,"response.body().getData().getItems().toString()",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Toast.makeText(search_medicine.this,t.getMessage()+"failure",Toast.LENGTH_SHORT).show();

            }
        });
//        call.enqueue(new Callback<RegisterResponse>() {
//            @Override
//            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
//                RegisterResponse registerResponse=response.body();
//                if(response.isSuccessful()){
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RegisterResponse> call, Throwable t) {
//                Toast.makeText(search_medicine.this,t.getMessage(),Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}