package com.example.bookingmedicalexaminatation.view.more;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingmedicalexaminatation.databinding.ActivitySecurityPolicyBinding;

public class SecurityPolicyActivity extends AppCompatActivity {
    private ActivitySecurityPolicyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecurityPolicyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initAction();
    }

    private void initAction() {
        binding.securityPolicyView.titleView.back.setOnClickListener(view -> finish());
    }

    private void initView() {
        binding.securityPolicyView.titleView.title.setText("Chính xách bảo mật");
        binding.securityPolicyView.contentText.setText("- Trang web của chúng tôi coi trọng việc bảo mật thông tin và sử dụng các biện pháp tốt nhất bảo vệ thông tin và việc thanh toán của quý khách. Thông tin của quý khách trong quá trình thanh toán sẽ được mã hóa để đảm bảo an toàn. Sau khi quý khách hoàn thành quá trình đặt hàng, quý khách sẽ thoát khỏi chế độ an toàn.\n" +
                "\n" +
                "- Quý khách không được sử dụng bất kỳ chương trình, công cụ hay hình thức nào khác để can thiệp vào hệ thống hay làm thay đổi cấu trúc dữ liệu. Trang web cũng nghiêm cấm việc phát tán, truyền bá hay cổ vũ cho bất kỳ hoạt động nào nhằm can thiệp, phá hoại hay xâm nhập vào dữ liệu của hệ thống. Cá nhân hay tổ chức vi phạm sẽ bị tước bỏ mọi quyền lợi cũng như sẽ bị truy tố trước pháp luật nếu cần thiết.\n" +
                "\n" +
                "- Mọi thông tin giao dịch sẽ được bảo mật nhưng trong trường hợp cơ quan pháp luật yêu cầu, chúng tôi sẽ buộc phải cung cấp những thông tin này cho các cơ quan pháp luật.");
    }
}