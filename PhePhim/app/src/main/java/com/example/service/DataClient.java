package com.example.service;

import com.example.model.BaiViet;
import com.example.model.BinhLuanBaiViet;
import com.example.model.BinhLuanPhim;
import com.example.model.Phim;
import com.example.model.User;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface DataClient {

    @Multipart
    @POST("uploadImage.php")
    Call<String> uploadImage(@Part MultipartBody.Part image);

    @FormUrlEncoded
    @POST("registerAccount.php")
    Call<String> registerAccount(@Field("uid") String uid,
                                 @Field("name") String name,
                                 @Field("password") String password);

    @FormUrlEncoded
    @POST("checkLogin.php")
    Call<List<User>> checkLogin(@Field("uid") String email,
                                @Field("password") String password);

    @GET("deleteAccount.php")
    Call<String> deleteUser(@Query("id") String id,
                            @Query("avatar") String avatar);

    @GET("getPhimHot.php")
    Call<List<Phim>> getPhimHot();

    @GET("getBaiViet.php")
    Call<List<BaiViet>> getBaiViet();

    @GET("searchPhim.php")
    Call<List<Phim>> searchPhim(@Query("tenPhim") String tenPhim,
                                @Query("theLoai") int maTheLoai);

    @GET("getBinhLuanPhim.php")
    Call<List<BinhLuanPhim>> getBinhLuanPhim (@Query("maPhim") String maPhim,
                                              @Query("sapXep") int sapXep);

    @FormUrlEncoded
    @POST("insertBinhLuanPhim.php")
    Call<String> insertBinhLuanPhim (@Field("maPhim") String maPhim,
                                                 @Field("email") String email,
                                                 @Field("noiDung") String noiDung,
                                                 @Field("diemPhim") int diemPhim);

    @GET("getBinhLuanBaiViet.php")
    Call<List<BinhLuanBaiViet>> getBinhLuanBaiViet (@Query("maBaiViet") String maBaiVet,
                                                    @Query("sapXep") int sapXep);

    @FormUrlEncoded
    @POST("insertBinhLuanBaiViet.php")
    Call<String> insertBinhLuanBaiViet (@Field("maBaiViet") String maBaiViet,
                                     @Field("email") String email,
                                     @Field("noiDung") String noiDung);
}
