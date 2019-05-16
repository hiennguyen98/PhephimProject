package com.example.phephim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.adapter.PhimAdapter;
import com.example.model.Phim;
import com.example.service.APIUtils;
import com.example.service.DataClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhimActivity extends AppCompatActivity {

    GridView gvPhim;
    PhimAdapter phimAdapter;
    EditText edtSearch;
    TextView txtNotFound;
    Spinner spTheLoai;
    List<Phim> phimList = new ArrayList<>();
    List<String> theLoaiList = new ArrayList<>();
    int maTheLoai = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phim);

        addControls();
        addEvents();
        getSearchResult(edtSearch.getText().toString(), maTheLoai);
        setupSpinnerData();
    }

    private void addControls() {
        gvPhim = findViewById(R.id.gvPhim);
        phimAdapter = new PhimAdapter(this, R.layout.phim_hot_item_main);
        gvPhim.setAdapter(phimAdapter);

        edtSearch = findViewById(R.id.edtSearchPhim);
        txtNotFound = findViewById(R.id.txtNotFoundPhim);
        spTheLoai = findViewById(R.id.spTheLoai);
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
                txtNotFound.setText("");
                if (edtSearch.getText().toString().equals("")) {
                    getSearchResult(edtSearch.getText().toString(), maTheLoai);
                } else {
                    getSearchResult(edtSearch.getText().toString(), maTheLoai);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        spTheLoai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maTheLoai = position;
                getSearchResult(edtSearch.getText().toString(), maTheLoai);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void getSearchResult(String tenPhim, int maTheLoai) {
        DataClient dataClient = APIUtils.getData();
        Call<List<Phim>> call = dataClient.searchPhim(tenPhim, maTheLoai);
        call.enqueue(new Callback<List<Phim>>() {
            @Override
            public void onResponse(Call<List<Phim>> call, Response<List<Phim>> response) {
                if(phimList != null) {
                    phimList.clear();
                }
                phimAdapter.clear();
                txtNotFound.setText("");
                for(int i = 0; i < response.body().size(); i++) {
                    phimAdapter.add(response.body().get(i));
                    phimList.add(response.body().get(i));
                }
                Log.e("QQQ", response.body().size()+" - " + response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Phim>> call, Throwable t) {
                Log.e("QQQ", t.getMessage());
                if(!edtSearch.getText().toString().equals("")) {
                    phimAdapter.clear();
                    txtNotFound.setText("Không tìm thấy kết quả nào phù hợp với từ khóa của bạn.");
                }
            }
        });
    }

    private void setupSpinnerData() {
        theLoaiList.add("Tất cả");
        theLoaiList.add("Kinh dị");
        theLoaiList.add("Thần thoại");
        theLoaiList.add("Hành động");
        theLoaiList.add("Hài");
        theLoaiList.add("Viễn tưởng");
        theLoaiList.add("Lịch sử");
        theLoaiList.add("Âm nhạc");
        theLoaiList.add("Phiêu lưu");
        theLoaiList.add("Tình cảm");

        ArrayAdapter<String> adapterSpTheLoai = new ArrayAdapter(this, R.layout.spinner_item,theLoaiList);
        adapterSpTheLoai.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTheLoai.setAdapter(adapterSpTheLoai);
    }
}
