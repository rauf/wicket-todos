package in.rauf.components.navbar;


import in.rauf.pages.about.AboutPage;
import in.rauf.pages.home.HomePage;
import in.rauf.pages.task.TaskManagementPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class Navbar extends Panel {

    public static final String LINK_HOME_PAGE = "homePageLink";
    public static final String LINK_ABOUT_PAGE = "aboutPageLink";
    public static final String LINK_TASK_MANAGEMENT_PAGE = "taskManagementPageLink";

    public Navbar(String id) {
        super(id);

        add(new Link<Void>(LINK_HOME_PAGE) {
            @Override
            public void onClick() {
                setResponsePage(HomePage.class);
            }
        });

        add(new Link<Void>(LINK_ABOUT_PAGE) {
            @Override
            public void onClick() {
                setResponsePage(AboutPage.class);
            }
        });

        add(new Link<Void>(LINK_TASK_MANAGEMENT_PAGE) {
            @Override
            public void onClick() {
                setResponsePage(TaskManagementPage.class);
            }
        });

    }
}
