package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View{
    Controller controller;

    private final String filePath =
            "./4.JavaCollections/src/"
            + this.getClass().getPackage().getName().replace('.', '/')
            + "/vacancies.html";
    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            String htmlText = getUpdatedFileContent(vacancies);
            updateFile(htmlText);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Dnepropetrovsk");
    }

    private String getUpdatedFileContent(List<Vacancy> list) throws IOException {
        Document document = null;
        try {
            document = getDocument();

            Element element = document.getElementsByClass("template").first();
            Element element1 = element.clone();
            element1.removeAttr("style");
            element1.removeClass("template");
            document.select("tr[class=vacancy]").remove();


            for (Vacancy vacancy : list){
                Element element2 = element1.clone();
                element2.getElementsByClass("city").first().text(vacancy.getCity());
                element2.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                element2.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element title = element2.select("a[href=url]")
                        .first()
                        .attr("href", vacancy.getUrl())
                        .text(vacancy.getTitle());
                element.before(element2.outerHtml());

            }
        } catch (Exception e){
            e.printStackTrace();
            return "Some exception occurred";
        }

        return document.html();
    }


    private void updateFile(String htmlText){
        try {
            FileWriter fileWriter = new FileWriter(filePath, false);
            fileWriter.write(htmlText);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        String result = "";
        while ((line = reader.readLine()) != null){
            result = result + line;
        }
        return Jsoup.parse(result);
    }
}
