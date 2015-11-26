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

import java.util.ArrayList;

import lantar.spy.R;
import lantar.spy.api.HandlerResult;
import lantar.spy.api.RouteAPI;
import lantar.spy.api.UserAPI;
import lantar.spy.entity.Route;
import lantar.spy.spy.MainActivity;
import lantar.spy.utils.Constants;
import lantar.spy.utils.RouteAdapter;

/**
 * Created by Lantar on 08.09.2015.
 */
public class RoutsListFragment extends Fragment {

    ListView listView;
    ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_routs_list, container, false);
        listView = (ListView) v.findViewById(R.id.frl_routsList);
        progressBar = (ProgressBar) v.findViewById(R.id.frouts_progressbar);
//        btnCreate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fm = getFragmentManager();
//                Fragment fragment = new MyHomeFragment();
//                fm.beginTransaction()
//                        .replace(R.id.fragment_container, fragment).commit();
//            }
//        });
        UserAPI userAPI = new UserAPI(routsListHandler);
        userAPI.update();



        return v;


    }



    private void onResultRoute(final ArrayList<Route> routeList) {
        progressBar.setVisibility(View.INVISIBLE);
        if(this.getActivity() == null || routeList.size() == 0)
            return;

        final RouteAdapter adapter = new RouteAdapter(this.getActivity(), R.layout.item_list_route, routeList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(Constants.LOG, "position" + position);

                MainActivity.setRouteName(routeList.get(position).getName());
                MainActivity.setRouteNumber(routeList.get(position).getNumber());
                MainActivity.setRoute(routeList.get(position));
                MainActivity.setArea(routeList.get(position).getArea());
                MainActivity.setAnnoncedCount(routeList.get(position).getNumber());
                MainActivity.setBrigadirName(routeList.get(position).getBrigadir());
                MainActivity.setCube(routeList.get(position).isCube());

                FragmentManager fm = getFragmentManager();
                Fragment fragment = new CreateReportFragment();
                fm.beginTransaction()
                        .replace(R.id.fragment_container, fragment).commit();

            }
        });

    }

    @SuppressLint("HandlerLeak")
    @SuppressWarnings("unchecked")
    private Handler routsListHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (HandlerResult.valueOf(msg.what)) {
                case OK:
                    RouteAPI routeAPI = new RouteAPI(routsListHandler);
                    routeAPI.readRouteList();
                    break;
                case ROUTS_TAKE:
                    onResultRoute((ArrayList<Route>) msg.obj);
                    break;
                case ERROR:
                default:
                    break;
            }
        }

    };
}