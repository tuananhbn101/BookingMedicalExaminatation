package com.example.bookingmedicalexaminatation.view.more.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingmedicalexaminatation.databinding.ActivityIntroduceBinding;

public class IntroduceActivity extends AppCompatActivity {
    private ActivityIntroduceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroduceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initAction();
    }

    private void initAction() {
        binding.introduceView.titleView.back.setOnClickListener(view -> finish());
    }

    private void initView() {
        binding.introduceView.titleView.title.setText("Thông tin");
        binding.introduceView.contentText.setText(" Là ứng dụng hỗ trợ cho bạn tìm kiếm bác sĩ, đặt lịch hẹn khám online trên điện thoại di động. Bằng ứng dụng này, bạn có thể tìm kiếm bác sĩ theo chuyên khoa, hẹn địa điểm, thời gian và tiến hành đặt lịch hẹn khám từ xa qua hình thức video call trên điện thoại di động. Sau khi khám xong, Well care sẽ nhanh chóng trả kết quả qua thông báo của ứng dụng, cùng với đó là đơn thuốc và lời dặn dò của bác sĩ. Thuốc sẽ nhanh chóng được giao đến trong vòng 2 giờ đối với khu vực TP Hải Phòng và 48 giờ đối với các tỉnh khác.\n" +
                "\n" +
                "Hospital - Khám bệnh từ xa\n" +
                "\n" +
                "Hospital - Khám bệnh từ xa\n" +
                "\n" +
                "Đặc điểm nổi bật:\n" +
                "\n" +
                "Khám bệnh trực tiếp bằng video call\n" +
                "Tự do chọn bác sĩ theo chuyên khoa, theo tên, theo thông tin\n" +
                "Liên hệ với bác sĩ bằng cách nhắn tin, gọi thoại\n" +
                "Theo dõi sức khỏe cá nhân trực tiếp trên ứng dụng\n" +
                "Kê đơn và giao thuốc tận nhà");
    }

}