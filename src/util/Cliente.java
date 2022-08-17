package util;
import java.util.Vector;

import util.Produto;

public class Cliente {
    private String name;
    private String password;
    private int id;
    private double coins=0;
    private Vector<Produto> products = new Vector<Produto>();

    Cliente(String _name, String _password, int _id){
        name = _name;
        password = _password;
        id = _id;
    }

    Cliente(){

    }
    
    public void setName(String _name){
        name = _name;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public int getQtdProduct(){
        return products.size();
    }

    public void setProduct(Produto prod){
        products.add(prod);
    }

    public void removeProduct(int i){
        products.remove(i);
    }

    public Boolean verifyPassword(String _pass){
        if(password.equals(_pass) == true){
            return true;
        } else {
            return false;
        }
    }

    public Double getMoney(){
        return coins;
    }
//Nosa idéia: Mercado Livre :p
    public void withdrawMoney(Double value){
        if(coins < value){
            System.out.println("Quantidade superior ao seu");
        } else {
            coins = coins - value;
            System.out.println("Compra realizada com sucesso, saldo atual: "+coins);

        }
    }
    
    public void receiveMoney(Double value){
        if(value > 0){
            coins = coins + value;
            System.out.println("Valor recebido com sucesso");
        } else {
            System.out.println("Por favor digitar valor acima de 0");
        }
    }
}
