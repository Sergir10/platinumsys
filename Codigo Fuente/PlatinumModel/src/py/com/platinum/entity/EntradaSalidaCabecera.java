/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "ENTRADA_SALIDA_CABECERA")
@SequenceGenerator(name="ENTRADA_SALIDA_SEQUENCE", sequenceName="SQ_CABECERA_ENTRADA_SALIDA", initialValue=5, allocationSize=1)
public class EntradaSalidaCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ENTRADA_SALIDA_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_ENTRADA_SALIDA")
    private Long codEntradaSalida;
     @Column(name = "FECHA_ENTRADA_SALIDA")
    @Temporal(TemporalType.DATE)
    private Date fechaEntradaSalida;
    @Column(name = "HORA_ENTRADA_SALIDA")
    @Temporal(TemporalType.DATE)
    private Date horaEntradaSalida;
    @Column(name = "OBSERVACION")
    private String observacion;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "USUARIO_ALTA")
    private String usuarioAlta;
    @Column(name = "USUARIO_MODIF")
    private String usuarioModif;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "FECHA_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModif;
    @JoinColumn(name = "COD_DEPOSITO", referencedColumnName = "COD_DEPOSITO")
    @ManyToOne(optional = false)
    private Deposito codDeposito;
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codEmpleado;
    @JoinColumn(name = "COD_ENCARGADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codEncargado;
 //   @OneToMany(mappedBy = "codEntSal", fetch=FetchType.EAGER)
 //   private Set<FacturaCompraCab> facturaCompraCab;
    @OneToMany(mappedBy = "codEntradaSalida", fetch=FetchType.EAGER)
    private Set<EntradaSalidaDetalle> entradaSalidaDetalle;
    @Column(name = "TIPO_COMPROBANTE")
    private Long tipoComprobante;
    @Column(name = "NRO_COMPROBANTE")
    private Long nroComprobante;
   @Column(name = "COD_PERDIDA")
    private Long codPerdida;

    public EntradaSalidaCabecera() {
    }

    public EntradaSalidaCabecera(Long codEntradaSalida) {
        this.codEntradaSalida = codEntradaSalida;
    }

    public Long getCodEntradaSalida() {
        return codEntradaSalida;
    }

    public void setCodEntradaSalida(Long codEntradaSalida) {
        this.codEntradaSalida = codEntradaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  
    public Date getFechaEntradaSalida() {
        return fechaEntradaSalida;
    }

    public void setFechaEntradaSalida(Date fechaEntradaSalida) {
        this.fechaEntradaSalida = fechaEntradaSalida;
    }

    public Date getHoraEntradaSalida() {
        return horaEntradaSalida;
    }

    public void setHoraEntradaSalida(Date horaEntradaSalida) {
        this.horaEntradaSalida = horaEntradaSalida;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public String getUsuarioModif() {
        return usuarioModif;
    }

    public void setUsuarioModif(String usuarioModif) {
        this.usuarioModif = usuarioModif;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaModif() {
        return fechaModif;
    }

    public void setFechaModif(Date fechaModif) {
        this.fechaModif = fechaModif;
    }

    public Deposito getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(Deposito codDeposito) {
        this.codDeposito = codDeposito;
    }

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public Empleado getCodEncargado() {
        return codEncargado;
    }

    public void setCodEncargado(Empleado codEncargado) {
        this.codEncargado = codEncargado;
    }

    public Long getCodPerdida() {
        return codPerdida;
    }

    public void setCodPerdida(Long codPerdida) {
        this.codPerdida = codPerdida;
    }

   

//    public Set<FacturaCompraCab> getFacturaCompraCab() {
//        return facturaCompraCab;
//    }
//
//    public List<FacturaCompraCab> getFacturaCompraCabList() {
//        return new ArrayList(Arrays.asList(facturaCompraCab.toArray(new FacturaCompraCab[0])));
//    }
//
//    public void setFacturaCompraCab(Set<FacturaCompraCab> facturaCompraCab) {
//        this.facturaCompraCab = facturaCompraCab;
//    }

    public Set<EntradaSalidaDetalle> getEntradaSalidaDetalle() {
        return entradaSalidaDetalle;
    }

    public List<EntradaSalidaDetalle> getEntradaSalidaDetalleList() {
        return new ArrayList(Arrays.asList(entradaSalidaDetalle.toArray(new EntradaSalidaDetalle[0])));
    }

    public void setEntradaSalidaDetalle(Set<EntradaSalidaDetalle> entradaSalidaDetalle) {
        this.entradaSalidaDetalle = entradaSalidaDetalle;
    }

    public Long getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(Long nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public Long getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(Long tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEntradaSalida != null ? codEntradaSalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaSalidaCabecera)) {
            return false;
        }
        EntradaSalidaCabecera other = (EntradaSalidaCabecera) object;
        if ((this.codEntradaSalida == null && other.codEntradaSalida != null) || (this.codEntradaSalida != null && !this.codEntradaSalida.equals(other.codEntradaSalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.EntradaSalidaCabecera[codEntradaSalida=" + codEntradaSalida + "]";
    }

}
