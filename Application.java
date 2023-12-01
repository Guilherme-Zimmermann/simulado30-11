import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entities.Post;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Listar posts
        // Curtir post
        // Compartilhar post
        // Não tenho interesse / tenho interesse

        Map<Integer, Post> postList = new HashMap<>();
        boolean loop = true;
        String escolha;
        int id;

        System.out.println("Bem vindo ao Instagram de pobre!");
        do {
            System.out.println("Digite (1) Para inserir um post: ");
            System.out.println("Digite (2) para curtir algum post: ");
            System.out.println("Digite (3) para compartilhar algum post: ");
            System.out.println("Digite (4) para configurar os seus interesses");
            System.out.println("Digite (5) para listar todos os posts: ");
            System.out.println("Digite (0) para encerrar o programa: ");
            System.out.print("Digite aqui a sua escolha: ");
            escolha = sc.nextLine();

            switch (escolha) {
                case "1":
                        System.out.print("Qual é o seu nome? ");
                        String nome = sc.nextLine();
                        System.out.print("Insira o conteúdo do seu post: ");
                        String conteudo = sc.nextLine();
                        Post post = new Post(nome, conteudo, new Date(), false, false, false);
                        postList.put(post.getId(), post);
                    break;

                case "2": 
                    System.out.print("Insira o id do post que você deseja curtir ou remover a curtida: ");
                    id = sc.nextInt();
                    if (postList.containsKey(id)) {
                        if (postList.get(id).getCurtidas().equals(false)) {   
                            postList.get(id).setCurtidas(true);
                            System.out.println("Post curtido com sucesso!");
                        } else {
                            postList.get(id).setCurtidas(false);
                            System.out.println("Curtida removida!");
                        }
                    } 
                    sc.nextLine();
                    break;

                case "3":
                    System.out.print("Insira o id do post que você deseja compartilhar ou remover o compartilhamento: ");
                    id = sc.nextInt();
                    if (postList.containsKey(id)) {
                        if (postList.get(id).getCompartilhar().equals(false)) {
                            postList.get(id).setCompartilhar(true);
                            System.out.println("Post compartilhado com sucesso!");
                        } else {
                            postList.get(id).setCompartilhar(false);
                            System.out.println("Compartilhamento removido!");
                        }
                    }
                    sc.nextLine();
                    break;

                case "4":
                    System.out.print("Insira o id do post que você deseja adicionar ou remover o interesse! ");
                    break;

                case "0":
                    loop = false;
                    break;
                default:
                    break;
            }
        } while (loop);

        sc.close();
    }   
}