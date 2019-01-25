package com.zeneo.newsapp.Activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.zeneo.newsapp.Adapter.NewsListAdapter;
import com.zeneo.newsapp.Model.News;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    int index;
    TextView textView;
    RecyclerView recyclerView;
    List<News> list = new ArrayList<>();
    NewsListAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = (RecyclerView)findViewById(R.id.akhbarlist);

        index = Integer.parseInt(getIntent().getStringExtra("index"));

        new GetNewsFromWebSites().execute();




    }
    public class GetNewsFromWebSites extends AsyncTask<Void, Void, Void> {

        String title;
        String imgurl = null;
        String medi1url= "https://www.medi1tv.ma/ar/";
        String elbotola = "https://www.elbotola.com/article/categorie/analyse/";
        String alyoum = "http://www.alyaoum24.com/";
        String akhbarona = "https://www.akhbarona.com/";
        String url;
        @Override
        protected Void doInBackground(Void... voids) {
            try {

                if (index == 0) {
                    Document document = Jsoup.connect(medi1url).get();
                    Elements sliderelement = document.getElementsByClass("panel");

                    for (int i = 0; i < sliderelement.size(); i++) {
                        title = sliderelement.get(i).getElementsByClass("titre_mav").get(0).getElementsByTag("a")
                                .get(0).text();
                        imgurl = sliderelement.get(i).getElementsByTag("img").get(0).attr("src");
                        url = "https://www.medi1tv.ma"+sliderelement.get(i).getElementsByTag("a").get(0).attr("href");
                        list.add(new News(url,title, imgurl));
                    }

                }else if (index == 1){
                    Document doc = Jsoup.connect(elbotola).get();
                    Elements articlesElements = doc.getElementsByClass("article");

                    for (int i = 0 ; i < articlesElements.size() ; i++ ){
                        title = articlesElements.get(i).getElementsByTag("h3").get(0).text();
                        imgurl = articlesElements.get(i).getElementsByTag("img").get(0).attr("src");
                        url = articlesElements.get(i).getElementsByTag("a").get(0).attr("href");
                        list.add(new News("https://www.elbotola.com"+url,title,"https:"+imgurl));
                    }

                }else if(index == 2){
                    Document doc = Jsoup.connect(alyoum).get();
                    Elements slider_items = doc.getElementsByClass("slider_items").get(0).getElementsByClass("item");

                    for (int i = 0 ;i < slider_items.size() ;i++ ){
                        title = slider_items.get(i).getElementsByClass("text_holder")
                                .get(0).getElementsByTag("a").get(0).text();
                        if(slider_items.get(i).getElementsByTag("img").size()>0){
                            imgurl = slider_items.get(i).getElementsByTag("img").get(0).attr("src");
                        }else imgurl = null;
                        url = slider_items.get(i).getElementsByTag("a").get(1).attr("href");
                        list.add(new News(url,title, imgurl));

                    }

                }else if(index == 3){
                    Document doc = Jsoup.connect(akhbarona).get();
                    Elements slider_items = doc.getElementsByClass("headline_article_holder");

                    for (int i = 0 ;i < slider_items.size() ; i++){
                        title = slider_items.get(i).getElementsByTag("img").attr("alt");
                        imgurl = slider_items.get(i).getElementsByTag("img").attr("src");
                        url = slider_items.get(i).getElementsByTag("a").get(0).attr("href");
                        list.add(new News("https://www.akhbarona.com/"+url,title, imgurl));
                    }
                }else if (index == 4){
                    Document document = Jsoup.connect("https://chouftv.ma/press").get();
                    Elements articles = document.getElementsByClass("press");
                    for (int i = 0; i < articles.size() ; i++ ){
                        title = articles.get(i).getElementsByClass("description").get(0).getElementsByTag("a").get(0).text();
                        imgurl = articles.get(i).getElementsByTag("img").get(0).attr("src");
                        url = articles.get(i).getElementsByTag("a").get(0).attr("href");
                        list.add(new News(url,title, imgurl));
                    }
                } else if(index == 5){
                    Document document = Jsoup.connect("https://www.hespress.com/").get();
                    Elements slider_articles = document.getElementsByClass("headline_article");

                    for (int i = 0; i < slider_articles.size() ; i++){
                        title = slider_articles.get(i).getElementsByTag("h1").get(0).getElementsByTag("a").text();
                        imgurl = slider_articles.get(i).getElementsByTag("img").get(0).attr("src");
                        url = slider_articles.get(i).getElementsByTag("a").get(0).attr("href");
                        list.add(new News("https://www.hespress.com"+url,title, imgurl));
                    }
                } else if(index == 6){
                    Document document = Jsoup.connect("https://ar.hibapress.com/").get();
                    Elements slider_articles = document.getElementsByClass("ei-slider-large").get(0).getElementsByTag("li");

                    for (int i = 0; i<slider_articles.size() ; i++){
                        title = slider_articles.get(i).getElementsByTag("h2").get(0).getElementsByTag("a").text();
                        imgurl = slider_articles.get(i).getElementsByTag("img").get(0).attr("src");
                        url = slider_articles.get(i).getElementsByTag("a").get(0).attr("href");
                        list.add(new News(url,title, imgurl));
                    }
                } else if (index == 7){
                    Document document = Jsoup.connect("https://lakome2.com/").get();
                    Elements slider_articles = document.getElementsByClass("carousel-content item");
                    for (int i = 0; i<slider_articles.size() ; i++){
                        title = slider_articles.get(i).getElementsByTag("h2").get(0).text();
                        imgurl = slider_articles.get(i).getElementsByTag("img").get(0).attr("src");
                        url = slider_articles.get(i).getElementsByTag("a").get(0).attr("href");
                        list.add(new News(url,title, imgurl));
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            myAdapter = new NewsListAdapter(list,getApplicationContext());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(myAdapter);

        }
    }


}
