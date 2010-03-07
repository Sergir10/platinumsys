/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.OrdenTrabajoCabeceraController;
import py.com.platinum.controller.OrdenTrabajoDetalleController;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.OrdenTrabajoDetalle;






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
public class RegistroProDiaria_1 extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        tipoDoc1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("1", "Cedula de Identidad"), new com.sun.webui.jsf.model.Option("2", "DNI"), new com.sun.webui.jsf.model.Option("3", "Pasaporte")});
        radioButtonGroup1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("e", "Entrada"), new com.sun.webui.jsf.model.Option("s", "Salida")});
        deposito2DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("1", "Deposito Central"), new com.sun.webui.jsf.model.Option("2", "Deposito 2"), new com.sun.webui.jsf.model.Option("3", "Deposito 3")});
        referencia1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("1", "Orden de Trabajo"), new com.sun.webui.jsf.model.Option("2", "Venta"), new com.sun.webui.jsf.model.Option("3", "Trabajo Diario")});
    }
    private StaticText detalleProduccion = new StaticText();

    public StaticText getDetalleProduccion() {
        return detalleProduccion;
    }

    public void setDetalleProduccion(StaticText st) {
        this.detalleProduccion = st;
    }
    private HtmlPanelGrid gridPanelAddUpdate = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelAddUpdate() {
        return gridPanelAddUpdate;
    }

    public void setGridPanelAddUpdate(HtmlPanelGrid hpg) {
        this.gridPanelAddUpdate = hpg;
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
    private SingleSelectOptionsList deposito2DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDeposito2DefaultOptions() {
        return deposito2DefaultOptions;
    }

    public void setDeposito2DefaultOptions(SingleSelectOptionsList ssol) {
        this.deposito2DefaultOptions = ssol;
    }
    private SingleSelectOptionsList referencia1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getReferencia1DefaultOptions() {
        return referencia1DefaultOptions;
    }

    public void setReferencia1DefaultOptions(SingleSelectOptionsList ssol) {
        this.referencia1DefaultOptions = ssol;
    }
    private DefaultTableDataProvider defaultTableDataProvider = new DefaultTableDataProvider();

    public DefaultTableDataProvider getDefaultTableDataProvider() {
        return defaultTableDataProvider;
    }

    public void setDefaultTableDataProvider(DefaultTableDataProvider dtdp) {
        this.defaultTableDataProvider = dtdp;
    }
    private HtmlPanelGrid gridPanelBusqueda = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBusqueda() {
        return gridPanelBusqueda;
    }

    public void setGridPanelBusqueda(HtmlPanelGrid hpg) {
        this.gridPanelBusqueda = hpg;
    }
    private HtmlPanelGrid gridPanelCabecera = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelCabecera() {
        return gridPanelCabecera;
    }

    public void setGridPanelCabecera(HtmlPanelGrid hpg) {
        this.gridPanelCabecera = hpg;
    }
    private HtmlPanelGrid gridPannelDetalle = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPannelDetalle() {
        return gridPannelDetalle;
    }

    public void setGridPannelDetalle(HtmlPanelGrid hpg) {
        this.gridPannelDetalle = hpg;
    }
    private TextField uiOTNro = new TextField();

    public TextField getUiOTNro() {
        return uiOTNro;
    }

    public void setUiOTNro(TextField tf) {
        this.uiOTNro = tf;
    }
    private SingleSelectOptionsList dropDown1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDropDown1DefaultOptions() {
        return dropDown1DefaultOptions;
    }

    public void setDropDown1DefaultOptions(SingleSelectOptionsList ssol) {
        this.dropDown1DefaultOptions = ssol;
    }
    private TextField uiTarCod = new TextField();

    public TextField getUiTarCod() {
        return uiTarCod;
    }

    public void setUiTarCod(TextField tf) {
        this.uiTarCod = tf;
    }
    private TextField uiTarDesc = new TextField();

    public TextField getUiTarDesc() {
        return uiTarDesc;
    }

    public void setUiTarDesc(TextField tf) {
        this.uiTarDesc = tf;
    }
    private TextField uiTarCant = new TextField();

    public TextField getUiTarCant() {
        return uiTarCant;
    }

    public void setUiTarCant(TextField tf) {
        this.uiTarCant = tf;
    }
    private TextField uiTarTiempo = new TextField();

    public TextField getUiTarTiempo() {
        return uiTarTiempo;
    }

    public void setUiTarTiempo(TextField tf) {
        this.uiTarTiempo = tf;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public RegistroProDiaria_1() {
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

    getSessionBean1().setTituloPagina("Registro de Produccion Diaria");
    getSessionBean1().setDetallePagina("Dpto de Produccion");


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
            this.gridPanelCabecera.setRendered(true);
            this.gridPanelBusqueda.setRendered(false);
            this.gridPannelDetalle.setRendered(true);
            
        } else if (updateRequest) {
            this.gridPanelCabecera.setRendered(true);
            this.gridPanelBusqueda.setRendered(false);
            this.gridPannelDetalle.setRendered(true);
            
        
        } else if (errorValidacion) {
            this.gridPanelCabecera.setRendered(false);
            this.gridPanelBusqueda.setRendered(true);
            this.gridPannelDetalle.setRendered(false);
            
        } else {

            this.gridPanelCabecera.setRendered(false);
            this.gridPanelBusqueda.setRendered(true);
            this.gridPannelDetalle.setRendered(false);
            
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
        this.errorValidacion=true;
                      

            this.pageAlert1.setType("error");
            this.pageAlert1.setTitle("Error en la Validacion de los Campos, favor verificar y volver a intentar");
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);


        return null;
    }

    public String button1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return null;
    }

    public String buttonNuevo_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.addRequest = true;
        this.updateRequest = false;
        this.errorValidacion = false;
        return null;
    }

    public String buttonEditar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.addRequest = false;
        this.updateRequest = true;
        this.errorValidacion = false;
        return null;
    }

    public String tarea_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    List<OrdenTrabajoDetalle>  ordenTrabajoDetalles = new ArrayList();
    OrdenTrabajoDetalle[]  ordenTrabajoDetalleArray = new OrdenTrabajoDetalle[0];



    public void uiOTNro_validate(FacesContext context, UIComponent component, Object value) {
        OrdenTrabajoDetalleController ordenTrabajoDetalleController = new OrdenTrabajoDetalleController();
        ordenTrabajoDetalles = ordenTrabajoDetalleController.getAllFiltered(Long.valueOf(value.toString()), null,null);
        ordenTrabajoDetalleArray = (OrdenTrabajoDetalle[]) ordenTrabajoDetalles.toArray(new OrdenTrabajoDetalle[0]);
        System.out.println("*********************");
        System.out.println(ordenTrabajoDetalles.size());

    }
}

