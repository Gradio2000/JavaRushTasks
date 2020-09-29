package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HHStrategy implements Strategy{
//    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?area=1&clusters=true&enable_snippets=true&text=java+%s&page=%d";
//    private static final String URL_FORMAT = "https://grc.ua/search/vacancy?text=java+%s&page=%d";
//    private static final String URL_FORMAT = "https://grc.ua/search/vacancy?L_is_autosearch=false&clusters=true&enable_snippets=true&text=java+%s&page=%d";
//    private static final String URL_FORMAT = "hhttp://javarush.ru/testdata/big28data.html";
      private static final String   URL_FORMAT =  "http://hh.ua/search/vacancy?text=java+%s&page=%d";


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        Document document;
        int page = 0;
        while (true) {
            try {
                document = getDocument(searchString, page);
                Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.size() == 0) break;
                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                    vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                    vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                    vacancy.setSalary(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                    vacancy.setSiteName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                    Pattern pattern = Pattern.compile(".+?\\/");
                    Matcher matcher = pattern.matcher(URL_FORMAT);
                    String url = "";
                    for (int i = 0; i < 2; i++) {
                        matcher.find();
                        url = url + matcher.group();
                    }
                    vacancy.setSiteName(url);
                    vacancies.add(vacancy);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            page++;
        }
        return vacancies;
    }


    protected Document getDocument(String searchString, int page) throws IOException{
        Document doc;
            doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36 OPR/70.0.3728.106")
                    .referrer("")
                    .get();
        return doc;
    }
}