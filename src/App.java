import java.util.Scanner;

import util.Session;

public class App {
    public static void main(String[] args) throws Exception {
        Session sessao = new Session("start");

        sessao.sessionRender();
    }
}
