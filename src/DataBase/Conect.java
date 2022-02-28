package DataBase;

import java.sql.*;
import java.util.Scanner;

public class Conect {

    public static void criarDados(DataFuncionarios d1){
        String url = "jdbc:mysql://localhost/funcionarios";
        String data = String.format("insert into usuarios(nome ,idade ,funcao ,cpf) values ('%s','%s','%s','%s');",
                d1.getName(),d1.getIdade(),d1.getFuncao(),d1.getCpf());
        try{
            Connection conexao = DriverManager.getConnection(url,"root", "password13258046A@");
            PreparedStatement atualizar = conexao.prepareStatement(data);
            atualizar.executeUpdate();
        }catch(Exception error){
            System.out.println("Erro ao colocar os dados no sistema !!");
        }
    }
    public static void exibirDados(){
        String url = "jdbc:mysql://localhost/funcionarios";
        String sql = "select * from usuarios";
        try {
            Connection conexao = DriverManager.getConnection(url, "root", "password13258046A@");
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String nome = resultSet.getString("nome");
                String idade = resultSet.getString("idade");
                String funcao = resultSet.getString("funcao");
                String cpf = resultSet.getString("cpf");
                System.out.println("Nome: "+nome+"\nIdade:"+idade+"\nCPF:"+cpf+ "\nFunção: "+funcao);

            }
        }catch(Exception error){
            System.out.println("Impossível fazer tal operação !");
        }
    }
    public static void deletarDados(){
        Scanner input = new Scanner(System.in);
        String url = "jdbc:mysql://localhost/funcionarios";
        String user = "root";
        String password = "password13258046A@";
        System.out.println("Digite o cpf de quem você deseja deletar :");
        String cpf = input.next();
        String sql = String.format("delete from usuarios where cpf = %s",cpf);
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        }
        catch(Exception Error){
            System.out.println("Erro em deletar o tipo de dado !!!!!");
        }
    }
    public static void alterarDados(){
        Scanner input = new Scanner(System.in);
        String url = "jdbc:mysql://localhost/funcionarios";
        String user = "root";
        String password ="password13258046A@";
        System.out.println("Digite o cpf de quem vc quer alterar os dados :");
        String cpfAlterar = input.next();

        System.out.println("Digite o novo cpf desse cadastro :");
        String novoCPF = input.next();

        System.out.println("Digite o novo nome :");
        String novoNome=  input.next();

        System.out.println("Digite a nova idade :");
        String idade = input.next();

        System.out.println("Digite a nova função desta pessoa :");
        String novaFuncao = input.next();


        String sql = String.format("update usuarios set nome = '%s' , cpf = '%s', idade = '%s', funcao = '%s' where cpf = '%s'", novoNome,novoCPF,idade,novaFuncao,cpfAlterar);
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        }
        catch(Exception Error){
            System.out.println("Erro em alterar a base de dados !!!!");
        }

    }
}