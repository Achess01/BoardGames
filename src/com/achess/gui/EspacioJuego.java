package com.achess.gui;

import com.achess.Utils;
import com.achess.casillas.Casilla;
import com.achess.casillas.Propiedad;
import com.achess.juego.Dados;
import com.achess.juego.Jugador;
import com.achess.juego.Tablero;
import com.achess.listas.ListaCasillas;
import com.achess.listas.ListaJugadores;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class EspacioJuego extends JPanel implements Serializable, Utils, Runnable {
    public static JPanel dados = new JPanel();
    private JPanel contenedorDados;
    private JButton moverDados;
    private JPanel tablero;
    private JPanel sur;
    private JPanel oeste;
    private JPanel norte;
    private JPanel este;
    public static JPanel centro = new JPanel();
    private static Tablero campo;
    private JPanel infoJugador;
    private JPanel infoTurno;
    private int valoresDados[];

    public EspacioJuego(Tablero campo){
        this.campo = campo;
        centro.removeAll();
        dados.removeAll();
        //Dados
        dados.setLayout(new BoxLayout(dados, BoxLayout.Y_AXIS));
        moverDados = new JButton("Listo");
        contenedorDados = new JPanel();
        contenedorDados.setLayout(new BoxLayout(contenedorDados, BoxLayout.Y_AXIS));
        contenedorDados.add(moverDados);
        contenedorDados.add(dados);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        int tamanio = this.campo.getCasillas().getTamanio();
        ListaCasillas listaCasilla = this.campo.getCasillas();
        //moverDados.setPreferredSize(new Dimension(50, 50));
        infoJugador = new JPanel();
        infoJugador.setLayout(new BoxLayout(infoJugador, BoxLayout.Y_AXIS));
        mostrarJugadores();
        centro.setLayout(new GridBagLayout());
        centro.add(contenedorDados);
        centro.add(infoJugador);
        centro.add(infoJugador);
        sur = new JPanel();
        sur.setBorder(new LineBorder(Color.BLACK));
        sur.setLayout(new BoxLayout(sur, BoxLayout.X_AXIS));
        oeste = new JPanel();
        oeste.setBorder(new LineBorder(Color.BLACK));
        oeste.setLayout(new BoxLayout(oeste, BoxLayout.Y_AXIS));
        norte = new JPanel();
        norte.setBorder(new LineBorder(Color.BLACK));
        norte.setLayout(new BoxLayout(norte, BoxLayout.X_AXIS));
        este = new JPanel();
        este.setBorder(new LineBorder(Color.BLACK));
        este.setLayout(new BoxLayout(este, BoxLayout.Y_AXIS));
        int s = tamanio/4 + tamanio%4;
        int o = tamanio/4;
        int n = o;
        int e = n;
        Casilla aux;
        aux = listaCasilla.getInicio();
        sur.add(aux);
        System.out.println(tamanio);
        for(int x = 0; x < tamanio - 1; x++){
            aux = aux.getSiguiente();
            if(x < s){
                sur.add(aux);
            }
            else if(x < (s + o)){
                oeste.add(aux);
            }
            else if(x < (s + o + n)){
                norte.add(aux);
            }
            else if(x < (s+o+n+e)){
                este.add(aux);
            }

        }
        infoTurno = new JPanel();
        infoTurno.setLayout(new BoxLayout(infoTurno, BoxLayout.Y_AXIS));
        centro.add(infoTurno);
        jugadorTurno();
        tablero = new JPanel();
        cambiarOrden(sur);
        cambiarOrden(oeste);
        tablero.setLayout(new BorderLayout());
        tablero.add(sur, BorderLayout.SOUTH);
        tablero.add(oeste, BorderLayout.WEST);
        tablero.add(norte, BorderLayout.NORTH);
        tablero.add(este, BorderLayout.EAST);
        tablero.add(centro, BorderLayout.CENTER);
        add(tablero);

        moverDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                moverDados.setEnabled(false);
                dados.removeAll();
                Thread Tdados[] = new Thread[campo.getCantidadDados()];
                valoresDados = new int[Tdados.length];
                int it = 0;
                for (Thread dado : Tdados) {
                    Dados d = new Dados();
                    d.valor();
                    dado = new Thread(d);
                    dado.start();
                    valoresDados[it] = d.getValor();
                    System.out.println(valoresDados[it]);
                    it++;
                    SwingUtilities.updateComponentTreeUI(centro);
                }

                SwingUtilities.updateComponentTreeUI(centro);
                Thread m = new Thread(EspacioJuego.this::run);
                m.start();
            }
        });

    }

    private void jugadorTurno(){
        Jugador j = campo.getTurno();
        Propiedad p[] = j.getPropiedades();
        infoTurno.removeAll();
        infoTurno.setBackground(j.getFondo());
        infoTurno.add(new Label("TURNO", Label.CENTER));
        infoTurno.add(new Label("Jugador: " + j.getNombre(), Label.CENTER));
        infoTurno.add(new Label("Propiedades", Label.CENTER));
        if(p.length > 0){
            for (Propiedad propiedad : p) {
                infoTurno.add(new Label("Nombre "+ propiedad.getNombre(), Label.CENTER));
                infoTurno.add(new Label("\tEstado: " + (propiedad.isHipoteca() ? "Hipotecado" : "Sin hipotecar"), Label.CENTER));
            }
        }
        SwingUtilities.updateComponentTreeUI(infoTurno);

    }
    private void mostrarJugadores(){
        infoJugador.removeAll();
        ListaJugadores l = campo.getJugadores();
        Jugador j = l.getInicio();
        for(int x = 0; x < l.getTamanio(); x++){
            infoJugador.add(new Label("Nombre: " + j.getNombre()));
            infoJugador.add(new Label("Dinero: Q" + j.getDinero()));
            infoJugador.add(new Label("Casilla actual: " + j.getActual()));
            infoJugador.add(new Label("____________________________"));
            j = j.getSiguiente();
        }
        SwingUtilities.updateComponentTreeUI(centro);
    }

    public static Tablero getCampo() {
        return campo;
    }

    public static void setCampo(Tablero campo) {
        EspacioJuego.campo = campo;
    }

    private void cambiarOrden(JPanel component){
        Component lista[] = component.getComponents();
        component.removeAll();
        for (int x = lista.length - 1; x >= 0; x--){
            component.add(lista[x]);
        }
    }

    @Override
    public void run() {
        esperarXsegundos(1300);
        Jugador t = campo.getTurno().comprobarDados(valoresDados);
        if(t.getPerderTurno() != 0) {
            t.setPerderTurno(t.getPerderTurno() - 1);
            JOptionPane.showMessageDialog(null, t.getNombre() + ", le quedan " + t.getPerderTurno()
            + " turnos de espera");
            t = t.getSiguiente();
        }
        campo.setTurno(t);
        moverDados.setEnabled(true);
        mostrarJugadores();
        jugadorTurno();
        if(campo.getJugadores().getTamanio() == 1){
            JOptionPane.showMessageDialog(null, "El ganador es " + t.getNombre());
        }
    }
}
