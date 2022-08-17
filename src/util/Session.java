package util;
import java.util.Scanner;
import java.util.AbstractMap;
import util.Cliente;
import util.Autenticacao;
import util.Estante;
import util.Produto;

public class Session {
    private Boolean statusSession = false;
    private Cliente client;
    private Autenticacao autenti;
    private Estante estante;

    public Session(String request){
        if(request == "start"){
            Autenticacao aut = new Autenticacao();
            autenti = aut;
            Estante est = new Estante();
            estante = est;
        }
    }

    public int getIdClient(){
        return client.getId();
    }

    public Boolean buyProduct(){
        Scanner read = new Scanner(System.in);

        System.out.println("Digite o ID do produto: ");
        Integer _id = read.nextInt();

        Produto _newProduct = estante.getProduct(_id); //Search a product in container
        if(_newProduct == null){
            return false;
        } else {
            System.out.print("Tem certeza que deseja comprar "+_newProduct.getName()+"? (y or n)?");
            String response = read.nextLine();

            if(response.equals("y") == true){
                client.setProduct(_newProduct);
                estante.deleteProduct(_newProduct.getId());

                return true;
            } else {
                return false;
            }
        }
    }

    public void bodySession(){
        Scanner read = new Scanner(System.in);

        System.out.println("SESSÃO: "+ client.getName()+" | Estoque: "+client.getQtdProduct());
        System.out.println("1 -> Visualizar produtos");
        System.out.println("2 -> Comprar produto");
        System.out.println("3 -> Sair");

        int request = read.nextInt();

        switch(request){
            case 2:
                Boolean response = buyProduct();
                if(response == true){
                    System.out.println("Compra realizada cm sucesso");
                } else {
                    System.out.println("Compra não finalizada");
                }
                break;
            case 3:
                statusSession = false;
                break;
        }

    }
    public void inicializeSession(){
        Scanner read = new Scanner(System.in);
        int choice;

        System.out.println("-------- MERCADO DIGITAL -----------");
        System.out.println("1 -> Login");
        System.out.println("2 -> Registre-se");
        choice = read.nextInt();

        
        switch(choice){
            case 1:
                Cliente _cliente;
                _cliente = autenti.loginClient();
                if(_cliente != null){
                    statusSession = true;
                    client = _cliente;
                } 
                break; 
            case 2:
                autenti.registerClient();
                break;
        }
    }

    public void sessionRender(){

        while(true){
            if(statusSession == false){
                inicializeSession();
            } else {
                bodySession();
            }
        }
    }


}
