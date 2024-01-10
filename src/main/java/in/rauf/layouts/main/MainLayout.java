package in.rauf.layouts.main;

import in.rauf.layouts.base.BaseLayout;
import in.rauf.pages.about.AboutPage;
import in.rauf.pages.home.HomePage;
import org.apache.wicket.markup.html.link.Link;

/**
 * The main layout including navbar and footer.
 */
public abstract class MainLayout extends BaseLayout {

    public MainLayout() {
        add(new Link<Void>("homePageLink") {
            @Override
            public void onClick() {
                setResponsePage(HomePage.class);
            }
        });

        add(new Link<Void>("aboutPageLink") {
            @Override
            public void onClick() {
                setResponsePage(AboutPage.class);
            }
        });
    }

}
