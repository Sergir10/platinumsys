/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Marca;

/**
 *
 * @author FerBoy
 */
public class MarcaController extends AbstractJpaDao<Marca> {

    public MarcaController() {
        super();
    }


    @Override
    public Marca findById(Long id) {
                return (Marca) this.findById(Marca.class, id);
    }

       @Override
    public List<Marca> getAll(String orderBy) {
        return this.getAll(Marca.class, orderBy);
     }


    /**
     * Este metodo realiza la consulta de acuerdo a los campos de filtro, la
     * busqueda se realiza en forma aproximada con el uso del operador like
     * @param codigo
     * @param descripcion
     *
     * @return lista de Marcas que cumplen con la condicion de busqueda
     */
    public List<Marca> getMarcas(String codigo, String descripcion) {
        //Armamos el sql String
        String SQL = "SELECT o FROM Marca o WHERE o.codMarca = o.codMarca";

        if (codigo != null && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codMarca) like UPPER(:codigo)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.nombreSeccion) like UPPER(:descripcion)";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        //Seteamos los parametros
        if (codigo != null && !codigo.equals("")) {
            q.setParameter("codigo", "%" + codigo + "%");
        }

        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%" + descripcion + "%");
        }

        //Realizamos la busqueda
        List<Marca> entities = q.getResultList();
        em.close();

        //retornamos la lista
        return entities;

      }

}
