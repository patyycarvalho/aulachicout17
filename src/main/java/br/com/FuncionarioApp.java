package br.com;

import java.io.*;
import java.util.Scanner;

public class FuncionarioApp {
    public static void main(String[] args) {
        File arquivo = new File("funcionarios.bin");
        Funcionario funcionario;
        int opcao;

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("\n1. Adicionar\n2. Atualizar\n3. Excluir\n4. Listar\n5. Sair\n");
                System.out.print("Escolha uma opcao: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o cargo: ");
                        String cargo = scanner.nextLine();
                        System.out.print("Digite o salario: ");
                        float salario = scanner.nextFloat();
                        scanner.nextLine();
                        funcionario = new Funcionario(id, nome, cargo, salario);
                        adicionarFuncionario(arquivo, funcionario);
                        break;
                    case 2:
                        System.out.print("Digite o ID: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o novo nome: ");
                        nome = scanner.nextLine();
                        System.out.print("Digite o novo cargo: ");
                        cargo = scanner.nextLine();
                        System.out.print("Digite o novo salario: ");
                        salario = scanner.nextFloat();
                        scanner.nextLine();
                        funcionario = new Funcionario(id, nome, cargo, salario);
                        adicionarFuncionario(arquivo, funcionario);
                        break;
                    case 3:
                        System.out.print("Digite o ID: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        adicionarFuncionario(arquivo, id);
                        break;
                    case 4:
                        listarFuncionarios(arquivo);
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                }
            } while (opcao != 5);
            scanner.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void adicionarFuncionario(File arquivo, int id) {
       
        throw new UnsupportedOperationException("Unimplemented method 'adicionarFuncionario'");
    }

    private static void listarFuncionarios(File arquivo) {
     
        throw new UnsupportedOperationException("Unimplemented method 'listarFuncionarios'");
    }

    private static void adicionarFuncionario(File arquivo, Funcionario funcionario) {
       
        throw new UnsupportedOperationException("Unimplemented method 'adicionarFuncionario'");
    }
}