package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.BaiViet;
import com.example.phephim.R;

public class BaiVietAdapter extends ArrayAdapter<BaiViet> {
    Activity context;
    int resource;
    TextView txtTieuDe, txtTacGia, txtNgay, txtDiem;
    ImageView imgHinh;

    public BaiVietAdapter(Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View mView = this.context.getLayoutInflater().inflate(this.resource, null);

        txtTacGia = mView.findViewById(R.id.txtTacGiaBaiVietItem);
        txtDiem = mView.findViewById(R.id.txtDiemBaiVietItem);
        txtNgay = mView.findViewById(R.id.txtNgayBaiVietItem);
        txtTieuDe = mView.findViewById(R.id.txtTieuDeBaiVietItem);

        BaiViet baiViet = getItem(position);

        txtTieuDe.setText(baiViet.getTieuDe());
        txtNgay.setText(baiViet.getNgayDang());
        txtDiem.setText(baiViet.getDiemDanhGia() + " điểm");
        txtTacGia.setText(baiViet.getTacGia());

        return mView;
    }
}
