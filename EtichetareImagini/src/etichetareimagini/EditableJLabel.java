import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditableJLabel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JTextField textField;
	private String text;
	private LinkedList<ValueChangedListener> listeners = new LinkedList<ValueChangedListener>();
	private LinkedList<MouseOverListener> mouselisteners = new LinkedList<MouseOverListener>();

	/**
	 * Create the new panel
	  */
	EditableJLabel(String startText) {
		super();

		CardLayout layout = new CardLayout(0, 0);
		this.setLayout(layout);
		EditableListener hl = new EditableListener();

		// Creare JPanel pentru starea  "normala"
		JPanel labelPanel = new JPanel(new GridLayout(1, 1));
		text = startText;
		label = new JLabel(startText);
		labelPanel.add(label);

		JPanel inputPanel = new JPanel(new GridLayout(1, 1));
		textField = new JTextField(startText);
		textField.addMouseListener(hl);
		textField.addKeyListener(hl);
		textField.addFocusListener(hl);
		inputPanel.add(textField);

		this.addMouseListener(hl);

		this.add(labelPanel, "NORMAL");
		this.add(inputPanel, "HOVER");

		layout.show(this, "NORMAL");
	}

		public void setText(String text) {
			this.text = text;
			this.label.setText(text);
			this.textField.setText(text);
	}
	
	public String getText() {
		return text;
	}
	
	public JTextField getTextField() {
		return textField;
	}
	
	public JLabel getLabel() {
		return label;
	}
	
	public void setHoverState(boolean hover) {
		CardLayout cl = (CardLayout) (this.getLayout());
		
		if (hover)
			cl.show(this, "HOVER");
		else
			cl.show(this, "NORMAL");
	}


	public void addValueChangedListener(ValueChangedListener l) {
		this.listeners.add(l);
	}
	public void addMouseOverListener(MouseOverListener l) {
		this.mouselisteners.add(l);
	}

	public class EditableListener implements MouseListener, KeyListener, FocusListener {

		boolean locked = false;
		String oldValue;

		/**
		 * Blocare  camp text cat timp este focus
		 */
		@Override
		public void focusGained(FocusEvent arg0) {
			locked = true;
			oldValue = textField.getText();
		}

		/**
		 * Eliberati blocarea, revenire la eticheta JLabel
		 */
		public void release() {
			this.locked = false;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			label.setForeground(Color.blue);
			//label.setText("<html><u>"+text+"</u></html>");
			for (MouseOverListener v : mouselisteners) {
				v.mouseEntered();
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (!locked) {
				setHoverState(false);
			}
			label.setForeground(Color.black);
			label.setText(text);
			for (MouseOverListener v : mouselisteners) {
				v.mouseExited();
			}
		}
		
                 @Override
		public void focusLost(FocusEvent e) {
			setText(textField.getText());
			for (ValueChangedListener v : listeners) {
				v.valueChanged(textField.getText(), EditableJLabel.this);
			}
			release();
			mouseExited(null);
		}

// Verificare daca exista apasare de taste. doar Enter (salvare valoare
// din camp) ai Escape (reseteaza campul la valoarea sa anterioara)
		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				setText(textField.getText());
				release();
				mouseExited(null);
			} else if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
				release();
				mouseExited(null);
				setText(oldValue);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			setHoverState(true);
			textField.grabFocus();
		}
	}
}

interface ValueChangedListener {
	public void valueChanged(String value, JComponent source);
}

interface MouseOverListener {
	public void mouseEntered();
	public void mouseExited();
}