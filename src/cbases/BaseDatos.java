package cbases;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BaseDatos {

    Connection connect;

    // Medoto para conectar la base
    public void conectar() {
        try {
            // Funcion que permite abrir la base de datos creada
            // en este caso la URL solo es miBd.bd, pues la cree dentro de la carpeta del proyecto
            // Si se encontrase en otro ubicación abría que poner la URL
            connect = DriverManager.getConnection("jdbc:sqlite:miBase.db");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectadar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// Medoto para desconectar la base

    public void desconectar() {
        try {
            // Funcion que cierra la base
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Metodo que carga los datos de la base y en este caso los muestra por una Tabla del Neatbeans
    public ArrayList bdCargar() {
        ArrayList<Alumno> listAlumno = new ArrayList();
        this.conectar();

        // Limpiar la lista, para que cuando se recargue no se duplique
        listAlumno.clear();
        try {
            // Metodo de sql que crea un Objeto de sql            
            Statement s = connect.createStatement();
            // Consulta para introducir una Query y con el ResultSet
            // recoge el Array de la consulta
            ResultSet rs = s.executeQuery("select * from Alumno");

            // Recorremos el Array y vamos introduciendo los datos en la tabla
            while (rs.next()) {
                listAlumno.add(new Alumno(rs.getInt(1), rs.getString(2), rs.getInt(3)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.desconectar();

        return listAlumno;
    }

    // Metodo que agrega un Alumno a la tabla Alumno
    public void addAlumno(Alumno alumno) {
        this.conectar();
        try {
            // Metodo prepareStament que no devuelve nada y con la instruccion para
            // insertar un nuevo usuario
            PreparedStatement st = connect.prepareStatement("insert into Alumno values (?,?,?)");
            // Recoge los valores que estan un Textfield y los números indican la Row de la base
            // donde se va a insertar
//             st.setInt(1, alumno.getRef());
            st.setString(2, alumno.getNombre());
            st.setInt(3, alumno.getNota());

            // Ejecuta la consulta
            st.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Alumno no guardado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            System.err.println(ex.getMessage());
        }
        this.desconectar();

//        this.bdCargar(Main.modelo);
    }

    // Metodo que elimina un Alumno de la tabla Alumno a traves de la Refencia de este
    public void deleteAlumno(int ref) {
        this.conectar();

        try {
            // Metodo de sql que crea un Objeto de sql    
            Statement st = connect.createStatement();
            // borra un usuario en concreto
            st.executeUpdate("delete from Alumno where Ref=" + ref + ";");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Alumno no eliminado", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }

        this.desconectar();
    }

    // Metodo que actualiza un Alumno de la tabla alumno, por unos valores nuevos que recibe
    public void updateAlumno(int ref, String nombre, int nota) {
        this.conectar();

        try {
            // Metodo de sql que crea un Objeto de sql    
            Statement st = connect.createStatement();
            // Metodo del objeto sql, que actualiza la base y no devuelve nada
            st.executeUpdate("update Alumno set Nombre = '" + nombre + "' , Nota = '" + nota + "' WHERE Ref = " + ref + "");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }

        this.desconectar();
//        this.bdCargar(Main.modelo);
    }

    // Metodo que busca un Alumno a traves de una referencia y lo carga en un table del NeatBeans
    public ArrayList searchAlumno(int ref) {
        ArrayList<Alumno> listAlumno = new ArrayList();
        this.conectar();

        // Limpiar la lista, para que cuando se recargue no se duplique
        listAlumno.clear();

        try {

            Statement s = connect.createStatement();
            // Busca en la base de datos una Referencia introducida si la encuentra
            // guarda los datos recibidos y los almacenas en rs
            ResultSet rs = s.executeQuery("select * from Alumno where Ref like'%" + ref + "%'");
            // Recorremos el Array y vamos introduciendo los datos en la tabla
            while (rs.next()) {
                listAlumno.add(new Alumno(rs.getInt(1), rs.getString(2), rs.getInt(3)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.desconectar();
        return listAlumno;
    }

}
