import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Post;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Listar posts
        // Curtir post
        // Compartilhar post
        // Não tenho interesse / tenho interesse

        List<Post> post = new ArrayList<>();
        boolean loop = true;
        String escolha;

        System.out.println("Bem vindo ao Instagram de pobre!");
        do {
            System.out.println("Digite (1) Para listar um post: ");
            System.out.println("Digite (2) para curtir algum post: ");
            System.out.println("Digite (3) para compartilhar algum post: ");
            System.out.println("Digite (4) para configurar os seus interesses");
            System.out.print("Digite aqui a sua escolha: ");
            escolha = sc.nextLine();

            switch (escolha) {
                case "1":
                        System.out.println("Qual é o seu nome? ");
                        String nome = sc.nextLine();
                        System.out.println("Insira o conteúdo do seu post: ");
                        String conteudo = sc.nextLine();
                        post.add(new Post(nome, conteudo, null, null, null, null));
                    break;
            
                default:
                    break;
            }
        } while (loop);

        post.forEach(System.out::println);

        sc.close();
    }   
}