package lantar.spy.utils;


import com.parse.ParseObject;

import java.util.Date;

import lantar.spy.entity.Report;

/**
 * Created by Lantar on 08.09.2015.
 */
public class ReportUtil {

    public static ParseObject getParseReport(Report report){
        ParseObject parseReport = new ParseObject(Constants.REPORT_REPORT + "_" + new Date().getMonth() + "_" + new Date().getDate());
        parseReport.put(Constants.REPORT_NAME, report.getName());
        parseReport.put(Constants.REPORT_START, report.getStart());
        parseReport.put(Constants.REPORT_FINISH, report.getFinish());
        parseReport.put(Constants.REPORT_COUNT_MEMBER, report.getCountMember());
        parseReport.put(Constants.REPORT_DESCRIPTION, report.getDescrioption());
        parseReport.put(Constants.REPORT_VIOLATION, report.isViolation());
        parseReport.put(Constants.REPORT_RAITING, report.getRaiting());
        parseReport.put(Constants.REPORT_NUMBER, report.getNumber());
        parseReport.put(Constants.REPORT_ROUTE, report.getRoute());
        if(report.getSpyName() != null)
        parseReport.put(Constants.REPORT_SPY, report.getSpyName());
        if(report.getViolationsMarks() != null)
        parseReport.put(Constants.REPORT_VIOLATIONS_MARKS, report.getViolationsMarks());
        if(report.getUrlFile() != "")
        parseReport.put(Constants.REPORT_URL_FILE, report.getUrlFile());
        if(report.getUlrSpyRepozitory() != "")
        parseReport.put(Constants.REPORT_URL_SPY, report.getUlrSpyRepozitory());
        if(report.getViolationDescriprion() != null)
        parseReport.put(Constants.REPORT_VIOLATION_DESCRIPTION, report.getViolationDescriprion());
        parseReport.put(Constants.REPORT_BRIGADE, report.getBrigade());


        return parseReport;
    }

    public static Report getReport(ParseObject parseRepot){
        Report report =  new Report();
        report.setObjectId(parseRepot.getObjectId());
        report.setName(parseRepot.getString(Constants.REPORT_NAME));
        report.setStart(parseRepot.getString(Constants.REPORT_START));
        report.setFinish(parseRepot.getString(Constants.REPORT_FINISH));
        report.setCountMember(parseRepot.getInt(Constants.REPORT_COUNT_MEMBER));
        report.setDescrioption(parseRepot.getString(Constants.REPORT_DESCRIPTION));
        report.setViolation(parseRepot.getBoolean(Constants.REPORT_VIOLATION));
        report.setRaiting(parseRepot.getString(Constants.REPORT_RAITING));
        report.setRoute(parseRepot.getInt(Constants.REPORT_ROUTE));
        report.setNumber(parseRepot.getInt(Constants.REPORT_NUMBER));
        report.setSpyName(parseRepot.getString(Constants.REPORT_SPY));
        report.setViolationDescriprion(parseRepot.getString(Constants.REPORT_VIOLATION_DESCRIPTION));
        report.setUrlFile(parseRepot.getString(Constants.REPORT_URL_FILE));
        report.setUlrSpyRepozitory(parseRepot.getString(Constants.REPORT_URL_SPY));
        report.setViolationsMarks(parseRepot.getString(Constants.REPORT_VIOLATIONS_MARKS));
        report.setBrigade(parseRepot.getInt(Constants.REPORT_BRIGADE));
        report.setCreateAt(parseRepot.getCreatedAt());


        return report;
    }
}
