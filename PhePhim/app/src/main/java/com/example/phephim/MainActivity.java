package com.example.phephim;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.adapter.BaiVietAdapter;
import com.example.adapter.PhimAdapter;
import com.example.model.BaiViet;
import com.example.model.Phim;
import com.example.service.APIUtils;
import com.example.service.DataClient;
import com.example.util.MyListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.time.LocalDate.now;

public class MainActivity extends AppCompatActivity {

    GridView gvPhim;
    PhimAdapter phimAdapter;
    MyListView lvBaiViet;
    BaiVietAdapter baiVietAdapter;
    ImageView imgLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
        addPhim();
        addBaiViet();
    }

    private void addControls() {
        gvPhim = findViewById(R.id.gvPhimHotMain);
        phimAdapter = new PhimAdapter(this, R.layout.phim_hot_item_main);
        gvPhim.setAdapter(phimAdapter);

        lvBaiViet = findViewById(R.id.lvBaiVietHotMain);
        baiVietAdapter = new BaiVietAdapter(this, R.layout.bai_viet_item);
        lvBaiViet.setAdapter(baiVietAdapter);

        imgLogin = findViewById(R.id.imgLoginToolbar);
    }

    private void addEvents() {
        gvPhim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, PhimDetailActivity.class);
                Phim phim = phimAdapter.getItem(position);
                intent.putExtra("Phim", phim);
                startActivity(intent);
            }
        });

        lvBaiViet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, BaiVietActivityDetail.class);
                BaiViet baiViet = baiVietAdapter.getItem(position);
                intent.putExtra("BaiViet", baiViet);
                startActivity(intent);
            }
        });

        imgLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }

    private void addPhim() {
        DataClient dataClient = APIUtils.getData();
        Call<List<Phim>> callback = dataClient.getPhimHot();
        callback.enqueue(new Callback<List<Phim>>() {
            @Override
            public void onResponse(Call<List<Phim>> call, Response<List<Phim>> response) {
                for (int i = 0; i < 6; i++){
                    phimAdapter.add(response.body().get(i));
                }
            }
            @Override
            public void onFailure(Call<List<Phim>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addBaiViet() {
        DataClient dataClient = APIUtils.getData();
        Call<List<BaiViet>> callback = dataClient.getBaiViet();
        callback.enqueue(new Callback<List<BaiViet>>() {
            @Override
            public void onResponse(Call<List<BaiViet>> call, Response<List<BaiViet>> response) {
                for (int i = 0; i < response.body().size(); i++){
                    baiVietAdapter.add(response.body().get(i));
                }
            }

            @Override
            public void onFailure(Call<List<BaiViet>> call, Throwable t) {
                Log.e("QQQ", t.getMessage());
            }
        });
    }

    public void show5BaiViet(View view) {
        Toast.makeText(getApplicationContext(), "Xem thêm", Toast.LENGTH_LONG).show();
    }

    public void openPhimActivity(View view) {
        startActivity(new Intent(this, PhimActivity.class));
    }
}
