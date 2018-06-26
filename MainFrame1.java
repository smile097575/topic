import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame1 extends JFrame{
    private JButton jbtn = new JButton("登入");
    private JButton jbtn1 = new JButton("退出");
    private JTextField jtf = new JTextField();
    private JLabel jib = new JLabel("帳號");
    private JPasswordField jtf1 = new JPasswordField();
    private JLabel jib1 = new JLabel("密碼");
    private JTextField jtf2 = new JTextField("9");
    private JLabel jib2 = new JLabel("行");
    private JTextField jtf3 = new JTextField("9");
    private JLabel jib3 = new JLabel("列");
    public MainFrame1(){
        ex1();
    }
    private void ex1(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("踩地雷");
        this.setBounds(100,100,600,500);
        jtf.setBounds(100,100,200,50);
        jtf1.setBounds(100,200,200,50);
        jtf2.setBounds(400,100,50,50);
        jtf3.setBounds(400,200,50,50);
        jbtn.setBounds(100,300,100,50);
        jbtn1.setBounds(200,300,100,50);
        jib.setBounds(100,50,100,50);
        jib1.setBounds(100,150,100,50);
        jib2.setBounds(400,50,50,50);
        jib3.setBounds(400,150,50,50);
        this.add(jbtn);
        this.add(jbtn1);
        this.add(jtf);
        this.add(jtf1);
        this.add(jtf2);
        this.add(jtf3);
        this.add(jib);
        this.add(jib1);
        this.add(jib2);
        this.add(jib3);
        jbtn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (jtf.getText().equals("1")&&(new String(jtf1.getPassword()).equals("1"))){
                    Frame2 frm = new Frame2(Integer.parseInt(jtf2.getText()), Integer.parseInt(jtf3.getText()));
                    frm.setVisible(true);
                    MainFrame1.this.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        });
    }
}
