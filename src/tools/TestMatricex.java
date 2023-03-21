package tools;

import java.io.IOException;

public class TestMatricex {

    public static void ExportAllMatrix() throws IOException {
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz2x2,1);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz4x4,2);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz8x8,3);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz16x16,4);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz32x32,5);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz64x64,6);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz128x128,7);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz256x256,8);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz512x512,9);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz1024x1024,10);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz2048x2048,11);
        ExportarTiempos.exportarTiemposMatriz(TiempoEjecucion.matriz4096x4096,12);
    }
}
