package client.impl;

import client.exception.EosApiError;
import client.exception.EosApiException;
import client.util.Utils;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

public class EosApiServiceGenerator {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .addConverterFactory(JacksonConverterFactory.create());

    private static Retrofit retrofit;

    public static <S> S createService(Class<S> serviceClass, String baseUrl) {

        builder.baseUrl(baseUrl);
        builder.client(httpClient.build());
        builder.addConverterFactory(JacksonConverterFactory.create());
        retrofit = builder.build();

        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                System.out.println("response: " + Utils.toJsonByGson(response));
                EosApiError apiError = getEosApiError(response);
                throw new EosApiException(apiError);
            }
        } catch (IOException e) {
            throw new EosApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    private static EosApiError getEosApiError(Response<?> response) throws IOException, EosApiException {
        return (EosApiError) retrofit.responseBodyConverter(EosApiError.class, new Annotation[0])
                .convert(response.errorBody());
    }
}
