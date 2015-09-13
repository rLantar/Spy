package lantar.spy.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import lantar.spy.R;
import lantar.spy.entity.Route;

/**
 * Created by Lantar on 02.04.2015.
 */
public class RouteAdapter extends ArrayAdapter {

    private Context context;

    public RouteAdapter(Context context, int resource, ArrayList<Route> items) {
        super(context, resource, items);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Route route = (Route) getItem(position);

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.item_list_route, null);

            holder = new ViewHolder();
            holder.name = (TextView) convertView
                    .findViewById(R.id.item_list_route);
            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();


        holder.name.setText(route.getNumber() + ". " + route.getName());

        return convertView;
    }
}

class ViewHolder {
    // ImageView imageView;
    TextView name;
    TextView title;
    TextView violation;
}
