<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Reporte
    Created on : 07-sep-2009, 16:17:37
    Author     : MartinJara
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
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
                            <h:panelGrid columns="2" id="mainContainer" style="height: 149px; left: 288px; top: 240px; position: absolute" width="456">
                                <webuijsf:label id="lblTipoProducto" text="Tipo Producto"/>
                                <webuijsf:dropDown binding="#{LSTExistenciaProducto.uiTipoProd}" id="uiTipoProd" items="#{LSTExistenciaProducto.listaTipoProductosOp}"/>
                                <webuijsf:label id="label1" text="Producto"/>
                                <webuijsf:dropDown binding="#{LSTExistenciaProducto.uiProducto}" id="uiProducto" items="#{LSTExistenciaProducto.listaProductosOp}"/>
                                <webuijsf:label id="label2" text="Deposito"/>
                                <webuijsf:dropDown binding="#{LSTExistenciaProducto.uiDeposito}" id="uiDeposito" items="#{LSTExistenciaProducto.listaDepositosOp}"/>
                                <webuijsf:label id="label3" text="Marca"/>
                                <webuijsf:dropDown binding="#{LSTExistenciaProducto.uiMarca}" id="uiMarca" items="#{LSTExistenciaProducto.listaMarcasOp}"/>
                                <h:panelGrid columns="2" id="gridPanel1" style="width: 100%; height: 100%;">
                                    <webuijsf:button actionExpression="#{LSTExistenciaProducto.button1_action}" id="button1" text="Ejecutar"/>
                                    <webuijsf:button actionExpression="#{LSTExistenciaProducto.button2_action}" id="button2" text="Cancelar"/>
                                </h:panelGrid>
                                <webuijsf:button actionExpression="#{LSTExistenciaProducto.button3_action}" id="button3" text="Consultar Listado de Precios"/>
                            </h:panelGrid>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
