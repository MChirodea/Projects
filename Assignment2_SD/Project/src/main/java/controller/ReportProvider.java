package controller;

import access.DataAccess;
import model.Report;

import java.util.List;

public class ReportProvider implements IReportProvider {
    @Override
    public List<Report> getReports() {
        return DataAccess.getInstance().getSessionFactory().openSession().createQuery("from Report", Report.class).list();
    }

}
