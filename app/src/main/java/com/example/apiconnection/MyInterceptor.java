package com.example.apiconnection;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MyInterceptor implements Interceptor {
    SharedPrefManager sharedPrefManager;

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        Request request=chain.request()
                .newBuilder()
                .addHeader("Authoriztion","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2Njc5NzczODIsIm5iZiI6MTY2Nzk3NzM4MiwianRpIjoiNjRlZmEyNzktZGU2My00OGI4LTkxMWMtZTNmOGVjYTBlNTNiIiwiZXhwIjoxNjcwNTY5MzgyLCJpZGVudGl0eSI6MzEsImZyZXNoIjpmYWxzZSwidHlwZSI6ImFjY2VzcyIsInVzZXJfY2xhaW1zIjp7InJvbGVzIjpbXSwiYXV0aF90eXBlIjoxfX0.HerBiohuln1rvRRjO-mG1vB8QryLiRJoanriRQh_9Ik")
                .build();
        return chain.proceed(request);
    }
}
