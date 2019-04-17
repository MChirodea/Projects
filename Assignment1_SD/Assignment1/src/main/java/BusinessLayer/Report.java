package BusinessLayer;

import PersistenceLayer.DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.time.*;

public class Report {
    private int userid;
    private String action;
    private LocalDate dte;

    public Report(){
        this.userid = -1;
        this.action ="";
    }

    public static  ArrayList<Report> getReports(LocalDate st, LocalDate end, int userid){
        return DAO.getInstance().getReport(st,end,userid);
    }

    public static void writeReports(LocalDate st, LocalDate end, int userid){
        ArrayList<Report> reps = Report.getReports(st,end,userid);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("Report.txt");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("UID : Action : Date");
        for(Report rep1 : reps){
            printWriter.println(rep1.getUserid() +" : "+rep1.getAction() +" : " +rep1.getDate().toString());
        }
        printWriter.close();

    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDate getDate() {
        return dte;
    }

    public void setDate(String date) {
        this.dte = LocalDate.parse(date);
    }

    public void addReport(){
        DAO.getInstance().addReport(this);
    }

}
