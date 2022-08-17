package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import util.Produto;

public class Estante {
    Vector<Produto> product = new Vector<Produto>();

    public void newProduct(int amount){ 
        Scanner read = new Scanner(System.in);
        String name, category;
        Double value;
        Boolean status;
        
        for(int i = 0; i < amount; i++){
            System.out.println("Nome: ");
            name = read.next();

            System.out.println("Valor: ");
            value = read.nextDouble();

            System.out.println("Categoria: ");
            category = read.next();

            System.out.println("Status: ");
            status = read.nextBoolean();

            Produto prod = new Produto(name, value, category, status);
            product.add(prod);

        }
        System.out.println("Cadastros realizados com sucesso");
    }
// CONVERT ERROR?
    /*public void addProductsStatic(){
        Produto prc = new Produto("Feijão", 20, "1", true);
    } */

    /* ---- FUNÇÃO AINDA NÃO FUNCIONAL --- */
    public void scanDataProduct() throws FileNotFoundException{
        Scanner data = new Scanner(new FileReader(getClass().getResource("/data.txt").getFile()));

        while(data.hasNextLine()){
            String line = data.nextLine();
            System.out.println(line);
        }  
    }

    public void showEstante(){
        System.out.println("------- PRODUTOS NO ESTOQUE ---------");
        for(int i = 0; i < product.size(); i++){
            if(product.get(i).getStatus() != false){
                product.get(i).showProduct();
            }
        }
    }

    public Produto getProduct(Integer id){
        for(int i = 0; i < product.size(); i++){
            if(product.get(i).getId() == id){
                return product.get(i);
            }
        }
        return null;
    }

    public Boolean deleteProduct(Integer id){
        for(int i = 0; i < product.size(); i++){
            if(product.get(i).getId() == id){
                product.remove(i);
                return true;
            }
        }
        return false;
    }
}
