package model;

public class Report {
    private String reportType;
    private double totalGrades;
    private int numOfStudentsSubmit;

    public Report() {
        this.reportType = null;
        this.totalGrades = 0;
        this.numOfStudentsSubmit = 0;
    }
    public Report(String reportType) {
        this();
        this.reportType = reportType;
    }
    public Report(String reportType, double totalGrades) {
        this(reportType);
        this.totalGrades = totalGrades;
    }
    public Report(String reportType, double totalGrades, int numOfStudentsSubmit) {
        this(reportType, totalGrades);
        this.numOfStudentsSubmit = numOfStudentsSubmit;
    }
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
    public void setTotalGrades(double totalGrades) {
        this.totalGrades = totalGrades;
    }
    public void setNumOfStudentsSubmit(int numOfStudentsSubmit) {
        this.numOfStudentsSubmit = numOfStudentsSubmit;
    }
    public String getReportType() {
        return this.reportType;
    }
    public double getTotalGrades() {
        return this.totalGrades;
    }
    public int getNumOfStudentsSubmit() {
        return this.numOfStudentsSubmit;
    }
    public double calcAvrageOfGrades() {
        return this.totalGrades / this.numOfStudentsSubmit;
    }
    public String toString() {
        return "Report Type: "+this.reportType+"\t|\tNumber Of Students submitted "+this.reportType+": "+this.numOfStudentsSubmit+"\t|\tAvrage Of Grades: "+this.calcAvrageOfGrades();
    }
}
