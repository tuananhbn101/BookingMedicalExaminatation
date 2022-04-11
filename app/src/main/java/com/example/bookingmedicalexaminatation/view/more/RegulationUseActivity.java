package com.example.bookingmedicalexaminatation.view.more;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingmedicalexaminatation.databinding.ActivityRegulationUseBinding;

public class RegulationUseActivity extends AppCompatActivity {
    private ActivityRegulationUseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegulationUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initAction();
    }

    private void initAction() {
        binding.regulationView.titleView.back.setOnClickListener(view -> finish());
    }

    private void initView() {
        binding.regulationView.titleView.title.setText("Hướng dẫn sử dụng");
        binding.regulationView.contentText.setText("Chúng tôi, Công ty CP Công nghệ BookingCare, đơn vị sở hữu và vận hành “Nền tảng Y tế Chăm sóc sức khỏe toàn diện BookingCare” bao gồm hệ thống website và các ứng dụng di động. BookingCare cung cấp nền tảng công nghệ để bệnh nhân thuận tiện trong việc đặt lịch dịch vụ y tế với bác sĩ và cơ sở y tế. Bằng việc truy cập hoặc sử dụng dịch vụ của BookingCare, bạn hoàn toàn đồng ý theo các điều khoản, điều kiện dưới đây.\n" +
                "\n" +
                "Chúng tôi duy trì quyền thay đổi hoặc điều chỉnh bất kỳ điều khoản và điều kiện nào dưới đây. Mọi sửa đổi nếu có sẽ có hiệu lực ngay lập tức sau khi đăng tải trên hệ thống trang này.\n" +
                "\n" +
                "SỬ DỤNG BOOKINGCARE\n" +
                "\n" +
                "Thông tin người cung cấp dịch vụ “Khám chữa bệnh”\n" +
                "\n" +
                "Hệ thống BookingCare đăng tải thông tin và lịch khám của bác sỹ, dịch vụ y tế và cơ sở y tế. Các thông tin về bác sĩ, dịch vụ y tế, cơ sở y tế (gọi chung là “Người cung cấp dịch vụ Khám chữa bệnh”) được cung cấp bởi chính “Người cung cấp dịch vụ Khám chữa bệnh” và các nguồn thông tin tin cậy khác do chúng tôi lựa chọn biên tập.\n" +
                "\n" +
                "Chúng tôi cố gắng tìm hiểu và lựa chọn thông tin chính xác để đăng tải trên hệ thống. Tuy nhiên, chúng tôi không đủ điều kiện xác minh sự chính xác tuyệt đối của thông tin đã đăng tải.\n" +
                "\n" +
                "Dịch vụ đặt lịch khám trực tuyến\n" +
                "\n" +
                "BookingCare cung cấp nền tảng công nghệ, phương tiện để kết nối bệnh nhân và bác sĩ, cơ sở y tế. Qua đó cung cấp dịch vụ đặt lịch khám trực tuyến.\n" +
                "\n" +
                "Bệnh nhân lựa chọn bác sĩ, dịch vụ hoặc cơ sở y tế phù hợp trên hệ thống BookingCare để đặt lịch khám. BookingCare không phải là người cung cấp dịch vụ y tế và cũng không đại diện cho bất kỳ “Người cung cấp dịch vụ khám chữa bệnh” nào. Vai trò duy nhất của chúng tôi là tạo ra các công cụ, phương tiện để cung cấp “dịch vụ đặt lịch khám trực tuyến”.\n" +
                "\n" +
                "Nhằm hỗ trợ việc đặt lịch khám hiệu quả cao, chúng tôi có thể kết nối thêm với người có nhu cầu đặt lịch thông qua ứng dụng (Apps),tin nhắn SMS, email, dịch vụ OTT và cuộc gọi thoại.\n" +
                "\n" +
                "Sai lệch thời gian & hủy lịch khám\n" +
                "\n" +
                "Lịch hẹn khám qua hệ thống BookingCare và thời gian khám thực tế có thể sai khác so với lịch hẹn ban đầu do đặc thù của hoạt động khám chữa bệnh. Chúng tôi cố gắng để giảm thiểu sự sai lệch về thời gian và giảm thiểu thời gian chờ đợi của người bệnh.\n" +
                "\n" +
                "Lịch hẹn khám có thể bị hủy hoặc thay đổi đột xuất vì một lý do nào đó, ví dụ như bác sĩ có công việc đột xuất. Việc này vẫn thỉnh thoảng xảy ra, nhất là với các bác sĩ, chuyên gia giỏi rất bận rộn. Chúng tôi sẽ thông báo sự thay đổi đó trong thời gian sớm nhất bằng một hoặc đồng thời các ứng dụng tin nhắn SMS, Push, email, dịch vụ OTT và cuộc gọi thoại.\n" +
                "\n" +
                "Tuy nhiên, vì một lý do nào đó, chẳng hạn như lỗi đường truyền hoặc sai lệch thông tin, bạn có thể không nhận được thông báo kịp thời. Trong trường hợp này, BookingCare mong nhận được thông tin từ người bệnh để chúng tôi có thể sắp xếp lịch khám bổ sung phù hợp với yêu cầu của bạn.\n" +
                "\n" +
                "Phí dịch vụ đặt lịch\n" +
                "\n" +
                "Thời điểm hiện tại, BookingCare cung cấp dịch vụ đặt lịch khám trực tuyến hoàn toàn miễn phí đối với người bệnh khi đặt lịch khám thông qua BookingCare.\n" +
                "\n" +
                "Trong một số trường hợp, bệnh nhân còn nhận được ưu đãi chi phí khám chữa bệnh khi đặt qua hệ thống.\n" +
                "\n" +
                "Chính sách hoàn trả chi phí dịch vụ \"Bác sĩ từ xa\"\n" +
                "\n" +
                "1.Trường hợp bác sĩ từ chối nhận khám (tình trạng bệnh không phù hợp khám từ xa/ không đúng chuyên môn của bác sĩ): Bệnh nhân được hoàn 100% chi phí.\n" +
                "\n" +
                "2. Trường hợp bệnh nhân chủ động yêu cầu hủy lịch:\n" +
                "\n" +
                "Yêu cầu hủy lịch<1 giờ trước giờ hẹn: Phí hủy lịch là 50%");
    }
}