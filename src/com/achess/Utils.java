package com.achess;

import com.achess.gui.EspacioJuego;
import com.achess.juego.Tablero;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public interface Utils {
    default int numerosAleatorios(int min, int max){
        int aleatorio = (int)Math.floor(Math.random()*(max - min +1) + min);
        return aleatorio;
    }

    default void esperarXsegundos(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    default void guardarFichero(String extension, Tablero campo){
        JFileChooser guardar = new JFileChooser();
        guardar.showSaveDialog(null);
        guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        File archivo = guardar.getSelectedFile();
        try{
            ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream(archivo.getPath()+ "." + extension));
            fichero.writeObject(campo);
            fichero.close();
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
            System.out.println(ex);
        }
    }

    default EspacioJuego abrirFichero(String descripcion, String extension){
        JFileChooser cargar = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(descripcion,extension);
        cargar.setFileFilter(filtro);
        cargar.showOpenDialog(null);
        cargar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        File archivo = cargar.getSelectedFile();
        try{
            ObjectInputStream fichero = new ObjectInputStream(new FileInputStream(archivo.getPath()));
            Tablero nuevo = (Tablero) fichero.readObject();
            fichero.close();
            EspacioJuego espacioJuego = new EspacioJuego(nuevo);
            return espacioJuego;

        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo");
            return null;
        }
    }

}
