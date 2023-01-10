import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Digite um número para gerar\nA Tabela de multiplicação:");

        boolean teveErro = false;

        //Pede para o usuário digitar a entrada e fiscaliza se é válida
        try(Scanner entrada = new Scanner(System.in)){

            final int numero = entrada.nextInt();

            boolean temCabecalho = false;
            String cabecalho = "║ Tabela de multiplicação de " + numero + " ║";
            int comprimento = 0;

            for(int i = 0; i < 11; i++) {

                String linha = ("║  " + numero + " x " + i + " = " + numero*i);

                if(cabecalho.length() > linha.length()) {
                    comprimento = cabecalho.length();
                } else {
                    comprimento = linha.length();
                }

                //Cria o topo da tabuada, caso não tenha sido feita
                if(!temCabecalho) {
                    System.out.println("\n╔" + "═".repeat(comprimento - 2) + "╗");
                    System.out.println("║" + " ".repeat(comprimento - 2)+ "║");
                    System.out.println(cabecalho);
                    System.out.println("║" + " ".repeat(comprimento - 2)+ "║");
                    temCabecalho = true;
                }

                System.out.println(linha + " ".repeat(comprimento - linha.length() - 1) + "║");

            }

            //Cria o final da tabuada.
            System.out.println("║" + " ".repeat(comprimento - 2)+ "║");
            System.out.println("╚" + "═".repeat(comprimento - 2) + "╝");
        
        }
        catch (Exception e) {
            // Trata os erros, identificados pelo "hashCode"
            int error = e.hashCode();

            if(error == 1828972342) { //Caso o usuário ultrapasse o tamanho do 'int'
                System.out.println("\n É uma tabuada, Raio de sol,\n você não tem nem capacidade\n de ler esse número!");
            } else if(error == 81628611) { //Caso o usuário não coloque um número
                System.out.println("\n Você precisa digitar um número!");
            }
            
            teveErro = true;
        }
        finally {
            if(teveErro){ // :p
                System.out.println("\n¯\\_('-')_/¯  Você é um bocózinho!\n\n");
            } else {
                System.out.println("\n(~ 'v')~ Tá pronto o sorvetinho!\n\n");
            }
        }
    }
}