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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.parse.ParseUser;

import java.util.ArrayList;

import lantar.spy.R;
import lantar.spy.api.HandlerResult;
import lantar.spy.api.ReportAPI;
import lantar.spy.api.RouteAPI;
import lantar.spy.entity.Report;
import lantar.spy.spy.MainActivity;
import lantar.spy.utils.Constants;
import lantar.spy.utils.ReportAdapter;

/**
 * Created by Lantar on 08.09.2015.
 */
public class ReportsListFragment extends Fragment {

    private ListView listView;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reports_list, container, false);

        listView = (ListView) v.findViewById(R.id.frl_listReports);
        progressBar = (ProgressBar) v.findViewById(R.id.rlf_progressBar);

        ReportAPI reportAPI = new ReportAPI(reportListHandler);
        reportAPI.read();

        return v;


    }


    private void onResultRoute(final ArrayList<Report> reportsList) {
        progressBar.setVisibility(View.INVISIBLE);
        if(this.getActivity() == null || reportsList.size() == 0)
            return;

        final ReportAdapter adapter = new ReportAdapter(this.getActivity(), R.layout.item_list_route, reportsList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(Constants.LOG, "position" + position);

                MainActivity.setReportId(reportsList.get(position).getObjectId());

                MainActivity.setRouteName(reportsList.get(position).getName());
                MainActivity.setRouteNumber(reportsList.get(position).getNumber());
                String role = ParseUser.getCurrentUser().getString(Constants.USER_ROLE);
                FragmentManager fm = getFragmentManager();
                Fragment fragment = null;
                switch (role){
                    case Constants.USER_ROLE_BRIGADIR:
                        fragment = new FixReportFragment();
                        break;
                    case Constants.USER_ROLE_SPY:
                        fragment = new ReadReportFragment();
                        break;
                    case Constants.USER_ROLE_GODFATER:
                       fragment = new FixReportFragment();
                        break;
                    default:
                        break;
                }
                fm.beginTransaction()
                        .replace(R.id.fragment_container, fragment).commit();

            }
        });

    }

    @SuppressLint("HandlerLeak")
    @SuppressWarnings("unchecked")
    private Handler reportListHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (HandlerResult.valueOf(msg.what)) {
                case OK:
                    RouteAPI routeAPI = new RouteAPI(reportListHandler);
                    routeAPI.readRouteList();
                    break;
                case REPORT_TAKE:
                    onResultRoute((ArrayList<Report>) msg.obj);
                    break;
                case ERROR:
                default:
                    break;
            }
        }

    };
}