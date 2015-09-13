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
public class ReportAdapter extends ArrayAdapter {

    private Context context;

    public ReportAdapter(Context context, int resource, ArrayList<Report> items) {
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

            convertView = mInflater.inflate(R.layout.item_list_report, null);

            holder = new ViewHolder();
            holder.name = (TextView) convertView
                    .findViewById(R.id.item_list_route);
            holder.title = (TextView) convertView.findViewById(R.id.item_listTitle);
            holder.violation = (TextView) convertView.findViewById((R.id.item_reportViolation));
            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();


        holder.name.setText("(" + report.getStart() + " -  " + report.getFinish() + ") " + report.getName());
        holder.title.setText(report.getSpyName() + "    маршрут: " + report.getRoute());
        String violation = report.getViolationDescriprion();
        holder.violation.setText(violation);
        if(report.getCountMember() == 0)
            holder.violation.setText("Активисты не обнаружены");
        if(violation != null)
            holder.violation.setText(holder.violation.getText().toString() + "  " + violation);


        return convertView;
    }
}


