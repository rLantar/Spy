package lantar.spy.utils;

import com.parse.ParseObject;

import lantar.spy.entity.Route;

/**
 * Created by Lantar on 08.09.2015.
 */
public class RouteUtil {

    public static Route fromLess(ParseObject parseRoute){
        Route route = new Route();
        route.setObjectId(parseRoute.getObjectId());
        route.setName(parseRoute.getString(Constants.ROUTE_NAME));
        route.setRoute(parseRoute.getInt(Constants.ROUTE_ROUTE));
        route.setNumber(parseRoute.getInt(Constants.ROUTE_NUMBER));
        if(parseRoute.getString(Constants.ROUTE_AREA) == null)
            route.setArea("Раён не был указан");
        else
        route.setArea(parseRoute.getString(Constants.ROUTE_AREA));
        if(parseRoute.getString(Constants.ROUTE_BRIGADIR_NAME) == null)
            route.setBrigadir("Бригадир не указан");
        else
        route.setBrigadir(parseRoute.getString(Constants.ROUTE_BRIGADIR_NAME));
        if(parseRoute.getString(Constants.ROUTE_BRIGADIR_NUMBER) == null)
            route.setNumberBrigadir("");
        else
        route.setNumberBrigadir(parseRoute.getString(Constants.ROUTE_BRIGADIR_NUMBER));
        if(parseRoute.getString(Constants.ROUTE_TIME) == null)
            route.setTime("Время не указано");
        else
        route.setTime(parseRoute.getString(Constants.ROUTE_TIME));
        return route;
    }
}
