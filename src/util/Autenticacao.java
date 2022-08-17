package util;

import java.util.Scanner;
import java.util.Vector;
import util.Cliente;

public class Autenticacao {
    private Vector<Cliente> clients = new Vector<Cliente>();

    Autenticacao(){

    }

    public void setClient(Cliente cli){
        clients.add(cli);
    }

    public Boolean searchClient(Cliente cli){
        for(Cliente _client : clients){
            if(_client.getId() == cli.getId()){
                return true;
            }
        }
        return false;
    }

    public Cliente verifyAutentication(String _name, String _password){
        for(Cliente _client : clients){
            if(_client.getName().equals(_name) == true){
                if(_client.verifyPassword(_password) == true){
                    return _client;
                } else {
                    System.out.println("Senha Incorreta");
                }
            }
        }
        System.out.println("Usuário não cadastrado");
        return null;
    }

    public void registerClient(){
        Scanner read = new Scanner(System.in);

        System.out.println("------CADASTRO NOVO CLIENTE-------");
        System.out.println("Nome: ");
        String _name = read.next();
        System.out.println("Senha: ");
        String _password = read.next();

        int _id = clients.size();

        Cliente _client = new Cliente(_name, _password, _id);
        clients.add(_client);
        System.out.println("Cadastro concluído com sucesso, por favor, faça login");
        System.out.println("Quantidade de registros: "+clients.size());

    }

    public Cliente loginClient(){ 
            Scanner read = new Scanner(System.in);
            System.out.println("------ LOGIN ------");
            System.out.println("Nome: ");
            String _name = read.nextLine();
            System.out.println("Senha: ");
            String _password = read.nextLine();

            Cliente _cli = verifyAutentication(_name, _password);
            if(_cli == null){
                return null;
            } else {
                return _cli;
            }
        

    }

}
