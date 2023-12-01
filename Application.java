import java.util.Date;
import java.util.LinkedHashMap;
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

        Map<Integer, Post> postMap = new LinkedHashMap<>();
        boolean loop = true;
        String escolha;
        int id;
        int posicaoTela = 0;

        System.out.println("Bem vindo ao Instagram de pobre!");
        do {
            System.out.println("Digite (1) Para inserir um post: ");
            System.out.println("Digite (2) para curtir algum post: ");
            System.out.println("Digite (3) para compartilhar algum post: ");
            System.out.println("Digite (4) para configurar os seus interesses");
            System.out.println("Digite (5) para listar todos os posts: ");
            System.out.println("Digite (6) para descer o feed: ");
            System.out.println("Digite (5) para subir o feed: ");
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
                        postMap.put(post.getId(), post);
                    break;

                case "2": 
                    System.out.print("Insira o id do post que você deseja curtir ou remover a curtida: ");
                    id = sc.nextInt();
                    if (postMap.containsKey(id)) {
                        if (postMap.get(id).getCurtidas().equals(false)) {   
                            postMap.get(id).setCurtidas(true);
                            System.out.println("Post curtido com sucesso!");
                        } else {
                            postMap.get(id).setCurtidas(false);
                            System.out.println("Curtida removida!");
                        }
                    } else {
                       System.out.println("Esse post não existe!");
                    }
                    System.out.println();
                    sc.nextLine();
                    break;

                case "3":
                    System.out.print("Insira o id do post que você deseja compartilhar ou remover o compartilhamento: ");
                    id = sc.nextInt();
                    if (postMap.containsKey(id)) {
                        if (postMap.get(id).getCompartilhar().equals(false)) {
                            postMap.get(id).setCompartilhar(true);
                            System.out.println("Post compartilhado com sucesso!");
                        } else {
                            postMap.get(id).setCompartilhar(false);
                            System.out.println("Compartilhamento removido!");
                        }
                    } else {
                        System.out.println("Esse post não existe!");
                    }
                    System.out.println();
                    sc.nextLine();
                    break;

                case "4":
                    System.out.print("Insira o id do post que você deseja adicionar ou remover o interesse: ");
                    id = sc.nextInt();
                    if (postMap.containsKey(id)) {
                        if (postMap.get(id).getInteresse().equals(false)) {
                            postMap.get(id).setInteresse(true);
                            System.out.println("Interesse adicionado!");
                        } else {
                            System.out.println("Interesse removido!");
                        }
                    } else {
                        System.out.println("Esse post não existe!");
                    }   
                    System.out.println();
                    sc.nextLine();
                    break;

                case "5":
                    int count = 0;
                    for (Integer i : postMap.keySet()) {
                        if (count >= posicaoTela && count < posicaoTela + 3) {
                            System.out.println(postMap.get(i));
                        }
                        count++;
                    }
                    break;
    
                case "6":
                    if (posicaoTela + 3 < postMap.size()) {
                        posicaoTela += 3;
                    }
                    break;
    
                case "7":
                    if (posicaoTela - 3 >= 0) {
                        posicaoTela -= 3;
                    }
                    break;
                    
                case "0":
                    loop = false;
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        } while (loop);

        sc.close();
    }   
}