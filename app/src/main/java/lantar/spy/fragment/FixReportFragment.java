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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

import java.util.Calendar;

import lantar.spy.R;
import lantar.spy.api.HandlerResult;
import lantar.spy.api.ReportAPI;
import lantar.spy.entity.Report;
import lantar.spy.spy.MainActivity;
import lantar.spy.utils.Constants;

/**
 * Created by Lantar on 10.09.2015.
 */
public class FixReportFragment extends Fragment {


    private int route;
    private int brigade;

    private Button btnCreate;
    private TextView textName;
    private String name;
    private int number;
    private EditText et_photoLink;
    private EditText et_description;
    private ProgressBar progressBar;
    private ScrollView scrollView;

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

    private TextView spyName;

    private int countPiple;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create_report, container, false);

//        Toast.makeText(getActivity(), getResources().getString(R.string.report_updateMessage), Toast.LENGTH_LONG).show();

        spyName = (TextView) v.findViewById(R.id.fcr_SpyName);
        btnCreate = (Button) v.findViewById(R.id.crf_btnCreate);
        name = MainActivity.getRouteName();
        number = MainActivity.getRouteNumber();
        et_description = (EditText) v.findViewById(R.id.crf_description);
        et_photoLink = (EditText) v.findViewById(R.id.crf_photolink);
        textName = (TextView) v.findViewById(R.id.fcr_textName);
        progressBar = (ProgressBar) v.findViewById(R.id.fcr_progressBar);
        scrollView = (ScrollView) v.findViewById(R.id.scrollView2);

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

        textName.setText(number + ". " + name.toString());

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


        scrollView.setVisibility(ScrollView.GONE);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        ReportAPI reportAPI = new ReportAPI(fixReportHandler);
        reportAPI.read(MainActivity.getReportId());

        checkBoxViolation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxViolation.isChecked()) {
                    checkBoxVisibility();
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


                raitingBarVisibility(i2);
            }

        });



        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Report report = new Report();
//                report.setName(MainActivity.getRouteName());
//                report.setNumber(MainActivity.getRouteNumber());
//                report.setSpyName(ParseUser.getCurrentUser().getString(Constants.USER_FIO));
//                report.setRoute(ParseUser.getCurrentUser().getInt(Constants.USER_ROUTE));
                report.setRaiting(allRating());
                report.setCountMember(numberPicker.getValue());
