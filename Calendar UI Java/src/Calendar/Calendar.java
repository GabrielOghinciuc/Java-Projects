package Calendar;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calendar{
    static JLabel lblMonth, lblAn;
    static JButton btnAnterior, btnUrmator;
    static JTable tblCalendar;
    static JComboBox cmbAn;
    static JFrame frmMain;
    static Container pane;
    static DefaultTableModel mtblCalendar;
    static JScrollPane stblCalendar;
    static JPanel pnlCalendar;
    static int AnReal, LunaReala, ZiReala, AnCurent, LunaCurenta;
    
    public static void main (String args[]){
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        
        frmMain = new JFrame ("Calendar"); 
        frmMain.setSize(330, 375);
        pane = frmMain.getContentPane();
        pane.setLayout(null); 
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        lblMonth = new JLabel ("Ianuarie");
        lblAn = new JLabel ("Schimba an:");
        cmbAn = new JComboBox();
        btnAnterior = new JButton ("<<");
        btnUrmator = new JButton (">>");
        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        pnlCalendar = new JPanel(null);
        
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
        
        btnAnterior.addActionListener(new btnAnterior_Action());
        btnUrmator.addActionListener(new btnUrmator_Action());
        cmbAn.addActionListener(new cmbAn_Action());

        pane.add(pnlCalendar);
        pnlCalendar.add(lblMonth);
        pnlCalendar.add(lblAn);
        pnlCalendar.add(cmbAn);
        pnlCalendar.add(btnAnterior);
        pnlCalendar.add(btnUrmator);
        pnlCalendar.add(stblCalendar);
        
        pnlCalendar.setBounds(0, 0, 320, 335);
        lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 100, 25);
        lblAn.setBounds(155, 305, 80, 20);
        cmbAn.setBounds(230, 305, 80, 20);
        btnAnterior.setBounds(10, 25, 50, 25);
        btnUrmator.setBounds(260, 25, 50, 25);
        stblCalendar.setBounds(10, 50, 300, 250);

        frmMain.setResizable(false); 
        frmMain.setVisible(true);

        GregorianCalendar cal = new GregorianCalendar(); 
        ZiReala = cal.get(GregorianCalendar.DAY_OF_MONTH);
        LunaReala = cal.get(GregorianCalendar.MONTH);
        AnReal = cal.get(GregorianCalendar.YEAR); 
        LunaCurenta = LunaReala; 
        AnCurent = AnReal;
        
        String[] headers = {"Dum", "Lun", "Mar", "Mie", "Joi", "Vin", "Sam"};
        for (int i=0; i<7; i++){
            mtblCalendar.addColumn(headers[i]);
        }
        
        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); 
        
        //Fara redimensionare/reordonare
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);

        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tblCalendar.setRowHeight(38);
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(6);

        for (int i=AnReal-100; i<=AnReal+100; i++){
            cmbAn.addItem(String.valueOf(i));
        }

        refreshCalendar (LunaReala, AnReal); 
    }
    
    public static void refreshCalendar(int month, int year){
        String[] months =  {"Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie", "Iulie", "August", "Septembrie", "Octombrie", "Noiembrie", "Decembrie"};
        int nod, som;

        btnAnterior.setEnabled(true);
        btnUrmator.setEnabled(true);
        if (month == 0 && year <= AnReal-10){btnAnterior.setEnabled(false);}
        if (month == 11 && year >= AnReal+100){btnUrmator.setEnabled(false);}
        lblMonth.setText(months[month]);
        lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 180, 25);
        cmbAn.setSelectedItem(String.valueOf(year));
        
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                mtblCalendar.setValueAt(null, i, j);
            }
        }
        
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        
        for (int i=1; i<=nod; i++){
            int row = new Integer((i+som-2)/7);
            int column  =  (i+som-2)%7;
            mtblCalendar.setValueAt(i, row, column);
        }

        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
    }
    
    static class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6){ 
                setBackground(new Color(255, 220, 220));
            }
            else{ 
                setBackground(new Color(255, 255, 255));
            }
            if (value != null){
                if (Integer.parseInt(value.toString()) == ZiReala && LunaCurenta == LunaReala && AnCurent == AnReal){ //Azi
                    setBackground(new Color(220, 220, 255));
                }
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }
    
    static class btnAnterior_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (LunaCurenta == 0){ 
                LunaCurenta = 11;
                AnCurent -= 1;
            }
            else{
                LunaCurenta -= 1;
            }
            refreshCalendar(LunaCurenta, AnCurent);
        }
    }
    static class btnUrmator_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (LunaCurenta == 11){ 
                LunaCurenta = 0;
                AnCurent += 1;
            }
            else{ 
                LunaCurenta += 1;
            }
            refreshCalendar(LunaCurenta, AnCurent);
        }
    }
    static class cmbAn_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbAn.getSelectedItem() != null){
                String b = cmbAn.getSelectedItem().toString();
                AnCurent = Integer.parseInt(b);
                refreshCalendar(LunaCurenta, AnCurent);
            }
        }
    }
}