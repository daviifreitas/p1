package p1;
import java.sql.*;
import java.util.Scanner;

public abstract class Pessoa implements createAccount{
    protected int id;
    protected String name ;
    protected int idade ;
    protected int cep ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    @Override
    public void menu() {
        int looping = 0 ;
        Scanner input = new Scanner(System.in);
        int select ;

        external : do {
            System.out.println("Welcome to the data base !\n\nSee the list of options our system !!\n 1 -> create\n 2 -> update\n 3 -> view \n 4 -> delete \n 5 -> exit\n\nType here :");
            select = input.nextInt();

            switch (select){
                case 1:
                    create();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    view();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    break external;
            }

        } while(looping == 0);
    }

    @Override
    public void create() {
        Scanner input = new Scanner(System.in);
        String name ;
        int id ;
        int idade ;
        int cep ;
        System.out.println("Type the name of user:");
        name = input.nextLine();

        System.out.println("Enter id: ");
        id = input.nextInt();

        System.out.println("Enter the age :");
        idade = input.nextInt();

        System.out.println("Type a CEP :");
        cep = input.nextInt();

        String url = "jdbc:mysql://localhost/p1";
        String user = "root";
        String pass = "password13258046A@";
        String sql = "insert into pessoa (id , name ,idade ,cep) values ("+id+", '"+name+"', "+idade+", "+cep+")";
        try {
            Connection conexao = DriverManager.getConnection(url , user ,pass);
            PreparedStatement inserir = conexao.prepareStatement(sql);
            inserir.executeUpdate();
            System.out.println("Create with sucess !!!!");
        }catch (Exception error){
            System.out.println("Error !\nThis action is not do");
        }
    }

    @Override
    public void delete() {
        Scanner input = new Scanner(System.in);
        int id ;
        System.out.println("Enter id for delete the register : ");
        id = input.nextInt();

        String url = "jdbc:mysql://localhost/p1";
        String user = "root";
        String pass = "password13258046A@";
        String sql = String.format("delete from pessoa where id = %d", id);
        try {
            Connection conexao = DriverManager.getConnection(url , user ,pass);
            PreparedStatement inserir = conexao.prepareStatement(sql);
            inserir.executeUpdate();
            System.out.println("Delete with sucess !!!!");
        }catch (Exception error){
            System.out.println("Error !\nThis action is not do");
        }
    }

    @Override
    public void update() {
        Scanner input = new Scanner(System.in);
        String name ;
        int id ;
        int idade ;
        int cep ;
        String updateName;

        System.out.println("Type the name of user which you want update :");
        updateName = input.nextLine();

        System.out.println("Type the name of user:");
        name = input.nextLine();

        System.out.println("Enter id: ");
        id = input.nextInt();

        System.out.println("Enter the age :");
        idade = input.nextInt();

        System.out.println("Type a CEP :");
        cep = input.nextInt();

        String url = "jdbc:mysql://localhost/p1";
        String user = "root";
        String pass = "password13258046A@";
        String sql = String.format("update pessoa set nome = %s ,%d ,%d ,%d", name, id ,idade ,cep);
        try {
            Connection conexao = DriverManager.getConnection(url , user ,pass);
            PreparedStatement inserir = conexao.prepareStatement(sql);
            inserir.executeUpdate();
            System.out.println("Update with sucess !!!!");
        }catch (Exception error){
            System.out.println("Error !\nThis action is not do");
        }

    }

    @Override
    public void view() {

        String url = "jdbc:mysql://localhost/p1";
        String user = "root";
        String pass = "password13258046A@";
        String sql = "select * from pessoa";
        try {
            Connection conexao = DriverManager.getConnection(url , user ,pass);
            PreparedStatement view = conexao.prepareStatement(sql);
            ResultSet result = view.executeQuery();
            while(result.next()){
                String inputName = result.getString("name");
                String inputAge = result.getString("idade");
                String inputId = result.getString("id");
                String inputCep = result.getString("cep");
                System.out.printf("\n\nName : %s\nId : %s\nAge : %s\nCep : %s\n\n", inputName ,inputId , inputAge , inputCep);
            }
        }catch (Exception error){
            System.out.println("Error !\nThis action is not do");
        }
        System.out.println("\n\n\n");
    }
}
