package lantar.spy.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
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

    @SuppressLint("ResourceAsColor")
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
            holder.descriprion = (TextView) convertView.findViewById((R.id.item_reportDescription));
            convertView.setTag(holder);
            holder.ratingKnowledge = (RatingBar) convertView.findViewById(R.id.ilr_ratingKnowledge);
            holder.ratingSpeech = (RatingBar) convertView.findViewById(R.id.ilr_ratingSpeech);
            holder.ratingKnowledge.setFocusable(false);
            holder.ratingSpeech.setFocusable(false);
            holder.speech = (TextView) convertView.findViewById(R.id.ilr_textSpeech);
            holder.knowledge = (TextView) convertView.findViewById(R.id.ilr_textKnowledge);

        } else
            holder = (ViewHolder) convertView.getTag();


        holder.name.setText(report.getArea() + " район (" + report.getStart() + " -  " + report.getFinish() + ") " + report.getName());
        holder.title.setText(report.getSpyName() + "    маршрут: " + report.getRoute() + "\nОбнаружено " + report.getCountMember() + " из " + report.getBrigadirCount() + " указаных бриагадиром");
        String violation = report.getViolationDescriprion();
        holder.violation.setText(violation);
        if (report.getCountMember() == 0)
            holder.violation.setText("Активисты не обнаружены");
        else
            holder.violation.setBackgroundResource(R.color.red);

        if (report.isLili())
            holder.descriprion.setBackgroundResource(R.color.green);
        else holder.descriprion.setBackgroundResource(R.color.white);

        if (report.getCountMember() != report.getBrigadirCount())
            holder.name.setBackgroundResource(R.color.darkorange);
        else holder.name.setBackgroundResource(R.color.white);

        holder.descriprion.setText(report.getDescrioption());
        if (report.isCube()) {
            holder.ratingKnowledge.setVisibility(RatingBar.VISIBLE);
            holder.ratingSpeech.setVisibility(RatingBar.VISIBLE);
            holder.knowledge.setVisibility(TextView.VISIBLE);
            holder.speech.setVisibility(TextView.VISIBLE);
            holder.ratingKnowledge.setRating((float) Double.parseDouble(report.getKnowlege()));
            holder.ratingSpeech.setRating((float) Double.parseDouble(report.getSpeech()));
            holder.ratingKnowledge.setFocusable(false);
            holder.ratingSpeech.setFocusable(false);

            if(report.getKnowlege() != "1.0"){
                holder.ratingKnowledge.setDrawingCacheBackgroundColor(R.color.orange);
//                LayerDrawable stars = (LayerDrawable) holder.ratingKnowledge.getProgressDrawable();
//                stars.getDrawable(1).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
            }
        } else {

            holder.speech.setVisibility(TextView.GONE);
            holder.knowledge.setVisibility(TextView.GONE);
            holder.ratingKnowledge.setVisibility(RatingBar.GONE);
            holder.ratingSpeech.setVisibility(RatingBar.GONE);
        }

        return convertView;
    }
}


