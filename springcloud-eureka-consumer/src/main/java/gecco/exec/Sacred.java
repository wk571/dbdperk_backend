package gecco.exec;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.List;

@Gecco(matchUrl="https://deadbydaylight.fandom.com/zh/wiki/Dead_by_Daylight_Wiki", pipelines={"sacredPipeline"})
@Component
public class Sacred implements HtmlBean {

    @Request
    private HttpRequest request;

    @HtmlField(cssPath = "#fpflexsection > div:nth-child(1) > center > table > tbody > tr[style~=text] > td:nth-child(2) > a")
    public List<String> scaredPerks;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<String> getScaredPerks() {
        return scaredPerks;
    }

    public void setScaredPerks(List<String> scaredPerks) {
        this.scaredPerks = scaredPerks;
    }

    @Test
    public void run() {

        GeccoEngine.create()
                //Gecco搜索的包路径
                .classpath("gecco")
                //开始抓取的页面地址
                .start("https://deadbydaylight.fandom.com/zh/wiki/Dead_by_Daylight_Wiki")
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                .run();
    }
}
