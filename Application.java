import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import entities.Post;
import entities.enums.TipoPost;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Listar posts
        // Curtir post
        // Compartilhar post
        // Não tenho interesse / tenho interesse

        Map<Integer, Post> postMap = new LinkedHashMap<>();
        Map<Integer, Post> reelsMap = new LinkedHashMap<>();
        boolean loop = true;
        String escolha;
        int id;
        int count;
        int posicaoTela = 0;
        
        mookPost(postMap);
        mookReels(reelsMap);

        System.out.println("Bem vindo ao Instagram de pobre!");
        do {
            System.out.println("Digite (1) Para inserir um post: ");
            System.out.println("Digite (2) para adicionar ou remover a curtida algum post: ");
            System.out.println("Digite (3) para adicionar ou remover o compartilhamento de algum post: ");
            System.out.println("Digite (4) para configurar os seus interesses");
            System.out.println("Digite (5) para listar todos os posts: ");
            System.out.println("Digite (6) para listar todos os reels: ");
            System.out.println("Digite (7) para descer o feed: ");
            System.out.println("Digite (8) para subir o feed: ");
            System.out.println("Digite (0) para encerrar o programa: ");
            System.out.print("Digite aqui a sua escolha: ");
            escolha = sc.nextLine();
            System.out.println();

            switch (escolha) {
                case "1":
                        System.out.print("Qual é o seu nome? ");
                        String nome = sc.nextLine();
                        System.out.print("Insira o conteúdo do seu post: ");
                        String conteudo = sc.nextLine();
                        Post post = new Post(nome, conteudo, new Date(), false, false, false, TipoPost.POST);
                        postMap.put(post.getId(), post);
                        System.out.println();
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
                    count = 0;
                    for (Integer i : postMap.keySet()) {
                        if (count >= posicaoTela && count < posicaoTela + 3) {
                            if (postMap.get(i).getTipo().equals(TipoPost.POST)){
                                System.out.println(postMap.get(i));
                            }
                        }
                        count++;
                    }
                    break;
                    
                case "6": 
                    count = 0;
                    for (Integer i : reelsMap.keySet()) {
                        if (count >= posicaoTela && count < posicaoTela + 3) {
                            if (reelsMap.get(i).getTipo().equals(TipoPost.REELS)) {
                                System.out.println(reelsMap.get(i));
                                System.out.println("Passando video..."); 
                                
                                try { 
                                    Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                System.out.print("Deseja ver outro vídeo? (S/N): ");
                                String v = sc.nextLine().toUpperCase();
                                if (v.equals("N")) {
                                    break;
                                }

                            }
                        }
                        count++;
                        System.out.println();
                    }
                    break;

                case "7":
                    if (posicaoTela + 3 < postMap.size()) {
                        posicaoTela += 3;
                    }
                    break;
    
                case "8":
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
    
    public static Map<Integer, Post> mookPost(Map<Integer, Post> postMap) {

        Post p1 = new Post("Guilherme", "Bom dia!", new Date(), false, false, false, TipoPost.POST);
        Post p3 = new Post("Gustavo", "O trabalho ta me matando", new Date(), false, false, false, TipoPost.POST);
        Post p4 = new Post("Pablo", "Comprei um chicote novo", new Date(), false, false, false, TipoPost.POST);
        Post p5 = new Post("Itamar", "Bora bora, Pra cima!", new Date(), false, false, false, TipoPost.POST);
        Post p6 = new Post("Will", "Não aguento mais fazer crud", new Date(), false, false, false, TipoPost.POST);
        Post p9 = new Post("Rebeca", "Partiu shopping", new Date(), false, false, false, TipoPost.POST);

        postMap.put(p1.getId(), p1);
        postMap.put(p3.getId(), p3);
        postMap.put(p4.getId(), p4);
        postMap.put(p5.getId(), p5);
        postMap.put(p6.getId(), p6);
        postMap.put(p9.getId(), p9);

        return postMap;
    }

    public static Map<Integer, Post> mookReels(Map<Integer, Post> reelsMap) {
        Post p1 = new Post("Joao", "Partiu cacoal", new Date(), false, false, false, TipoPost.REELS);       
        Post p2 = new Post("Pedro", "Partiu viagem!", new Date(), false, false, false, TipoPost.REELS);
        Post p3 = new Post("Maria", "Jantar de hoje", new Date(), false, false, false, TipoPost.REELS); 
        
        reelsMap.put(p1.getId(), p1);
        reelsMap.put(p2.getId(), p2);
        reelsMap.put(p3.getId(), p3);

        return reelsMap;
    }
}