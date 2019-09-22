
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janpa
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    main(){
        entradas();
    }
    
    public void entradas(){
        Integer num = 0;
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        procesamiento(Long.valueOf(num));
    }
    
    public void procesamiento(Long n){
        
        Long mun = invertirnum(n);
        Long NC = Long.valueOf(0);
        int cont = 0;
        boolean espalindromo = false;
        
        while(!espalindromo){
            NC = n+mun;
            espalindromo = respalindromo(NC);
            cont++;
            n = NC;
            mun = invertirnum(n);
        }
        
        System.out.print(NC + " " + cont);
        
    }
    
    public boolean respalindromo(Long num){
        String numnorm = num.toString();
        String numinv = invertirnum(num).toString();
        if(numnorm.equals(numinv))
            return true;
        return false;
    }
    
    public Long invertirnum(Long n){
        String auxinv="";
        Long inverso = Long.valueOf(0);
        Stack<Character> pilanum = new Stack<>();
        
        auxinv = n.toString();
        for(int i=0;i<auxinv.length();i++){
            pilanum.push(auxinv.charAt(i));
        }
        auxinv = "";
        while(!pilanum.isEmpty())
           auxinv+=pilanum.pop();
        inverso = Long.valueOf(auxinv);
        
        
        return inverso;
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        main entradas = new main();
    }
    
}
