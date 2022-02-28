package DataBase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int options ;

        external : do{
            System.out.println("\n\n\n\n\nWelcome to the system !!!\n\nDo you want create any data base press-1\nView the data base press-2\nChange data type-3 \nFor delete data type -4");
            options = input.nextInt();
            switch (options){
                case 1 :
                    DataFuncionarios d1 = new DataFuncionarios();
                    d1.inserInDataBase();
                    break external;
                case 2 :
                    Conect.exibirDados();
                    break external;
                case 3:
                    Conect.alterarDados();
                    break external;
                case 4 :
                    Conect.deletarDados();
                    break external;
            }
        }while (true);
    }
}
