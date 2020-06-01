package com.achess.juego;

import com.achess.casillas.Casilla;
import com.achess.casillas.Lugar;
import com.achess.casillas.Propiedad;
import com.achess.gui.EspacioJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class Jugador extends JPanel implements Serializable {
    public static final Color COLOR_FICHA[] = {Color.BLUE, Color.CYAN, Color.GRAY, Color.YELLOW,
    Color.MAGENTA, Color.RED};
    public static int letra = 65;
    private String nombre;
    private Propiedad propiedades[] = new Propiedad[0];
    private int salirCarcel;
    private int dinero;
    private Jugador siguiente;
    private Jugador anterior;
    private Casilla actual;
    private Color fondo;
    private int perderTurno;
    private Tablero campo;

    public Jugador(int index, int dinero, Tablero campo){
        this.dinero = dinero;
        this.campo = campo;
        salirCarcel = 0;
        perderTurno = 0;
        actual = null;
        siguiente = null;
        anterior = null;
        nombre = Character.toString(letra);
        letra++;
        this.fondo = COLOR_FICHA[index];
        //setPreferredSize(new Dimension(30, 50));
        setBackground(this.fondo);
        add(new Label(nombre), JLabel.CENTER);
    }

    public int getLugares(int indexGrupo){
        int cL = 0;
        int cantidad = 0;
        for (Propiedad propiedad : propiedades) {
            if(propiedad instanceof Lugar){
                cL++;
            }
        }
        Lugar l[] = new Lugar[cL];
        cL = 0;
        for (Propiedad propiedad : propiedades) {
            if(propiedad instanceof Lugar){
               l[cL] = (Lugar) propiedad;
               cL++;
            }
        }

        for (Lugar lugar : l) {
            if(lugar.getGrupo() == indexGrupo){
                cantidad++;
            }
        }
        return cantidad;
    }
    public void agregarPropiedad(Propiedad propiedad){
        propiedades = agregar(propiedades, propiedad);
    }
    public void mover(Casilla casilla){
        if(actual != null){
            actual.getEspacioJugadores().remove(this);
            SwingUtilities.updateComponentTreeUI(actual);
        }
        actual = casilla;
        casilla.getEspacioJugadores().add(this);
        SwingUtilities.updateComponentTreeUI(actual);
    }

    public Jugador comprobarDados(int valoresDados[]){
            int iguales = 0;
            int suma = 0;

            for (int valorDado : valoresDados) {
                suma += valorDado;
            }

            calcularMovimiento(suma);
            SwingUtilities.updateComponentTreeUI(EspacioJuego.centro);
            if (valoresDados.length > 1) {
                for (int i = 0; i < valoresDados.length - 1; i++) {
                    if (valoresDados[i] == valoresDados[i + 1]) {
                        iguales++;
                    }
                }
                if (iguales == valoresDados.length - 1) {
                    JOptionPane.showMessageDialog(null, "¡Los números de los dados son iguales!\n " +
                            "Tiene otro turno");
                    return this;
                }
            }
            actual.accion(this);
            return getSiguiente();

    }

    public Tablero getCampo() {
        return campo;
    }

    public void setCampo(Tablero campo) {
        this.campo = campo;
    }

    public Color getFondo() {
        return fondo;
    }

    public void setFondo(Color fondo) {
        this.fondo = fondo;
    }

    private void calcularMovimiento(int suma){
        Casilla aux = actual;
        for (int i = 0; i < Math.abs(suma); i++) {
            if(suma > 0) {
                aux = aux.getSiguiente();
                if(aux.equals(campo.getCasillas().getInicio())){
                    setDinero(getDinero() + campo.getCantidadDineroPorVuelta());
                }
            }
            else {
                aux = aux.getAnterior();
            }
        }
        mover(aux);
    }

    public int getPerderTurno() {
        return perderTurno;
    }

    public void setPerderTurno(int perderTurno) {
        this.perderTurno = perderTurno;
    }

    public Casilla getActual() {
        return actual;
    }

    public void setActual(Casilla actual) {
        this.actual = actual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Propiedad[] getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(Propiedad[] propiedades) {
        this.propiedades = propiedades;
    }

    public int getSalirCarcel() {
        return salirCarcel;
    }

    public void setSalirCarcel(int salirCarcel) {
        this.salirCarcel = salirCarcel;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
        if(dinero <= 0){
            actual.remove(this);
            SwingUtilities.updateComponentTreeUI(actual);
            campo.getJugadores().eliminar(this);
        }
    }

    public Jugador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Jugador siguiente) {
        this.siguiente = siguiente;
    }

    public Jugador getAnterior() {
        return anterior;
    }

    public void setAnterior(Jugador anterior) {
        this.anterior = anterior;
    }

    private Propiedad[] agregar(Propiedad arreglo[], Propiedad elemento){
        Propiedad a[] = new Propiedad[arreglo.length +1];
        a[arreglo.length] = elemento;
        for(int x = 0; x < arreglo.length; x++){
            a[x] = arreglo[x];
        }
        return a;
    }
}
