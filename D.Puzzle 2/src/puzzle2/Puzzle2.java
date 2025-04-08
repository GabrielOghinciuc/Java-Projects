/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.MenuBar;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Boolean.TRUE;
import java.util.Random;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Puzzle2 extends javax.swing.JFrame {
    Random rand = new Random();
static JButton invisible;
static void switchButtons(JButton clickedButton)
{
    if(
            invisible.getLocation().x < (clickedButton.getLocation().x - clickedButton.getSize().width)||
            invisible.getLocation().x > (clickedButton.getLocation().x + clickedButton.getSize().width)||
            invisible.getLocation().y < (clickedButton.getLocation().y - clickedButton.getSize().height)||
            invisible.getLocation().y > (clickedButton.getLocation().y + clickedButton.getSize().height)||
            (invisible.getLocation().y != clickedButton.getLocation().y && invisible.getLocation().x != clickedButton.getLocation().x)
        )
        return;
    Point tmpLoc= clickedButton.getLocation();
    clickedButton.setLocation(invisible.getLocation());
    invisible.setLocation(tmpLoc);
}

    public Puzzle2() {
        initComponents();
        LayoutManager layout = new GridLayout(3,3);
        Frame f = new Frame();
        f.setResizable(false);
        f.setTitle("Puzzle cu cifre");
        f.setBackground(Color.LIGHT_GRAY);
        f.addWindowListener(new WindowAdapter(){
    @Override
    public void windowClosing(WindowEvent e){System.exit(0);}
    });
        f.setLayout(layout);
        JButton btn = new JButton();
       /* ArrayList<String> l = new ArrayList<String>(); // incercare esuata
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("5");
        l.add("6");
        l.add("7");
        l.add("8");
        l.add("9");
        l.add("10");
        l.add("11");
        l.add("12");
        Collections.shuffle(l);*/
        int[] list =new int [13];
        for(int i=1;i<13;i++)
        {
            list[i]=rand.nextInt(12-1)+1;
            // aici faci un if in care pui toate posibilitatile de duplicate
        }
        do
        {
        if(list[1]==list[2])
            list[2]=rand.nextInt(12-1)+1;
        else
            if(list[1]==list[3])
                list[3]=rand.nextInt(12-1)+1;
        else
            if(list[2]==list[3])
                list[3]=rand.nextInt(12-1)+1;
         else
                if(list[1]==list[4])
                    list[4]=rand.nextInt(12-1)+1;
        else
                if(list[2]==list[4])
                    list[4]=rand.nextInt(12-1)+1;
        else
                if(list[3]==list[4])
                    list[4]=rand.nextInt(12-1)+1;
        else
                if(list[1]==list[5])
                    list[5]=rand.nextInt(12-1)+1;
        else
                if(list[2]==list[5])
                    list[5]=rand.nextInt(12-1)+1;
        else
                if(list[3]==list[5])
                    list[5]=rand.nextInt(12-1)+1;
        else
                if(list[4]==list[5])
                    list[5]=rand.nextInt(12-1)+1;
        else
                if(list[1]==list[6])
                    list[6]=rand.nextInt(12-1)+1;
        else
                if(list[2]==list[6])
                    list[6]=rand.nextInt(12-1)+1;
        else
                if(list[3]==list[6])
                    list[6]=rand.nextInt(12-1)+1;
        else
                if(list[4]==list[6])
                    list[6]=rand.nextInt(12-1)+1;
        else
                if(list[5]==list[6])
                    list[6]=rand.nextInt(12-1)+1;
        else
                if(list[1]==list[7])
                    list[7]=rand.nextInt(12-1)+1;
        else
                if(list[2]==list[7])
                    list[7]=rand.nextInt(12-1)+1;
        else
                if(list[3]==list[7])
                    list[7]=rand.nextInt(12-1)+1;
        else
                if(list[4]==list[7])
                    list[7]=rand.nextInt(12-1)+1;
        else
                if(list[5]==list[7])
                    list[7]=rand.nextInt(12-1)+1;
        else
                if(list[6]==list[7])
                    list[7]=rand.nextInt(12-1)+1;
        else
                if(list[1]==list[8])
                    list[8]=rand.nextInt(12-1)+1;
        else
                if(list[2]==list[8])
                    list[8]=rand.nextInt(12-1)+1;
        else
                if(list[3]==list[8])
                    list[8]=rand.nextInt(12-1)+1;
        else
                if(list[4]==list[8])
                    list[8]=rand.nextInt(12-1)+1;
        else
                if(list[5]==list[8])
                    list[8]=rand.nextInt(12-1)+1;
        else
                if(list[6]==list[8])
                    list[8]=rand.nextInt(12-1)+1;
        else
                if(list[7]==list[8])
                    list[8]=rand.nextInt(12-1)+1;
        else
                if(list[1]==list[9])
                    list[9]=rand.nextInt(12-1)+1;
        else
                if(list[2]==list[9])
                    list[9]=rand.nextInt(12-1)+1;
        else
                if(list[3]==list[9])
                    list[9]=rand.nextInt(12-1)+1;
        else
                if(list[4]==list[9])
                    list[9]=rand.nextInt(12-1)+1;
        else
                if(list[5]==list[9])
                    list[9]=rand.nextInt(12-1)+1;
        else
                if(list[6]==list[9])
                    list[9]=rand.nextInt(12-1)+1;
        else
                if(list[7]==list[9])
                    list[9]=rand.nextInt(12-1)+1;
        else
                if(list[8]==list[9])
                    list[9]=rand.nextInt(12-1)+1;
        else
                if(list[1]==list[10])
                    list[10]=rand.nextInt(12-1)+1;
        else
                if(list[2]==list[10])
                    list[10]=rand.nextInt(12-1)+1;
        else
                if(list[3]==list[10])
                    list[10]=rand.nextInt(12-1)+1;
        else
                if(list[4]==list[10])
                    list[10]=rand.nextInt(12-1)+1;
        else
                if(list[5]==list[10])
                    list[10]=rand.nextInt(12-1)+1;
        else
                if(list[6]==list[10])
                    list[10]=rand.nextInt(12-1)+1;
        else
                if(list[7]==list[10])
                    list[10]=rand.nextInt(12-1)+1;
        else
                if(list[8]==list[10])
                    list[10]=rand.nextInt(12-1)+1;
        else
                if(list[9]==list[10])
                    list[10]=rand.nextInt(12-1)+1;
        else
                if(list[1]==list[11])
                    list[11]=rand.nextInt(12-1)+1;
        else
                if(list[2]==list[11])
                    list[11]=rand.nextInt(12-1)+1;
        else
                if(list[3]==list[11])
                    list[11]=rand.nextInt(12-1)+1;
        else
                if(list[4]==list[11])
                    list[11]=rand.nextInt(12-1)+1;
        else
                if(list[5]==list[11])
                    list[11]=rand.nextInt(12-1)+1;
        else
                if(list[6]==list[11])
                    list[11]=rand.nextInt(12-1)+1;
        else
                if(list[7]==list[11])
                    list[11]=rand.nextInt(12-1)+1;
        else
                if(list[8]==list[11])
                    list[11]=rand.nextInt(12-1)+1;
        else
                if(list[9]==list[11])
                    list[11]=rand.nextInt(12-1)+1;
        else
                if(list[10]==list[11])
                    list[11]=rand.nextInt(12-1)+1;
        }
        while(list[1]==list[2]||list[1]==list[3]||list[2]==list[3]||list[1]==list[4]||list[2]==list[4]||list[3]==list[4]||list[1]==list[5]||list[2]==list[5]||list[3]==list[5]||list[4]==list[5]||list[1]==list[6]||list[2]==list[6]||list[3]==list[6]||list[4]==list[6]||list[5]==list[6]||list[1]==list[7]||list[2]==list[7]||list[3]==list[7]||list[4]==list[7]||list[5]==list[7]||list[6]==list[7]||list[1]==list[8]||list[2]==list[8]||list[3]==list[8]||list[4]==list[8]||list[5]==list[8]||list[6]==list[8]||list[7]==list[8]||list[1]==list[9]||list[2]==list[9]||list[3]==list[9]||list[4]==list[9]||list[5]==list[9]||list[6]==list[9]||list[7]==list[9]||list[8]==list[9]||list[1]==list[10]||list[2]==list[10]||list[3]==list[10]||list[4]==list[10]||list[5]==list[10]||list[6]==list[10]||list[7]==list[10]||list[8]==list[10]||list[9]==list[10]||list[1]==list[11]||list[2]==list[11]||list[3]==list[11]||list[4]==list[11]||list[5]==list[11]||list[6]==list[11]||list[7]==list[11]||list[8]==list[11]||list[9]==list[11]||list[10]==list[11]);
        
        for(int i=1;i<13;i++)
        {
            btn = new JButton(String.valueOf(list[i]));
            btn.addActionListener((ActionEvent e) -> {
                switchButtons((JButton)e.getSource());
            });
            f.add(btn);
        }
        btn.setVisible(false);
        invisible = btn;
        f.setSize(420,420);
        f.setVisible(true);
        ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("1.png"));
        f.setIconImage(logo.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
                java.awt.EventQueue.invokeLater(() -> {
            new Puzzle2().setVisible(false);
        });
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
