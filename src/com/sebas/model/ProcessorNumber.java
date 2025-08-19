/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebas.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author sebath
 */
public class ProcessorNumber {
    private List<Integer> numbers;
    
     // creamos el constructor de la clase ProcessorNumber que reciba nuesto listado de numeros
    public ProcessorNumber(){
        this.numbers = new ArrayList<>();
    }
    
    // creamos el metodo para añadir un numero
    public void addNumber(int number){
        this.numbers.add(number);
    }
    
    // creamos el metodo para encontrar el numero mas grande
    public int getNumberLargest(){
        if (numbers.isEmpty()){
            return 0;
        }
        return Collections.max(numbers);
    }
    
    // creamos el metodo para encontrar el numero mas pequeño
    public int getNumberSmallest(){
        if (numbers.isEmpty()){
            return 0;
        }
        return Collections.min(numbers);
    }
    
    // creamos el metodo para obtener la sumatoria de todos los numeros de la lista
    public int getSumAllNumbers(){
        int sum = 0;
        for (int number : numbers){
            sum += number;
            System.out.println("la sumatoria de los numeros es: " + sum);
        }
        return sum;
    }
    
    // creamos el metodo para limpiar la lista de los numeros
    public void clearNumbers(){
        this.numbers.clear();
    }
    
}
