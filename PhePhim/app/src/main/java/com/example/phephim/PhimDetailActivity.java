package com.example.phephim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.adapter.BinhLuanPhimAdapter;
import com.example.model.BinhLuanPhim;
import com.example.util.MyListView;

import java.util.ArrayList;
import java.util.List;

public class PhimDetailActivity extends AppCompatActivity {

    Spinner spinnerSapXep;
    MyListView lvBinhLuan;
    BinhLuanPhimAdapter adapterBL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phim_detail);

        EditSpinner();

        lvBinhLuan = findViewById(R.id.lvBinhLuanPhimDetail);
        adapterBL = new BinhLuanPhimAdapter(PhimDetailActivity.this, R.layout.binh_luan_phim_item);

        adapterBL.add(new BinhLuanPhim("Lê Quốc Hưng", 10,
                "Đây vừa là bộ phim Người Nhện hay nhất từ trước đến giờ mình từng được xem, vừa là một trong những phim siêu anh hùng nói chung xuất sắc nhất được làm ra. Thêm vào đó, phần hình ảnh và âm thanh của Spiderverse đã đẩy phim lên 1 tầm cao mới. Nhất định mình sẽ xem lại lúc high khi có bản đẹp.",
                "12/12/2019", 13, "Chưa có"));
        adapterBL.add(new BinhLuanPhim("Nguyễn Quang Hiền", 7,
                "Phong cách đồ hoạ mang đậm chất comic cực kì ấn tượng, với dots & stripes rất phong cách, cảm giác như đang đọc một cuốn comic có hình ảnh chuyển động và âm thanh vậy. Tuy nội dung vẫn chưa thực sự đột phá, vẫn là một kịch bản siêu anh hùng thường thấy, nhưng nhờ kết hợp yếu tố đa vũ trụ cộng với cách thể hiện quirky đầy dí dỏm, bộ phim đã cho mình một trải nghiệm xem phim vô cùng thú vị",
                "21/9/2019", 7, "Chưa có"));
        adapterBL.add(new BinhLuanPhim("Nguyễn Tiến Đạt", 9,
                "Bộ phim không có điểm nào để chê cả =))",
                "12/10/2019", 3, "Chưa có" ));


        lvBinhLuan.setAdapter(adapterBL);
    }

    private void EditSpinner() {
        spinnerSapXep = findViewById(R.id.spinnerSapXepDetail);

        List<String> list = new ArrayList<>();
        list.add("Hay nhất");
        list.add("Mới nhất");

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter(this, R.layout.spinner_item,list);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSapXep.setAdapter(adapterSpinner);
    }
}
