package lantar.spy.utils;

import com.parse.ParseObject;

import lantar.spy.entity.Route;

/**
 * Created by Lantar on 08.09.2015.
 */
public class RouteUtil {

    public static Route fromLess(ParseObject parseRoute){
        Route route = new Route();
        route.setName(parseRoute.getString(Constants.ROUTE_NAME));
        route.setRoute(parseRoute.getInt(Constants.ROUTE_ROUTE));
        route.setNumber(parseRoute.getInt(Constants.ROUTE_NUMBER));
        return route;
    }
}
