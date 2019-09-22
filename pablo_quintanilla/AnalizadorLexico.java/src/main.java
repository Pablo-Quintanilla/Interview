
import java.util.ArrayList;
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
        Scanner scan = new Scanner(System.in);
        String cadena = new String();
        cadena = scan.nextLine();
        analizador(cadena);
    }
    
    public void analizador(String cadena){
        Character c;
        String auxiliarcord="";
        ArrayList<String> coordenadas = new ArrayList<>();
        ArrayList<String> texto = new ArrayList<>();
        Boolean cordfound = false, salir = false;
        Stack<Character> pilatexto, pilacord;
        pilatexto = new Stack<>();
        pilacord = new Stack<>();
        for(int i=0;i<cadena.length();i++){
            c = cadena.charAt(i);
            if(c.equals(',')){
                pilatexto.push(c);
                while(!salir){
                    if(!pilatexto.peek().equals('('))
                    {
                        pilacord.push(pilatexto.pop());
                    }
                    else{
                        pilacord.push(pilatexto.pop());
                        texto.add(pilatexto.toString());
                        pilatexto.removeAllElements();
                        salir = true;
                    }
                    
                }
                cordfound = true;
            }
            if(cordfound){
                if(!pilacord.isEmpty()){
                    while(!pilacord.isEmpty())
                        auxiliarcord+=pilacord.pop();
                }
                else{
                    if(!c.equals(')')){
                        auxiliarcord+=c;
                    }
                    else{
                        auxiliarcord+=c;
                        cordfound=false;
                        coordenadas.add(auxiliarcord);
                        salir = false;
                        auxiliarcord = "";
                    }
                }
                    
            }
            else{
                pilatexto.push(c);
            }
            
        }
        texto.add(pilatexto.toString());
        imprimir(coordenadas,texto);
    }
    
    public void imprimir(ArrayList<String> coordenadas, ArrayList<String> texto){
        for(int i=0;i<coordenadas.size();i++){
            System.out.print(coordenadas.get(i)+" ");
            System.out.print(printlinea(texto.get(i+1)));
            System.out.println();
        }
    }
    
    public String printlinea(String texto){
        String cadena="";
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)!='[' && texto.charAt(i)!=',' 
                    && texto.charAt(i)!=']' && texto.charAt(i)!=' '){
                cadena+=texto.charAt(i);
            }
        }
        return cadena;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        main entradas = new main();
    }
    
}
