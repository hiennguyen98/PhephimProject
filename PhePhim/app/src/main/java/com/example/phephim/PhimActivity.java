package com.example.phephim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.PhimAdapter;
import com.example.model.Phim;
import com.example.service.APIUtils;
import com.example.service.DataClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhimActivity extends AppCompatActivity {

    GridView gvPhim;
    PhimAdapter phimAdapter;
    EditText edtSearch;
    TextView txtNotFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phim);

        addControls();
        addEvents();
        getData();
    }

    private void addControls() {
        gvPhim = findViewById(R.id.gvPhim);
        phimAdapter = new PhimAdapter(this, R.layout.phim_hot_item_main);
        gvPhim.setAdapter(phimAdapter);

        edtSearch = findViewById(R.id.edtSearchPhim);

        txtNotFound = findViewById(R.id.txtNotFoundPhim);
    }

    private void addEvents() {
        gvPhim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), PhimDetailActivity.class);
                Phim phim = phimAdapter.getItem(position);
                intent.putExtra("Phim", phim);
                startActivity(intent);
            }
        });

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count > 0) {
                    getSearchResult(edtSearch.getText().toString().trim());
                }
                else {
                    getData();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void getSearchResult(String tenPhim) {
        DataClient dataClient = APIUtils.getData();
        Call<List<Phim>> call = dataClient.searchPhim(tenPhim);
        call.enqueue(new Callback<List<Phim>>() {
            @Override
            public void onResponse(Call<List<Phim>> call, Response<List<Phim>> response) {
                phimAdapter.clear();
                txtNotFound.setText("");
                for(int i = 0; i < response.body().size(); i++) {
                    phimAdapter.add(response.body().get(i));
                }
                Log.e("QQQ", response.body().size()+" - " + response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Phim>> call, Throwable t) {
                Log.e("QQQ", t.getMessage());
                phimAdapter.clear();
                txtNotFound.setText("Không tìm thấy kết quả nào phù hợp với từ khóa của bạn.");
            }
        });
    }

    private void getData() {
        DataClient dataClient = APIUtils.getData();
        Call<List<Phim>> callback = dataClient.getPhimHot();
        callback.enqueue(new Callback<List<Phim>>() {
            @Override
            public void onResponse(Call<List<Phim>> call, Response<List<Phim>> response) {
                phimAdapter.clear();
                for (int i = 0; i < response.body().size(); i++){
                    phimAdapter.add(response.body().get(i));
                }
            }
            @Override
            public void onFailure(Call<List<Phim>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
