package jogodavelha;

import java.util.Scanner;

public class JogodaVelha {
    String[][] ocup = new String[3][3];
    ocupacao o1 = ocupacao.VAZIO;
    ocupacao o2 = ocupacao.JOGADOR1;
    ocupacao o3 = ocupacao.JOGADOR2;

    private void definirCasasIniciais(){
        System.out.println(o1.getOcupacao());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ocup[i][j] = o1.getOcupacao();
            }
        }
    }

    public void exibirTabuleiro(){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("|%S|",ocup[i][j]);
            }
            System.out.println();
        }
    }
    public void jogar(){
        Scanner input = new Scanner(System.in);
        definirCasasIniciais();
        do{
            exibirTabuleiro();
            System.out.println("Jogador 1 digite qual linha vc deseja jogar :");
            int l1 = input.nextInt();

            System.out.println("Jogador 1 digite qual coluna você deseja jogar :");
            int c1 = input.nextInt();
            if(ocup[l1-1][c1-1].equals(o2.getOcupacao()) && igual() !=0){
                do{
                    System.out.println("Digite novamente :");
                    l1 = input.nextInt();

                    c1 = input.nextInt();

                    if(!ocup[l1-1][c1-1].equals(o2.getOcupacao())){
                        break;
                    }
                } while(true);
            }
            ocup[l1 - 1][c1 - 1] = o2.getOcupacao();
            exibirTabuleiro();
            int result = igual();
            if(result == 1){
                exibirTabuleiro();
                System.out.println("\n\nJogador 1 ganhou !!!!");
                break;
            }


            System.out.println("Jogador 2 digite qual linah você deseja jogar :");
            int l2 = input.nextInt();

            System.out.println("Jogador 2 digite qual coluna você deseja jogar :");
            int c2 = input.nextInt();

            if(ocup[l2 - 1][c2 - 1].equals(o3.getOcupacao()) && igual() != 1){
                do{
                    System.out.println("Digite novamente :");
                    l2= input.nextInt();

                    c2 = input.nextInt();

                    if(!ocup[l2 - 1][c2 - 1].equals(o2.getOcupacao())){
                        break;
                    }
                } while(true);
            }
            ocup[l2- 1][c2-1] = o3.getOcupacao();
            result = igual();

            if(result == 2){
                exibirTabuleiro();
                System.out.println("\n\nJogador 2 ganhou !!!!");
                break;
            }


        }while(true);

    }

    public int igual(){
        int equal = 0;
        int equal1 = 0 ;
        int igual = 0 ;
        int igual1 = 0 ;
        int i1 = 0;
        int i2 =0 ;
        external :for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(ocup[i][j].equals(o2.getOcupacao())){
                    equal++;
                    if(equal == 3){
                        break external;
                    }
                }
                else if (ocup[i][j].equals(o3.getOcupacao()));{
                    equal1++;
                    if(equal1 ==3){
                        break external;
                    }
                }
            }
            equal =0 ;
            equal1 = 0;
        }
        external :for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if(ocup[b][a].equals(o2.getOcupacao())){
                    igual++;
                    if(igual == 3){
                        break external;
                    }
                }
                else if (ocup[b][a].equals(o3.getOcupacao()));{
                    igual1++;
                    if(igual1 ==3){
                        break external;
                    }
                }
            }
            igual =0 ;
            igual1 = 0 ;
        }
        external :for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if(ocup[j][j].equals(o2.getOcupacao())){
                    i1++;
                    if(i1 ==3){
                        break external;
                    }
                }
                if(ocup[j][j].equals(o3.getOcupacao())){
                    i2++;
                    if(i2 ==3){
                        break external;
                    }
                }
            }
            i1 =0;
            i2 = 0 ;
        }
        if(i1 == 3 || equal == 3 || igual ==3){
            return 1 ;
        } else {
            return 0 ;
        }
    }
}
enum ocupacao{
    VAZIO(" "),
    JOGADOR1("X"),
    JOGADOR2("0");
    private String ocupacao;
    ocupacao(String ocupacao){
        this.ocupacao = ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getOcupacao() {
        return ocupacao;
    }
}
