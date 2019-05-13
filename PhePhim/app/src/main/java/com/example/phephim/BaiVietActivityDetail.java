package com.example.phephim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.adapter.BinhLuanBaiVietAdapter;
import com.example.model.BaiViet;
import com.example.model.BinhLuanBaiViet;
import com.example.util.MyListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BaiVietActivityDetail extends AppCompatActivity {

    Spinner spinnerSapXep;
    MyListView lvBinhLuan;
    BinhLuanBaiVietAdapter adapter;
    TextView txtTieuDe, txtTacGia, txtNgay, txtNoiDung, txtDiem, txtSoBinhLuan;
    ImageView imgTacGia, imgAnh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_viet_detail);

        addControl();
        setData();
        setupSpinner();
        addBinhLuan();
    }

    private void addBinhLuan() {
        adapter.add(new BinhLuanBaiViet("Ronaldo", "21/12/2019",
                "Nếu chỉ tính trong phạm vi các bộ phim SAH thì mình yêu thích khá nhiều nhân vật phản diện như Joker, Doctor Octopus, Magneto, General Zod .... nhưng nhân vật mà để mình đồng cảm nhất thì có lẽ là General Zod. Xét cho cùng thì khi rơi vào hoàn cảnh của những phản diện khác  thì bản thân mình vẫn có thể hành động khác do mục tiêu của các phản diện khác thường nằm một trong hai lý do sau: 1 - hoàn thành tâm nguyện của 1 ai đó/ của bản thân một cách cực đoan; 2 - trả thù một người/ một nhóm người/ cả xã hội, thứ đã biến hắn thành kẻ ác như vậy. Với các mục đích như vậy, đôi khi con người ta có thể lựa chọn tha thứ hoặc từ bỏ, tức là với cùng một hoàn cảnh đó xảy ra với mười người thì không chắc rằng cả 10 người đó đều sẽ trở thành kẻ xấu. \n" +
                        "Nhưng với General Zod thì khác, hắn đôi khi không còn lựa chọn. Đương nhiên cách xử lý của hắn khá tàn bạo và cực đoan nhưng nên nhớ hắn là một tướng quân trong quân đội, còn con người thì không phải cùng chủng loại đối với hắn.  Như hắn ta đã nói : \"ta tồn tại chỉ để bảo vệ krypton, ta sinh ra đã được định sẵn mục đích như vậy. Mọi hành động ta làm, dù có tàn bạo thế nào, dù có độc ác ra sao thì đều vì mục đích tốt hơn cho chủng tộc của ta\". Thật vậy, nhìn lại cuộc đời của hắn, hắn sinh ra mà không được lựa chọn mình là ai, tương lai mình sẽ làm gì, hắn sinh ra với một sứ mệnh được định sẵn: bảo vệ Krypton. Nhưng trớ trêu thay, những lãnh đạo của dân tộc hắn bỏ ngoài tai những lời cảnh báo của các nhà khoa học về tác hại của việc khai thác lõi Krypton sẽ khiến cho hành tinh bị nổ tung => Để cứu dân tộc mình, cách duy nhất hắn có thể làm là đảo chính. Hắn cũng chưa từng muốn giết Jor-el cho đến khi ông trộm cổ bản - cơ sở để xây dựng lại Krypton đi mất (ngoài ra còn vì lý do dị giáo). Khi Krypton bị hủy diệt, dân tộc hắn chỉ còn những người bị lưu đày giống hắn + superman => hắn phải đi tìm cổ bản để tái thiết Krypton. \n" +
                        "Và có lẽ ấn tượng nhất với mình ở nhân vật này là ở 2 phân cảnh. Phân cảnh thứ nhất là khi superman lao vào, định phá hủy con tàu cuối cùng chứa những bào thai Krypton, là nơi sẽ nhân dữ liệu từ cổ bản để tạo ra người Krypton thì lần đầu tiên trong phim hắn hét lên van xin đầy hoảng sợ (trong cả phim, hắn chưa từng van xin ai, kể xả khi bị xử tội lưu đầy): \"If you destroy this ship, YOU DESTROY KRYPTON!\" - Superman thì đứng trước quyết định chọn dân tộc mình hoặc loài người, anh đáp lại : “KRYPTON HAD ITS CHANCE”rồi hủy diệt con tàu => Lúc này với Zod, Krypton đã không thể khôi phục lại được nữa. Phân cảnh thứ hai, khi toàn bộ quân của hắn, những người Krypton cuối cùng bị hút vào lỗ đen, hắn và superman đối mặt - hi vọng xây dựng lại Krypton bị sụp đổ trong chốc lát, thế hệ mới không thể sinh ra từ cổ bản, những người bên cạnh cũng bị chết/ bị hố đen hút hết. => Lúc này chỉ còn lại 2 người Krypton cuối cùng lại phải đánh đến sống còn: \"There is only one way this ends, Kal: either you die or I do.\". Ở đoạn này mình cũng rất ấn tượng với những câu thoại của General Zod, những câu thoại đã thể hiện rõ hắn là con người như thế nào: \"Look at this. We could have built a new Krypton in this squalor, but you choose the humans over us. I exist only to protect Krypton. That is the sole purpose for which I was born, and every action I take, no matter how violent or how cruel, is for the greater good of my people. And now, I have no people.  My soul–that is what you have taken from me!\".\n" +
                        "Nói tóm lại thì General Zod là một phản diện yêu thích của mình và MoS cũng là một bộ phim ưa thích của mình vì những giá trị mang tính biểu tượng mà nó mang lại hơn là logic trong phim. Phim bị chỉ trích vì phân đoạn Krypton quá dài, vì phân đoạn cơn lôc, vì cái vặn cổ của superman và vì.. Lois Lane nặng đến nỗi hố đen cũng không hút nổi cô <(\") nhưng theo mình đa phần các chi tiết đều có thể chấp nhận được, chúng mang tính biểu tượng về mặt trưởng thành, đối mặt với thực tại, về sự tái sinh nhiều hơn là về logic. Xem xong phim và bộ 3 batman chỉ càng thấy tiêc nuối khi phim của DC đã từng tốt như thế nào.",
                "Chưa có", 17));
        adapter.add(new BinhLuanBaiViet("Lê Quốc Hưng", "21/12/2019",
                "Tôi thích khá nhiều nhân vật phản diện, trong các phim siêu anh hùng thì thậm chí đôi khi còn thích hơn cả anh hùng, nên tôi cũng thích các sản phẩm về Anti-hero nữa. Còn về tại sao thì khá là dài mà chắc nhiều người hiểu (riêng vụ này các bác nên kiếm video bàn luận của Samurice mà coi). Tuy nhiên là, đồng cảm với nhân vật phản diện thì thôi, ko có đâu, vì tôi đâu có bá đạo như họ, đồng cảm làm sao được?",
                "Chưa có", 17));
        adapter.add(new BinhLuanBaiViet("Nguyễn Quang Hiền", "21/12/2019",
                "bài viết rất hay, cảm ơn thớt đã chia sẻ \uD83D\uDC4D",
                "Chưa có", 17));
    }

    private void addControl() {
        lvBinhLuan = findViewById(R.id.lvBinhLuanBV);
        adapter = new BinhLuanBaiVietAdapter(BaiVietActivityDetail.this, R.layout.binh_luan_bai_viet_item);
        lvBinhLuan.setAdapter(adapter);

        txtTieuDe = findViewById(R.id.txtTieuDeBVDetail);
        txtTacGia = findViewById(R.id.txtTacGiaBV);
        txtNgay = findViewById(R.id.txtNgayDangBV);
        txtNoiDung = findViewById(R.id.txtNoiDungBV);
        txtDiem = findViewById(R.id.txtDiemBaiVietDetail);
        txtSoBinhLuan = findViewById(R.id.txtSoBLBV);

        imgTacGia = findViewById(R.id.imgTacGiaBV);
        imgAnh = findViewById(R.id.imgAnhBV);
    }

    private void setData() {
        Intent intent = getIntent();
        BaiViet baiViet = (BaiViet) intent.getSerializableExtra("BaiViet");

        txtTieuDe.setText(baiViet.getTieuDe());
        txtTacGia.setText(baiViet.getTacGia());
        txtNgay.setText(baiViet.getNgay());
        txtNoiDung.setText(baiViet.getNoiDung());
        txtDiem.setText(baiViet.getDiem() + "");
        txtSoBinhLuan.setText("3 Bình luận");

        Picasso.get()
                .load(baiViet.getAvatar())
                .placeholder(android.R.drawable.ic_menu_report_image)
                .error(android.R.drawable.ic_menu_report_image)
                .into(imgTacGia);
        if(baiViet.getAnh() != null) {
            Picasso.get()
                    .load(baiViet.getAnh())
                    .placeholder(android.R.drawable.ic_menu_report_image)
                    .error(android.R.drawable.ic_menu_report_image)
                    .into(imgAnh);
        }
    }

    private void setupSpinner() {
        spinnerSapXep = findViewById(R.id.spinnerBLBV);

        List<String> list = new ArrayList<>();
        list.add("Hay nhất");
        list.add("Mới nhất");

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter(this, R.layout.spinner_item,list);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSapXep.setAdapter(adapterSpinner);
    }
}
