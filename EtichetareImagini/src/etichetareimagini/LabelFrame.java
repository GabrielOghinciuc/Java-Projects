
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.beans.PropertyVetoException;


public class LabelFrame extends JInternalFrame implements ActionListener, KeyListener, InternalFrameListener{
	private static final long serialVersionUID = 1L;
	private JTextField text;
	ImageDesktop parent;
	private boolean pressed = false;
	
    public LabelFrame(ImageDesktop parent,int x, int y,String defaultText) {
        super("Choose a Label", false, true, false, false); 
        this.parent = parent;
        setSize(300,120);
        text = new JTextField();
        text.setPreferredSize(new Dimension(250,30));
        text.setMaximumSize(new Dimension(250,30));
        text.setMinimumSize(new Dimension(250,30));
        text.addKeyListener(this);
        text.setText(defaultText);
        addInternalFrameListener(this);
        
        JButton discard = new JButton();
        discard.setText("Discard");
        discard.setActionCommand("discard");
        discard.addActionListener(this);
        
      
        JButton submit = new JButton();
        submit.setText("Trimite");
        submit.addActionListener(this);
        submit.setActionCommand("submit");
        
        JPanel main = new JPanel();
        setContentPane(main);
        main.add(text);
        main.add(discard);
        main.add(submit);
        main.setLayout(new FlowLayout(FlowLayout.CENTER));
        setLocation(x, y);
        
    }

    public void keyPressed(KeyEvent key) {
		pressed = true;
	}

	@Override
	public void keyReleased(KeyEvent key) {
		if(pressed) {
			if(key.getKeyCode() == KeyEvent.VK_ENTER) {
				addLabel(text.getText());
				setVisible(false);
				dispose();
			} else if(key.getKeyCode() == KeyEvent.VK_ESCAPE) {
				try {
					setClosed(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
				dispose();
			}
		}
		pressed = false;
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {

	}

	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		//aterge poligonul curent
		parent.deleteCurrentPolygon();
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		
	}
	
	private void addLabel(String label) {
		parent.addLabel(label);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if("submit".equals(e.getActionCommand())) {
			addLabel(text.getText());
			setVisible(false);
			dispose();
		} else if("discard".equals(e.getActionCommand())) {
			try {
				setClosed(true);
			} catch (PropertyVetoException e1) {
				System.out.println("Eroare fatala");
			}
			dispose();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}