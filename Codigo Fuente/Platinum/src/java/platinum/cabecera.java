/*
 * cabecera.java
 *
 * Created on Jul 30, 2008, 5:17:10 PM
 */
 
package platinum;

import com.sun.rave.web.ui.appbase.AbstractFragmentBean;
import com.sun.webui.jsf.component.ContentPageTitle;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.Masthead;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.servlet.http.HttpServletResponse;




/**
 * <p>Fragment bean that corresponds to a similarly named JSP page
 * fragment.  This class contains component definitions (and initialization
 * code) for all components that you have defined on this fragment, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author Martin Jara
 */
public class cabecera extends AbstractFragmentBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization. <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private Masthead masthead = new Masthead();

    public Masthead getMasthead() {
        return masthead;
    }

    public void setMasthead(Masthead m) {
        this.masthead = m;
    }
    private ContentPageTitle pageTitle = new ContentPageTitle();

    public ContentPageTitle getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(ContentPageTitle cpt) {
        this.pageTitle = cpt;
    }
    private Hyperlink hyp1 = new Hyperlink();

    public Hyperlink getHyp1() {
        return hyp1;
    }

    public void setHyp1(Hyperlink h) {
        this.hyp1 = h;
    }
    private Hyperlink hyp2 = new Hyperlink();

    public Hyperlink getHyp2() {
        return hyp2;
    }

    public void setHyp2(Hyperlink h) {
        this.hyp2 = h;
    }
    private Hyperlink hyp3 = new Hyperlink();

    public Hyperlink getHyp3() {
        return hyp3;
    }

    public void setHyp3(Hyperlink h) {
        this.hyp3 = h;
    }
    private Hyperlink hyp4 = new Hyperlink();

    public Hyperlink getHyp4() {
        return hyp4;
    }

    public void setHyp4(Hyperlink h) {
        this.hyp4 = h;
    }
    // </editor-fold>

    public cabecera() {
    }

    /**
     * <p>Callback method that is called whenever a page containing
     * this page fragment is navigated to, either directly via a URL,
     * or indirectly via page navigation.  Override this method to acquire
     * resources that will be needed for event handlers and lifecycle methods.</p>
     * 
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        
        // <editor-fold defaultstate="collapsed" desc="Visual-Web-managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here

    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called.  Override this
     * method to release resources acquired in the <code>init()</code>
     * resources that will be needed for event handlers and lifecycle methods.</p>
     * 
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public String hyp3_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

   
        return null;
    }

}
