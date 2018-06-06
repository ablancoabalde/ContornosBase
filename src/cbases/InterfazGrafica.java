package cbases;

import cbases.Paneles.*;
import static cbases.Paneles.PanelUpdate.tNombre;
import static cbases.Paneles.PanelUpdate.tNota;
import java.awt.GridBagLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazGrafica {

    static DefaultTableModel modelo = new DefaultTableModel();
    static DefaultTableModel modelo2 = new DefaultTableModel();

    // Instancio la clase metodos
    Metodos met = new Metodos();

    // Layout que permite cambiar los JPanel Forms
    GridBagLayout layout = new GridBagLayout();
    PanelTable ptable;
    PanelAdd padd;
    PanelUpdate pUpd;
    PanelSearch pSear;

    static int referencia;
    static String nombre;
    static int nota;

    /**
     * Metodo que añade los paneles a un panel contenedor que está contenido en
     * el Main y controla la presentación inicial de este
     */
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

        // Establece el tamaño del contenedor a los JPanel
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

    /**
     * Recibe el nombre del botón que se ha pulsado y dependiendo de lo que
     * reciba, actua de manera consecuente
     *
     * @param nombre
     */
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
                break;
        }

    }

    /**
     * Carga el valor por defecto de los JPanels y los configura
     */
    private void modeloTable() {
        modelo = (DefaultTableModel) PanelTable.jTAlumnos.getModel();
        modelo2 = (DefaultTableModel) PanelSearch.TablaSearch.getModel();
    }

    /**
     * Metodo que llama un metodo de la clase Metodos que carga los datos
     * recogidos, en la Tabla jTAlumnos
     */
    public void mostrarDatosTabla() {
        met.btnCargar(modelo);
    }

    /**
     * Metodo que llama un metodo de la clase Metodos el cual se le pasa los
     * valores nombre y nota que recoge del PanelAdd
     *
     * @param nombre
     * @param nota
     */
    public void addAlumno(String nombre, int nota) {
        met.btnAddAlumno(nombre, nota);
    }

    /**
     * Metodo que llama un metodo de la clase Metodos, el cual comprueba si ha
     * sido seleccionado primero un alumno en el jTAlumnos, si es así recoge los
     * datos de la tabla y transfiere la referencia de dicho alumno
     */
    public void deleteAlumno() {
        if (referencia != 0) {
            met.btnDelete(referencia);
            this.borrar();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione primero un Alumno de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }

    /**
     * Metodo que llama un metodo de la clase Metodos, que recoge y envia los
     * datos introducidos en el PanelUpdate
     *
     * @param nombre
     * @param nota
     */
    public void updateAlumno(String nombre, int nota) {
        met.btnUpdate(referencia, nombre, nota);
        this.borrar();
    }

    /**
     * Metodo que llama un metodo de la clase Metodos, que recoge y envia los
     * datos introducidos en el PanelSearch y el modelo de la tabla a cargar
     *
     * @param ref
     */
    public void searchAlumno(int ref) {
        met.btnSearch(modelo2, ref);
        this.borrar();
    }

    /**
     * Recoge los valores al pulsar sobre la tabla y los almacena en variables
     * locales
     *
     * @param refrecog
     * @param nombrerecog
     * @param notarecog
     */
    public void recogerDatos(int refrecog, String nombrerecog, int notarecog) {
        referencia = refrecog;
        nombre = nombrerecog;
        nota = notarecog;
    }

    // 
    /**
     * Mete los valores recogidos en las cajas de texto del panel Update,
     * siempre y cuando se haya seleccionado primero un alumno de jTAlumnos
     */
    public void datosCajas() {
        if (referencia != 0) {
            tNombre.setText(nombre);
            tNota.setText(String.valueOf(nota));
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione primero un Alumno de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }

    /**
     * Reinicia valores a 0 o null
     */
    public void borrar() {
        referencia = 0;
        nombre = null;
        nota = 0;
        tNombre.setText(null);
        tNota.setText(null);
    }
}
