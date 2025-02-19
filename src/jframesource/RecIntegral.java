/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframesource;

/**
 *
 * @author user
 */
public class RecIntegral {
    public double result = 0.0, low = 0.0, high = 0.0, step = 0.0;
    
    public RecIntegral() { }
    
    public RecIntegral(double low, double high, double step) throws NewException {
        // нижний предел больше верхнего и шаг интегрирования больше разницы верхнего и нижнего предела
        // Проверка на вхождение в разрешенный диапазон
        if (low > high){
            throw new NewException("Нижний порог больше верхнего");
        }
        else { 
        if (step > (high - low)) {
            throw new NewException("Шаг интегрирования больше разницы верхнего и нижнего предела");
        }
        else {
        if (low >= 0.000001 && low <= 1000000 &&
                high >= 0.000001 && high <= 1000000 &&
                step >= 0.000001 && step <= 1000000) {
            this.low = low;
            this.high = high;
            this.step = step;
            this.result = 0.0;
        }
        else
            // Исключение
            throw new NewException("Одно из чисел находится вне разрешенного диапазона [0.000001;1000000]");
                
        }}
    }
   
    public double CalculateResult() {
        int n = 0;
        result = 0.0;
        
        for (double x = low; x < high; x += step) {
            result += (Math.exp(-x) + Math.exp(-x+step)) * step/2;
            n++;
        }
        
        double normalize = high - (low + n * step);
        if (normalize > 0)
            result += (Math.exp(low + n * step) + Math.exp(high)) * normalize / 2;
        return result;
    }
}
