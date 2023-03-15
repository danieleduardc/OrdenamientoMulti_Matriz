package tools;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExportarTiempos {
    static List<String> algoritmo = new ArrayList<>(Arrays.asList("NaivStandard", "NaivOnArray", "NaivKahan", "NaivLoopUnrollingTwo", "NaivLoopUnrollingThree", "NaivLoopUnrollingFour", "WinogradOriginal", "WinogradScaled"));

    public static void exportarTiempos(List<Long> lista, int item) throws IOException {
        String rutaArchivo = "src/TimeResult/" +algoritmo.get(item)+ ".txt"; // Especifica la ruta del archivo con el nombre proporcionado
        FileWriter escritor = new FileWriter(rutaArchivo);
        BufferedWriter bufferEscritor = new BufferedWriter(escritor);

        for (Long numero : lista) {
            bufferEscritor.write(numero.toString());
            bufferEscritor.newLine();
        }

        bufferEscritor.close();
    }
}

