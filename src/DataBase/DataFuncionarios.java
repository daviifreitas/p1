package DataBase;

import java.util.Scanner;

public class DataFuncionarios {
    private String name ;
    private String idade ;
    private String funcao ;
    private String cpf ;

    public void inserInDataBase(){
        Scanner input = new Scanner(System.in);
        System.out.println("Escreva o nome que vai entrar no banco de dados : ");
        setName(input.next());

        System.out.println("Digite a função do funcionario : ");
        setFuncao(input.next());

        System.out.println("Digite a idade :");
        setIdade(input.next());

        System.out.println("Digite o cpf :");
        setCpf(input.next());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }


    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
