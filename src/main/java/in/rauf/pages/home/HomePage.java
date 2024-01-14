package in.rauf.pages.home;

import in.rauf.layouts.main.MainLayout;
import in.rauf.pages.task.TaskManagementPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends MainLayout {

    public static final String REDIRECT_TO_TASK_PAGE_LINK = "redirectToTaskPageLink";

    public HomePage(final PageParameters parameters) {
        super();
        add(new Link<Void>(REDIRECT_TO_TASK_PAGE_LINK) {
            @Override
            public void onClick() {
                setResponsePage(TaskManagementPage.class);
            }
        });
    }
}
