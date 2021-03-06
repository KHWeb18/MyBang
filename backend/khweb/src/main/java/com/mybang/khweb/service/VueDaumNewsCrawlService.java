package com.mybang.khweb.service;


import com.mybang.khweb.entity.DaumNews;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public interface VueDaumNewsCrawlService {
    public Document connectUrl(String url);
    public List<DaumNews> daumNewsFindAll();
    public void daumNewsMainCrawler(String category);
    public void daumNewsCrawling(Elements elements, String category);
}