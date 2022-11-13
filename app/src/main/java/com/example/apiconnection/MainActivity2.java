package com.example.apiconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apiconnection.ModelResponses.Data;
import com.example.apiconnection.ModelResponses.LoginResponse;
import com.example.apiconnection.ModelResponses.RegisterResponse;
import com.example.apiconnection.ModelResponses.ResendOtp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
//    TextView rawdata;
    TextView resend;
    EditText phn;
    EditText otp;
    EditText firstname;
    Button btn2;
    SharedPrefManager sharedPrefManager;
    String phn_number;

    
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        rawdata=findViewById(R.id.rawdata);
        resend=findViewById(R.id.resendotp);
        Intent intent = getIntent();
        phn_number=intent.getStringExtra("Phone");
        otp=findViewById(R.id.editTextNumberPassword);
        btn2=findViewById(R.id.button2);
//        firstname=findViewById(R.id.first_name);
        sharedPrefManager=new SharedPrefManager(getApplicationContext());

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resentOtp();
            }
        });
    }


    private void userLogin() {
//        String first=firstname.getText().toString();
        String number=phn_number;
        int otp1= Integer.parseInt(otp.getText().toString());
        if(number.isEmpty()){
            phn.requestFocus();
            phn.setError("please enter number");
            Toast.makeText(MainActivity2.this,"enter correct number",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Patterns.PHONE.matcher(number).matches()){
            phn.requestFocus();
            phn.setError("please enter a valid number");
            Toast.makeText(MainActivity2.this,"enter correct number",Toast.LENGTH_SHORT).show();
            return;
        }
        Call<LoginResponse> call= RetrofitClient.getInstance().getApi().login(number,otp1);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse= response.body();

                if (response.isSuccessful()){
//                    rawdata.setText(String.format(
//                            "%s\n %s \n",loginResponse.getData().getRefresh_token(),loginResponse.getData().getGender()
//                    ));

                    sharedPrefManager.saveUser(loginResponse.getData());
                    Intent intent = new Intent(MainActivity2.this, search_medicine.class);

                    startActivity(intent);

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
    private void resentOtp() {
        String number=phn_number;
        Call<ResendOtp> call= RetrofitClient.getInstance().getApi().resend(number);
        call.enqueue(new Callback<ResendOtp>() {
            @Override
            public void onResponse(Call<ResendOtp> call, Response<ResendOtp> response) {
                ResendOtp resendOtp=response.body();
                if(response.isSuccessful()){

                    Toast.makeText(MainActivity2.this,"OTP sended to "+number,Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ResendOtp> call, Throwable t) {
                Toast.makeText(MainActivity2.this,t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        if(sharedPrefManager.isLoggedIn()){
//            Intent intent = new Intent(MainActivity2.this, HomeActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
//        }
//    }
}