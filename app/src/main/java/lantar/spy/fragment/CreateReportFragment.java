package lantar.spy.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParsePush;
import com.parse.ParseUser;

import java.util.Calendar;

import lantar.spy.R;
import lantar.spy.api.HandlerResult;
import lantar.spy.api.ReportAPI;
import lantar.spy.entity.Report;
import lantar.spy.spy.MainActivity;
import lantar.spy.utils.Constants;

/**
 * Created by Lantar on 07.09.2015.
 */
public class CreateReportFragment extends Fragment {

    private Button btnCreate;
    private TextView textName;
    private TextView textDuration;
    private String name;
    private int number;
    private EditText et_photoLink;
    private EditText et_description;

    private RatingBar ratingBar1;
    private RatingBar ratingBar2;
    private RatingBar ratingBar3;
    private RatingBar ratingBar4;
    private RatingBar ratingBar5;
    private RatingBar ratingBar6;
    private RatingBar ratingBar7;
    private RatingBar ratingBar8;
    private RatingBar ratingBar9;
    private RatingBar ratingBar10;
    private RatingBar ratingBar11;
    private RatingBar ratingBar12;
    private RatingBar ratingBar13;
    private RatingBar ratingBar14;
    private RatingBar ratingBar15;
    private RatingBar ratingBar16;
    private RatingBar ratingBar17;
    private RatingBar ratingBar18;
    private RatingBar ratingBar19;
    private RatingBar ratingBar20;
    private RatingBar ratingBar21;
    private RatingBar ratingBar22;
    private RatingBar ratingBar23;
    private RatingBar ratingBar24;
    private RatingBar ratingBar25;
    private RatingBar ratingBar26;
    private RatingBar ratingBar27;
    private RatingBar ratingBar28;
    private RatingBar ratingBar29;
    private RatingBar ratingBar30;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private CheckBox checkBox7;
    private CheckBox checkBox8;
    private CheckBox checkBox9;
    private CheckBox checkBox10;
    private CheckBox checkBox11;

    private NumberPicker numberPicker;
    private NumberPicker numberPickerBrigadir;
    private NumberPicker hourPickerStart;
    private NumberPicker minutePickierStart;
    private NumberPicker hourPickerFinish;
    private NumberPicker minutePickierFinish;
    private CheckBox checkBoxViolation;

