import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class Frame2 extends JFrame{
    static int mapHeight = 9, mapWidth = 9;
    static int frameWidth = 400, frameHeight = 400;
    private JButton [][] jbtn = new JButton[mapHeight][mapWidth];
    private int jbtnbomb [][] = new int [mapHeight][mapWidth];
    private int bombCount = Math.round(((mapHeight*mapWidth)*3)*10/100f);
    private JLabel bombmany = new JLabel("目前炸彈數："+bombCount);
    private int map[][] = new int[mapHeight][mapWidth];
    private boolean buttonpull [][] = new boolean[mapHeight][mapWidth];
    private int timecount = 0;
    private int timeContinue = 1;
    private int count = 0;
    private int idI,idJ;
    public Frame2(int v1,int v2){
        mapHeight = v1;
        mapWidth = v2;
        ex2();
    }
    public void ex2(){
        this.setBounds(100,100,frameWidth,frameHeight);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setTitle("踩地雷");
//        ------------------上面介面------------------------------
        JPanel topPanel = new JPanel();
        bombmany.setText("炸彈至少有："+bombCount);
        topPanel.add(bombmany);
        JButton restart = new JButton("新局");
        restart.setActionCommand("r");
        restart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timecount = 1;
                timeContinue = 1;
                for (int i = 0;i<mapHeight;i++) Arrays.fill(map[i],0);
                for (int i = 0;i<mapHeight;i++) Arrays.fill(buttonpull[i],false);
                for (int i = 0;i<mapHeight;i++){
                    for (int j = 0;j<mapWidth;j++){
                        jbtn[i][j].setText("");
                        jbtn[i][j].setBackground(Color.WHITE);
                    }
                }
                bombCount = bombCount;
                bombmany.setText("炸彈至少有："+bombCount);
            }
        });
        topPanel.add(restart);
        JLabel time = new JLabel("已經過了：0");
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (timeContinue == 1) time.setText("已經過："+(timecount++)+"秒");
            }
        };
        new Timer().scheduleAtFixedRate(timerTask,0,1000);
        topPanel.add(time);
        add(topPanel,BorderLayout.NORTH);
//        ----------------建立地圖-------------------------
        JPanel centerButtonPanel = new JPanel();
        centerButtonPanel.setLayout(new GridLayout(mapHeight, mapWidth));
        for (int i=0;i<mapHeight;i++){
            for (int j=0;j<mapWidth;j++){
                jbtn[i][j] = new JButton();
                jbtn[i][j].setActionCommand(i+" "+j);
                jbtn[i][j].addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton jtmpBtn = (JButton) e.getSource();
                        for (int i1 = 0;i1<mapHeight;i1++){
                            for (int j1 = 0;j1<mapWidth;j1++){
                                if (jtmpBtn.equals(jbtn[i1][j1])){
                                    idI = i1;
                                    idJ = j1;
                                }
                            }
                        }
                        jbtnbomb[idI][idJ] = 1;
//        ---------------亂數炸彈
                        int a = (int)(Math.random()*10);
                        int b = (int)(Math.random()*10);
                        for (int i=0;i<bombCount;i++){
                           if (jbtnbomb[a][b] == jbtnbomb[idI][idJ]){
                               count = 1;
                           }else {
                               count = 0;
                           }
                        }
                        switch (count){
                            case 0:
                                jbtn[idI][idJ].setBackground(Color.BLACK);
                                break;
                            case 1:
                                jbtn[idI][idJ].setBackground(Color.BLUE);
                                Frame3 frm1 = new Frame3();
                                frm1.setVisible(true);
                                Frame2.this.setVisible(false);
                                break;
                        }
                    }
                });
                centerButtonPanel.add(jbtn[i][j]);
            }
        }
        add(centerButtonPanel,BorderLayout.CENTER);
        bombCount = bombCount;
        setVisible(true);
    }
}
