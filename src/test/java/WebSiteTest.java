import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class WebSiteTest {

    @BeforeMethod
    public void initTest() {
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        open("http://rozetka.com.ua/");
    }

    @Test
    public void pageObjectWebSiteTest() throws InterruptedException {
        SiteMainPageLogic mainSite = new SiteMainPageLogic().categoriesCallingClick();

        NotebooksPageLogic notebooksPageLogic = mainSite.getNotebooksChapterAndOpenIt().findFirstNotebook();
        notebooksPageLogic.buySelectedNotebook();

        mainSite.comparePreBoughtNotebookTitle();
    }
}