    private int countPiple;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create_report, container, false);
        btnCreate = (Button) v.findViewById(R.id.crf_btnCreate);
        progressBar = (ProgressBar) v.findViewById(R.id.fcr_progressBar);
        name = MainActivity.getRouteName();
        number = MainActivity.getRouteNumber();
        et_description = (EditText) v.findViewById(R.id.crf_description);
        et_photoLink = (EditText) v.findViewById(R.id.crf_photolink);
        textName = (TextView) v.findViewById(R.id.fcr_textName);
        ratingBar1 = (RatingBar) v.findViewById(R.id.ratingBar1);
        ratingBar2 = (RatingBar) v.findViewById(R.id.ratingBar2);
        ratingBar3 = (RatingBar) v.findViewById(R.id.ratingBar3);
        ratingBar4 = (RatingBar) v.findViewById(R.id.ratingBar4);
        ratingBar5 = (RatingBar) v.findViewById(R.id.ratingBar5);
        ratingBar6 = (RatingBar) v.findViewById(R.id.ratingBar6);
        ratingBar7 = (RatingBar) v.findViewById(R.id.ratingBar7);
        ratingBar8 = (RatingBar) v.findViewById(R.id.ratingBar8);
        ratingBar9 = (RatingBar) v.findViewById(R.id.ratingBar9);
        ratingBar10 = (RatingBar) v.findViewById(R.id.ratingBar10);
        ratingBar11 = (RatingBar) v.findViewById(R.id.ratingBar11);
        ratingBar12 = (RatingBar) v.findViewById(R.id.ratingBar12);
        ratingBar13 = (RatingBar) v.findViewById(R.id.ratingBar13);
        ratingBar14 = (RatingBar) v.findViewById(R.id.ratingBar14);
        ratingBar15 = (RatingBar) v.findViewById(R.id.ratingBar15);
        ratingBar16 = (RatingBar) v.findViewById(R.id.ratingBar16);
        ratingBar17 = (RatingBar) v.findViewById(R.id.ratingBar17);
        ratingBar18 = (RatingBar) v.findViewById(R.id.ratingBar18);
        ratingBar19 = (RatingBar) v.findViewById(R.id.ratingBar19);
        ratingBar20 = (RatingBar) v.findViewById(R.id.ratingBar20);
        ratingBar21 = (RatingBar) v.findViewById(R.id.ratingBar21);
        ratingBar22 = (RatingBar) v.findViewById(R.id.ratingBar22);
        ratingBar23 = (RatingBar) v.findViewById(R.id.ratingBar23);
        ratingBar24 = (RatingBar) v.findViewById(R.id.ratingBar24);
        ratingBar25 = (RatingBar) v.findViewById(R.id.ratingBar25);
        ratingBar26 = (RatingBar) v.findViewById(R.id.ratingBar26);
        ratingBar27 = (RatingBar) v.findViewById(R.id.ratingBar27);
        ratingBar28 = (RatingBar) v.findViewById(R.id.ratingBar28);
        ratingBar29 = (RatingBar) v.findViewById(R.id.ratingBar29);
        ratingBar30 = (RatingBar) v.findViewById(R.id.ratingBar30);


        checkBoxViolation = (CheckBox) v.findViewById(R.id.crf_Violation);
        checkBox1 = (CheckBox) v.findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) v.findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) v.findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) v.findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) v.findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox) v.findViewById(R.id.checkBox6);
        checkBox7 = (CheckBox) v.findViewById(R.id.checkBox7);
        checkBox8 = (CheckBox) v.findViewById(R.id.checkBox8);
        checkBox9 = (CheckBox) v.findViewById(R.id.checkBox9);
        checkBox10 = (CheckBox) v.findViewById(R.id.checkBox10);
        checkBox11 = (CheckBox) v.findViewById(R.id.checkBox11);

        ratingBar1.setStepSize(1);
        ratingBar2.setStepSize(1);
        ratingBar3.setStepSize(1);
        ratingBar4.setStepSize(1);
        ratingBar5.setStepSize(1);
        ratingBar6.setStepSize(1);
        ratingBar7.setStepSize(1);
        ratingBar8.setStepSize(1);
        ratingBar9.setStepSize(1);
        ratingBar10.setStepSize(1);
        ratingBar11.setStepSize(1);
        ratingBar12.setStepSize(1);
        ratingBar13.setStepSize(1);
        ratingBar14.setStepSize(1);
        ratingBar15.setStepSize(1);
        ratingBar16.setStepSize(1);
        ratingBar17.setStepSize(1);
        ratingBar18.setStepSize(1);
        ratingBar19.setStepSize(1);
        ratingBar20.setStepSize(1);
        ratingBar21.setStepSize(1);
        ratingBar22.setStepSize(1);
        ratingBar23.setStepSize(1);
        ratingBar24.setStepSize(1);
        ratingBar25.setStepSize(1);
        ratingBar26.setStepSize(1);
        ratingBar27.setStepSize(1);
        ratingBar28.setStepSize(1);
        ratingBar29.setStepSize(1);
        ratingBar30.setStepSize(1);

        ratingBar1.setRating(1);
        ratingBar2.setRating(1);
        ratingBar3.setRating(1);
        ratingBar4.setRating(1);
        ratingBar5.setRating(1);
        ratingBar6.setRating(1);
        ratingBar7.setRating(1);
        ratingBar8.setRating(1);
        ratingBar9.setRating(1);
        ratingBar10.setRating(1);
        ratingBar11.setRating(1);
        ratingBar12.setRating(1);
        ratingBar13.setRating(1);
        ratingBar14.setRating(1);
        ratingBar15.setRating(1);
        ratingBar16.setRating(1);
        ratingBar17.setRating(1);
        ratingBar18.setRating(1);
        ratingBar19.setRating(1);
        ratingBar20.setRating(1);
        ratingBar21.setRating(1);
        ratingBar22.setRating(1);
        ratingBar23.setRating(1);
        ratingBar24.setRating(1);
        ratingBar25.setRating(1);
        ratingBar26.setRating(1);
        ratingBar27.setRating(1);
        ratingBar28.setRating(1);
        ratingBar29.setRating(1);
        ratingBar30.setRating(1);


        textName.setText(number + "человек с " + name.toString());

        numberPicker = (NumberPicker) v.findViewById(R.id.fcr_numberPicer);

        numberPicker.setMaxValue(30);
        numberPicker.setMinValue(0);
        numberPickerBrigadir = (NumberPicker) v.findViewById(R.id.fcr_brigadirCount);

        numberPickerBrigadir.setMaxValue(30);
        numberPickerBrigadir.setMinValue(0);

        hourPickerStart = (NumberPicker) v.findViewById(R.id.fcr_hourStart);
        hourPickerStart.setMaxValue(24);
        hourPickerStart.setMinValue(1);
        hourPickerStart.setValue(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

        hourPickerFinish = (NumberPicker) v.findViewById(R.id.fcr_HourFinish);
        hourPickerFinish.setMaxValue(24);
        hourPickerFinish.setMinValue(1);
        hourPickerFinish.setValue(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

        minutePickierStart = (NumberPicker) v.findViewById(R.id.fcr_minuteStart);
        minutePickierStart.setMaxValue(59);
        minutePickierStart.setMinValue(0);
        minutePickierStart.setValue(Calendar.getInstance().get(Calendar.MINUTE));

        minutePickierFinish = (NumberPicker) v.findViewById(R.id.fcr_minuteFinish);
        minutePickierFinish.setMaxValue(59);
        minutePickierFinish.setMinValue(0);
        minutePickierFinish.setValue(Calendar.getInstance().get(Calendar.MINUTE));

        numberPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(Constants.LOG, "testing numberPicker");
            }
        });

        checkBoxViolation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxViolation.isChecked()) {
                    checkBox1.setVisibility(CheckBox.VISIBLE);
                    checkBox2.setVisibility(CheckBox.VISIBLE);
                    checkBox3.setVisibility(CheckBox.VISIBLE);
                    checkBox4.setVisibility(CheckBox.VISIBLE);
                    checkBox5.setVisibility(CheckBox.VISIBLE);
                    checkBox6.setVisibility(CheckBox.VISIBLE);
                    checkBox7.setVisibility(CheckBox.VISIBLE);
                    checkBox8.setVisibility(CheckBox.VISIBLE);
//                    checkBox9.setVisibility(CheckBox.VISIBLE);
                    checkBox10.setVisibility(CheckBox.VISIBLE);
                    checkBox11.setVisibility(CheckBox.VISIBLE);
                }
            }
        });

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                ratingBar1.setVisibility(RatingBar.GONE);
                ratingBar2.setVisibility(RatingBar.GONE);
                ratingBar3.setVisibility(RatingBar.GONE);
                ratingBar4.setVisibility(RatingBar.GONE);
                ratingBar5.setVisibility(RatingBar.GONE);
                ratingBar6.setVisibility(RatingBar.GONE);
                ratingBar7.setVisibility(RatingBar.GONE);
                ratingBar8.setVisibility(RatingBar.GONE);
                ratingBar9.setVisibility(RatingBar.GONE);
                ratingBar10.setVisibility(RatingBar.GONE);
                ratingBar11.setVisibility(RatingBar.GONE);
                ratingBar12.setVisibility(RatingBar.GONE);
                ratingBar13.setVisibility(RatingBar.GONE);
                ratingBar14.setVisibility(RatingBar.GONE);
                ratingBar15.setVisibility(RatingBar.GONE);
                ratingBar16.setVisibility(RatingBar.GONE);
                ratingBar17.setVisibility(RatingBar.GONE);
                ratingBar18.setVisibility(RatingBar.GONE);
                ratingBar19.setVisibility(RatingBar.GONE);
                ratingBar20.setVisibility(RatingBar.GONE);
                ratingBar21.setVisibility(RatingBar.GONE);
                ratingBar22.setVisibility(RatingBar.GONE);
                ratingBar23.setVisibility(RatingBar.GONE);
                ratingBar24.setVisibility(RatingBar.GONE);
                ratingBar25.setVisibility(RatingBar.GONE);
                ratingBar26.setVisibility(RatingBar.GONE);
                ratingBar27.setVisibility(RatingBar.GONE);
                ratingBar28.setVisibility(RatingBar.GONE);
                ratingBar29.setVisibility(RatingBar.GONE);
                ratingBar30.setVisibility(RatingBar.GONE);


                for (int x = 0; x <= i2; x++) {
                    countPiple = x;
                    switch (x) {
                        case 0:
                            break;
                        case 1:
                            ratingBar1.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 2:
                            ratingBar2.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 3:
                            ratingBar3.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 4:
                            ratingBar4.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 5:
                            ratingBar5.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 6:
                            ratingBar6.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 7:
                            ratingBar7.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 8:
                            ratingBar8.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 9:
                            ratingBar9.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 10:
                            ratingBar10.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 11:
                            ratingBar11.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 12:
                            ratingBar12.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 13:
                            ratingBar13.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 14:
                            ratingBar14.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 15:
                            ratingBar15.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 16:
                            ratingBar16.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 17:
                            ratingBar17.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 18:
                            ratingBar18.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 19:
                            ratingBar19.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 20:
                            ratingBar20.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 21:
                            ratingBar21.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 22:
                            ratingBar22.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 23:
                            ratingBar23.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 24:
                            ratingBar24.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 25:
                            ratingBar25.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 26:
                            ratingBar26.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 27:
                            ratingBar27.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 28:
                            ratingBar28.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 29:
                            ratingBar29.setVisibility(RatingBar.VISIBLE);
                            break;
                        case 30:
                            ratingBar30.setVisibility(RatingBar.VISIBLE);
                            break;

                    }

                }
            }

        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Report report = new Report();
                report.setName(MainActivity.getRouteName());
                report.setNumber(MainActivity.getRouteNumber());
                report.setSpyName(ParseUser.getCurrentUser().getString(Constants.USER_FIO));
                report.setRoute(ParseUser.getCurrentUser().getInt(Constants.USER_ROUTE));
                report.setRaiting(allRating());
                report.setCountMember(numberPicker.getValue());
                report.setUlrSpyRepozitory(ParseUser.getCurrentUser().getString(Constants.USER_URL));
