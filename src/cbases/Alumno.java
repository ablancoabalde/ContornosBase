package cbases;

public class Alumno {

    private int ref;
    private String nombre;
    private int nota;

    public Alumno() {
    }

    public Alumno(int ref, String nombre, int nota) {
        this.ref = ref;
        this.nombre = nombre;
        this.nota = nota;        
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return  "ref=" + ref + ", nombre=" + nombre + ", nota=" + nota ;
    }


}
