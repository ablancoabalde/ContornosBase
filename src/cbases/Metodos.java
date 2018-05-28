package cbases;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class Metodos {

    BaseDatos bd = new BaseDatos();
    Alumno alumno;

    private void limpiarTable(DefaultTableModel modelo) {
        // Limpia la tabla
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
    }

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

    public void btnAddAlumno(String nombre, int nota) {
        alumno = new Alumno(0, nombre, nota);
        bd.addAlumno(alumno);
    }
    
    public void btnDelete(int ref){
        bd.deleteAlumno(ref);
    }
    
    public void btnUpdate(int ref,String nombre, int nota){
        bd.updateAlumno(ref, nombre, nota);
    }
    
    public void btnSearch(DefaultTableModel modelo2,int ref){
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