//                report.setUrlFile(et_photoLink.getText().toString());
                report.setArea(MainActivity.getArea());
                report.setAnnouncedCount(MainActivity.getAnnoncedCount());
                report.setBrigadirCount(numberPickerBrigadir.getValue());
                int hourStart = hourPickerStart.getValue();
                int minuteStart = minutePickierStart.getValue();
                int hourFinish = hourPickerFinish.getValue();
                int minuteFinish = minutePickierFinish.getValue();
                report.setStart(addZerro(hourStart) + ":" + addZerro(minuteStart));
                report.setFinish(addZerro(hourFinish) + ":" + addZerro(minuteFinish));

                report.setViolation(checkBoxViolation.isChecked());
                if (checkBoxViolation.isChecked()) {
                    report.setViolationDescriprion(violationCheked());
                    report.setUrlFile(ParseUser.getCurrentUser().getString(Constants.USER_URL));

                }
                report.setDescrioption(et_description.getText().toString());
                report.setViolationsMarks(violationChekedSetMarks());
                report.setBrigade(ParseUser.getCurrentUser().getInt(Constants.USER_BRIGADE));
                ReportAPI reportAPI = new ReportAPI(createReportHandler);

                reportAPI.create(report);
                btnCreate.setEnabled(false);
                progressBar.setVisibility(ProgressBar.VISIBLE);


            }
        });

        return v;


    }

    private String addZerro(int x) {
        if (x < 10) {
            return 0 + "" + x;
        } else {
            return "" + x;
        }
    }

    private String allRating() {
        String ratingStr = "";

        for (int x = 0; x <= countPiple; x++) {
            switch (x) {
                case 0:
                    break;
                case 1:
                    ratingStr = "" + (int) ratingBar1.getRating();
                    break;
                case 2:
                    ratingStr = ratingStr + ", " + ((int) ratingBar2.getRating());
                    break;
                case 3:
                    ratingStr = ratingStr + ", " + (int) ratingBar3.getRating();
                    break;
                case 4:
                    ratingStr = ratingStr + ", " + (int) ratingBar4.getRating();
                    break;
                case 5:
                    ratingStr = ratingStr + ", " + (int) ratingBar5.getRating();
                    break;
                case 6:
                    ratingStr = ratingStr + ", " + (int) ratingBar6.getRating();
                    break;
                case 7:
                    ratingStr = ratingStr + ", " + (int) ratingBar7.getRating();
                    break;
                case 8:
                    ratingStr = ratingStr + ", " + (int) ratingBar8.getRating();
                    break;
                case 9:
                    ratingStr = ratingStr + ", " + (int) ratingBar9.getRating();
                    break;
                case 10:
                    ratingStr = ratingStr + ", " + (int) ratingBar10.getRating();
                    break;
                case 11:
                    ratingStr =ratingStr + ", " + (int) ratingBar11.getRating();
                    break;
                case 12:
                    ratingStr = ratingStr + ", " + ((int) ratingBar12.getRating());
                    break;
                case 13:
                    ratingStr = ratingStr + ", " + (int) ratingBar13.getRating();
                    break;
                case 14:
                    ratingStr = ratingStr + ", " + (int) ratingBar14.getRating();
                    break;
                case 15:
                    ratingStr = ratingStr + ", " + (int) ratingBar15.getRating();
                    break;
                case 16:
                    ratingStr = ratingStr + ", " + (int) ratingBar16.getRating();
                    break;
                case 17:
                    ratingStr = ratingStr + ", " + (int) ratingBar17.getRating();
                    break;
                case 18:
                    ratingStr = ratingStr + ", " + (int) ratingBar18.getRating();
                    break;
                case 19:
                    ratingStr = ratingStr + ", " + (int) ratingBar19.getRating();
                    break;
                case 20:
                    ratingStr = ratingStr + ", " + (int) ratingBar20.getRating();
                    break;
                case 21:
                    ratingStr =ratingStr + ", " + (int) ratingBar21.getRating();
                    break;
                case 22:
                    ratingStr = ratingStr + ", " + ((int) ratingBar22.getRating());
                    break;
                case 23:
                    ratingStr = ratingStr + ", " + (int) ratingBar23.getRating();
                    break;
                case 24:
                    ratingStr = ratingStr + ", " + (int) ratingBar24.getRating();
                    break;
                case 25:
                    ratingStr = ratingStr + ", " + (int) ratingBar25.getRating();
                    break;
                case 26:
                    ratingStr = ratingStr + ", " + (int) ratingBar26.getRating();
                    break;
                case 27:
                    ratingStr = ratingStr + ", " + (int) ratingBar27.getRating();
                    break;
                case 28:
                    ratingStr = ratingStr + ", " + (int) ratingBar28.getRating();
                    break;
                case 29:
                    ratingStr = ratingStr + ", " + (int) ratingBar29.getRating();
                    break;
                case 30:
                    ratingStr = ratingStr + ", " + (int) ratingBar30.getRating();
                    break;

            }

        }
        return ratingStr;
    }

    private String violationCheked() {
        String violationStr = "";
        if (checkBox1.isChecked())
            violationStr = violationStr + getResources().getString(R.string.report_violation1) + ", ";
        if (checkBox2.isChecked())
            violationStr = violationStr + getResources().getString(R.string.report_violation2) + ", ";
        if (checkBox3.isChecked())
            violationStr = violationStr + getResources().getString(R.string.report_violation3) + ", ";
        if (checkBox4.isChecked())
            violationStr = violationStr + getResources().getString(R.string.report_violation4) + ", ";
        if (checkBox5.isChecked())
            violationStr = violationStr + getResources().getString(R.string.report_violation5) + ", ";
        if (checkBox6.isChecked())
            violationStr = violationStr + getResources().getString(R.string.report_violation6) + ", ";
        if (checkBox7.isChecked())
            violationStr = violationStr + getResources().getString(R.string.report_violation7) + ", ";
        if (checkBox8.isChecked())
            violationStr = violationStr + getResources().getString(R.string.report_violation8) + ", ";
        if (checkBox9.isChecked())
            violationStr = violationStr + getResources().getString(R.string.report_violation9) + ", ";
        if (checkBox10.isChecked())
            violationStr = violationStr + getResources().getString(R.string.report_violation10) + ", ";
        if (checkBox11.isChecked())
            violationStr = violationStr + getResources().getString(R.string.report_violation11) + ", ";
//        if(violationStr != "")
//            violationStr.substring(0,violationCheked().length()-2);
        return violationStr;
    }

    private String violationChekedSetMarks() {
        String violationMrkStr = "";
        if (checkBox1.isChecked())
            violationMrkStr = violationMrkStr + 1 + ", ";
        else
            violationMrkStr = violationMrkStr + 0 + ", ";
        if (checkBox2.isChecked())
            violationMrkStr = violationMrkStr + 1 + ", ";
        else
            violationMrkStr = violationMrkStr + 0 + ", ";
        if (checkBox3.isChecked())
            violationMrkStr = violationMrkStr + 1 + ", ";
        else
            violationMrkStr = violationMrkStr + 0 + ", ";
        if (checkBox4.isChecked())
            violationMrkStr = violationMrkStr + 1 + ", ";
        else
            violationMrkStr = violationMrkStr + 0 + ", ";
        if (checkBox5.isChecked())
            violationMrkStr = violationMrkStr + 1 + ", ";
        else
            violationMrkStr = violationMrkStr + 0 + ", ";
        if (checkBox6.isChecked())
            violationMrkStr = violationMrkStr + 1 + ", ";
        else
            violationMrkStr = violationMrkStr + 0 + ", ";
        if (checkBox7.isChecked())
            violationMrkStr = violationMrkStr + 1 + ", ";
        else
            violationMrkStr = violationMrkStr + 0 + ", ";
        if (checkBox8.isChecked())
            violationMrkStr = violationMrkStr + 1 + ", ";
        else
            violationMrkStr = violationMrkStr + 0 + ", ";
        if (checkBox9.isChecked())
            violationMrkStr = violationMrkStr + 1 + ", ";
        else
            violationMrkStr = violationMrkStr + 0 + ", ";
        if (checkBox10.isChecked())
            violationMrkStr = violationMrkStr + 1 + ", ";
        else
            violationMrkStr = violationMrkStr + 0 + ", ";
        if (checkBox11.isChecked())
            violationMrkStr = violationMrkStr + 1 + ", ";
        else
            violationMrkStr = violationMrkStr + 0 + "";

        return violationMrkStr;
    }

    private void sendPush() {
        if (checkBox3.isChecked() || checkBox5.isChecked() || checkBox6.isChecked()) {
            ParsePush push = new ParsePush();
            push.setChannel("Control");
            push.setMessage(MainActivity.getRouteNumber() + ". " + MainActivity.getRouteName() + ". Нарушение: " + violationCheked());
            push.sendInBackground();
        }
    }


    @SuppressLint("HandlerLeak")
    @SuppressWarnings("unchecked")
    private Handler createReportHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (HandlerResult.valueOf(msg.what)) {
                case OK:
                    sendPush();
                    Log.d(Constants.LOG, "OK");
                    Toast.makeText(getActivity(), getResources().getString(R.string.report_create), Toast.LENGTH_SHORT).show();
                    FragmentManager fm = getFragmentManager();
                    Fragment fragment = new RoutsListFragment();
                    fm.beginTransaction()
                            .replace(R.id.fragment_container, fragment).commit();

                    progressBar.setVisibility(ProgressBar.GONE);
                    break;
                case ERROR:
                    Toast.makeText(getActivity(), getResources().getString(R.string.report_error), Toast.LENGTH_SHORT).show();
                    btnCreate.setEnabled(true);
                    progressBar.setVisibility(ProgressBar.GONE);
                default:
                    break;
            }
        }

    };


}
