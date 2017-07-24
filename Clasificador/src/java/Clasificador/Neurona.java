/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificador;

import java.util.*;

/**
 *
 * @author julio
 */
public class Neurona {
    double[] pesosAnteriores;
    double umbralAnterior;
    public double[] pesos;
    public double umbral;
    public double tasaDeAprendizaje = 0.3;
    
    public Neurona(int nEntradas){
        pesos = new double[nEntradas];
        pesosAnteriores = new double[nEntradas];
        aprender();
    }

    public void aprender(){
        for(int i = 0; i < pesosAnteriores.length; i++){
            pesosAnteriores[i] = Math.random()- Math.random();
        }
        umbralAnterior = Math.random()- Math.random();

        pesos = pesosAnteriores;
        umbral = umbralAnterior;
    }
    
    public void aprender(double[] entradas, double salidaEsperada){
        if(pesosAnteriores != null){
            double error = salidaEsperada - salida(entradas);
            for(int i =0; i < pesos.length; i++){
                pesos[i] = pesosAnteriores[i] + tasaDeAprendizaje * error * entradas[i];
            }
            umbral = umbralAnterior + tasaDeAprendizaje * error;
            
            pesosAnteriores = pesos;
            umbralAnterior = umbral;
        }else{
            for(int i = 0; i < pesosAnteriores.length; i++){
                pesosAnteriores[i] = Math.random() - Math.random();
            }
            umbralAnterior = Math.random() - Math.random();
            pesos = pesosAnteriores;
            umbral = umbralAnterior;
        }
    }
    

    public double salida(double[] entradas){
        return sigmoid(neurona(entradas));
    }

    public double neurona (double[] entradas){
        float sum = 0;
        for(int i =0; i < pesos.length; i++){
            sum+= entradas[i] * pesos[i];
        }
        sum+=umbral;

        return sum;
    }

    public double sigmoid(double d){
        return d > 0 ? 1 : 0;
    }
    
    public static void main(String[] args){
        Neurona p = new Neurona(2);

        boolean sw = false;
        while(!sw){
            sw = true;

            
            System.out.println("--------------------------------------------");
            System.out.println("Peso 1: " +p.pesos[0]);
            System.out.println("Peso 2: " +p.pesos[0]);
            System.out.println("umbral: " +p.umbral);
            
            double[] d = {1,1};
            System.out.println("E1:1 E2:1 :"+ p.salida(new double[] {1,1}));
            System.out.println("E1:1 E2:0 :"+ p.salida(new double[] {1,0}));
            System.out.println("E1:0 E2:1 :"+ p.salida(new double[] {0,1}));
            System.out.println("E1:0 E2:0 :"+ p.salida(new double[] {0,0}));
            
            if(p.salida(new double[]{1,1}) != 1){
                p.aprender(new double[]{1,1},1);
                sw = false;
            }if(p.salida(new double[]{1,0}) != 0){
                p.aprender(new double[]{1,0},0);
                sw = false;
            }if(p.salida(new double[]{0,1}) != 0){
                p.aprender(new double[]{0,1},0);
                sw = false;
            }if(p.salida(new double[]{0,0}) != 0){
                p.aprender(new double[]{0,0},0);
                sw = false;
            }
        }
    }

}
