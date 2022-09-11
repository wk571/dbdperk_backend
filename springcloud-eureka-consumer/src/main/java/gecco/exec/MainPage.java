package gecco.exec;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

@Gecco(matchUrl="http://www.shajiwiki.com/survivorsPerkInformation.html", pipelines={"perkPipeline"})
public class MainPage implements HtmlBean {
    @Request
    private HttpRequest request;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    @HtmlField(cssPath = ".L2tab .L2tabText .textTitle")
    public List<String> titles;

    @HtmlField(cssPath = ".L2tab .L2tabText .textExplain")
    public List<String> descriptions;

    @Image({"src"})
    @HtmlField(cssPath = ".mainTab > a .perkIconDefault")
    public List<String> images;

    @HtmlField(cssPath = ".L2tab .L2tabText .textSubtitle")
    public List<String> resources;

    public List<String> getResources() {
        return resources;
    }

    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public static void main(String[] args) {

        GeccoEngine.create()
                //Gecco搜索的包路径
                .classpath("gecco")
                //开始抓取的页面地址
                .start("http://www.shajiwiki.com/survivorsPerkInformation.html")
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                .run();
    }
}
