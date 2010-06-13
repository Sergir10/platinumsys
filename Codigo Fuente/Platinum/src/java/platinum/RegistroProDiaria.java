/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.OrdenTrabajoCabeceraController;
import py.com.platinum.controller.OrdenTrabajoDetalleController;
import py.com.platinum.controller.ProduccionDiariaController;
import py.com.platinum.controller.TareaAsignadaController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.ProduccionDiaria;
import py.com.platinum.entity.TareaAsignada;
import py.com.platinum.utils.StringUtils;






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
public class RegistroProDiaria extends AbstractPageBean {
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
    private TextField uiSemiTerNombre = new TextField();

    public TextField getUiSemiTerNombre() {
        return uiSemiTerNombre;
    }

    public void setUiSemiTerNombre(TextField tf) {
        this.uiSemiTerNombre = tf;
    }
    private TextField uiSemiTerCod = new TextField();

    public TextField getUiSemiTerCod() {
        return uiSemiTerCod;
    }

    public void setUiSemiTerCod(TextField tf) {
        this.uiSemiTerCod = tf;
    }
    private TextArea uiOTDescripcion = new TextArea();

    public TextArea getUiOTDescripcion() {
        return uiOTDescripcion;
    }

    public void setUiOTDescripcion(TextArea ta) {
        this.uiOTDescripcion = ta;
    }
    private Calendar uiFechaAct = new Calendar();

    public Calendar getUiFechaAct() {
        return uiFechaAct;
    }

    public void setUiFechaAct(Calendar c) {
        this.uiFechaAct = c;
    }
    private DropDown uiEmpleado = new DropDown();

    public DropDown getUiEmpleado() {
        return uiEmpleado;
    }

    public void setUiEmpleado(DropDown dd) {
        this.uiEmpleado = dd;
    }
    private TextField uiDetCodTarea = new TextField();

    public TextField getUiDetCodTarea() {
        return uiDetCodTarea;
    }

    public void setUiDetCodTarea(TextField tf) {
        this.uiDetCodTarea = tf;
    }
    private TextField uiDetDescTarea = new TextField();

    public TextField getUiDetDescTarea() {
        return uiDetDescTarea;
    }

    public void setUiDetDescTarea(TextField tf) {
        this.uiDetDescTarea = tf;
    }
    private TextField uiCabNroOT = new TextField();

    public TextField getUiCabNroOT() {
        return uiCabNroOT;
    }

    public void setUiCabNroOT(TextField tf) {
        this.uiCabNroOT = tf;
    }
    private TextField uiDetCodTareaAsig = new TextField();

    public TextField getUiDetCodTareaAsig() {
        return uiDetCodTareaAsig;
    }

    public void setUiDetCodTareaAsig(TextField tf) {
        this.uiDetCodTareaAsig = tf;
    }
    private TextField uiDetCantidad = new TextField();

    public TextField getUiDetCantidad() {
        return uiDetCantidad;
    }

    public void setUiDetCantidad(TextField tf) {
        this.uiDetCantidad = tf;
    }
    private TextField uiDetTiempo = new TextField();

    public TextField getUiDetTiempo() {
        return uiDetTiempo;
    }

    public void setUiDetTiempo(TextField tf) {
        this.uiDetTiempo = tf;
    }
    private Table tablaTareas = new Table();

    public Table getTablaTareas() {
        return tablaTareas;
    }

