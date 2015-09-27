package lantar.spy.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

import java.util.Date;

import lantar.spy.R;
import lantar.spy.api.HandlerResult;
import lantar.spy.api.ReportAPI;
import lantar.spy.entity.Report;
import lantar.spy.spy.MainActivity;
import lantar.spy.utils.Constants;

/**
 * Created by Lantar on 12.09.2015.
 */
public class ReadReportFragment extends Fragment {

    ScrollView scrollView;
    ProgressBar progressBar;
    TextView spyName;
    TextView name;
    TextView count;
    TextView timeStart;
    TextView timeFinish;
    TextView raiting;
    TextView violation;
    TextView description;
    TextView url;
    Button back;
    Button fix;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_read_report, container, false);
        scrollView = (ScrollView) v.findViewById(R.id.rrf_scrollView);
        progressBar = (ProgressBar) v.findViewById(R.id.rrf_progressBar);
        spyName = (TextView) v.findViewById(R.id.rrf_spyName);
        name = (TextView) v.findViewById(R.id.rrf_name);
        count = (TextView) v.findViewById(R.id.rrf_countppl);
        timeStart = (TextView) v.findViewById(R.id.rrf_start);
        timeFinish = (TextView) v.findViewById(R.id.rrf_finish);
        raiting = (TextView) v.findViewById(R.id.rrf_raiting);
        violation = (TextView) v.findViewById(R.id.rrf_violation);
        description = (TextView) v.findViewById(R.id.rrf_description);
        url = (TextView) v.findViewById(R.id.rrf_url);
        back = (Button) v.findViewById(R.id.rrf_btnBack);
        fix = (Button) v.findViewById(R.id.rrf_btnFix);

        fix.setVisibility(Button.GONE);

        ReportAPI reportAPI = new ReportAPI(readReportFragment);
        reportAPI.read(MainActivity.getReportId());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                Fragment fragment = new ReportsListFragment();
                fm.beginTransaction()
                        .replace(R.id.fragment_container, fragment).commit();
            }
        });

        fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                Fragment fragment = new FixReportFragment();
                fm.beginTransaction()
                        .replace(R.id.fragment_container, fragment).commit();
            }
        });


        return v;


    }



    private void onReportResult(Report report) {
        if(ParseUser.getCurrentUser().getString(Constants.USER_FIO) != report.getSpyName()) {
            spyName.setText(report.getSpyName());
            spyName.setVisibility(TextView.VISIBLE);
        }
        scrollView.setVisibility(ScrollView.VISIBLE);
        progressBar.setVisibility(ProgressBar.GONE);
        Date now = new Date();
        Date old = report.getCreateAt();

        if(old.getTime() + 5*60*1000 > now.getTime())
            fix.setVisibility(Button.VISIBLE);
        String role = ParseUser.getCurrentUser().getString(Constants.USER_ROLE);
                        switch (role){
                    case Constants.USER_ROLE_BRIGADIR:
                        fix.setVisibility(Button.VISIBLE);
                        break;
                    case Constants.USER_ROLE_SPY:
//                        fragment = new ReadReportFragment();
                        break;
                    case Constants.USER_ROLE_GODFATER:
                        fix.setVisibility(Button.VISIBLE);
                        break;
                    default:
                        break;
                }

        name.setText(MainActivity.getRouteNumber() + ". " +MainActivity.getRouteName());
        count.setText(count.getText().toString() + report.getCountMember());
        timeStart.setText(timeStart.getText().toString() + report.getStart());
        timeFinish.setText(timeFinish.getText().toString() + report.getFinish());
        raiting.setText(report.getRaiting());
        violation.setText(report.getViolationDescriprion());
        description.setText(report.getDescrioption());
        url.setText(report.getUrlFile());

    }


    @SuppressLint("HandlerLeak")
    @SuppressWarnings("unchecked")
    private Handler readReportFragment = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (HandlerResult.valueOf(msg.what)) {

                case GET_OBJECT:
                    onReportResult((Report) msg.obj);
                    break;
                case ERROR:
                    Toast.makeText(getActivity(), getResources().getString(R.string.report_error), Toast.LENGTH_SHORT).show();
                default:
                    break;
            }
        }

    };


}
