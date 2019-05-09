package com.example.phephim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.adapter.BaiVietAdapter;
import com.example.adapter.PhimAdapter;
import com.example.model.BaiViet;
import com.example.model.Phim;
import com.example.util.MyListView;

import static java.time.LocalDate.now;

public class MainActivity extends AppCompatActivity {

    GridView gvPhim;
    PhimAdapter phimAdapter;
    MyListView lvBaiViet;
    BaiVietAdapter baiVietAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
        addData();
    }

    private void addControls() {
        gvPhim = findViewById(R.id.gvPhimHotMain);
        phimAdapter = new PhimAdapter(this, R.layout.phim_hot_item_main);
        gvPhim.setAdapter(phimAdapter);

        lvBaiViet = findViewById(R.id.lvBaiVietHotMain);
        baiVietAdapter = new BaiVietAdapter(this, R.layout.bai_viet_item);
        lvBaiViet.setAdapter(baiVietAdapter);
    }

    private void addEvents() {
        gvPhim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, PhimDetailActivity.class);
                startActivity(intent);
            }
        });

        lvBaiViet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, BaiVietActivityDetail.class);
                startActivity(intent);
            }
        });
    }

    private void addData() {
        phimAdapter.clear();
        phimAdapter.add(new Phim("Ma", "Ten", "Dao Dien", "Dien Vien", "Thoi Luong", "12/12/2019", 7.6f, "Hinh", "The Loai"));
        phimAdapter.add(new Phim("Ma", "Ten", "Dao Dien", "Dien Vien", "Thoi Luong", "12/12/2019", 8.6f, "Hinh", "The Loai"));
        phimAdapter.add(new Phim("Ma", "Ten", "Dao Dien", "Dien Vien", "Thoi Luong", "12/12/2019", 4.6f, "Hinh", "The Loai"));
        phimAdapter.add(new Phim("Ma", "Ten", "Dao Dien", "Dien Vien", "Thoi Luong", "12/12/2019", 5.6f, "Hinh", "The Loai"));
        phimAdapter.add(new Phim("Ma", "Ten", "Dao Dien", "Dien Vien", "Thoi Luong", "12/12/2019", 7.63f, "Hinh", "The Loai"));
        phimAdapter.add(new Phim("Ma", "Ten", "Dao Dien", "Dien Vien", "Thoi Luong", "12/12/2019", 8.6f, "Hinh", "The Loai"));

        baiVietAdapter.clear();
        baiVietAdapter.add(new BaiViet("Ma", "Tiêu đề bài viết số 1 Tiêu đề bài viết số 1 Tiêu đề bài viết số 1 ", "Noi Dung", "12/12/2019", 11, "Thể loại", "Lê Quốc Hưng"));
        baiVietAdapter.add(new BaiViet("Ma", "Tiêu đề bài viết số 2 Tiêu đề bài viết số 1", "Noi Dung", "12/12/2019", 9, "Thể loại", "Lê Quốc Hưng"));
        baiVietAdapter.add(new BaiViet("Ma", "Tiêu đề bài viết số 3", "Noi Dung", "12/12/2019", 8, "Thể loại", "Lê Quốc Hưng"));
        baiVietAdapter.add(new BaiViet("Ma", "Tiêu đề bài viết số 4", "Noi Dung", "12/12/2019", 7, "Thể loại", "Lê Quốc Hưng"));
        baiVietAdapter.add(new BaiViet("Ma", "Tiêu đề bài viết số 5", "Noi Dung", "12/12/2019", 6, "Thể loại", "Lê Quốc Hưng"));
    }

    public void show5BaiViet(View view) {
        Toast.makeText(MainActivity.this, "Clicked: " + lvBaiViet.getHeight(), Toast.LENGTH_LONG).show();

        lvBaiViet.setMinimumHeight(lvBaiViet.getHeight() + lvBaiViet.getHeight());

        baiVietAdapter.add(new BaiViet("Ma", "Tiêu đề bài viết số 1 Tiêu đề bài viết số 1 Tiêu đề bài viết số 1 ", "Noi Dung", "12/12/2019", 11, "Thể loại", "Lê Quốc Hưng"));
        baiVietAdapter.add(new BaiViet("Ma", "Tiêu đề bài viết số 2 Tiêu đề bài viết số 1", "Noi Dung", "12/12/2019", 9, "Thể loại", "Lê Quốc Hưng"));
        baiVietAdapter.add(new BaiViet("Ma", "Tiêu đề bài viết số 3", "Noi Dung", "12/12/2019", 8, "Thể loại", "Lê Quốc Hưng"));
        baiVietAdapter.add(new BaiViet("Ma", "Tiêu đề bài viết số 4", "Noi Dung", "12/12/2019", 7, "Thể loại", "Lê Quốc Hưng"));
        baiVietAdapter.add(new BaiViet("Ma", "Tiêu đề bài viết số 5", "Noi Dung", "12/12/2019", 6, "Thể loại", "Lê Quốc Hưng"));
    }
}
