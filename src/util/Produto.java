package util;

public class Produto {
    //This is atribute of class Products
    private String name;
    private Double value;
    private String category;
    private Boolean status;
    private Integer id;

    Produto(String _name, Double _value, String _category, Boolean _status){
        name = _name;
        value = _value;
        category = _category;
        status = _status;
    }

    public void updateStatus(Boolean _status){
        status = _status;
    }

    public void showProduct(){
        System.out.println("Nome:"+name);
        System.out.println("Valor:"+value);
        System.out.println("Categoria:"+category);
        System.out.println("Status:"+status+"\n");
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