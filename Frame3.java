import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame3 extends JFrame{
    private JLabel jib = new JLabel("失敗");
    private JButton jbtn1 = new JButton("不玩了");
    public Frame3(){
        ex2();
    }
    private void ex2(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(100,100,400,400);
        jib.setBounds(100,100,100,100);
        jbtn1.setBounds(200,100,100,100);
        this.add(jib);
        this.add(jbtn1);
        jbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
