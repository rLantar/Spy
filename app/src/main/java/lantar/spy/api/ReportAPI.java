package lantar.spy.api;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lantar.spy.entity.Report;
import lantar.spy.utils.Constants;
import lantar.spy.utils.ReportUtil;

/**
 * Created by Lantar on 08.09.2015.
 */
public class ReportAPI {

    private Handler handler;

    public ReportAPI(Handler handler) {
        super();
        this.handler = handler;
    }

    public void create(Report report){

        ParseObject parseReport = ReportUtil.getParseReport(report);
        parseReport.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null)
                    success();
                else
                    error(e);
            }
        });
    }

    public void read(String id){
        ParseQuery<ParseObject> query = ParseQuery.getQuery(Constants.REPORT_REPORT  + "_" + new Date().getMonth() + "_" + new Date().getDate());
        query.getInBackground(id, new GetCallback<ParseObject>() {
            public void done(ParseObject parseReport, ParseException e) {
                if (e == null) {
                    Report report = ReportUtil.getReport(parseReport);
                    success(HandlerResult.GET_OBJECT, report);
                } else {
                   error(e);
                }
            }
        });
    }

    public void read(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery(Constants.REPORT_REPORT + "_" + new Date().getMonth() + "_" + new Date().getDate());
        query.setLimit(999);
        String role = ParseUser.getCurrentUser().getString(Constants.USER_ROLE);
        if(role.equals(Constants.USER_ROLE_SPY))
            query.whereEqualTo(Constants.REPORT_SPY, ParseUser.getCurrentUser().get(Constants.USER_FIO));

        if(role.equals(Constants.USER_ROLE_BRIGADIR)) {
//            query.whereEqualTo(ParseUser.getCurrentUser().getString(Constants.USER_BRIGADE), Constants.REPORT_BRIGADE);
            query.whereEqualTo(Constants.REPORT_BRIGADE, ParseUser.getCurrentUser().get(Constants.REPORT_BRIGADE));
        }


        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> parseReportList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + parseReportList.size() + " scores");
                    List<Report> listRoute = new ArrayList<Report>();
                    for(ParseObject pair: parseReportList) {
                        Report report = ReportUtil.getReport(pair);
                        listRoute.add(report);
                    }
                    success(listRoute);
                } else {
                    error(e);
                }
            }

        });


    }

    public void update(final Report report){
        ParseQuery<ParseObject> query = ParseQuery.getQuery(Constants.REPORT_REPORT + "_" + new Date().getMonth() + "_" + new Date().getDate());
        query.getInBackground(report.getObjectId(), new GetCallback<ParseObject>() {
            public void done(ParseObject parseReport, ParseException e) {
                if (e == null) {
                    parseReport = ReportUtil.getParseReport(report);
                    parseReport.setObjectId(report.getObjectId());
                    parseReport.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e == null)
                                success();
                            else
                                error(e);
                        }
                    });
                } else {
                    error(e);
                }
            }
        });
    }

    public void delete(String id){
        ParseQuery<ParseObject> query = ParseQuery.getQuery(Constants.REPORT_REPORT);
        query.getInBackground(id, new GetCallback<ParseObject>() {
            public void done(ParseObject parseReport, ParseException e) {
                if (e == null) {
                    parseReport.unpinInBackground();
                    success();
                } else {
                    error(e);
                }
            }
        });
    }




    private void success() {
        handler.sendEmptyMessage(HandlerResult.OK.getResult());
    }

    private void success(HandlerResult result, Report report) {
        Message msg = handler.obtainMessage();
        msg.what = result.getResult();
        msg.obj = report;

        handler.sendMessage(msg);
    }

    private void success(List<Report> reportList) {
        Message msg = handler.obtainMessage();
        msg.what = HandlerResult.REPORT_TAKE.getResult();
        msg.obj = reportList;

        handler.sendMessage(msg);
    }

    private void error(Exception error) {
        Log.d(Constants.LOG, error.toString());
        handler.sendEmptyMessage(HandlerResult.ERROR.getResult());
    }

}
