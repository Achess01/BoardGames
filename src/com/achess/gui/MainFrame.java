package com.achess.gui;

import com.achess.juego.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame  extends JFrame {
    private final int WIDTH = 750;
    private final int  HEIGHT = 450;
    public MainFrame(){
       // setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        //setResizable(false);
        setVisible(true);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = miPantalla.getScreenSize();
        int alto = tamanoPantalla.height;
        int ancho = tamanoPantalla.width;
        this.setSize(2*(ancho/3), 2*(alto/3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Juegos de mesa");
        JPanel panelBienvenida = new JPanel();
        JLabel mensaje = new JLabel("BIENVENIDO", JLabel.CENTER);
        mensaje.setFont(new Font("Nuevo",1,45));
        panelBienvenida.add(mensaje);
        this.setJMenuBar(navBar());
        this.setContentPane(panelBienvenida);
    }

    @Override
    public void setContentPane(Container contentPane) {
        super.setContentPane(contentPane);
        SwingUtilities.updateComponentTreeUI(this);
    }

    private JMenuBar navBar(){
            JMenuBar menuBar = new JMenuBar();
            JMenu menuFile = new JMenu("Archivo");

            //Opciones del menu Archivo
            JMenuItem newGame = new JMenuItem("Crear juego");
            newGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Tablero t = new Tablero("Juego", 3, 1400, 27,
                            200, 2, 2, 2, 20);
                    EspacioJuego espacioJuego = new EspacioJuego(t);
                    setContentPane(espacioJuego);
                    t.getCasillas().listar();
                    pack();
                }
            });
            JMenuItem editGame = new JMenuItem("Editar juego");
            JMenu play = new JMenu("Jugar");
            JMenuItem nuevo = new JMenuItem("Nuevo");
            JMenuItem load = new JMenuItem("Cargar");
            play.add(nuevo);
            play.add(load);
            JMenuItem ranking = new JMenuItem("Ranking");
            JMenuItem about = new JMenuItem("Acerca de");


            menuFile.add(newGame);
            menuFile.add(editGame);
            menuFile.add(play);
            menuFile.add(ranking);
            menuFile.add(about);
            menuBar.add(menuFile);
            return menuBar;
    }
}
