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
import lantar.spy.entity.Report;

/**
 * Created by Lantar on 10.09.2015.
 */
public class RoutAdapter extends ArrayAdapter {

    private Context context;

    public RoutAdapter(Context context, int resource, ArrayList<Report> items) {
        super(context, resource, items);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Report report = (Report) getItem(position);

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


        holder.name.setText("(" + report.getStart() + " -  " + report.getFinish() + ") " + report.getName());

        return convertView;
    }
}


