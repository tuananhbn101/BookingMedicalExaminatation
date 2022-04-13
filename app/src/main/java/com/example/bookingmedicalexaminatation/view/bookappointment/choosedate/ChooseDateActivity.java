package com.example.bookingmedicalexaminatation.view.bookappointment.choosedate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookingmedicalexaminatation.R;
import com.example.bookingmedicalexaminatation.databinding.ActivityChooseDateBinding;
import com.example.bookingmedicalexaminatation.model.WorkSchedule;
import com.example.bookingmedicalexaminatation.util.Const;
import com.example.bookingmedicalexaminatation.viewmodel.WorkScheduleViewModel;

import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.OnDateSelectedListener;
import org.naishadhparmar.zcustomcalendar.OnNavigationButtonClickedListener;
import org.naishadhparmar.zcustomcalendar.Property;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ChooseDateActivity extends AppCompatActivity {
    private ActivityChooseDateBinding binding;
    private WorkScheduleViewModel workScheduleViewModel;
    private List<WorkSchedule> workSchedules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChooseDateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initObserve();
        initAction();
    }

    private void initObserve() {
        workScheduleViewModel = ViewModelProviders.of(this).get(WorkScheduleViewModel.class);
        workScheduleViewModel.getWorkSchedules().observe(this, new Observer<List<WorkSchedule>>() {
            @Override
            public void onChanged(List<WorkSchedule> workSchedulesResonse) {
                workSchedules.clear();
                workSchedules = workSchedulesResonse;
                Calendar calendar = Calendar.getInstance();
                if (workSchedules == null) {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra(Const.Configure.DATE_RESULT, "Chọn ngày khám");
                    Toast.makeText(getApplicationContext(), "Bác sỹ không có lịch làm việc", Toast.LENGTH_SHORT).show();
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                } else
                    binding.customCalendar.setDate(calendar, setDatePaint(calendar, setDateCalendar(workSchedules, calendar.get(Calendar.MONTH)), calendar.get(Calendar.MONTH)));
            }
        });
    }

    private void initView() {
        setCalendar();
        workSchedules = new ArrayList<>();
        binding.title.title.setText("Chọn ngày khám");
    }


    private List<Integer> setDateCalendar(List<WorkSchedule> workSchedules, int month) {
        List<Integer> dates = new ArrayList<>();
        for (WorkSchedule workSchedule : workSchedules) {
            try {
                Date date = new SimpleDateFormat("dd-MM-yyyy", Locale.US).parse(workSchedule.getDate());
                if (month == date.getMonth()) {
                    int count = 0;
                    for (Integer date1 : dates) {
                        if (date1 == date.getDate()) {
                            ++count;
                        }
                    }
                    if (dates.size() > 0 && count != 0) {

                    } else {
                        dates.add(date.getDate());
                    }
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return dates;
    }

    private void setCalendar() {
        HashMap<Object, Property> mapDescToProp = new HashMap<>();
        Property propDefault = new Property();
        propDefault.layoutResource = R.layout.defaul_date_item;
        propDefault.dateTextViewResource = R.id.default_date_item_text;
        mapDescToProp.put("default", propDefault);

        Property propExamination = new Property();
        propExamination.layoutResource = R.layout.has_date_item;
        propExamination.dateTextViewResource = R.id.had_date_text;
        mapDescToProp.put("examination", propExamination);
        binding.customCalendar.setMapDescToProp(mapDescToProp);
    }

    private Map<Integer, Object> setDatePaint(Calendar calendar, List<Integer> days, int month) {
        Map<Integer, Object> date1 = new HashMap<>();
        for (Integer day : days) {
            date1.put(day, "examination");
        }
        calendar.set(Calendar.MONTH, month);
        return date1;
    }

    private void initAction() {
        Intent intent = getIntent();
        if (intent != null) {
            workScheduleViewModel.getWorkScheduleList(intent.getStringExtra(Const.Account.USER_NAME));
        }
        binding.customCalendar.setOnDateSelectedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(View view, Calendar selectedDate, Object desc) {
                int hasDate = 0;
                Date date = selectedDate.getTime();
                String dateChoose = new SimpleDateFormat("dd-MM-yyyy", Locale.US).format(date);
                for (WorkSchedule workSchedule : workSchedules) {
                    if (workSchedule.getDate().contains(dateChoose)) {
                        hasDate++;
                    }
                }
                if (hasDate != 0) {
                    for (WorkSchedule workSchedule: workSchedules
                         ) {
                        if(workSchedule.getDate().equals(dateChoose)){
                            Intent returnIntent = new Intent();
                            returnIntent.putExtra(Const.Configure.DATE_RESULT, workSchedule);
                            setResult(Activity.RESULT_OK, returnIntent);
                            finish();
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Bạn cần chọn ngày có lịch làm", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.customCalendar.setOnNavigationButtonClickedListener(CustomCalendar.NEXT, new OnNavigationButtonClickedListener() {
            @Override
            public Map<Integer, Object>[] onNavigationButtonClicked(int whichButton, Calendar newMonth) {
                Map<Integer, Object> date[] = new Map[2];
                date[0] = setDatePaint(newMonth, setDateCalendar(workSchedules, newMonth.get(Calendar.MONTH)), newMonth.get(Calendar.MONTH));
                date[1] = setDatePaint(newMonth, setDateCalendar(workSchedules, newMonth.get(Calendar.MONTH)), newMonth.get(Calendar.MONTH));
                return date;
            }
        });
        binding.customCalendar.setOnNavigationButtonClickedListener(CustomCalendar.PREVIOUS, new OnNavigationButtonClickedListener() {
            @Override
            public Map<Integer, Object>[] onNavigationButtonClicked(int whichButton, Calendar newMonth) {
                Map<Integer, Object> date[] = new Map[2];
                date[0] = setDatePaint(newMonth, setDateCalendar(workSchedules, newMonth.get(Calendar.MONTH)), newMonth.get(Calendar.MONTH));
                date[1] = setDatePaint(newMonth, setDateCalendar(workSchedules, newMonth.get(Calendar.MONTH)), newMonth.get(Calendar.MONTH));
                return date;
            }
        });
        binding.title.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}