/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.Date;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.OrdenTrabajoDetalleController;
import py.com.platinum.controller.PerdidaController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.Perdida;
import py.com.platinum.entity.Producto;
import py.com.platinum.utils.StringUtils;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version Usuario.java
 * @version Created on 20-ago-2009, 19:25:56
 * @author MartinJara
 */
public class ABMPerdidasProduccion extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private HtmlPanelGrid mainContainer = new HtmlPanelGrid();

    public HtmlPanelGrid getMainContainer() {
        return mainContainer;
    }

    public void setMainContainer(HtmlPanelGrid hpg) {
        this.mainContainer = hpg;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private Button uiNuevoButton = new Button();

    public Button getUiNuevoButton() {
        return uiNuevoButton;
    }

    public void setUiNuevoButton(Button b) {
        this.uiNuevoButton = b;
    }
    private Button uiEditarButton = new Button();

    public Button getUiEditarButton() {
        return uiEditarButton;
    }

    public void setUiEditarButton(Button b) {
        this.uiEditarButton = b;
    }
    private Button uiBorrarButon = new Button();

    public Button getUiBorrarButon() {
        return uiBorrarButon;
    }

    public void setUiBorrarButon(Button b) {
        this.uiBorrarButon = b;
    }
    private HtmlPanelGrid addUpdatePanel = new HtmlPanelGrid();

    public HtmlPanelGrid getAddUpdatePanel() {
        return addUpdatePanel;
    }

    public void setAddUpdatePanel(HtmlPanelGrid hpg) {
        this.addUpdatePanel = hpg;
    }
    private TextField uiResponsableNombre = new TextField();

    public TextField getUiResponsableNombre() {
        return uiResponsableNombre;
    }

    public void setUiResponsableNombre(TextField tf) {
        this.uiResponsableNombre = tf;
    }
    private TextField emailAddressField = new TextField();

    public TextField getEmailAddressField() {
        return emailAddressField;
    }

    public void setEmailAddressField(TextField tf) {
        this.emailAddressField = tf;
    }
    private Button addRecordButton = new Button();

    public Button getAddRecordButton() {
        return addRecordButton;
    }

    public void setAddRecordButton(Button b) {
        this.addRecordButton = b;
    }
    private Button updateRecordButton = new Button();

    public Button getUpdateRecordButton() {
        return updateRecordButton;
    }

    public void setUpdateRecordButton(Button b) {
        this.updateRecordButton = b;
    }
    private Button cancelButton = new Button();

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button b) {
        this.cancelButton = b;
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private TextField userNameFiltro = new TextField();

    public TextField getUserNameFiltro() {
        return userNameFiltro;
    }

    public void setUserNameFiltro(TextField tf) {
        this.userNameFiltro = tf;
    }
    private Button uiBuscarButton = new Button();

    public Button getUiBuscarButton() {
        return uiBuscarButton;
    }

    public void setUiBuscarButton(Button b) {
        this.uiBuscarButton = b;
    }
    private Button uiTodosButton = new Button();

    public Button getUiTodosButton() {
        return uiTodosButton;
    }

    public void setUiTodosButton(Button b) {
        this.uiTodosButton = b;
    }
    
    private Table perdidas = new Table();

    public Table getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(Table t) {
        this.perdidas = t;
    }
    private HtmlPanelGrid gridPanelBuscar = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBuscar() {
        return gridPanelBuscar;
    }

    public void setGridPanelBuscar(HtmlPanelGrid hpg) {
        this.gridPanelBuscar = hpg;
    }
    private HtmlPanelGrid buttonPanel = new HtmlPanelGrid();

    public HtmlPanelGrid getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(HtmlPanelGrid hpg) {
        this.buttonPanel = hpg;
    }
    private HtmlPanelGrid gridPanel1 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel1() {
        return gridPanel1;
    }

    public void setGridPanel1(HtmlPanelGrid hpg) {
        this.gridPanel1 = hpg;
    }
    private Calendar uiFecha = new Calendar();

    public Calendar getUiFecha() {
        return uiFecha;
    }

    public void setUiFecha(Calendar c) {
        this.uiFecha = c;
    }
    private TextArea uiDescProd = new TextArea();

    public TextArea getUiDescProd() {
        return uiDescProd;
    }

    public void setUiDescProd(TextArea ta) {
        this.uiDescProd = ta;
    }
    private TextField uiProductoCod = new TextField();

    public TextField getUiProductoCod() {
        return uiProductoCod;
    }

    public void setUiProductoCod(TextField tf) {
        this.uiProductoCod = tf;
    }
    private TextField uiProductoDesc = new TextField();

    public TextField getUiProductoDesc() {
        return uiProductoDesc;
    }

    public void setUiProductoDesc(TextField tf) {
        this.uiProductoDesc = tf;
    }
    private TextField uiCantidad = new TextField();

    public TextField getUiCantidad() {
        return uiCantidad;
    }

    public void setUiCantidad(TextField tf) {
        this.uiCantidad = tf;
    }
    private TextArea uiObservacion = new TextArea();

    public TextArea getUiObservacion() {
        return uiObservacion;
    }

    public void setUiObservacion(TextArea ta) {
        this.uiObservacion = ta;
    }
    private TableColumn tableColumn2 = new TableColumn();

    public TableColumn getTableColumn2() {
        return tableColumn2;
    }

    public void setTableColumn2(TableColumn tc) {
        this.tableColumn2 = tc;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private DropDown uiNroOt = new DropDown();

    public DropDown getUiNroOt() {
        return uiNroOt;
    }

    public void setUiNroOt(DropDown dd) {
        this.uiNroOt = dd;
    }
    private TextField uiResponsableCod = new TextField();

    public TextField getUiResponsableCod() {
        return uiResponsableCod;
    }

    public void setUiResponsableCod(TextField tf) {
        this.uiResponsableCod = tf;
    }
    private TextField uiCodOtFil = new TextField();

    public TextField getUiCodOtFil() {
        return uiCodOtFil;
    }

    public void setUiCodOtFil(TextField tf) {
        this.uiCodOtFil = tf;
    }
    private DropDown uiResponsableFil = new DropDown();

    public DropDown getUiResponsableFil() {
        return uiResponsableFil;
    }

    public void setUiResponsableFil(DropDown dd) {
        this.uiResponsableFil = dd;
    }
    private Calendar uiFecha1Fil = new Calendar();

    public Calendar getUiFecha1Fil() {
        return uiFecha1Fil;
    }

    public void setUiFecha1Fil(Calendar c) {
        this.uiFecha1Fil = c;
    }
    private Calendar uiFecha2Fil = new Calendar();

    public Calendar getUiFecha2Fil() {
        return uiFecha2Fil;
    }

    public void setUiFecha2Fil(Calendar c) {
        this.uiFecha2Fil = c;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMPerdidasProduccion() {
    cargarListaTodosOts();
    cargarListaTodosPerdidas();
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
            log("Usuario Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        getSessionBean1().setTituloPagina("Facturas Compras");
        getSessionBean1().setDetallePagina("Registro de Facturas - Proveedor");

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
    @Override
    public void prerender() {
        cancelButton.setRendered(true);
        if (addRequest) {
            gridPanelBuscar.setRendered(false);
            perdidas.setRendered(false);
            buttonPanel.setRendered(false);
            addUpdatePanel.setRendered(true);
            addRecordButton.setRendered(true);
            updateRecordButton.setRendered(false);

            getSessionBean1().setTituloPagina("Registro de Perdidas en la Produccion");
            getSessionBean1().setDetallePagina("Insertar nuevo Registro");
            limpiarCamposNew();

        } else if (updateRequest) {
            //if (getTableRowGroup1().getSelectedRowsCount() > 0) {
                gridPanelBuscar.setRendered(false);
                perdidas.setRendered(false);
                buttonPanel.setRendered(false);
                addUpdatePanel.setRendered(true);
                addRecordButton.setRendered(false);
                updateRecordButton.setRendered(true);

                cargarCamposUpdate();
            //}
        } else if(errorValidacion){
            addUpdatePanel.setRendered(true);



        }else {
            getSessionBean1().setTituloPagina("Pérdidas en Producción");
            getSessionBean1().setDetallePagina("Registro de Pérdidas en Producción");
            gridPanelBuscar.setRendered(true);
            perdidas.setRendered(true);
            buttonPanel.setRendered(true);
            addUpdatePanel.setRendered(false);
        }
        buscar_action2();
    }


    public String buscar_action() {
        this.pageAlert1.setRendered(false);
        return buscar_action2();
    }

    public String buscar_action2() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.


        Perdida[] listaPerdidas;

        PerdidaController perdidaController = new PerdidaController();

        String pNroOt=null, pCodEmp=null;
        Date pFecha=null, pFecha2=null;

        if (this.uiCodOtFil.getText()!=null) {
            pNroOt = this.uiCodOtFil.getText().toString();
        }
        if (this.uiResponsableFil.getSelected()!=null) {
            pCodEmp = this.uiResponsableFil.getSelected().toString();
        }
        if (this.uiFecha1Fil.getSelectedDate()!=null) {
            pFecha = this.uiFecha1Fil.getSelectedDate();
        }
        if (this.uiFecha1Fil.getSelectedDate()!=null) {
            pFecha = this.uiFecha1Fil.getSelectedDate();
        }


        listaPerdidas = (Perdida[]) perdidaController.getAllFiltered(pCodEmp,null,pNroOt, pFecha2, pFecha2).toArray(new Perdida[0]);

        setlistaPerdidas(listaPerdidas);
        return null;
    }

      public void cargarCamposUpdate(){
         if (getTableRowGroup1().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
          Perdida[] perdidas = listaPerdidas;
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          Perdida perdida = perdidas[rowId];

          this.idPerdidaEditada = perdida.getCodPerdida();
         //// CARGA DE CAMPOS DE LA PAGINA


         this.uiResponsableCod.setText(perdida.getCodEmpleado().getCodEmpleado().toString());
         this.uiResponsableNombre.setText(perdida.getCodEmpleado().getNombreEmpleado().toString());
         this.uiFecha.setSelectedDate(perdida.getFechaPerdida());
         this.uiProductoCod.setText(perdida.getCodProducto().getCodProducto().toString());
         this.uiProductoDesc.setText(perdida.getCodProducto().getDescripcion().toString());
         this.uiCantidad.setText(String.valueOf(perdida.getCantidadPerdida()));
         this.uiObservacion.setText(perdida.getObservacion());

         if (perdida.getCodOrdenTrabajoDetalle() != null) {
                     this.uiNroOt.setSelected(perdida.getCodOrdenTrabajoDetalle().getCodOrdenTrabajoDet().toString());
             }
 

         this.uiResponsableCod.setText(perdida.getCodEmpleado().getCodEmpleado().toString());
         }

    }


    public void limpiarCamposNew(){

            
            this.uiResponsableCod.setText("");
            this.uiResponsableNombre.setText("");
            this.uiObservacion.setText("");
            this.uiProductoCod.setText("");
            this.uiProductoDesc.setText("");
            this.uiCantidad.setText("");
            this.uiObservacion.setText("");
            this.uiFecha.setSelectedDate(new Date());

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
    private TableSelectPhaseListener tablePhaseListener =
            new TableSelectPhaseListener();

    public void setSelected(Object object) {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        if (rowKey != null) {
            tablePhaseListener.setSelected(rowKey, object);
        }
    }

    public Object getSelected() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.getSelected(rowKey);

    }

    public Object getSelectedValue() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return (rowKey != null) ? rowKey.getRowId() : null;

    }

    public boolean getSelectedState() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.isSelected(rowKey);
    }
    private boolean addRequest = false;
    private boolean updateRequest = false;
    private boolean errorValidacion = false;

    public String uiNuevoButton_action() {
        addRequest = true;
        updateRequest = false;

        this.addRecordButton.setRendered(true);
        this.updateRecordButton.setRendered(false);

      

        getSessionBean1().setTituloPagina("Nueva Pérdida en Producción");
        getSessionBean1().setDetallePagina("Registro de Pérdida en Producción");

        this.pageAlert1.setRendered(false);
        this.addRequest=true;
//        this.buttonPanel.setRendered(true);
//        this.buttonGuardarEdicion.setRendered(false);


        return null;
    }

    public String uiEditarButton_action() {
        updateRequest = true;
        addRequest = false;

        this.pageAlert1.setRendered(false);

        this.addRecordButton.setRendered(false);
        this.updateRecordButton.setRendered(true);
        
        getSessionBean1().setTituloPagina("Editar Pérdida en Producción");
        getSessionBean1().setDetallePagina("Edición de Pérdida en Producción");
        return null;
    }

    public String uiBorrarButon_action() {
        return null;
    }

    public String addRecordButton_action() {

        validarCampos();
        if (! errorValidacion){
                            Perdida perdida = new Perdida();

                            ProductoController productoController = new ProductoController();
                            EmpleadoController empleadoController = new EmpleadoController();
                            OrdenTrabajoDetalleController otDetController = new OrdenTrabajoDetalleController();

                            perdida.setCodEmpleado(empleadoController.findById(Long.valueOf(this.uiResponsableCod.getText().toString())));
                            perdida.setCodProducto(productoController.findById(Long.valueOf(this.uiProductoCod.getText().toString())));
                            perdida.setCodOrdenTrabajoDetalle(otDetController.findById(Long.valueOf(this.uiNroOt.getSelected().toString())));
                            perdida.setCantidadPerdida(Long.valueOf(this.uiCantidad.getText().toString()));
                            perdida.setFechaPerdida(this.uiFecha.getSelectedDate());
                            perdida.setFechaAlta(this.uiFecha.getSelectedDate());
                            perdida.setObservacion(this.uiObservacion.getText().toString());

                            PerdidaController perdidaController = new PerdidaController();

                            ControllerResult controllerResult = new ControllerResult();
                            controllerResult = perdidaController.create(perdida);


                             if (controllerResult.getCodRetorno() ==-1) {
                                    this.pageAlert1.setType("error");
                                    this.errorValidacion=true;

                                    addRequest = false;
                                    updateRequest = false;


                                } else {
                                    this.pageAlert1.setType("information");
                                    addRequest = true;
                                    updateRequest = false;
                                }

                                this.pageAlert1.setTitle(controllerResult.getMsg());
                                this.pageAlert1.setSummary("");
                                this.pageAlert1.setDetail("");
                                this.pageAlert1.setRendered(true);

    }
    return null;
    }



    public String updateRecordButton_action() {
        //errorValidacion = validarCampos();
        
        updateRequest = true;
        validarCampos();
        Perdida p = new PerdidaController().findById(idPerdidaEditada);
        PerdidaController pCont = new PerdidaController();
        errorValidacion = false;

        if (!errorValidacion) {

                            ProductoController productoController = new ProductoController();
                            EmpleadoController empleadoController = new EmpleadoController();
                            OrdenTrabajoDetalleController otDetController = new OrdenTrabajoDetalleController();

                            p.setCodEmpleado(empleadoController.findById(Long.valueOf(this.uiResponsableCod.getText().toString())));
                            p.setCodProducto(productoController.findById(Long.valueOf(this.uiProductoCod.getText().toString())));
                            p.setCodOrdenTrabajoDetalle(otDetController.findById(Long.valueOf(this.uiNroOt.getSelected().toString())));
                            p.setCantidadPerdida(Long.valueOf(this.uiCantidad.getText().toString()));
                            p.setFechaPerdida(this.uiFecha.getSelectedDate());
                            p.setFechaAlta(this.uiFecha.getSelectedDate());
                            p.setObservacion(this.uiObservacion.getText().toString());


                            ControllerResult controllerResult = new ControllerResult();
                            controllerResult = pCont.update(p);


                             if (controllerResult.getCodRetorno() ==-1) {
                                    this.pageAlert1.setType("error");
                                    this.errorValidacion=true;

                                     addRequest = false;
                                     updateRequest = true;
                                } else {

                                    this.pageAlert1.setType("information");
                                        addRequest = false;
                                        updateRequest = false;

                                }

                                this.pageAlert1.setTitle(controllerResult.getMsg());
                                this.pageAlert1.setSummary("");
                                this.pageAlert1.setDetail("");
                                this.pageAlert1.setRendered(true);



            


        }
        return null;
    }

    public String cancelButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        addRequest = false;
        updateRequest = false;
        return null;
    }

    private void validarCampos(){
        //Variables
//        boolean errorValidacion;

        //Inicializar
        errorValidacion = false;

        this.errorValidacion = false;


        if (this.uiResponsableCod.getText() == null) {
            info("Nombre del empleado obligatorio, ingrese un valor");
            errorValidacion = true;
        }else if (!StringUtils.esNumero(this.uiResponsableCod.getText().toString())) {
            info("Valor incorrecto para Codidgo de Responsable, debe ser un numero");
            errorValidacion = true;
        }else{

             Empleado e   = new EmpleadoController().findById(Long.valueOf(uiResponsableCod.getText().toString()));
                        if (e == null) {
                            this.errorValidacion= true;
                            info("Verifique el codigo del Empleado Responsable");
                        }
        }


        if (this.uiProductoCod.getText() == null) {
            info("El codigo de producto es un campo obligatorio, ingrese un valor");
            errorValidacion = true;
        } else if (!StringUtils.esNumero(this.uiProductoCod.getText().toString())) {
            info("Valor incorrecto para Codidgo Producto, debe ser un numero");
            errorValidacion = true;
        }else{
                Producto p = new ProductoController().findById(Long.valueOf(uiProductoCod.getText().toString()));
                if (p == null) {
                        this.errorValidacion= true;
                        info("Verifique el codigo de Producto");
                }
        }
        if (this.uiObservacion.getText() == null || this.uiObservacion.getText().equals("")) {
            info("Favor ingrese la observacion de la Perdida");
            errorValidacion = true;
        }

        if (this.uiCantidad.getText() == null) {
            info("Cantidad es un campo obligatorio, ingrese un valor");
            errorValidacion = true;
        } else if (!StringUtils.esNumero(this.uiCantidad.getText().toString())) {
            info("Valor incorrecto para Cantidad, debe ser un numero");
            errorValidacion = true;
        }
        
        
    }

    public void uiResponsableNombre_processValueChange(ValueChangeEvent event) {
    }

 ////// CARGA DE COMBO BOX DE PERDIDAS
    Perdida[] listaPerdidas;

    public Perdida[] getlistaPerdidas() {
        return listaPerdidas;
    }

    public void setlistaPerdidas(Perdida[] listaPerdidas) {
        this.listaPerdidas= listaPerdidas;
    }

    public void cargarListaTodosPerdidas() {
        PerdidaController perdidaController  = new PerdidaController ();
        listaPerdidas = (Perdida[]) perdidaController.getAllFiltered(null, null, null, null, null). toArray(new Perdida[0]);
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
        listaOts = (OrdenTrabajoDetalle[]) otController.getAll(null).toArray(new OrdenTrabajoDetalle[0]);
        listaOtsOp = new Option[listaOts.length];
        Option option;
        for (int i = 0; i < listaOts.length; i++) {
            OrdenTrabajoDetalle p = listaOts[i];
            option = new Option();
            option.setLabel(p.getCodOrdenTrabajoDet().toString()+" "+p.getCodProducto().getDescripcion());
            option.setValue(p.getCodOrdenTrabajoDet().toString());
            listaOtsOp[i] = option;
        }
    }


    public void uiNroOt_validate(FacesContext context, UIComponent component, Object value) {


        OrdenTrabajoDetalleController ordenTrabajoDetalleController = new OrdenTrabajoDetalleController();

        OrdenTrabajoDetalle otDet = ordenTrabajoDetalleController.findById(Long.valueOf(value.toString()));

        String mensaje = "Codigo de OT "+ otDet.getCodOrdenTrabajo().getCodOrdenTrabjo().toString()+"\n";
        mensaje= mensaje + "Descripcion de la OT "+ otDet.getCodOrdenTrabajo().getDescripcion().toString()+"\n";
        mensaje= mensaje  +"\n";
        mensaje = mensaje  + "Codigo de SubOT "+ otDet.getCodOrdenTrabajoDet().toString()+"\n";
        mensaje= mensaje + "Semiterminado "+ otDet.getCodProducto().getDescripcion().toString()+"\n";
        mensaje= mensaje + "Cantidad " + String.valueOf(otDet.getCantidad());
        this.uiDescProd.setText(mensaje);

    }
////// FIN CARGA DE COMBO BOX OTS
    private Long idPerdidaEditada;

    public Long getIdPerdidaEditada() {
        return idPerdidaEditada;
    }

    /// Se define esta variable ID para hacer la busqueda del objeto a actualizar en la actualizacion de los abm
    public void setIdPerdidaEditada(Long idPerdidaEditada) {
        this.idPerdidaEditada = idPerdidaEditada;
    }

    public String uiBuscarButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        this.pageAlert1.setRendered(false);
        return buscar_action2();

    }

    public void uiFecha1Fil_processValueChange(ValueChangeEvent vce) {
    }

    public String uiTodosButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.


        listaPerdidas = (Perdida[]) new PerdidaController().getAll("codPerdida").toArray(new Perdida[0]);
        setlistaPerdidas(listaPerdidas);

        
        return null;
    }
  
    
}

