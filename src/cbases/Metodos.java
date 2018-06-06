package cbases;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class Metodos {

    // Instancio la clase Base de datos 
    BaseDatos bd = new BaseDatos();
    Alumno alumno;

    /**
     * Recibe un modelo de tabla y lo limpia para poder recargarle nuevos
     * valores
     *
     * @param modelo
     */
    private void limpiarTable(DefaultTableModel modelo) {
        // Limpia la tabla
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
    }

    /**
     * Metodo que carga los datos recogidos de la base de datos en la tabla
     * jTAlumno
     *
     * @param modelo
     */
    public void btnCargar(DefaultTableModel modelo) {
        this.limpiarTable(modelo);

        modelo.addColumn("Referencia");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");

        Iterator<Alumno> it = bd.bdCargar().iterator();
        while (it.hasNext()) {
            Alumno a = it.next();
            modelo.addRow(new Object[]{a.getRef(), a.getNombre(), a.getNota()});
        }

    }

    /**
     * Metodo que crea un nuevo alumno con los parametros recogidos y los
     * exporta a la base de datos
     *
     * @param nombre
     * @param nota
     */
    public void btnAddAlumno(String nombre, int nota) {
        alumno = new Alumno(0, nombre, nota);
        bd.addAlumno(alumno);
    }

    /**
     * Metodo que exporta la referencia recogido para su borrado de la base de
     * datos
     *
     * @param ref
     */
    public void btnDelete(int ref) {
        bd.deleteAlumno(ref);
    }

    /**
     * Metodo que exporta los nuevos parametros a cambiar y busca en la base de
     * datos a traves de la referencia para cambiar los datos nuevos.
     *
     * @param ref
     * @param nombre
     * @param nota
     */
    public void btnUpdate(int ref, String nombre, int nota) {
        bd.updateAlumno(ref, nombre, nota);
    }

    /**
     * Metodo que carga los datos recogidos de la base de datos, tras realizar
     * la busqueda de la referencia. En la tabla TablaSearch.
     *
     * @param modelo2
     * @param ref
     */
    public void btnSearch(DefaultTableModel modelo2, int ref) {
        this.limpiarTable(modelo2);

        modelo2.addColumn("Referencia");
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Nota");

        Iterator<Alumno> it = bd.searchAlumno(ref).iterator();
        while (it.hasNext()) {
            Alumno a = it.next();
            modelo2.addRow(new Object[]{a.getRef(), a.getNombre(), a.getNota()});
        }
    }
}
