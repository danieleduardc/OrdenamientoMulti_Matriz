import tools.ExportarTiempos;
import tools.LeerArchivoTxt;
import tools.TestMatricex;
import tools.TiempoEjecucion;

import javax.swing.*;
import java.io.IOException;

public class Main {
    static long inicio;
    static long fin;
    static int[][] Matriz1;
    static int[][] Matriz2;

    public static void main(String[] args) {
        // eleccion del algoritmo
        for(int algoritmo = 11; algoritmo <= 16; algoritmo++) {
            //iteraciones por las diferentes matrices nxn
            for (int caso = 1; caso <= 12; caso++) {
                matrices(caso);
                algorithm(algoritmo);
            }
            System.out.println("Termino algoritmo: " + algoritmo);
            try {
                ExportarTiempos.exportarTiempos(TiempoEjecucion.matricesTiempoAlgoritmos, algoritmo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            TiempoEjecucion.ResulTimeMatrix(TiempoEjecucion.matricesTiempoAlgoritmos.size());
            TiempoEjecucion.matricesTiempoAlgoritmos.clear();
        }
        try {
            TestMatricex.ExportAllMatrix();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void matrices(int caso){
        switch (caso){
            case 1:{
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_2x2.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_2x2.txt",(int)Math.pow(2, caso));
                break;
            }
            case 2:{
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_4x4.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_4x4.txt",(int)Math.pow(2, caso));
                break;
            }
            case 3: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_8x8.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_8x8.txt",(int)Math.pow(2, caso));
                break;
            }
            case 4: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_16x16.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_16x16.txt",(int)Math.pow(2, caso));
                break;
            }
            case 5: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_32x32.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_32x32.txt",(int)Math.pow(2, caso));
                break;
            }
            case 6: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_64x64.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_64x64.txt",(int)Math.pow(2, caso));
                break;
            }
            case 7: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_128x128.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_128x128.txt",(int)Math.pow(2, caso));
                break;
            }
            case 8: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_256x256.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_256x256.txt",(int)Math.pow(2, caso));
                break;
            }
            case 9: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_512x512.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_512x512.txt",(int)Math.pow(2, caso));
                break;
            }
            case 10: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_1024x1024.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_1024x1024.txt",(int)Math.pow(2, caso));
                break;
            }
            case 11: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_2048x2048.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_2048x2048.txt",(int)Math.pow(2, caso));
                break;
            }
            case 12: {
                Matriz1 = LeerArchivoTxt.leerArchivo("src/1matriz/1matriz_4096x4096.txt",(int)Math.pow(2, caso));
                Matriz2 = LeerArchivoTxt.leerArchivo("src/2matriz/2matriz_4096x4096.txt",(int)Math.pow(2, caso));
                break;
            }
        }//cierra SWITCH
    }

    public static void algorithm(int option){
        switch (option){
            case 1:{
                inicio = System.nanoTime();
                NaivStandard.naivStandard(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 2:{
                inicio = System.nanoTime();
                NaivOnArray.naivOnArray(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 3:{
                inicio = System.nanoTime();
                NaivKahan.naiveKahan(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 4:{
                inicio = System.nanoTime();
                NaivLoopUnrollingTwo.naiveLoopUnrollingTwo(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 5:{
                inicio = System.nanoTime();
                NaivLoopUnrollingThree.naivLoopUnrollingThree(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 6:{
                inicio = System.nanoTime();
                NaivLoopUnrollingFour.naivLoopUnrollingFour(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 7:{
                inicio = System.nanoTime();
                WinogradOriginal.winogradOriginal(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 8:{
                inicio = System.nanoTime();
                WinogradScaled.winogradScaled(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 9:{
                inicio = System.nanoTime();
                StrassenNaiv.multiply(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            case 10:{
                inicio = System.nanoTime();
                StrassenWinograd.strassenWinograd(Matriz1, Matriz2);
                fin = System.nanoTime();
                TiempoEjecucion.timeAlgortithm(inicio,fin);
                break;
            }
            default: {
                System.out.println("Opcion incorrecta");
            }
        }//cierra SWITCH
    }
}