package Beta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculate extends JFrame{
    private JButton a9Button1;
    private JButton a8Button1;
    private JButton a1Button;
    private JButton a6Button1;
    private JButton a2Button;
    private JButton a7Button1;
    private JButton a3Button;
    private JButton a5Button;
    private JButton a4Button;
    private JButton plusButon;
    private JButton lassButon;
    private JButton multiplyButon;
    private JButton divisionButon;
    private JPanel painel;
    private JTextField exibir;
    private JButton equals;
    private JButton cleanButon;
    private int num1 = 0 ;
    private int identificador = 0 ;

    public Calculate() {


        a9Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = String.format("%s%s",exibir.getText(),"9");
                exibir.setText(n1);
            }
        });
        a8Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = String.format("%s%s",exibir.getText(),"8");
                exibir.setText(n1);

            }
        });
        a7Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = String.format("%s%s", exibir.getText(),"7");
                exibir.setText(n1);

            }
        });
        a6Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = String.format("%s%s",exibir.getText(),"6");
                exibir.setText(n1);
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = String.format("%s%s",exibir.getText(),"5");
                exibir.setText(n1);
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = String.format("%s%s",exibir.getText(),"4");
                exibir.setText(n1);
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = String.format("%s%s",exibir.getText(),"3");
                exibir.setText(n1);

            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = String.format("%s%s", exibir.getText(), "2");
                exibir.setText(n1);

            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = String.format("%s%s", exibir.getText(), "1");
                exibir.setText(n1);
            }
        });
        plusButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Integer.parseInt(exibir.getText());
                exibir.setText(null);
                identificador = 1 ;

            }
        });
        lassButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Integer.parseInt(exibir.getText()) ;
                exibir.setText(null);
                identificador = 2 ;
            }
        });
        multiplyButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Integer.parseInt(exibir.getText());
                exibir.setText(null);
                identificador = 3 ;
            }
        });
        divisionButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Integer.parseInt(exibir.getText()) ;
                exibir.setText(null);
                identificador = 4 ;
            }
        });
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (identificador) {
                    case 1 -> {
                        num1 += Integer.parseInt(exibir.getText());
                        exibir.setText(Integer.toString(num1));
                        identificador = 0;
                    }
                    case 2 -> {
                        num1 -= Integer.parseInt(exibir.getText());
                        exibir.setText(Integer.toString(num1));
                        identificador = 0;
                    }
                    case 3 -> {
                        num1 *= Integer.parseInt(exibir.getText());
                        exibir.setText(Integer.toString(num1));
                        identificador = 0;
                    }
                    case 4 -> {
                        num1 /= Integer.parseInt(exibir.getText());
                        exibir.setText(Integer.toString(num1));
                        identificador = 0;
                    }
                }
            }
        });
        cleanButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = 0 ;
                exibir.setText(null);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }

    public static void main(String[] args) {
        Calculate c1 = new Calculate();
        c1.setSize(520,480);
        c1.setContentPane(new Calculate().painel);
        c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c1.setVisible(true);
    }
}
