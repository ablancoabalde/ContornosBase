package cbases;

import cbases.Paneles.*;
import static cbases.Paneles.PanelTable.jTAlumnos;
import static cbases.Paneles.PanelUpdate.tNombre;
import static cbases.Paneles.PanelUpdate.tNota;
import java.awt.GridBagLayout;
import javax.swing.table.DefaultTableModel;

public class InterfazGrafica {

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    
    Metodos met = new Metodos();

    GridBagLayout layout = new GridBagLayout();
    PanelTable ptable;
    PanelAdd padd;
    PanelUpdate pUpd;
    PanelSearch pSear;

    static int referencia;
    static String nombre;
    static int nota;

    public void addPanel() {
        ptable = new PanelTable();
        padd = new PanelAdd();
        pUpd = new PanelUpdate();
        pSear = new PanelSearch();

        Main.PanelContenedor.setLayout(layout);
        Main.PanelContenedor.add(ptable);
        Main.PanelContenedor.add(padd);
        Main.PanelContenedor.add(pUpd);
        Main.PanelContenedor.add(pSear);

        System.out.println(Main.PanelContenedor.getSize());
        ptable.setSize(Main.PanelContenedor.getSize());
        ptable.setPreferredSize(Main.PanelContenedor.getSize());

        padd.setSize(Main.PanelContenedor.getSize());
        padd.setPreferredSize(Main.PanelContenedor.getSize());

        pUpd.setSize(Main.PanelContenedor.getSize());
        pUpd.setPreferredSize(Main.PanelContenedor.getSize());

        pSear.setSize(Main.PanelContenedor.getSize());
        pSear.setPreferredSize(Main.PanelContenedor.getSize());

        padd.setVisible(false);
        pUpd.setVisible(false);
        pSear.setVisible(false);
        this.modeloTable();
    }

    public void mostrarPanel(String nombre) {
        
        switch (nombre) {
            case "Cargar":
                ptable.setVisible(true);
                padd.setVisible(false);
                pUpd.setVisible(false);
                pSear.setVisible(false);
                this.mostrarDatosTabla();
                break;
            case "Añadir":
                ptable.setVisible(false);
                padd.setVisible(true);
                pUpd.setVisible(false);
                pSear.setVisible(false);
                break;
            case "Modificar":
                ptable.setVisible(false);
                padd.setVisible(false);
                pUpd.setVisible(true);
                pSear.setVisible(false);
                this.datosCajas();
                break;
            case "Buscar":
                ptable.setVisible(false);
                padd.setVisible(false);
                pUpd.setVisible(false);
                pSear.setVisible(true);
                //?
               // this.searchAlumno(referencia);
                break;
        }

    }

    private void modeloTable() {
        modelo = (DefaultTableModel) PanelTable.jTAlumnos.getModel();
        modelo2= (DefaultTableModel) PanelSearch.TablaSearch.getModel();
    }

    public void mostrarDatosTabla() {
        met.btnCargar(modelo);
    }

    public void addAlumno(String nombre, int nota) {
        met.btnAddAlumno(nombre, nota);
    }

    public void deleteAlumno() {
        met.btnDelete(referencia);
    }

    public void updateAlumno(String nombre, int nota) {
        met.btnUpdate(referencia, nombre, nota);
    }

    public void searchAlumno(int ref) {
        met.btnSearch(modelo2, ref);
    }

    // Recoge los valores al pulsar sobre la tabla y los almacena en variables locales
    public void recogerDatos(int refrecog, String nombrerecog, int notarecog) {
        referencia = refrecog;
        nombre = nombrerecog;
        nota = notarecog;
    }

    // Mete los valores recogidos en las de texto del panel Update
    public void datosCajas() {
        tNombre.setText(nombre);
        tNota.setText(String.valueOf(nota));
    }
}
