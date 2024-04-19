import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    public MainFrame(){
        JFrame ventana = new JFrame("Interfaz Criptomonedas");
        ventana.setLayout(null);

        JButton botonCambio = new JButton("Cambio de moneda");
        botonCambio.setBounds(50, 50, 200, 50);
        botonCambio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton botonPrecios = new JButton("Precio criptomonedas");
        botonPrecios.setBounds(50, 150, 200, 50);
        botonPrecios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
                new ConsultaPrecios();
            }
        });

        JButton botonGestion = new JButton("Gestión de cartera");
        botonGestion.setBounds(50, 250, 200, 50);
        botonGestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        /* Añadir ventanas */
        ventana.add(botonCambio);
        ventana.add(botonPrecios);
        ventana.add(botonGestion);

        /* Configuración ventana */
        ventana.setSize(310, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
}
