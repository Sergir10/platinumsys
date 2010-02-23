
--Tipos de Comprobantes
insert into tipo_comprobante values (1, 'Factura Contado - Compra', 0, 'COMPRA');
insert into tipo_comprobante values (2, 'Factura Cr�dito 15 d�as - Compra', 15, 'COMPRA');
insert into tipo_comprobante values (3, 'Factura Cr�dito 30 d�as - Compra', 30, 'COMPRA');
insert into tipo_comprobante values (4, 'Factura Cr�dito 60 d�as - Compra', 60, 'COMPRA');
insert into tipo_comprobante values (5, 'Factura Cr�dito 90 d�as - Compra', 90, 'COMPRA');
insert into tipo_comprobante values (6, 'Factura Cr�dito 120 d�as - Compra', 120, 'COMPRA');
insert into tipo_comprobante values (7, 'Factura Contado - Venta', 0, 'VENTA');
insert into tipo_comprobante values (8, 'Factura Cr�dito 15 d�as - Venta', 15, 'VENTA');
insert into tipo_comprobante values (9, 'Factura Cr�dito 30 d�as - Venta', 30, 'VENTA');
insert into tipo_comprobante values (10, 'Factura Cr�dito 60 d�as - Venta', 60, 'VENTA');
insert into tipo_comprobante values (11, 'Factura Cr�dito 90 d�as - Venta', 90, 'VENTA');
insert into tipo_comprobante values (12, 'Factura Cr�dito 120 d�as - Venta', 120, 'VENTA');
insert into tipo_comprobante values (13, 'Nota de Cr�dito - Proveedor', 0, 'PAGO PROVEEDOR');
insert into tipo_comprobante values (14, 'Nota de Cr�dito - Cliente', 0, 'COBRANZA');
insert into tipo_comprobante values (15, 'Recibo de Dinero - Cobranza', 0, 'COBRANZA');
insert into tipo_comprobante values (16, 'Movimiento de Caja - Cobranza', 0, 'COBRANZA');
insert into tipo_comprobante values (17, 'Pedido - Cliente', 0, 'PEDIDO CLIENTE');

commit;