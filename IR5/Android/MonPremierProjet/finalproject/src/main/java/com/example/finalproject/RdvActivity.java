package com.example.finalproject;



import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.List;
import java.util.Arrays;

public class RdvActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button start_date;
    TextView start_date_view;
    TimePickerDialog picker;
    myDbAdapter helper;
    private ArrayList<Integer> AllName;

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
        Switch family_switch = findViewById(R.id.Familywitch);
        TextView family_check =findViewById(R.id.FamilyCheck);
        TextView family_selected = findViewById(R.id.FamilySelected);

        //to get name in the db
        helper = new myDbAdapter(this);
        String name = helper.getName();

         String[] nameList = (name.replaceAll("\\s+$", "")).split(" ");
         List<String> l  = Arrays.asList(nameList);
         AllName = new ArrayList<>();
         boolean[] checkedMembers = new boolean[nameList.length];

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


        //when switch is checked
        family_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    // do something when check is selected
                    //hide people selection
                    family_check.setVisibility(View.INVISIBLE);
                    family_selected.setVisibility(View.INVISIBLE);
                } else {
                    //do something when unchecked
                    //show people selection
                    family_check.setVisibility(View.VISIBLE);
                    family_selected.setVisibility(View.VISIBLE);
                }
            }

        });

        //cleick on the people btn to select the family menber
        //https://www.youtube.com/watch?v=wfADRuyul04
        family_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(RdvActivity.this);
                mBuilder.setTitle("Family menber");
                mBuilder.setMultiChoiceItems(nameList, checkedMembers, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        if(isChecked){
                            if(!AllName.contains(which)){
                                AllName.add(which);
                            }else if (AllName.contains(which)){
                                AllName.remove(which);
                            }
                        }
                    }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = "";
                        for(int i = 0; i<AllName.size();i++){
                            item = item + nameList[AllName.get(i)];
                            if(i != AllName.size()-1){
                                item = item + ", ";
                            }
                        }
                        family_selected.setText(item.replace("\n", "").replace("\r", ""));
                    }
                });

                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        for(int t =0; t<checkedMembers.length;t++){
                            checkedMembers[t]=false;
                            AllName.clear();
                            family_selected.setText("");
                        }
                        dialog.dismiss();
                    }
                });

                mBuilder.setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for(int i =0; i<checkedMembers.length;i++){
                            checkedMembers[i]=false;
                            AllName.clear();
                            family_selected.setText("");
                        }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();


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