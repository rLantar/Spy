package lantar.spy.api;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import lantar.spy.entity.Route;
import lantar.spy.utils.Constants;
import lantar.spy.utils.RouteUtil;

/**
 * Created by Lantar on 08.09.2015.
 */
public class RouteAPI {


    private Handler handler;

    public RouteAPI(Handler handler) {
        super();
        this.handler = handler;
    }


    public void readRouteList(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery(Constants.ROUTE_ROUTE);
        query.whereEqualTo(Constants.ROUTE_ROUTE, ParseUser.getCurrentUser().get(Constants.ROUTE_ROUTE));
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> parseRouteList, ParseException e) {
                if (e == null) {
                    List<Route> listRoute = new ArrayList<Route>();
                    for(ParseObject pair: parseRouteList) {
                        Route route = RouteUtil.fromLess(pair);
                        listRoute.add(route);
                    }
                    success(listRoute);
                } else {
                    error(e);
                }
            }

        });
    }

    private void success(List<Route> routeList) {
        Message msg = handler.obtainMessage();
        msg.what = HandlerResult.ROUTS_TAKE.getResult();
        msg.obj = routeList;

        handler.sendMessage(msg);
    }

    private void error(Exception error) {
        Log.d(Constants.LOG, error.toString());
        handler.sendEmptyMessage(HandlerResult.ERROR.getResult());
    }

}
