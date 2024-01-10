package in.rauf.layouts.base;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.WebPage;

/**
 * A base layout to be used as a parent for the pages we're implementing. Common page configuration is done here.
 */
public abstract class BaseLayout extends WebPage {

    private static final String BOOTSTRAP_CSS_LINK = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css";
    private static final String BOOTSTRAP_JS_LINK = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js";

    public static final String POPPER_JS = "https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js";

    private static final String MAIN_CSS_URL = "/style.css";

    @Override
    public void renderHead(IHeaderResponse response) {
        // Add bootstrap
        response.render(CssReferenceHeaderItem.forUrl(BOOTSTRAP_CSS_LINK));
        response.render(JavaScriptReferenceHeaderItem.forUrl(BOOTSTRAP_JS_LINK));

        // Add custom CSS
        response.render(CssReferenceHeaderItem.forUrl(MAIN_CSS_URL));

        // Add Popper.js
        response.render(JavaScriptReferenceHeaderItem.forUrl(POPPER_JS));

    }

}
