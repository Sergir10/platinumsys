<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Usuario
    Created on : 20-ago-2009, 19:25:55
    Author     : MartinJara
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                    <!-- \SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <script>
                        function initAllRows() {
                            var table = document.getElementById("form1:table1");
                            table.initAllRows();}
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                    <!-- \SCRIPT PARA CONFIRMAR ELIMINACION-->
                    <script>
                        var delSelect;
                        function confirmar() {
                            if (delSelect!=null){
                                if(!confirm("¿Está seguro de eliminar el Registro seleccionado?")) {
                                    return false;
                                }else{
                                    return true;
                                }
                            }
                        }
                    </script>
                    <!-- \ FIN SCRIPT PARA REFRESCAR EL RADIO BUTTON-->
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div>
                            <jsp:directive.include file="cabecera.jspf"/>
                        </div>
                        <div>
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <div>
                            <h:panelGrid binding="#{ABMComprasProveedor.mainContainer}" id="mainContainer"
                                style="height: 96px; left: 288px; top: 216px; position: absolute" width="768">
                                <h:panelGrid binding="#{ABMComprasProveedor.gridPanelBuscar}" columns="3" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelNroFactura">
                                        <webuijsf:label id="lblNroProveedor" text="Nro. Factura"/>
                                        <webuijsf:textField binding="#{ABMComprasProveedor.uiFilTxtNroFactura}" id="uiFilTxtNroFactura"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelProveedor1">
                                        <webuijsf:label id="lblProveedor" text="Proveedor"/>
                                        <webuijsf:textField binding="#{ABMComprasProveedor.uiFilTxtProveedor}" columns="35" id="uiFilTxtProveedor"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro">
                                        <webuijsf:label id="label3Filtro" text="Fecha Factura"/>
                                        <webuijsf:calendar binding="#{ABMComprasProveedor.uiFilCalFechaFactura}" columns="15" id="uiFilCalFechaFactura"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                    <webuijsf:button actionExpression="#{ABMComprasProveedor.uiBtnBuscar_action}" binding="#{ABMComprasProveedor.uiBtnBuscar}"
                                        id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMComprasProveedor.uiBtnTodos_action}" binding="#{ABMComprasProveedor.uiBtnTodos}"
                                        id="uiBtnTodos" text="Todos"/>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMComprasProveedor.pageAlert1}" rendered="false" style="height: 72px"/>
                                <script>
                                    function ABMVentasCliente() {
                                        var table = document.getElementById("form1:table1");
                                        table.ABMVentasCliente();
                                    }
                                </script>
                                <webuijsf:table augmentTitle="false" binding="#{ABMComprasProveedor.table1}" id="table1" title="Compras Proveedor" width="719">
                                    <webuijsf:tableRowGroup binding="#{ABMComprasProveedor.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMComprasProveedor.selectedState}"
                                        sourceData="#{ABMComprasProveedor.lstCabecera}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMComprasProveedor.tableColumn11}" id="tableColumn11" width="36">
                                            <webuijsf:radioButton binding="#{ABMComprasProveedor.radioButton1}" id="radioButton1" label=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Factura" id="tableColumn2" width="169">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['nroFactura']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Proveedor" id="tableColumn3">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['codProveedor'].nombreProveedor}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Fecha" id="tableColumn4" width="96">
                                            <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText4" text="#{currentRow.value['fecha']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn5" width="112">
                                            <webuijsf:staticText id="staticText8" text="#{currentRow.value['estado']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMComprasProveedor.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMComprasProveedor.addButton_action}" binding="#{ABMComprasProveedor.addButton}"
                                        id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMComprasProveedor.updateButton_action}" binding="#{ABMComprasProveedor.updateButton}"
                                        id="updateButton" text="Editar"/>
                                    <webuijsf:button actionExpression="#{ABMComprasProveedor.deleteButton_action}" binding="#{ABMComprasProveedor.deleteButton}"
                                        id="deleteButton" text="Eliminar"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMComprasProveedor.addUpdatePanel}" columns="1" id="addUpdatePanel">
                                    <h:panelGrid cellpadding="1" columns="3" id="panelGridCabeceraCompra" style="text-align: left">
                                        <webuijsf:label id="lblNroFac" text="Nro. Factura"/>
                                        <h:panelGrid columns="3" id="panelGridCabCompra1" width="335">
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtNroFac}" id="uiTxtNroFac"/>
                                            <webuijsf:label for="uiLstTipoComprobante" id="lblTipoFactura" text="Tipo"/>
                                            <webuijsf:dropDown binding="#{ABMComprasProveedor.uiLstTipoComprobante}" id="uiLstTipoComprobante"
                                                items="#{ABMComprasProveedor.uiLstTipoComprobanteDefaultOptions.options}"
                                                selected="#{ABMComprasProveedor.uiLstTipoComprobanteDefaultOptions.selectedValue}" width="126px"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra2" style="text-align: right" width="200">
                                            <webuijsf:label for="uiLstEstado" id="lblEstadoFactura" text="Estado"/>
                                            <webuijsf:dropDown binding="#{ABMComprasProveedor.uiLstEstado}" id="uiLstEstado"
                                                items="#{ABMComprasProveedor.uiLstEstadoDefaultOptions.options}"
                                                selected="#{ABMComprasProveedor.uiLstEstadoDefaultOptions.selectedValue}" width="126px"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                            text="Proveedor" url="/faces/popupproductos.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelProveedor" width="335">
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtCodProveedor}" columns="10" id="uiTxtCodProveedor" required="true"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtNombreProveedor}" columns="50" id="uiTxtNombreProveedor" valueChangeListenerExpression="#{ABMComprasProveedor.uiTxtNombreProveedor_processValueChange}"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra3" style="text-align: right" width="200">
                                            <webuijsf:label id="lblSubTotal" text="Sub-Total"/>
                                            <webuijsf:textField columns="20" id="uiTxtSubTotal"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="lblFecha" text="Fecha"/>
                                        <webuijsf:calendar columns="15" dateFormatPattern="dd/MM/yyyy" id="uiCalFecha"/>
                                        <h:panelGrid columns="2" id="panelGridCabCompra4" style="text-align: right" width="200">
                                            <webuijsf:label id="lblTotalIva" text="Total IVA"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtTotalIva}" columns="20" id="uiTxtTotalIva"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="lnkEmpleado" onClick="doPopup('form1:txtCodCliente_field', 'form1:txtApellidoNombre_field')"
                                            text="Empleado" url="/faces/popupEmpleados.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelEmpleado" width="335">
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtCodEmpleado}" columns="10" id="uiTxtCodEmpleado"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtNombreEmpleado}" columns="50" id="uiTxtNombreEmpleado"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra5" style="text-align: right" width="200">
                                            <webuijsf:label id="lblTotal" text="Total"/>
                                            <webuijsf:textField columns="20" id="uiTxtTotal"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel1"
                                        style="direction: rtl; line-height: normal; margin-left: 500px; text-align: right; vertical-align: bottom" width="182">
                                        <webuijsf:button actionExpression="#{ABMComprasProveedor.uiBtnCancelar_action}"
                                            binding="#{ABMComprasProveedor.uiBtnCancelar}" id="uiBtnCancelar" style="font-size: 14px" text="Cancelar"/>
                                        <webuijsf:button actionExpression="#{ABMComprasProveedor.uiBtnGuardarNuevo_action}"
                                            binding="#{ABMComprasProveedor.uiBtnGuardarNuevo}" id="uiBtnGuardarNuevo" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMComprasProveedor.updateRecordButton_action}"
                                            binding="#{ABMComprasProveedor.updateRecordButton}" id="updateRecordButton" rendered="false" style="font-size: 14px" text="Guardar"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="gridPanel2" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Detalle Factura"/>
                                        <h:panelGrid columns="8" id="gridPanel3" style="height: 48px" width="695">
                                            <webuijsf:hyperlink id="hyperlink2"
                                                onClick="doPopup('form1:uiTxtCodProducto_field', 'form1:uiTxtDescProducto_field')" target="popup"
                                                text="Producto" url="/faces/popup/popupProductos.jsp"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtCodProducto}" columns="10" id="uiTxtCodProducto"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtDescProducto}" id="uiTxtDescProducto"/>
                                            <webuijsf:label id="lblPrecio" text="Precio Uni."/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtPrecioUnitario}" columns="15" id="uiTxtPrecioUnitario"/>
                                            <webuijsf:label id="lblCantidaf" text="Cantidad"/>
                                            <webuijsf:textField binding="#{ABMComprasProveedor.uiTxtCantidad}" columns="15" id="uiTxtCantidad"/>
                                            <webuijsf:button id="uiBtnAgregarDet" text="Agregar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" id="tableDetalle" title="Detalle" width="720">
                                            <webuijsf:tableRowGroup id="tableRowGroup2" rows="5" sourceData="#{ABMComprasProveedor.lstDetalle}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Cod. Producto" id="tableColumn1">
                                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['codProducto'].codProducto}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Producto" id="tableColumnDescProducto">
                                                    <webuijsf:staticText id="staticTextDescProducto" text="#{currentRow.value['codProducto'].descripcion}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Precio Unit." id="tableColumn6">
                                                    <webuijsf:staticText id="staticText5" text="#{currentRow.value['precioUni']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cantidad" id="tableColumn7">
                                                    <webuijsf:staticText id="staticText6" text="#{currentRow.value['cantidad']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Monto Iva" id="tableColumn8">
                                                    <webuijsf:staticText id="staticText7" text="#{currentRow.value['montoIva']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Total" id="tableColumn9">
                                                    <webuijsf:staticText id="staticText9" text="#{currentRow.value['total']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn15" width="40">
                                                    <webuijsf:imageHyperlink id="uilnkEditarDetalle" imageURL="/resources/img/edit_16x16.gif" text=""/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" id="tableColumn9" width="40">
                                                    <webuijsf:imageHyperlink id="uilnkEliminarDetalle" imageURL="/resources/img/delete.png" text=""/>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>