//                report.setUlrSpyRepozitory(ParseUser.getCurrentUser().getString(Constants.USER_URL));
//                report.setUrlFile(et_photoLink.getText().toString());

                int hourStart = hourPickerStart.getValue();
                int minuteStart = minutePickierStart.getValue();
                int hourFinish = hourPickerFinish.getValue();
                int minuteFinish = minutePickierFinish.getValue();
                report.setStart(addZerro(hourStart) + ":" + addZerro(minuteStart));
                report.setFinish(addZerro(hourFinish) + ":" + addZerro(minuteFinish));

                report.setViolation(checkBoxViolation.isChecked());
                if (checkBoxViolation.isChecked())
                    report.setViolationDescriprion(violationCheked());
                report.setDescrioption(et_description.getText().toString());
                report.setObjectId(MainActivity.getReportId());
                report.setRoute(route);
                report.setBrigade(brigade);
                report.setBrigadirCount(numberPickerBrigadir.getValue());
                ReportAPI reportAPI = new ReportAPI(fixReportHandler);
                reportAPI.update(report);
                btnCreate.setEnabled(false);
                progressBar.setVisibility(ProgressBar.VISIBLE);

            }
        });

        return v;


    }

    private void initialize(){

    }



    private String addZerro(int x) {
        if (x < 10) {
            return 0 + "" + x;
        } else {
            return "" + x;
        }
    }

    private void checkBoxVisibility() {
        checkBox1.setVisibility(CheckBox.VISIBLE);
        checkBox2.setVisibility(CheckBox.VISIBLE);
        checkBox3.setVisibility(CheckBox.VISIBLE);
        checkBox4.setVisibility(CheckBox.VISIBLE);
        checkBox5.setVisibility(CheckBox.VISIBLE);
        checkBox6.setVisibility(CheckBox.VISIBLE);
        checkBox7.setVisibility(CheckBox.VISIBLE);
        checkBox8.setVisibility(CheckBox.VISIBLE);
        checkBox9.setVisibility(CheckBox.VISIBLE);
        checkBox10.setVisibility(CheckBox.VISIBLE);
        checkBox11.setVisibility(CheckBox.VISIBLE);
    }

    private void raitingBarVisibility(int i2) {
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
//        violationStr = violationStr.substring(0,violationCheked().length()-2);
        return violationStr;
    }

    private void setRaringBars(String rating) {
        for (int x = 0; x < rating.length(); x = x + 3) {
            if (x == 0)
                ratingBar1.setRating(Integer.parseInt("" + rating.charAt(0)));
            if (x == 3)
                ratingBar2.setRating(Integer.parseInt("" + rating.charAt(3)));
            if (x == 6)
                ratingBar3.setRating(Integer.parseInt("" + rating.charAt(6)));
            if (x == 9)
                ratingBar4.setRating(Integer.parseInt("" + rating.charAt(9)));
            if (x == 12)
                ratingBar5.setRating(Integer.parseInt("" + rating.charAt(12)));
            if (x == 15)
                ratingBar6.setRating(Integer.parseInt("" + rating.charAt(15)));
            if (x == 18)
                ratingBar7.setRating(Integer.parseInt("" + rating.charAt(18)));
            if (x == 21)
                ratingBar8.setRating(Integer.parseInt("" + rating.charAt(21)));
            if (x == 24)
                ratingBar9.setRating(Integer.parseInt("" + rating.charAt(24)));
            if (x == 27)
                ratingBar10.setRating(Integer.parseInt("" + rating.charAt(27)));
            if (x == 30)
                ratingBar11.setRating(Integer.parseInt("" + rating.charAt(0)));
            if (x == 33)
                ratingBar12.setRating(Integer.parseInt("" + rating.charAt(3)));
            if (x == 36)
                ratingBar13.setRating(Integer.parseInt("" + rating.charAt(6)));
            if (x == 39)
                ratingBar14.setRating(Integer.parseInt("" + rating.charAt(9)));
            if (x == 42)
                ratingBar15.setRating(Integer.parseInt("" + rating.charAt(12)));
            if (x == 45)
                ratingBar16.setRating(Integer.parseInt("" + rating.charAt(15)));
            if (x == 48)
                ratingBar17.setRating(Integer.parseInt("" + rating.charAt(18)));
            if (x == 51)
                ratingBar18.setRating(Integer.parseInt("" + rating.charAt(21)));
            if (x == 54)
                ratingBar19.setRating(Integer.parseInt("" + rating.charAt(24)));
            if (x == 57)
                ratingBar20.setRating(Integer.parseInt("" + rating.charAt(27)));
            if (x == 60)
                ratingBar21.setRating(Integer.parseInt("" + rating.charAt(0)));
            if (x == 63)
                ratingBar22.setRating(Integer.parseInt("" + rating.charAt(3)));
            if (x == 66)
                ratingBar23.setRating(Integer.parseInt("" + rating.charAt(6)));
            if (x == 69)
                ratingBar24.setRating(Integer.parseInt("" + rating.charAt(9)));
            if (x == 72)
                ratingBar25.setRating(Integer.parseInt("" + rating.charAt(12)));
            if (x == 75)
                ratingBar26.setRating(Integer.parseInt("" + rating.charAt(15)));
            if (x == 78)
                ratingBar27.setRating(Integer.parseInt("" + rating.charAt(18)));
            if (x == 81)
                ratingBar28.setRating(Integer.parseInt("" + rating.charAt(21)));
            if (x == 84)
                ratingBar29.setRating(Integer.parseInt("" + rating.charAt(24)));
            if (x == 87)
                ratingBar30.setRating(Integer.parseInt("" + rating.charAt(27)));
        }

    }

    private void setCheckBoxViolation(String mark) {
        for (int x = 0; x < mark.length(); x = x + 3) {
            if (x == 0)
                checkBox1.setChecked(testCheckBox(mark.charAt(0)));
//            checkBox1.setChecked(false);
            if (x == 3)
                checkBox2.setChecked(testCheckBox(mark.charAt(3)));
            if (x == 6)
                checkBox3.setChecked(testCheckBox(mark.charAt(6)));
            if (x == 9)
                checkBox4.setChecked(testCheckBox(mark.charAt(9)));
            if (x == 12)
                checkBox5.setChecked(testCheckBox(mark.charAt(12)));
            if (x == 15)
                checkBox6.setChecked(testCheckBox(mark.charAt(15)));
            if (x == 18)
                checkBox7.setChecked(testCheckBox(mark.charAt(18)));
            if (x == 21)
                checkBox8.setChecked(testCheckBox(mark.charAt(21)));
            if (x == 24)
                checkBox9.setChecked(testCheckBox(mark.charAt(24)));
            if (x == 27)
                checkBox10.setChecked(testCheckBox(mark.charAt(27)));
            if (x == 30)
                checkBox11.setChecked(testCheckBox(mark.charAt(30)));
        }

    }

    private boolean testCheckBox(int i) {
        if (i == 48)
            return false;
        else return true;
    }

    private void onReportResult(Report report) {

        route = report.getRoute();
        brigade = report.getBrigade();

        if(ParseUser.getCurrentUser().getString(Constants.USER_FIO) != report.getSpyName()) {
            spyName.setText(report.getSpyName());
            spyName.setVisibility(TextView.VISIBLE);
        }
        String startHour = String.valueOf(report.getStart().charAt(0)) + String.valueOf(report.getStart().charAt(1));
        String startMinute = String.valueOf(report.getStart().charAt(3)) + String.valueOf(report.getStart().charAt(4));
        String finishHour = String.valueOf(report.getFinish().charAt(0)) + String.valueOf(report.getFinish().charAt(1));
        String finishMinute = String.valueOf(report.getFinish().charAt(3)) + String.valueOf(report.getFinish().charAt(4));

        progressBar.setVisibility(ProgressBar.GONE);
        scrollView.setVisibility(ScrollView.VISIBLE);
        numberPickerBrigadir.setValue(report.getBrigadirCount());
        hourPickerStart.setValue(Integer.parseInt(startHour));
        minutePickierStart.setValue(Integer.parseInt(startMinute));
        hourPickerFinish.setValue(Integer.parseInt(finishHour));
        minutePickierFinish.setValue(Integer.parseInt(finishMinute));
        numberPicker.setValue(report.getCountMember());
        countPiple = report.getCountMember();

        raitingBarVisibility(countPiple);
        setRaringBars(report.getRaiting());
        setCheckBoxViolation(report.getViolationsMarks());

        et_description.setText(report.getDescrioption());
        et_photoLink.setText(report.getUrlFile());
        if (report.isViolation()) {
            checkBoxViolation.setChecked(true);
            checkBoxVisibility();
        }
    }

    @SuppressLint("HandlerLeak")
    @SuppressWarnings("unchecked")
    private Handler fixReportHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (HandlerResult.valueOf(msg.what)) {
                case OK:
                    Log.d(Constants.LOG, "OK");
                    Toast.makeText(getActivity(), getResources().getString(R.string.report_update), Toast.LENGTH_SHORT).show();

                    FragmentManager fm = getFragmentManager();
                    Fragment fragment = new RoutsListFragment();
                    fm.beginTransaction()
                            .replace(R.id.fragment_container, fragment).commit();
                    progressBar.setVisibility(ProgressBar.GONE);
                    break;
                case GET_OBJECT:
                    onReportResult((Report) msg.obj);
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
