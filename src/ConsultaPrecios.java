import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * 0 -> Bitcoin
 * 1 -> Etherium
 * 4 -> Solana
 * 9 -> Dogecoin
 * 10 -> Cardano
 * */

public class ConsultaPrecios {
    public ConsultaPrecios(){
        CriptomonedasAPI api = new CriptomonedasAPI();
        JFrame ventana = new JFrame("Consultar Precios");
        ventana.setLayout(null);

/* PARTE SUPERIOR*/
        /* Texto superior */
        JLabel textoCripto = new JLabel("Seleccione una criptomoneda");
        textoCripto.setBounds(150, 10, 200, 50);

        /* Desplegable de opciones*/
        JComboBox<String> desplegable = new JComboBox<>();
        /*desplegable.addItem(api.mostrarID(0).toUpperCase());
        desplegable.addItem(api.mostrarID(1).toUpperCase());
        desplegable.addItem(api.mostrarID(4).toUpperCase());
        desplegable.addItem(api.mostrarID(9).toUpperCase());
        desplegable.addItem(api.mostrarID(10).toUpperCase());*/
        desplegable.setBounds(170,60,140,60);

/* PARTE INFERIOR*/





        /* Añadir elementos */
        ventana.add(textoCripto);
        ventana.add(desplegable);

        /* Configuración ventana */
        ventana.setSize(500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
}
