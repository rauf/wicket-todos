package in.rauf.layouts.main;

import in.rauf.components.footer.Footer;
import in.rauf.components.navbar.Navbar;
import in.rauf.layouts.base.BaseLayout;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * The main layout including navbar and footer.
 */
public abstract class MainLayout extends BaseLayout {

    public static final String ID_NAVBAR = "navbar";
    public static final String ID_FOOTER = "footer";

    public MainLayout() {
        initialize();
    }

    public MainLayout(PageParameters parameters) {
        super(parameters);
        initialize();
    }

    void initialize() {
        var navbar = new Navbar(ID_NAVBAR);
        var footer = new Footer(ID_FOOTER);
        add(navbar);
        add(footer);
    }

}
