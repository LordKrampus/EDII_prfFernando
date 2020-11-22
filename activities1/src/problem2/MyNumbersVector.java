package problem2;

import java.util.Collection;
import java.util.Vector;

public class MyNumbersVector {
    private Vector<Integer> numbers;
    private int limite;
    
    public MyNumbersVector(int limite){
        this.numbers = new Vector(0);
        this.limite = limite; // lenght max do vector
    }
    
    public void add(int number){
        if(numbers.size() < this.limite)
            this.numbers.add(number);
    }
    
    public void printAscending(){
        for(int i = 0; i < this.numbers.size(); i++)
            System.out.print(this.numbers.elementAt(i) + " ");          
    }
    
    public void printDescending(){
        for(int i = (this.numbers.size()-1); i >= 0; i--)
            System.out.print(this.numbers.elementAt(i) + " ");    
    }
    
    private Vector<Integer> getElementRestOfTwoIf(int rest){
        Vector<Integer> restNumbers = new Vector(0);
        for(int number: this.numbers)
            if(number % 2 == rest)
                restNumbers.add(number);
        return restNumbers;
    }
    
    public Vector<Integer> getEvenNumbers(){
        return getElementRestOfTwoIf(0); // elemento cujo qual resto de dois é zero
    }
    
    public Vector<Integer> getOddNumbers(){
        return getElementRestOfTwoIf(1);
    }
    
    private int sumSpecificNumbers(Vector<Integer> specificNumbers){
        int sum = 0;
        for(int number: specificNumbers)
            sum += number;
        return sum;
    }
    
    public int sumEvenNumbers(){
        Vector<Integer> evenNumbers = this.getEvenNumbers();
        return this.sumSpecificNumbers(evenNumbers);
    }
    
    public int SumOddNumbers(){
        Vector<Integer> oddNumbers = this.getOddNumbers();
        return this.sumSpecificNumbers(oddNumbers);
    }
    
    private int multiplySpecificNumbers(Vector<Integer> specificNumbers){
        int product = 1;
        for(int number: specificNumbers)
            product *= number;
        return product;
    }
    
    public int productEvenNumbers(){
        Vector<Integer> evenNumbers = this.getEvenNumbers();
        return this.multiplySpecificNumbers(evenNumbers);
    }
    
    public int productOddNumbers(){
        Vector<Integer> oddNumbers = this.getOddNumbers();
        return this.multiplySpecificNumbers(oddNumbers);
    }
}
