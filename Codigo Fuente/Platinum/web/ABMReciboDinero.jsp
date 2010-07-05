<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Usuario
    Created on : 20-ago-2009, 19:25:55
    Author     : MartinJara
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:script id="scriptPopUp" type="text/javascript" url="/js/utilJS.js"/>
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
                            <h:panelGrid binding="#{ABMReciboDinero.mainContainer}" id="mainContainer"
                                style="height: 96px; left: 288px; top: 216px; position: absolute" width="768">
                                <h:panelGrid binding="#{ABMReciboDinero.gridPanelBuscar}" columns="3" id="gridPanelBuscar">
                                    <h:panelGrid columns="2" id="gridPanelNroFactura">
                                        <webuijsf:label id="lblNroPedido" text="Nro. Recibo"/>
                                        <webuijsf:textField binding="#{ABMReciboDinero.uiFilTxtNroRecibo}" id="uiFilTxtNroRecibo"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelCliente">
                                        <webuijsf:label id="lblCliente" text="Cliente"/>
                                        <webuijsf:textField binding="#{ABMReciboDinero.uiFilTxtCliente}" columns="35" id="uiFilTxtCliente"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanelEmailFiltro">
                                        <webuijsf:label id="label3Filtro" text="Fecha"/>
                                        <webuijsf:calendar binding="#{ABMReciboDinero.uiFilCalFecha}" columns="15" id="uiFilCalFecha"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMReciboDinero.gridPanelBtnBuscar}" columns="2" id="gridPanelBtnBuscar" style="height: 100%" width="191">
                                    <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnBuscar_action}" binding="#{ABMReciboDinero.uiBtnBuscar}"
                                        id="uiBtnBuscar" text="Buscar"/>
                                    <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnTodos_action}" binding="#{ABMReciboDinero.uiBtnTodos}"
                                        id="uiBtnTodos" text="Todos"/>
                                </h:panelGrid>
                                <webuijsf:pageAlert binding="#{ABMReciboDinero.pageAlert1}" rendered="false" style="height: 72px"/>
                                <webuijsf:table augmentTitle="false" binding="#{ABMReciboDinero.table1}" id="table1" title="Recibos" width="743">
                                    <webuijsf:tableRowGroup binding="#{ABMReciboDinero.tableRowGroup1}" emptyDataMsg="No se recupero ningun registro..."
                                        id="tableRowGroup1" rows="10" selected="#{ABMReciboDinero.selectedState}" sourceData="#{ABMReciboDinero.lstCabecera}" sourceVar="currentRow">
                                        <webuijsf:tableColumn align="center" binding="#{ABMReciboDinero.tableColumn11}" id="tableColumn11"
                                            onClick="setTimeout('initAllRows()',0)" selectId="#{ABMReciboDinero.radioButton1.id}" width="30">
                                            <webuijsf:radioButton binding="#{ABMReciboDinero.radioButton1}" id="radioButton1" label=""
                                                name="#{ABMReciboDinero.radioButton1.id}" onClick="delSelect='ok'" selected="#{ABMReciboDinero.selected}" selectedValue="#{ABMReciboDinero.selectedValue}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Serie" id="tableColumnSerie" width="96">
                                            <webuijsf:staticText id="staticTextTipo" text="#{currentRow.value['tipoFactura'].descTipo}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Nro. Recibo" id="tableColumn2" width="130">
                                            <webuijsf:staticText id="staticText2" text="#{currentRow.value['establecimiento']} - #{currentRow.value['bocaExpendio']} - #{currentRow.value['numeroFactura']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Cliente" id="tableColumn3">
                                            <webuijsf:staticText id="staticText3" text="#{currentRow.value['codCliente'].apellidoCliente}, #{currentRow.value['codCliente'].nombreCliente}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Emisión" id="tableColumn4" width="96">
                                            <webuijsf:staticText converter="#{SessionBean1.dateTimeConverter}" id="staticText4" text="#{currentRow.value['fechaFactura']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn headerText="Estado" id="tableColumn5" width="112">
                                            <webuijsf:staticText converter="#{ABMReciboDinero.characterConverter1}" id="staticText8" text="#{currentRow.value['estadoFactura']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <h:panelGrid binding="#{ABMReciboDinero.buttonPanel}" columns="3" id="buttonPanel">
                                    <webuijsf:button actionExpression="#{ABMReciboDinero.addButton_action}" binding="#{ABMReciboDinero.addButton}"
                                        id="addButton" text="Nuevo"/>
                                    <webuijsf:button actionExpression="#{ABMReciboDinero.updateButton_action}" binding="#{ABMReciboDinero.updateButton}"
                                        id="updateButton" text="Ver Detalle"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{ABMReciboDinero.addUpdatePanel}" columns="1" id="addUpdatePanel">
                                    <h:panelGrid cellpadding="1" columns="3" id="panelGridCabeceraCompra" style="text-align: left" width="743">
                                        <webuijsf:label id="lblTipoFactura" text="SERIE"/>
                                        <h:panelGrid cellpadding="2" cellspacing="2" columns="3" id="panelGridCabCompra1" width="335">
                                            <webuijsf:textField columns="10" id="uiTxtSerie" maxLength="15"/>
                                            <webuijsf:label id="lblNroFac" text="NRO. RECIBO"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtNroRecibo}" id="uiTxtNroRecibo" maxLength="20" onClick="document.getElementById('form1:uiLstTipoComprobante_list').focus(); return false;"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra2" style="text-align: right" width="200">
                                            <webuijsf:label for="uiLstEstado" id="lblEstadoFactura" text="Estado"/>
                                            <webuijsf:dropDown binding="#{ABMReciboDinero.uiLstEstado}" id="uiLstEstado"
                                                items="#{ABMReciboDinero.uiLstEstadoDefaultOptions.options}"
                                                selected="#{ABMReciboDinero.uiLstEstadoDefaultOptions.selectedValue}" width="120px"/>
                                        </h:panelGrid>
                                        <webuijsf:hyperlink id="hyperlink1" onClick="doPopup('form1:uiTxtCodCliente_field', 'form1:uiTxtNombreCliente_field')"
                                            target="popup" text="Cliente" url="/faces/popup/popupCliente.jsp"/>
                                        <h:panelGrid columns="2" id="gridPanelProveedor" width="335">
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtCodCliente}" columns="10" id="uiTxtCodCliente" maxLength="15"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtNombreCliente}" columns="50" id="uiTxtNombreCliente" onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="panelGridCabCompra3" style="height: 26px; text-align: right" width="200">
                                            <webuijsf:label id="lblFecha" text="Fecha"/>
                                            <webuijsf:calendar binding="#{ABMReciboDinero.uiCalFecha}" columns="15" dateFormatPattern="dd/MM/yyyy"
                                                id="uiCalFecha" style="margin-left: 24px"/>
                                        </h:panelGrid>
                                        <webuijsf:label id="lblTotalIva" text="TOTAL"/>
                                        <webuijsf:textField binding="#{ABMReciboDinero.uiTxtTotal1}" columns="20" id="uiTxtTotal1"
                                            onFocus="document.getElementById('form1:uiBtnCancelar').focus(); return false;" style="text-align: right"/>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" id="gridPanel1"
                                        style="direction: rtl; height: 48px; line-height: normal; margin-left: 540px; text-align: right; vertical-align: bottom" width="182">
                                        <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnGuardarNuevo_action}"
                                            binding="#{ABMReciboDinero.uiBtnGuardarNuevo}" id="uiBtnGuardarNuevo" style="font-size: 14px" text="Guardar"/>
                                        <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnGuardarEditar_action}"
                                            binding="#{ABMReciboDinero.uiBtnGuardarEditar}" id="uiBtnGuardarEditar" rendered="false" style="font-size: 14px" text="Anular"/>
                                        <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnCancelar_action}" binding="#{ABMReciboDinero.uiBtnCancelar}"
                                            id="uiBtnCancelar" style="font-size: 14px" text="Cancelar"/>
                                    </h:panelGrid>
                                    <webuijsf:messageGroup id="messageGroup1" showGlobalOnly="true" style="width: 719px"/>
                                    <h:panelGrid id="gridPanel2" style="width: 100%; height: 100%;">
                                        <webuijsf:label id="label5" style="font-size: 16px" text="Detalle Recibo"/>
                                        <h:panelGrid binding="#{ABMReciboDinero.gridPanelDetLin1}" columns="10" id="gridPanelDetLin1" style="height: 24px" width="743">
                                            <webuijsf:hyperlink id="hyperlink2"
                                                onClick="doPopup('form1:uiTxtDescComprobante_field', 'form1:uiTxtNroComprobante_field', 'form1:uiTxtCodComprobante_field', 'form1:uiTxtNroCuota_field', 'form1:uiTxtSaldoCuota_field')"
                                                target="popup" text="Comprobante" url="/faces/popup/popupProductoVenta.jsp"/>
                                            <webuijsf:textField columns="18" id="uiTxtDescComprobante" onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;"/>
                                            <webuijsf:label id="lblnro" text="Nro.:"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtNroComprobante}" columns="15" id="uiTxtNroComprobante" onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;"/>
                                            <webuijsf:label id="lblCodComprobante" text="Codigo"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtCodComprobante}" columns="10" id="uiTxtCodComprobante" onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;"/>
                                            <webuijsf:label id="lblFecVencimiento" text="Vencimiento"/>
                                            <webuijsf:textField columns="10" id="uiTxtFecVencimiento"
                                                onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;" style="margin-left: -20px; text-align: left"/>
                                        </h:panelGrid>
                                        <h:panelGrid binding="#{ABMReciboDinero.gridPanelDetLin2}" columns="12" id="gridPanelDetLin2" style="height: 24px"
                                                width="767"> x&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;
                                            <webuijsf:label
                                                id="lblTipoComprobante1" text="Cuota"/>
                                            <webuijsf:textField columns="5" id="uiTxtNroCuota" onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;"/>
                                            <webuijsf:label id="lblTipoComprobante1" text="DE"/>
                                            <webuijsf:textField columns="5" id="uiTxtCantCuota" onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;"/>
                                            <webuijsf:label id="lblPrecio1" text="Monto Cuota"/>
                                            <webuijsf:textField columns="15" id="uiTxtMontoCuota"
                                                onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;" style="margin-left: -20px; text-align: left"/>
                                            <webuijsf:label id="lblPrecio" text="Saldo Cuota"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtSaldoCuota}" columns="15" id="uiTxtSaldoCuota"
                                                onFocus="document.getElementById('form1:uiTxtMontoCobro_field').focus(); return false;" style="margin-left: -20px; text-align: left"/>
                                            <webuijsf:label id="lblMontoTotal" text="Monto Cobro"/>
                                            <webuijsf:textField binding="#{ABMReciboDinero.uiTxtMontoCobro}" columns="15" id="uiTxtMontoCobro" style="text-align: right"/>
                                            <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnAgregarDet_action}" id="uiBtnAgregarDet" text="Agregar"/>
                                            <webuijsf:button actionExpression="#{ABMReciboDinero.uiBtnCancelarDetalle_action}" id="uiBtnCancelarDetalle" text="Cancelar"/>
                                        </h:panelGrid>
                                        <webuijsf:table augmentTitle="false" binding="#{ABMReciboDinero.tableDetalle}" id="tableDetalle" title="Detalle" width="743">
                                            <webuijsf:tableRowGroup binding="#{ABMReciboDinero.tableRowGroup2}" id="tableRowGroup2" rows="5"
                                                sourceData="#{ABMReciboDinero.lstDetalle}" sourceVar="currentRow">
                                                <webuijsf:tableColumn headerText="Cod. Producto" id="tableColumn1">
                                                    <webuijsf:staticText id="staticText1" text="#{currentRow.value['codProducto'].codProducto}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Producto" id="tableColumnDescProducto">
                                                    <webuijsf:staticText id="staticTextDescProducto" text="#{currentRow.value['codProducto'].descripcion}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Precio Unit." id="tableColumn6">
                                                    <webuijsf:staticText id="staticText5" text="#{currentRow.value['precioUnitario']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Cantidad" id="tableColumn7">
                                                    <webuijsf:staticText id="staticText6" text="#{currentRow.value['cantidad']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="IVA %" id="tableColumn71">
                                                    <webuijsf:staticText id="staticText6Porc" text="#{currentRow.value['porcentajeIva']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Monto IVA" id="tableColumn8">
                                                    <webuijsf:staticText id="staticText7" text="#{currentRow.value['totalIva']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn headerText="Total" id="tableColumn9">
                                                    <webuijsf:staticText id="staticText9" text="#{currentRow.value['subTotal']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" binding="#{ABMReciboDinero.tableColumnEditarDet}" id="tableColumnEditarDet" width="40">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMReciboDinero.updateDetAction}" id="uilnkEditarDetalle"
                                                        imageURL="/resources/img/edit_16x16.gif" text="">
                                                        <f:setPropertyActionListener target="#{ABMReciboDinero.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                    </webuijsf:imageHyperlink>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" binding="#{ABMReciboDinero.tableColumnEliminarDet}"
                                                    id="tableColumnEliminarDet" width="40">
                                                    <webuijsf:imageHyperlink actionExpression="#{ABMReciboDinero.deleteDetAction}" id="uilnkEliminarDetalle"
                                                        imageURL="/resources/img/delete.png" text="">
                                                        <f:setPropertyActionListener target="#{ABMReciboDinero.itemDet}" value="#{currentRow.tableRow.rowId}"/>
                                                    </webuijsf:imageHyperlink>
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