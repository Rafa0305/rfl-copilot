package exercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);

        String csvFile = "caminho/para/seu/arquivo.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] dados = line.split(csvSplitBy);
                System.out.println("Nome: " + dados[0] + " , CPF: " + dados[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