    public void setTablaTareas(Table t) {
        this.tablaTareas = t;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public RegistroProDiaria() {
    cargarListaTodosOts();
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
    getSessionBean1().setDetallePagina("Detalles de Tareas en Produccion");

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


    private List<ProduccionDiaria> produccionesDiarias = new ArrayList();

    public List<ProduccionDiaria> getProduccionesDiarias() {
        return produccionesDiarias;
    }

    public void setProduccionesDiarias(List<ProduccionDiaria> produccionesDiarias) {
        this.produccionesDiarias = produccionesDiarias;
    }

    public ProduccionDiaria[] getProduccionesDiariasArray() {
        return produccionesDiariasArray;
    }

    public void setProduccionesDiariasArray(ProduccionDiaria[] produccionesDiariasArray) {
        this.produccionesDiariasArray = produccionesDiariasArray;
    }




    private ProduccionDiaria[] produccionesDiariasArray = new ProduccionDiaria[0];

    @Override
    public void prerender() {

        if (addRequest) {

            this.gridPanelCabecera.setRendered(true);
//            this.gridPanelBusqueda.setRendered(false);
            this.gridPannelDetalle.setRendered(true);
            
        } else if (updateRequest) {
            this.gridPanelCabecera.setRendered(true);
//            this.gridPanelBusqueda.setRendered(false);
            this.gridPannelDetalle.setRendered(true);
            
        }


    getSessionBean1().setTituloPagina("Registro de Produccion Diaria");
    getSessionBean1().setDetallePagina("Detalles de Tareas en Produccion");


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

    public OrdenTrabajoDetalle[] getOrdenTrabajoDetalleArray() {
        return ordenTrabajoDetalleArray;
    }

    public void setOrdenTrabajoDetalleArray(OrdenTrabajoDetalle[] ordenTrabajoDetalleArray) {
        this.ordenTrabajoDetalleArray = ordenTrabajoDetalleArray;
    }

    public List<OrdenTrabajoDetalle> getOrdenTrabajoDetalles() {
        return ordenTrabajoDetalles;
    }

    public void setOrdenTrabajoDetalles(List<OrdenTrabajoDetalle> ordenTrabajoDetalles) {
        this.ordenTrabajoDetalles = ordenTrabajoDetalles;
    }

    
    List<TareaAsignada>  tareasAsignadas = new ArrayList();
    TareaAsignada[]  tareasAsignadasArray = new TareaAsignada[0];

    public List<TareaAsignada> getTareasAsignadas() {
        return tareasAsignadas;
    }

    public void setTareasAsignadas(List<TareaAsignada> tareasAsignadas) {
        this.tareasAsignadas = tareasAsignadas;
    }

    public TareaAsignada[] getTareasAsignadasArray() {
        return tareasAsignadasArray;
    }

    public void setTareasAsignadasArray(TareaAsignada[] tareasAsignadasArray) {
        this.tareasAsignadasArray = tareasAsignadasArray;
    }

//    public void uiCabOTNro_validate(FacesContext fc, UIComponent uic, Object o) {
//     OrdenTrabajoDetalleController ordenTrabajoDetalleController = new OrdenTrabajoDetalleController();
//        ordenTrabajoDetalles = ordenTrabajoDetalleController.getAllFiltered(Long.valueOf(o.toString()), null,null);
//        ordenTrabajoDetalleArray = (OrdenTrabajoDetalle[]) ordenTrabajoDetalles.toArray(new OrdenTrabajoDetalle[0]);
//        getSessionBean1().setOrdenTrabajoDetalleArray(ordenTrabajoDetalleArray);
//
//
//        System.out.println("*********************");
//        System.out.println(ordenTrabajoDetalles.size());
//    }

    public void uiCabNroOT_validate(FacesContext context, UIComponent component, Object value) {

        OrdenTrabajoDetalleController ordenTrabajoDetalleController = new OrdenTrabajoDetalleController();
        getSessionBean1().setIdOTProdDiaria(Long.valueOf(value.toString()));
        ordenTrabajoDetalles = ordenTrabajoDetalleController.getAllFiltered(Long.valueOf(value.toString()), null,null);
        ordenTrabajoDetalleArray = (OrdenTrabajoDetalle[]) ordenTrabajoDetalles.toArray(new OrdenTrabajoDetalle[0]);
        getSessionBean1().setOrdenTrabajoDetalleArray(ordenTrabajoDetalleArray);
        this.uiSemiTerCod.setText(value);
        this.uiSemiTerNombre.setText(value);
        limpiarDetalle();
        

        System.out.println("*********************");
        System.out.println(ordenTrabajoDetalles.size());

    }
    


    public void uiSemiTerCod_validate(FacesContext context, UIComponent component, Object value) {
        this.pageAlert1.setRendered(false);
        getSessionBean1().setIdOTDetProdDiaria(Long.valueOf(value.toString()));
        TareaAsignadaController tareaAsignadaController = new TareaAsignadaController();
        tareasAsignadas = tareaAsignadaController.getAllFiltered(Long.valueOf(value.toString()), null, null);
        tareasAsignadasArray = (TareaAsignada[]) tareasAsignadas.toArray(new TareaAsignada[0]);

        ProduccionDiariaController produccionDiariaController = new ProduccionDiariaController();
        produccionesDiarias = produccionDiariaController.getAllFiltered(null,null,Long.valueOf(value.toString()), null);
        produccionesDiariasArray = (ProduccionDiaria[]) produccionesDiarias.toArray(new ProduccionDiaria[0]);
        limpiarDetalle();

        getSessionBean1().setTareasAsignadasArray(tareasAsignadasArray);
      

    }

    public String uiButtonAgregarTarea_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
         this.pageAlert1.setRendered(false);
         validarCampos();

         if (!errorValidacion) {
                        ControllerResult controllerResult = new ControllerResult();
                        ProduccionDiaria produccionDiaria = new ProduccionDiaria();
                        ProduccionDiariaController produccionDiariaController = new ProduccionDiariaController();
                        TareaAsignadaController tareaAsignadaController = new TareaAsignadaController();

                        produccionDiaria.setCodTareaAsignada(tareaAsignadaController.findById(Long.valueOf(this.uiDetCodTareaAsig.getText().toString())));
                        produccionDiaria.setCodEmpleado(new EmpleadoController().findById(Long.valueOf(this.uiEmpleado.getSelected().toString())));
                        produccionDiaria.setCantidad(Long.valueOf(this.uiDetCantidad.getText().toString()));
                        produccionDiaria.setTiempoInvertido(Long.valueOf(this.uiDetTiempo.getText().toString()));
                        produccionDiaria.setFecha(this.uiFechaAct.getSelectedDate());

                        produccionesDiarias.add(produccionDiaria);
                        produccionesDiariasArray = (ProduccionDiaria[]) produccionesDiarias.toArray(new ProduccionDiaria[0]);
                        controllerResult = produccionDiariaController.create(produccionDiaria);

                         if (controllerResult.getCodRetorno() ==-1) {
                                        this.pageAlert1.setType("error");
                                    } else {
                                        this.pageAlert1.setType("information");
                                        limpiarDetalle();
                                    }

                            this.pageAlert1.setTitle(controllerResult.getMsg());
                            this.pageAlert1.setSummary("");
                            this.pageAlert1.setDetail("");
                            this.pageAlert1.setRendered(true);
        }
       
        return null;
    }

    public void limpiarDetalle(){

            this.uiDetCantidad.setText("");
            this.uiDetCodTarea.setText("");
            this.uiDetCodTareaAsig.setText("");
            this.uiDetTiempo.setText("");
            this.uiDetDescTarea.setText("");

}

private boolean validarCampos(){
         errorValidacion = false;

            

         if (this.uiDetCodTarea.getText() == null ||
                    this.uiDetCodTarea.getText().toString() == null ||
                    this.uiDetCodTarea.getText().toString().equals("")){
                        errorValidacion = true;
                       this.info("Debe seleccionar una tarea");
                }

//         if (this.uiDetDescTarea.getText() == null ||
//                    this.uiDetDescTarea.getText().toString() == null ||
//                    this.uiDetDescTarea.getText().toString().equals("")){
//                        errorValidacion = true;
//                       this.info("Verifique el codigo de la tarea");
//                }

         if (this.uiFechaAct.getSelectedDate() == null 
                 //|| this.uiFechaAct.getSelectedDate().getTime() < new Date()
                 )
                {
                        errorValidacion = true;
                        this.info("Verifique el valor de la Fecha");
                }


         if (this.uiDetCantidad.getText() == null ||
                   !StringUtils.esNumero(this.uiDetCantidad.getText().toString()))
                        {   errorValidacion = true;
                            this.info("Verifique la cantidad");
                        }

         if (this.uiDetTiempo.getText() == null ||
                    !StringUtils.esNumero(this.uiDetTiempo.getText().toString()))
                        {   errorValidacion = true;
                            this.info("Verifique el tiempo");
                        }

                 return errorValidacion;

}

////// CARGA DE COMBO BOX DE ORDEN TRABAJO
    OrdenTrabajoDetalle[] listaOts;
    Option[] listaOtsOp;

    public Option[] getlistaOtsOp() {
        return listaOtsOp;
    }

    public void setlistaOtsOp(Option[] listaOtsOp) {
        this.listaOtsOp = listaOtsOp;
    }

    public OrdenTrabajoDetalle[] listaOts() {
        return listaOts;
    }

    public void setlistaOts(OrdenTrabajoDetalle[] listaOts) {
        this.listaOts = listaOts;
    }

    public void cargarListaTodosOts() {
        OrdenTrabajoDetalleController otController = new OrdenTrabajoDetalleController();
        listaOts = (OrdenTrabajoDetalle[]) otController.getAll("codOrdenTrabajoDet").toArray(new OrdenTrabajoDetalle[0]);
        listaOtsOp = new Option[listaOts.length];
        Option option;
        for (int i = 0; i < listaOts.length; i++) {
            OrdenTrabajoDetalle p = listaOts[i];
            option = new Option();
            //            if (p.getEstado().toString().equals("P")) {
            //            }
            option.setLabel(p.getCodOrdenTrabajoDet().toString()+" "+p.getCodProducto().getDescripcion());
            option.setValue(p.getCodOrdenTrabajoDet().toString());
            listaOtsOp[i] = option;
        }
    }

    public void uiCodSubOt_validate(FacesContext context, UIComponent component, Object value) {
        OrdenTrabajoDetalle ordenTrabajoDetalle = new OrdenTrabajoDetalleController().findById(Long.valueOf(value.toString()));
            this.uiOTDescripcion.setText(ordenTrabajoDetalle.getCodOrdenTrabajo().getDescripcion().toString());
            this.uiCabNroOT.setText(ordenTrabajoDetalle.getCodOrdenTrabajo().getCodOrdenTrabjo().toString());
            this.uiSemiTerCod.setText(ordenTrabajoDetalle.getCodOrdenTrabajoDet().toString());
            this.uiSemiTerNombre.setText(ordenTrabajoDetalle.getCodProducto().getDescripcion().toString());

             this.pageAlert1.setRendered(false);
        getSessionBean1().setIdOTDetProdDiaria(Long.valueOf(value.toString()));
        TareaAsignadaController tareaAsignadaController = new TareaAsignadaController();
        tareasAsignadas = tareaAsignadaController.getAllFiltered(Long.valueOf(value.toString()), null, null);
        tareasAsignadasArray = (TareaAsignada[]) tareasAsignadas.toArray(new TareaAsignada[0]);

        ProduccionDiariaController produccionDiariaController = new ProduccionDiariaController();
        produccionesDiarias = produccionDiariaController.getAllFiltered(null,null,Long.valueOf(value.toString()), null);
        produccionesDiariasArray = (ProduccionDiaria[]) produccionesDiarias.toArray(new ProduccionDiaria[0]);
        limpiarDetalle();

        getSessionBean1().setTareasAsignadasArray(tareasAsignadasArray);



    }



}

