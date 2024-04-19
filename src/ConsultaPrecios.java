import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultaPrecios {
    public ConsultaPrecios(){
        CriptomonedasAPI api = new CriptomonedasAPI();
        api.mostrarPrimeraID();

        JFrame ventana = new JFrame("Consultar Precios");
        ventana.setLayout(null);


        /* Configuración ventana */
        ventana.setSize(500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
}
