/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.math.BigInteger;
import java.util.Date;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import py.com.platinum.controller.CajaController;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.HabilitacionCajaController;
import py.com.platinum.entity.Caja;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.HabilitacionCaja;






/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ABMCliente.java
 * @version Created on Oct 18, 2009, 8:11:57 PM
 * @author FerBoy
 */
public class RegistroAperturaCaja extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        tipoDoc1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("1", "Cedula de Identidad"), new com.sun.webui.jsf.model.Option("2", "DNI"), new com.sun.webui.jsf.model.Option("3", "Pasaporte")});
        radioButtonGroup1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("e", "Entrada"), new com.sun.webui.jsf.model.Option("s", "Salida")});
        referencia1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("1", "Orden de Trabajo"), new com.sun.webui.jsf.model.Option("2", "Venta"), new com.sun.webui.jsf.model.Option("3", "Trabajo Diario")});
    }
    private HtmlPanelGrid buttonsPanelAddUpdate = new HtmlPanelGrid();

    public HtmlPanelGrid getButtonsPanelAddUpdate() {
        return buttonsPanelAddUpdate;
    }

    public void setButtonsPanelAddUpdate(HtmlPanelGrid hpg) {
        this.buttonsPanelAddUpdate = hpg;
    }
    private Button button2 = new Button();

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button b) {
        this.button2 = b;
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private SingleSelectOptionsList tipoDoc1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getTipoDoc1DefaultOptions() {
        return tipoDoc1DefaultOptions;
    }

    public void setTipoDoc1DefaultOptions(SingleSelectOptionsList ssol) {
        this.tipoDoc1DefaultOptions = ssol;
    }
    private SingleSelectOptionsList radioButtonGroup1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getRadioButtonGroup1DefaultOptions() {
        return radioButtonGroup1DefaultOptions;
    }

    public void setRadioButtonGroup1DefaultOptions(SingleSelectOptionsList ssol) {
        this.radioButtonGroup1DefaultOptions = ssol;
    }
    private SingleSelectOptionsList referencia1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getReferencia1DefaultOptions() {
        return referencia1DefaultOptions;
    }

    public void setReferencia1DefaultOptions(SingleSelectOptionsList ssol) {
        this.referencia1DefaultOptions = ssol;
    }
    private TextField codCaja = new TextField();

    public TextField getCodCaja() {
        return codCaja;
    }

    public void setCodCaja(TextField tf) {
        this.codCaja = tf;
    }
    private TextField codEmpleado = new TextField();

    public TextField getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(TextField tf) {
        this.codEmpleado = tf;
    }
    private TextField saldo = new TextField();

    public TextField getSaldo() {
        return saldo;
    }

    public void setSaldo(TextField tf) {
        this.saldo = tf;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public RegistroAperturaCaja() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("ABMCliente Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here

    getSessionBean1().setTituloPagina("Registro de Apertura de CAJAS");
    getSessionBean1().setDetallePagina("Cobranzas");


    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }
    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    private boolean addRequest = false;
    private boolean updateRequest = false;
    private boolean errorValidacion = false;

    @Override
    public void prerender() {

        if (addRequest) {
        

        } else if (updateRequest) {

        
        } else if (errorValidacion) {
            
        

        } else {
        
        }

    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public String nuevo_action() {
        // TODO: Process the action. Return value is a navigation

        // case name where null will return to the same page.
        this.addRequest=true;
        
        return null;
    }

    public String editar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.updateRequest=true;
        return null;

    }

    public String eliminar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return null;
    }

    public String cancelar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.addRequest=false;
        this.updateRequest=false;

        return null;
    }

    public String button2_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.addRequest=false;
        this.updateRequest=false;
        this.errorValidacion=false;
        Caja caja = null;
        if (codCaja.getText() == null) {
            this.pageAlert1.setType("error");
            this.pageAlert1.setTitle("Caja ingresado incorrecto");
            this.errorValidacion=true;
        }else{
            caja = new CajaController().findById(Long.valueOf(codCaja.getText().toString()));
            if (caja == null) {
                this.pageAlert1.setType("error");
                this.pageAlert1.setTitle("Caja ingresado incorrecto");
                this.errorValidacion=true;
            }else{
                Caja[] l = getSessionBean1().getListaCajaAbierta();
                if (l == null) {
                    l = new Caja[0];
                }
             for (int i = 0; i < l.length; i++) {
                 Caja c = l[i];

                 if (c.getCodCaja() == caja.getCodCaja()) {
                     this.pageAlert1.setType("error");
                        this.pageAlert1.setTitle("Caja ingresado Esta Abierta");
                        this.errorValidacion=true;
                 }

             }
            }
        }
        Empleado e = null;
        if (codEmpleado.getText() == null) {
            this.pageAlert1.setType("error");
            this.pageAlert1.setTitle("Empleado ingresado incorrecto");
            this.errorValidacion=true;
        }else{
            e = new EmpleadoController().findById(Long.valueOf(codEmpleado.getText().toString()));
            if (e == null) {
                this.pageAlert1.setType("error");
                this.pageAlert1.setTitle("Empleado ingresado incorrecto");
                this.errorValidacion=true;
            }
        }

        
         if (!errorValidacion) {
            HabilitacionCaja h = new HabilitacionCaja();

            h.setCodCaja(caja);
            h.setCodEmpleado(e);
            h.setCodReponsable(e);
            h.setEstado("A");
            Long s = Long.valueOf("0");
             if (saldo.getText() != null) {
                s = Long.valueOf(saldo.getText().toString());
             }
            h.setMontoInicial(BigInteger.valueOf(s));
            h.setFechaAlta(new Date());
            h.setUsuarioAlta(getSessionBean1().getUsuarioLogueado().getUsuario());
            h.setFechaHabCaja(new Date());
            new HabilitacionCajaController().create(h);

            this.pageAlert1.setType("information");
                this.pageAlert1.setTitle("Caja Habilitada");
        }
             

            
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);


        return null;
    }
}

