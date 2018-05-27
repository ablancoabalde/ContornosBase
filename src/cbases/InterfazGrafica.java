package cbases;

import cbases.Paneles.*;
import static cbases.Paneles.PanelTable.jTAlumnos;
import java.awt.GridBagLayout;
import javax.swing.table.DefaultTableModel;

public class InterfazGrafica {

    DefaultTableModel modelo = new DefaultTableModel();
    Metodos met = new Metodos();

    GridBagLayout layout = new GridBagLayout();
    PanelTable ptable;
    PanelAdd padd;
    PanelUpdate pUpd;
    PanelSearch pSear;

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
    }

    public void mostrarPanel(String nombre) {
        this.modeloTable();
        switch (nombre) {
            case "Cargar":
                ptable.setVisible(true);
                padd.setVisible(false);
                pUpd.setVisible(false);
                pSear.setVisible(false);
                this.mostrarDatosTabla(modelo);
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
                break;
            case "Buscar":
                ptable.setVisible(false);
                padd.setVisible(false);
                pUpd.setVisible(false);
                pSear.setVisible(true);
                break;
        }

    }

    private void modeloTable() {
        modelo = (DefaultTableModel) PanelTable.jTAlumnos.getModel();
    }

    public void mostrarDatosTabla(DefaultTableModel modelo) {
        met.btnCargar(modelo);
    }
    
    public void addAlumno(String nombre, int nota){
        met.btnAddAlumno(nombre, nota);
    }

}
