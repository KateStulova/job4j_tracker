package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report1 = new TextReport();
        String text1 = report1.generate("Report's name", "Report's body");
        System.out.println(text1);
        HtmlReport report2 = new HtmlReport();
        String text2 = report2.generate("Report's name", "Report's body");
        System.out.println(text2);
        JSONReport report3 = new JSONReport();
        String text3 = report3.generate("Report's name", "Report's body");
        System.out.println(text3);
    }
}
