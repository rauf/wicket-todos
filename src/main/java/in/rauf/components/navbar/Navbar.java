package in.rauf.components.navbar;


import in.rauf.pages.about.AboutPage;
import in.rauf.pages.home.HomePage;
import in.rauf.pages.task.TaskManagementPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class Navbar extends Panel {

    public Navbar(String id) {
        super(id);

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

        add(new Link<Void>("taskManagementPageLink") {
            @Override
            public void onClick() {
                setResponsePage(TaskManagementPage.class);
            }
        });

    }
}
