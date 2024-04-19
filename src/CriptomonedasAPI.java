import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
/* Importada libreria externa JSON Simple desde un .jar, para poder leer la URL de la API REST*/
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CriptomonedasAPI{
    private String inline = "";
    private JSONArray data_arr;

    public void leerUrl(){
        try {
            URL url = new URL("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd"); // URL de la API de criptomonedas

            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // Establecer conexión con la URL
            conn.setRequestMethod("GET"); // Método de petición de la API
            conn.connect();// Conecta a la URL

            int responsecode = conn.getResponseCode(); // Obtener código de respuesta

            /* Si la respuesta no es 200, lanzar excepción
             https://developer.mozilla.org/es/docs/Web/HTTP/Status */
            if (responsecode != 200) {
                throw new RuntimeException("Código de error: " + responsecode);
            } else {
                Scanner scanner = new Scanner(url.openStream());

                // Guarda el contenido del JSON en una string unsando el scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                // Cerrar el scanner
                scanner.close();
            }
        } catch (Exception e) { // Captura cualquier excepción
            e.printStackTrace();
        }
    }

    public void leerJSON(){
        try{
            leerUrl();
            JSONParser parse = new JSONParser(); // Crear un parser para el JSON
            data_arr = (JSONArray) parse.parse(inline); // Parsear la string de la API a un array JSON
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarID(){
        leerJSON();
        if (data_arr != null) { // Comprueba si data_arr es null (por algún fallo de conexión con la API)
            // Recorre cada elemento del array JSON
            for (Object obj: data_arr){
                JSONObject criptomoneda = (JSONObject) obj;
                System.out.println(criptomoneda.get("id")); // Accede al id de cada criptomoneda y la imprime
            }
        } else {
            System.out.println("No se pudo obtener datos de la API");
        }
    }

    public void mostrarPrimeraID(){
        leerJSON();
        if (data_arr != null) { // Comprueba si data_arr es null o está vacío
            JSONObject criptomoneda = (JSONObject) data_arr.get(0); // Obtiene el primer elemento del array JSON
            System.out.println(criptomoneda.get("id")); // Imprime el id de la criptomoneda
        } else {
            System.out.println("No se pudo obtener datos de la API");
        }
    }

    public CriptomonedasAPI(){
    }
}