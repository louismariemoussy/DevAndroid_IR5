package com.example.finalproject;



import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RdvActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button start_date;
    TextView start_date_view;
    TimePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdv);

        Calendar calendar = Calendar.getInstance();
        String date = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        //String time = DateFormat.getDateInstance().format(calendar.getTime());

        //https://www.youtube.com/watch?v=Le47R9H3qow



        Button start_date = findViewById(R.id.btnSetDate);
        TextView start_date_view = findViewById(R.id.txtStartDate);
        TextView start_time_view = findViewById(R.id.txtStartTime);
        TextView end_date_view = findViewById(R.id.txtEndDate);
        TextView end_time_view = findViewById(R.id.txtEndTime);

        // Get Current Time
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        calendar.add(Calendar.HOUR, 1);
        int mHourPlusOne = calendar.get(Calendar.HOUR_OF_DAY);
        String current_time = "" + mHour+":"+mMinute;
        String current_time_plus_one = "" + mHourPlusOne+":"+mMinute;



        start_date_view.setText(date);
        end_date_view.setText(date);
        start_time_view.setText(current_time);
        end_time_view.setText(current_time_plus_one);

        //https://www.youtube.com/watch?v=eX-TdY6bLdg

        //Create popup
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.7));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        //close button
        Button mCloseBTN = findViewById(R.id.CloseBTN);
        mCloseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Open satrt date selector
        start_date_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.finalproject.DatePicker mDatePicker;
                mDatePicker = new com.example.finalproject.DatePicker();
                mDatePicker.show(getSupportFragmentManager(), "DATE PICK");

            }
        });

        //Open end date selector
        end_date_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.finalproject.DatePicker mDatePicker;
                mDatePicker = new com.example.finalproject.DatePicker();
                mDatePicker.show(getSupportFragmentManager(), "DATE PICK");

            }
        });

        //Select start time
        start_time_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                picker = new TimePickerDialog(RdvActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                start_time_view.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                picker.show();
            }

    });

        //Select end time
        end_time_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                picker = new TimePickerDialog(RdvActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                end_time_view.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                picker.show();
            }

        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)

    {

        TextView start_date_view = findViewById(R.id.txtStartDate);
        // Create a Calender instance

        Calendar mCalender = Calendar.getInstance();

        // Set static variables of Calender instance

        mCalender.set(Calendar.YEAR,year);

        mCalender.set(Calendar.MONTH,month);

        mCalender.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        // Get the date in form of string

        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalender.getTime());


        // Set the textview to the selectedDate String

        start_date_view.setText(selectedDate);

    }

}