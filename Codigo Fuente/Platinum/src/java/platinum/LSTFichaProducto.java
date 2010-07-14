/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package platinum;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import javax.faces.FacesException;
import javax.servlet.ServletContext;
import py.com.platinum.controller.DepositoController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.entity.Deposito;
import py.com.platinum.entity.Producto;
import py.com.platinum.utils.DateUtils;
import reportes.Formated;
import reportes.GetConnection;
import reportes.RptCreate;












/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version Reporte.java
 * @version Created on 07-sep-2009, 16:17:38
 * @author MartinJara
 */

public class LSTFichaProducto extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DropDown uiDeposito = new DropDown();

    public DropDown getUiDeposito() {
        return uiDeposito;
    }

    public void setUiDeposito(DropDown dd) {
        this.uiDeposito = dd;
    }
    private DropDown uiProducto = new DropDown();

    public DropDown getUiProducto() {
        return uiProducto;
    }

    public void setUiProducto(DropDown dd) {
        this.uiProducto = dd;
    }
    private Calendar uiFechaIni = new Calendar();

    public Calendar getUiFechaIni() {
        return uiFechaIni;
    }

    public void setUiFechaIni(Calendar c) {
        this.uiFechaIni = c;
    }
    private Calendar uiFechaFin = new Calendar();

    public Calendar getUiFechaFin() {
        return uiFechaFin;
    }

    public void setUiFechaFin(Calendar c) {
        this.uiFechaFin = c;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LSTFichaProducto() {

    cargarListaTodosDepositos();
    cargarListaTodosProductos();
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
            log("Reporte Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
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
        getSessionBean1().setTituloPagina("Ficha de Producto");
        getSessionBean1().setDetallePagina("Detalle de variacion de la existencia de un producto, segun intervalo de fecha y Deposito");
        uiDeposito.setSelected("-1");
        uiProducto.setSelected("-1");
       

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
    protected Menu getMenu() {
        return (Menu) getBean("Menu");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public String uiEjecutar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
                String[] sparamName= new String[9];
                String[] sparamValue= new String[9];
                Connection conn= GetConnection.getSimpleConnection();
                ServletContext theApplicationsServletContext = (ServletContext) this.getExternalContext().getContext();
                String sProducto="";
                String ps;
                
                String sDeposito="";
                String ds;

                String sFecha="";
                String sF;

                String sFechaF="";
                String sFF;

                String cantidadInicial = "0";
                String codProd = "";
                String codDep = "";


                String sSql="";
                Formated f= new Formated();
                f.setDatePattern("dd/MM/yyyy");

                
                
                Producto p;
                boolean error = false;
                try{

                if (!uiProducto.getSelected().toString().equals("-1")){
                    sProducto = " and det.cod_producto = "+uiProducto.getSelected().toString();
                    ps = new ProductoController().findById(Long.valueOf(this.uiProducto.getSelected().toString())).getDescripcion().toString();
                    codProd = new ProductoController().findById(Long.valueOf(this.uiProducto.getSelected().toString())).getCodProducto().toString();

                }else{
                    error = true;
                    info("Favor Seleccione el Producto");
                    ps= "Todos";
                 }

                if (!uiDeposito.getSelected().toString().equals("-1")){
                    sDeposito = " and cab.cod_deposito = "+uiDeposito.getSelected().toString();
                        ds = new DepositoController().findById(Long.valueOf(this.uiDeposito.getSelected().toString())).getNombre().toString();
                        codDep = new DepositoController().findById(Long.valueOf(this.uiDeposito.getSelected().toString())).getCodDeposito().toString();

                }else{
                        error = true;
                        info("Favor Seleccione el Deposito");
                        ds= "Todos";
                }

               

                 if (uiFechaIni.getSelectedDate() != null){
                    String simpleFecha = DateUtils.toString(uiFechaIni.getSelectedDate(), "dd/MM/yyyy");
                    sFecha = " and cab.fecha_entrada_salida >= to_date('"+simpleFecha+"','dd/mm/yyyy')";
                    sF = "'"+simpleFecha+"'";
                }else{
                    error = true;
                    info("Favor Seleccione seleccione la fecha inicial");
                    sF="Todos";
                }

                if (uiFechaFin.getSelectedDate() != null){
                    String simpleFechaF = DateUtils.toString(uiFechaFin.getSelectedDate(), "dd/MM/yyyy");
                    sFechaF = " and cab.fecha_entrada_salida <= to_date('"+simpleFechaF+"','dd/mm/yyyy')";
                    sFF = "'"+simpleFechaF+"'";
                }else{
                    error = true;
                    info("Favor Seleccione la fecha Final");
                    sFF="Todos";
                }

                //                if (calFecHasta.getValue()!=null)
//                sFecHasta = " and TARJETAS.FECHA_ALTA <= convert(datetime,'"+f.getDateFormat((Date)calFecHasta.getValue())+"') ";



                            sSql = sProducto+sDeposito+sFecha+sFechaF;

                            if (!error) {
                                    Long movimientos = null;
                                    movimientos = new ProductoController().calcularMovimientos(Long.valueOf(uiProducto.getSelected().toString()), this.uiFechaIni.getSelectedDate(), this.uiFechaFin.getSelectedDate(), Long.valueOf(uiDeposito.getSelected().toString()));
                                if (movimientos != null) {
                                    cantidadInicial = movimientos.toString();
                                }

                            }

                            RptCreate rpt= new RptCreate();

                            sparamName[0]="parametros";
                            sparamValue[0]= sSql;
                            sparamName[1]="producto";
                            sparamValue[1]= ps;
                            sparamName[2]="deposito";
                            sparamValue[2]= ds;
                            sparamName[3]="fechaIni";
                            sparamValue[3]= sF;
                            sparamName[4]="fechaFin";
                            sparamValue[4]= sFF;
                            sparamName[5]="cantidadInicial";
                            sparamValue[5]= cantidadInicial;
                            sparamName[6]="codProd";
                            sparamValue[6]= codProd;
                            sparamName[7]="codDep";
                            sparamValue[7]= codDep;
                            sparamName[8] = "logo_path";
                            sparamValue[8] = theApplicationsServletContext.getRealPath("/WEB-INF/classes/reportesFuente/logo_platinum.jpg");


                            if (!error) {
                            rpt.getReport(conn, "FichaProductoExistencia.jrxml", sparamName, sparamValue, theApplicationsServletContext);
                            }




                            }catch(Exception e){
                            error("Error al generar el reporte ");
                            error(" " + e);
                            }finally{
                            try{
                            if(conn != null && !conn.isClosed())
                            conn.close();
                            }catch(SQLException sqle){
                            error("Error al intentar cerrar la conexion"+ sqle);
                            }
                            }
        return null;
    }

    public String button2_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    ////// CARGA DE COMBO BOX Depositos
//////     import com.sun.webui.jsf.model.Option;
    Deposito[] listaDepositos;
    Option[] listaDepositosOp;

    public Option[] getListaDepositosOp() {
        return listaDepositosOp;
    }

    public void setListaDepositosOp(Option[] listaDepositosOp) {
        this.listaDepositosOp = listaDepositosOp;
    }

    public Deposito[] getListaDepositos() {
        return listaDepositos;
    }

    public void setListaDepositos(Deposito[] listaDepositos) {
        this.listaDepositos = listaDepositos;
    }

    public void cargarListaTodosDepositos() {
        DepositoController depositoController = new DepositoController();
        listaDepositos = (Deposito[]) depositoController.getAll("nombre").toArray(new Deposito[0]);
        listaDepositosOp = new Option[listaDepositos.length];
        Option option;
        int i;
        for (i = 0; i < listaDepositos.length; i++) {
            Deposito tp = listaDepositos[i];
            option = new Option();
            option.setLabel(tp.getNombre());
            option.setValue(tp.getCodDeposito().toString());
            listaDepositosOp[i] = option;
        }
            

    }
////// FIN CARGA DE COMBO BOX


     ////// CARGA DE COMBO BOX PRODUCTOS
    Producto[] listaProductos;
    Option[] listaProductosOp;

    public Option[] getListaProductosOp() {
        return listaProductosOp;
    }

    public void setListaProductosOp(Option[] listaProductosOp) {
        this.listaProductosOp = listaProductosOp;
    }

    public Producto[] getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(Producto[] listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void cargarListaTodosProductos() {
        ProductoController productoController = new ProductoController();
        listaProductos = (Producto[]) productoController.getInsumosMateriasFinalesSemiter(null, null, null).toArray(new Producto[0]);
        listaProductosOp = new Option[listaProductos.length];
        Option option;
        for (int i = 0; i < listaProductos.length; i++) {
            Producto p = listaProductos[i];
            option = new Option();
            option.setLabel(p.getCodTipoProducto().toString()+" "+p.getDescripcion()+" "+p.getCodMarca().getNombre().toString());
            option.setValue(p.getCodProducto().toString());
            listaProductosOp[i] = option;
        }
     }
}

