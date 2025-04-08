
package tictactoe;

import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class TicTacToe extends JFrame{
public TicTacToe(String string, GraphicsConfiguration gc) {
super(string, gc);
}
public TicTacToe(String string) throws HeadlessException {
super(string);
}
    public TicTacToe(GraphicsConfiguration gc)
{
super(gc);
}
public TicTacToe firstInstance =null;
protected JButton but[];
protected GridLayout grid; 
@SuppressWarnings("OverridableMethodCallInConstructor")
    protected TicTacToe()throws HeadlessException
{
super("X și O");
but = new JButton[9];
grid= new GridLayout(3,3,5,5);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(300,300);
setLayout(grid);
setResizable(false);
ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("1.jpg"));
setIconImage(logo.getImage());

//Creare Butoane
for(int loop=0; loop<9; loop++)
{
but[loop] = new JButton();
add(but[loop]);
}
setVisible(true);
}
// Resetare GUI
public void resetGame()
{ // pentru fiecare din cele 9 piese
for(int z=0; z<9; z++)
{ but[z].setText(""); // cu textul "" }
}}
//Folosirea SINGLETON-lui
public TicTacToe getInstace()
{
if (firstInstance==null)
firstInstance = new TicTacToe();
return firstInstance;
}
    private static class start {

        public start() {
            super();
        }
    }
public class model {
public model() {
super();
}
int array[] = new int[9]; // O = 1 - X = 2
int numberOfClicks=1;
public void setClick(int position, int XorO)
{
array[position]=XorO; // Adauga 1 sau 2 pozititii in ARRAY
numberOfClicks++; // incrementeaza clik-urile
}
//Reseteaza ARRAY si Numarul de clik-uri
public void resetGame() // resetare joc
{ // resetare joc
numberOfClicks=0; //initializare cu 0 nr click-uri
for(int z=0; z<9; z++)
{ array[z]=0; } //intializare array cu 0 pt cele 9 piese
}
// Aceasta metoda este pentru a vedea care jucator
// a castigat si intoarce o valoare
// 1 (daca O castigator) - 2 (daca X castigator)
// 3 (DACĂ nimeni nu castiga - 0 default
public int getResult()
{
//Testul Orizontal
if (array[0]==1 && array[1]==1 && array[2]==1)
return 1; // O castiga
if (array[0]==2 && array[1]==2 && array[2]==2)
return 2; // X castiga
if (array[3]==1 && array[4]==1 && array[5]==1)
return 1; // O castiga
if (array[3]==2 && array[4]==2 && array[5]==2)
return 2; // X castiga
if (array[6]==1 && array[7]==1 && array[8]==1)
return 1; // O castiga
if (array[6]==2 && array[7]==2 && array[8]==2)
return 2; // X castiga
// Testul Verical
if (array[0]==1 && array[3]==1 && array[6]==1)
return 1; // O castiga
if (array[0]==2 && array[3]==2 && array[6]==2)
return 2; // X castiga
if (array[1]==1 && array[4]==1 && array[7]==1)
return 1; // O castiga
if (array[1]==2 && array[4]==2 && array[7]==2)
return 2; // X castiga
if (array[2]==1 && array[5]==1 && array[8]==1)
return 1; // O castiga
if (array[2]==2 && array[5]==2 && array[8]==2)
return 2; // X castiga
if (array[0]==1 && array[4]==1 && array[8]==1)
return 1; // O castiga
if (array[0]==2 && array[4]==2 && array[8]==2)
return 2; // X castiga
if (array[2]==1 && array[4]==1 && array[6]==1)
return 1; // O castiga
if (array[2]==2 && array[4]==2 && array[6]==2)
return 2; // X castiga
if (numberOfClicks==9)
return 3; //Nimeni nu a Castigat acest joc
return 0; // Nimeni nu a castigat inca
}}
public static class controller extends TicTacToe implements ActionListener {
public model newModel = new model();
public int result = 0;
public boolean whosGo = false; // Setarea Jucatorului O ca fiind primul
@SuppressWarnings("LeakingThisInConstructor")
public controller() {
super();
// Adaugarea Actiunii Listener Buttonului pentru Clasa View
for (int x = 0; x < 9; x++)
super.but[x].addActionListener(this);
}
public void goAgain() {
int reply = JOptionPane.showConfirmDialog(null, "Un nou joc?", "TIC TAC TOE", JOptionPane.YES_NO_OPTION);
if (reply == JOptionPane.YES_OPTION) {
newModel.resetGame();
super.resetGame();
} 
    else 
{
    dispose();
    System.exit(0);
}
}
public void actionPerformed(ActionEvent event) {
Object objClicked = event.getSource();
for (int x = 0; x < 9; x++) {
if (objClicked == super.but[x]) {
    but[x].setBackground(java.awt.Color.lightGray);
if (super.but[x].getText() == "") {
if (whosGo == false) {
super.but[x].setText("X");
but[x].setForeground(java.awt.Color.red);
newModel.setClick(x, 1);
whosGo = true; // Schimba urmatorul Jucator
result = newModel.getResult();
} else {
super.but[x].setText("O");
but[x].setForeground(java.awt.Color.blue);
newModel.setClick(x, 2);
whosGo = false; // Schimba urmatorul Jucator
result = newModel.getResult();
}
}
}
}
if (result != 0)
goAgain();
}
}
    public static void main(String[] args) {
        start start = new start();
// crearea instantei controlerului
       controller cont = new controller();
    }
}
