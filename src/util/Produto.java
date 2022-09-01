package util;
import java.util.Scanner;

public class Produto {
    //This is atribute of class Products
    private String name;
    private Double value;
    private String category;
    private Boolean status;
    private Integer id;
    private String owner;

    Produto(String _name, Double _value, String _category, Boolean _status, String _owner){
        name = _name;
        value = _value;
        category = _category;
        status = _status;
        owner = _owner;
    }

    public void updateStatus(Boolean _status){
        status = _status;
    }

    public void showProduct(){
        Scanner read = new Scanner(System.in);

        System.out.println("Nome: "+name);
        System.out.println("Valor: "+value);
        System.out.println("Categoria: "+category);
        System.out.println("Status: "+status);
        System.out.println("Vendedor: "+owner+"\n");

        int enter = read.nextInt();
        
    }

    public Boolean getStatus(){
        return status;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}

//Category: 1 - Sementes, 2 - Bebidas, 3 - Biscoitos, 4 - Frutas & Legumes