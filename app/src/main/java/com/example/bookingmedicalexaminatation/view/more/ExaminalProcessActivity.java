package com.example.bookingmedicalexaminatation.view.more;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingmedicalexaminatation.databinding.ActivityExaminalProcessBinding;

public class ExaminalProcessActivity extends AppCompatActivity {
    private ActivityExaminalProcessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExaminalProcessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initAction();
    }

    private void initAction() {
        binding.examinalProcessView.titleView.back.setOnClickListener(view -> finish());
    }

    private void initView() {
        binding.examinalProcessView.titleView.title.setText("Quy trình khám bệnh");
        binding.examinalProcessView.contentText.setText("1. Bước 1: Tiếp đón người bệnh\n" +
                "\n" +
                "1.1. Trách nhiệm của người bệnh\n" +
                "\n" +
                "– Lấy số thứ tự để làm thủ tục khám bệnh.\n" +
                "\n" +
                "– Xuất trình thẻ Bảo hiểm y tế (BHYT), giấy tờ tùy thân có ảnh, hồ sơ chuyển việnhoặc giấy hẹn tái khám.\n" +
                "\n" +
                "– Nhận phiếu khám bệnh và số thứ tự tại buồng khám.\n" +
                "\n" +
                "– Đối với những trường hợp vượt tuyến, trái tuyến, người bệnh có nguyện vọng khámbệnh, chữa bệnh theo yêu cầu thì người bệnh tạm ứng tiền khám bệnh, chữa bệnh.\n" +
                "\n" +
                "1.2. Trách nhiệm của bệnh viện\n" +
                "\n" +
                "– Bố trí các quầy để tiếp đón, kiểm tra thẻ BHYT và các giấy tờ liên quan.\n" +
                "\n" +
                "– Nhập thông tin của người bệnh vào máy vi tính, xác định buồng khám phù hợp, inphiếu khám bệnh và phát số thứ tự khám.\n" +
                "\n" +
                "– Giữ thẻ BHYT, hồ sơ chuyển viện và hẹn tái khám (và chuyển tập trung về bộ phậnthanh toán ra viện).\n" +
                "\n" +
                "– Thu tiền tạm ứng đối với những trường hợp người bệnh vượt tuyến, trái tuyến, ngườibệnh có nguyện vọng khám bệnh, chữa bệnh theo yêu cầu (theo quy định cụ thể củabệnh viện).\n" +
                "\n" +
                "2. Bước 2: Khám lâm sàng và chẩn đoán\n" +
                "\n" +
                "Tùy theo tình trạng bệnh, thầy thuốc có thể chỉ định xét nghiệm, chẩn đoán hình ảnh,thăm dò chức năng hoặc chẩn đoán xác định và kê đơn điều trị mà không cần chỉ địnhxét nghiệm cận lâm sàng.\n" +
                "\n" +
                "2.1. Khám lâm sàng, chẩn đoán và chỉ định điều trị\n" +
                "\n" +
                "2.1.1. Trách nhiệm của người bệnh\n" +
                "\n" +
                "– Chờ khám theo số thứ tự đã được ghi trên phiếu khám bệnh.\n" +
                "\n" +
                "– Vào khám khi được thông báo.\n" +
                "\n" +
                "2.1.2. Trách nhiệm của bệnh viện\n" +
                "\n" +
                "– Thông báo người bệnh vào khám theo số thứ tự.\n" +
                "\n" +
                "– Bố trí buồng khám lâm sàng, chuyên khoa,\n" +
                "\n" +
                "– Khám, ghi chép thông tin về tình trạng bệnh, chẩn đoán, chỉ định điều trị.\n" +
                "\n" +
                "– Kê đơn thuốc, in đơn thuốc (in 3 liên cho người bệnh, kế toán và khoa dược), in vàký phiếu thanh toán chi phí khám bệnh, chữa bệnh (mẫu 01/BV) và hướng dẫn ngườibệnh đến bộ phận thanh toán.\n" +
                "\n" +
                "– Nếu người bệnh phải nhập viện lưu theo dõi hoặc điều trị nội trú: Làm bệnh án lưu,nhập viện và tạm ứng viện phí.\n" +
                "\n" +
                "Phụ lục 1: Sơ đồ Quy trình khám lâm sàng và kê đơn điều trị.\n" +
                "\n" +
                "2.2. Khám lâm sàng, xét nghiệm, chẩn đoán và chỉ định điều trị\n" +
                "\n" +
                "2.2.1. Trách nhiệm của người bệnh\n" +
                "\n" +
                "– Chờ khám theo số thứ tự đã được ghi trên phiếu khám bệnh.\n" +
                "\n" +
                "– Vào khám khi được thông báo.\n" +
                "\n" +
                "– Nhận phiếu chỉ định xét nghiệm từ bác sĩ khám.\n" +
                "\n" +
                "– Đến nơi lấy mẫu xét nghiệm, nộp phiếu chỉ định xét nghiệm và chờ đến lượt.\n" +
                "\n" +
                "– Phối hợp với kỹ thuật viên xét nghiệm để lấy mẫu xét nghiệm.\n" +
                "\n" +
                "– Quay về buồng khám bệnh, chờ đến lượt.\n" +
                "\n" +
                "– Nhận chỉ định điều trị, đơn thuốc và về nơi làm thủ tục chi trả viện phí hoặc đồng chitrả bảo hiểm y tế.\n" +
                "\n" +
                "2.2.2. Trách nhiệm của bệnh viện\n" +
                "\n" +
                "a) Tại buồng khám bệnh\n" +
                "\n" +
                "– Thông báo người bệnh vào khám theo số thứ tự.\n" +
                "\n" +
                "– Khám lâm sàng, ghi chép thông tin về tình trạng bệnh, chỉ định xét nghiệm, in phiếu xétnghiệm.\n" +
                "\n" +
                "– Chỉ dẫn người bệnh đến địa điểm làm xét nghiệm theo chỉ định.\n" +
                "\n" +
                "b) Tại nơi lấy mẫu xét nghiệm\n" +
                "\n" +
                "– Bố trí đủ điểm lấy mẫu xét nghiệm phù hợp với lưu lượng người bệnh. Nơi lấy mẫuđược đặt tại khoa khám bệnh.\n" +
                "\n" +
                "– Nhận phiếu chỉ định từ người bệnh.\n" +
                "\n" +
                "– Hướng dẫn người bệnh chuẩn bị và lấy mẫu xét nghiệm.\n" +
                "\n" +
                "– Chuyển mẫu về khoa xét nghiệm.\n" +
                "\n" +
                "c) Tại khoa xét nghiệm\n" +
                "\n" +
                "– Thực hiện xét nghiệm.\n" +
                "\n" +
                "– Chuyển trả kết quả xét nghiệm cận lâm sàng về buồng khám nơi chỉ định.\n" +
                "\n" +
                "Phụ lục 2: Sơ đồ Quy trình khám lâm sàng có xét nghiệm.\n" +
                "\n" +
                "2.3. Khám lâm sàng, thực hiện kỹ thuật chẩn đoán hình ảnh, chẩn đoán bệnh và chỉđịnh điều trị\n" +
                "\n" +
                "2.3.1. Trách nhiệm của người bệnh\n" +
                "\n" +
                "– Chờ khám theo số thứ tự đã được ghi trên phiếu khám bệnh.\n" +
                "\n" +
                "– Vào khám khi được thông báo.\n" +
                "\n" +
                "– Nhận phiếu chỉ định kỹ thuật chẩn đoán hình ảnh từ bác sĩ khám.\n" +
                "\n" +
                "– Đến nơi làm kỹ thuật chẩn đoán hình ảnh, nộp phiếu chỉ định và chờ đến lượt.\n" +
                "\n" +
                "– Phối hợp theo chỉ dẫn của kỹ thuật viên chẩn đoán hình ảnh để thực hiện kỹ thuật.\n" +
                "\n" +
                "– Chờ nhận kết quả chẩn đoán hình ảnh, quay lại buồng khám và nộp kết quả chẩn đoán hình ảnh cho buồng khám, chờ bác sĩ khám chẩn đoán và chỉ định điều trị.\n" +
                "\n" +
                "– Nhận chỉ định điều trị hoặc đơn thuốc và về nơi làm thủ tục chi trả viện phí hoặc đồng chi trả bảo hiểm y tế.\n" +
                "\n" +
                "2.3.2. Trách nhiệm của bệnh viện\n" +
                "\n" +
                "a) Tại buồng khám bệnh\n" +
                "\n" +
                "– Thông báo người bệnh vào khám theo số thứ tự.\n" +
                "\n" +
                "– Khám lâm sàng, ghi chép thông tin về tình trạng bệnh, chỉ định kỹ thuật chẩn đoán hình ảnh và in phiếu chỉ định.\n" +
                "\n" +
                "– Chỉ dẫn người bệnh đến nơi thực hiện kỹ thuật chẩn đoán hình ảnh.\n" +
                "\n" +
                "– Bác sĩ xem kết quả, chẩn đoán và chỉ định điều trị, kê đơn.\n" +
                "\n" +
                "b) Tại nơi thực hiện kỹ thuật chẩn đoán hình ảnh\n" +
                "\n" +
                "– Nơi thực hiện kỹ thuật tốt nhất là được đặt tại khoa khám bệnh nhằm tạo thuận lợi cho người bệnh, giảm khoảng cách di chuyển và thuận tiện cho người bệnh. Trường hợp chưa thể bố trí được thì có sơ đồ hướng dẫn cụ thể cho người bệnh.\n" +
                "\n" +
                "– Kỹ thuật viên chẩn đoán hình ảnh nhận phiếu chỉ định từ người bệnh.\n" +
                "\n" +
                "– Hướng dẫn người bệnh chuẩn bị và phối hợp thực hiện kỹ thuật.\n" +
                "\n" +
                "– Trả kết quả chẩn đoán hình ảnh, kèm phim, ảnh (nếu có) cho người bệnh.\n" +
                "\n" +
                "* Khuyến khích các bệnh viện chuyển trả thẳng kết quả chẩn đoán hỉnh ảnh, phim, ảnh về buồng khám.\n" +
                "\n" +
                "Phụ lục 3: Sơ đồ Quy trình khám lâm sàng có xét nghiệm và chẩn đoán hình ảnh.\n" +
                "\n" +
                "2.4. Khám lâm sàng, thực hiện kỹ thuật thăm dò chức năng, chẩn đoán bệnh và chỉđịnh điều trị\n" +
                "\n" +
                "2.4.1. Trách nhiệm của người bệnh\n" +
                "\n" +
                "– Chờ khám theo số thứ tự đã được ghi trên phiếu khám bệnh.\n" +
                "\n" +
                "– Vào khám khi được thông báo.\n" +
                "\n" +
                "– Nhận phiếu chỉ định kỹ thuật thăm dò chức năng từ bác sĩ khám.\n" +
                "\n" +
                "– Đến nơi làm kỹ thuật thăm dò chức năng, nộp phiếu chỉ định và chờ đến lượt.\n" +
                "\n" +
                "– Phối hợp theo chỉ dẫn của bác sĩ, kỹ thuật viên để thực hiện kỹ thuật.\n" +
                "\n" +
                "– Chờ nhận kết quả thăm dò chức năng và quay lại buồng khám.\n" +
                "\n" +
                "– Nộp kết quả chẩn đoán hình ảnh cho buồng khám, chờ bác sĩ khám chẩn đoán và chỉ định điều trị.\n" +
                "\n" +
                "– Nhận chỉ định điều trị hoặc đơn thuốc và về nơi làm thủ tục chi trả viện phí hoặc đồng chi trả bảo hiểm y tế.\n" +
                "\n" +
                "2.4.2. Trách nhiệm của bệnh viện\n" +
                "\n" +
                "a) Tại buồng khám bệnh\n" +
                "\n" +
                "– Thông báo người bệnh vào khám theo số thứ tự.\n" +
                "\n" +
                "– Khám lâm sàng, ghi chép thông tin về tình trạng bệnh, chỉ định kỹ thuật thăm dò chức năng và in phiếu chỉ định.\n" +
                "\n" +
                "– Chỉ dẫn người bệnh đến nơi thực hiện kỹ thuật thăm dò chức năng.\n" +
                "\n" +
                "– Bác sĩ xem kết quả thăm dò chức năng, chẩn đoán, chỉ định điều trị, kê đơn.\n" +
                "\n" +
                "b) Tại nơi thực hiện kỹ thuật thăm dò chức năng\n" +
                "\n" +
                "– Nơi thực hiện kỹ thuật tốt nhất là được đặt tại khoa khám bệnh nhằm tạo thuận lợi cho người bệnh, giảm khoảng cách di chuyển và thuận tiện cho người bệnh. Trường hợp chưa thể bố trí được thì có sơ đồ hướng dẫn cụ thể cho người bệnh.\n" +
                "\n" +
                "– Bác sĩ, kỹ thuật viên thăm dò chức năng nhận phiếu chỉ định từ người bệnh.\n" +
                "\n" +
                "– Hướng dẫn người bệnh chuẩn bị và phối hợp thực hiện kỹ thuật.\n" +
                "\n" +
                "– Trả kết quả thăm dò chức năng, kèm phim, ảnh (nếu có) cho người bệnh.\n" +
                "\n" +
                "Phụ lục 4: Sơ đồ Quy trình khám lâm sàng có xét nghiệm, chẩn đoán hình ảnh và thămdò chức năng.\n" +
                "\n" +
                "2.5. Các trường hợp thực hiện khám lâm sàng và có chỉ định làm 1, 2 hoặc 3 kỹthuật cận lâm sàng phối hợp (xét nghiệm, chẩn đoán hình ảnh, thăm dò chức năng),thực hiện kỹ thuật hoặc chuyển khám chuyên khoa\n" +
                "\n" +
                "Người bệnh và bệnh viện phải thực hiện theo trình tự các bước như trên, đồng thời,bác sĩ khoa khám bệnh hoặc nhân viên tại buồng khám phải hướng dẫn cụ thể trình tựlàm các kỹ thuật cận lâm sàng phù hợp. Sau khi có đủ kết quả cận lâm sàng thì ngườibệnh quay lại buồng khám, nộp kết quả cho bác sĩ khám và bác sĩ xem xét kết quả,chẩn đoán và chỉ định, kê đơn điều trị. Trưởng hợp thực hiện dịch vụ kỹ thuât hoặccần khám chuyên khoa khác, người bệnh được làm dịch vụ kỹ thuật hoặc khám chuyênkhoa theo yêu cầu chuyên môn.\n" +
                "\n" +
                "Người bệnh nhận chỉ định điều trị, đơn thuốc và về nơi làm thủ tục chi trả viện phí hoặcđồng chi trả bảo hiểm y tế.\n" +
                "\n" +
                "3. Bước 3: Thanh toán viện phí\n" +
                "\n" +
                "3.1. Trách nhiệm của người bệnh\n" +
                "\n" +
                "* Người bệnh có bảo hiểm y tế\n" +
                "\n" +
                "– Nộp phiếu thanh toán (mẫu 01/BV).\n" +
                "\n" +
                "– Xếp hàng chờ đến lượt thanh toán.\n" +
                "\n" +
                "– Nộp tiền cùng chi trả và nhận lại thẻ BHYT.\n" +
                "\n" +
                "* Người bệnh không có bảo hiểm y tế nộp viện phí theo quy định.\n" +
                "\n" +
                "3.2. Trách nhiệm của bệnh viện\n" +
                "\n" +
                "– Kiểm tra nội dung thống kê trong mẫu 01/BV, ký xác nhận.\n" +
                "\n" +
                "– Thu tiền thanh toán.\n" +
                "\n" +
                "4. Bước 4: Phát và lĩnh thuốc\n" +
                "\n" +
                "4.1. Trách nhiệm của người bệnh\n" +
                "\n" +
                "– Nộp đơn thuốc tại quầy phát thuốc.\n" +
                "\n" +
                "– Kiểm tra, so sánh thuốc trong đơn và thuốc đã nhận.\n" +
                "\n" +
                "– Nhận đơn thuốc, thuốc và ký nhận.\n" +
                "\n" +
                "4.2. Trách nhiệm của bệnh viện\n" +
                "\n" +
                "– Kiểm tra đơn thuốc, phát thuốc.\n" +
                "\n" +
                "– Tư vấn người bệnh về đơn thuốc và thuốc đã cấp.\n" +
                "\n" +
                "IV. CÁC GIẢI PHÁP CẢI TIẾN QUY TRÌNH KHÁM BỆNH TẠI BỆNH VIỆN\n" +
                "\n" +
                "Tùy theo điều kiện thực tế, bệnh viện lựa chọn 1 hoặc nhiều giải pháp cải tiến như sau:\n" +
                "\n" +
                "1. Các giải pháp tổng thể của bệnh viện\n" +
                "\n" +
                "1.1. Cải tạo cơ sở hạ tầng khoa khám bệnh\n" +
                "\n" +
                "Bố trí mặt bằng đủ rộng, tăng số lượng bàn khám bệnh, tăng ô làm thủ tục, mở rộngnơi tiếp đón, nơi chờ, sắp xếp khoa khám bệnh liên hoàn, số điểm lấy bệnh phẩm, nơithực hiện kỹ thuật chẩn đoán hình ảnh, thăm dò chức năng, thu viện phí, giải quyết thủtục bảo hiểm y tế đáp ứng lưu lượng người bệnh đến khám tại bệnh viện. Tổ chứcnhiều điểm hướng dẫn người bệnh đến khám làm thủ tục và khám bệnh theo đúng quytrình.\n" +
                "\n" +
                "1.2. Tăng cường ứng dụng công nghệ thông tin\n" +
                "\n" +
                "– Kết nối mạng giữa khoa khám bệnh, xét nghiệm, khoa dược, thu viện phí, lãnh đạobệnh viện và các bộ phận có liên quan giúp giảm thời gian chờ, tăng cường quản lý,giảm sai sót, nhầm lẫn, nâng cao chất lượng khám, chữa bệnh, giảm nhân lực trực tiếp tham gia quy trình khám bệnh.\n" +
                "\n" +
                "– Ứng dụng một số phần mềm hỗ trợ cho thầy thuốc nhằm nâng cao chất lượng chẩnđoán, kê đơn và điều trị.\n" +
                "\n" +
                "– Áp dụng mã vạch, thẻ từ trong việc xác định người bệnh, tránh nhầm lẫn, sai sót vàthuận tiện trong việc trao đổi thông tin về người bệnh giữa các khoa, phòng, bộ phậntrong bệnh viện.\n" +
                "\n" +
                "1.3. Nhân lực đủ và có chất lượng\n" +
                "\n" +
                "– Tăng cường nhân lực làm việc tại các khâu tiếp đón, khám bệnh, lấy mẫu xét nghiệm,thực hiện kỹ thuật, thu viện phí, thủ tục BHYT, cấp phát thuốc;\n" +
                "\n" +
                "– Nhân viên được huấn luyện nắm vững chuyên môn, thái độ giao tiếp ứng xử phù hợp vàthân thiện.\n" +
                "\n" +
                "1.4. Bổ sung các trang thiết bị cần thiết tại khoa khám bệnh\n" +
                "\n" +
                "Tăng cường các thiết bị bổ sung bao gồm cả thiết bị chẩn đoán hình ảnh, xét nghiệm,thăm dò chức năng để phục vụ người bệnh ngay tại khoa khám bệnh.\n" +
                "\n" +
                "1.5. Xây dựng phương án đáp ứng linh hoạt khi lưu lượng người bệnh tăng độtbiến.\n" +
                "\n" +
                "2. Các giải pháp cải tiến cụ thể tại các bộ phận tham gia quy trình khám bệnh\n" +
                "Ngoài các giải pháp lớn mang tính tổng thể như trên, bệnh viện cần nghiên cứu áp dụngmột số giải pháp sau:\n" +
                "\n" +
                "2.1. Tiếp đón người bệnh\n" +
                "\n" +
                "– Khuyến khích sử dụng máy phát số tự động.\n" +
                "\n" +
                "– Bệnh viện không để người bệnh tự photo giấy tờ tùy thân, thẻ bảo hiểm y tế, giấychuyển viện, … . Nếu có nhu cầu, bệnh viện tự thực hiện (áp dụng cho bệnh viện đã thuviện phí theo khung giá mới).\n" +
                "\n" +
                "– Bố trí đủ quầy tiếp đón với sự phối hợp giữa bộ phận tiếp đón, thu viện phí và hướngdẫn thủ tục bảo hiểm y tế.\n" +
                "\n" +
                "– Bố trí đủ bàn và người hướng dẫn người bệnh tại khoa khám bệnh.\n" +
                "\n" +
                "– Đặt lịch hẹn khám qua điện thoại, qua tổng đài 1080, qua mạng internet.\n" +
                "\n" +
                "– Công khai giờ khán bệnh, quy trình khám bệnh, bảng giá viện phí, đối tượng ưu tiên.\n" +
                "\n" +
                "– Có sơ đồ khoa khám bệnh.\n" +
                "\n" +
                "2.2. Khám lâm sàng, cận lâm sàng, chẩn đoán, chỉ định điều trị\n" +
                "\n" +
                "– Ứng dụng bảng số điện tử, bảng thông báo điện tử.\n" +
                "\n" +
                "– Phiếu hẹn giờ trả kết quả xét nghiệm, chẩn đoán hình ảnh.\n" +
                "\n" +
                "– Nhân viên khoa xét nghiệm trả kết quả cho khoa khám bệnh (các buồng khám).\n" +
                "\n" +
                "2.3. Thu viện phí, trả thẻ bảo hiểm y tế\n" +
                "\n" +
                "– Bố trí nhiều quầy thu viện phí.\n" +
                "\n" +
                "– Ứng dụng thẻ thanh toán điện tử.\n" +
                "\n" +
                "2.4. Phát và lĩnh thuốc\n" +
                "\n" +
                "– Kết nối bộ phận cấp phát thuốc với khoa dược, buồng khám tạo thuận lợi cho công tác dược lâm sàng và chủ động trong cấp-phát thuốc.\n" +
                "\n" +
                "– Sắp xếp nơi cấp phát thuốc trật tự, ngăn nắp, theo nhóm thuốc chuyên khoa.\n" +
                "\n" +
                "V. TỔ CHỨC THỰC HIỆN\n" +
                "\n" +
                "1. Giám đốc bệnh viện\n" +
                "\n" +
                "a) Căn cứ hướng dẫn này, giám đốc bệnh viện phải quy định cụ thể quy trình khámbệnh của bệnh viện và công khai để người bệnh, nhân viên biết và thực hiện.\n" +
                "\n" +
                "b) Liên tục thực hiện cải tiến quy trình khám bệnh qua các bước sau\n" +
                "\n" +
                "– Thành lập nhóm cải tiến chất lượng gồm đại diện khoa khám bệnh và các phòng,khoa có liên quan để phối hợp triển khai các giải pháp cải tiến quy trình khám bệnh.\n" +
                "\n" +
                "– Đánh giá lại toàn bộ quy trình khám bệnh tại bệnh viện và xây dựng Đề án cải tiến quytrình khám bệnh của bệnh viện.\n" +
                "\n" +
                "– Xác định những nội dung, các vấn đề ưu tiên cải tiến nhằm rút ngắn thời gian chờ và tăng sự hài lòng của người bệnh.\n" +
                "\n" +
                "– Phê duyệt đề án, triển khai các giải pháp can thiệp, đánh giá hiệu quả, duy trì thựchiện giải pháp cải tiến.\n" +
                "\n" +
                "2. Cục Quản lý Khám, chữa bệnh chủ trì phối hợp với Vụ Bảo hiểm y tế và các đơn vịcó liên quan chỉ đạo, kiểm tra, đánh giá việc triển khai thực hiện hướng dẫn tại cácbệnh viện trực thuộc Bộ Y tế.\n" +
                "\n" +
                "3. Thủ trưởng y tế ngành chỉ đạo, kiểm tra, đánh giá việc triển khai thực hiện hướngdẫn tại các bệnh viện trực thuộc Bộ, Ngành.\n" +
                "\n" +
                "4. Giám đốc Sở Y tế tỉnh, thành phố trực thuộc Trung ương chỉ đạo, kiểm tra, đánh giáviệc triển khai thực hiện hướng dẫn tại các bệnh viện trực thuộc sở y tế, bệnh viện tưnhân trên địa bàn.");
    }
}