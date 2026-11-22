import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ViewEmployee extends JFrame implements MouseListener, ActionListener {
    JPanel panel;
    JLabel search;
    JButton srch, upd, back;
    Font myFont;
    Color myColor;
    Choice choiceEMP;
    JTable table;
    DefaultTableModel model;
    JScrollPane scroll;
    UpdateEmployee updateEmployeeFrame;
    
    String[] columns = {"Name", "Father's Name", "Date of Birth", "Salary", "Address", "Phone", "Email", "Education", "Designation", "Nid Number", "Employee ID"};
    List<String[]> employeeData = new ArrayList<>();

    public ViewEmployee() {
        super("View Employee Details");
        this.setSize(1000, 550);
        this.setLocation(200, 50);

        myColor = new Color(224, 76, 30);
        myFont = new Font("Times New Roman", Font.PLAIN, 15);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(myColor);

        search = new JLabel("Search by ID");
        search.setBounds(20, 20, 150, 20);
        search.setFont(myFont);
        panel.add(search);

        srch = new JButton("SEARCH");
        srch.setBounds(30, 50, 110, 25);
        srch.setFont(myFont);
        srch.addActionListener(this);
        panel.add(srch);

        upd = new JButton("UPDATE");
        upd.setBounds(150, 50, 110, 25);
        upd.setFont(myFont);
        upd.addActionListener(this);
        panel.add(upd);

        back = new JButton("BACK");
        back.setBounds(270, 50, 110, 25);
        back.setFont(myFont);
        back.addActionListener(this);
        panel.add(back);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180, 20, 120, 20);
        panel.add(choiceEMP);

        model = new DefaultTableModel();
        table = new JTable(model);

        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.setSelectionBackground(new Color(246, 246, 246));
        table.setRowHeight(30);
        table.addMouseListener(this);

        scroll = new JScrollPane(table);
        scroll.setBounds(20, 90, 950, 450);
        panel.add(scroll);

        loadInformation();
        this.add(panel);
    }

    public void processUpdate() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String[] rowData = new String[columns.length];
            for (int i = 0; i < columns.length; i++) {
                rowData[i] = model.getValueAt(selectedRow, i).toString();
            }
            updateEmployeeFrame = new UpdateEmployee(rowData);
            updateEmployeeFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == table) {
            processUpdate();
        }
    }

    public void mousePressed(MouseEvent me) { }
    public void mouseReleased(MouseEvent me) { }
    public void mouseEntered(MouseEvent me) { }
    public void mouseExited(MouseEvent me) { }

    File file = new File("employee_details.txt");

    public void loadInformation() {
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] value = line.split("\t");
                employeeData.add(value);
                model.addRow(value);
                choiceEMP.add(value[10]);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == srch) {
            String selectedID = choiceEMP.getSelectedItem();
            searchEmployee(selectedID);
        } else if (ae.getSource() == upd) {
            processUpdate();
        } else if (ae.getSource() == back) {
            SecondFrame s1 = new SecondFrame();
            s1.setVisible(true);
            setVisible(false);
        }
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedID = choiceEMP.getSelectedItem();
            searchEmployee(selectedID);
        }
    }

    private void searchEmployee(String selectedID) {
        model.setRowCount(0); // Clear the table
        for (String[] employee : employeeData) {
            if (employee[10].equals(selectedID)) {
                model.addRow(employee);
                table.setRowSelectionInterval(0, 0);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Employee ID not found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public void updateRow(String[] updateData) {
        for (int i = 0; i < employeeData.size(); i++) {
            if (employeeData.get(i)[10].equals(updateData[10])) {
                employeeData.set(i, updateData);
                break;
            }
        }
        model.setRowCount(0);
        for (String[] employee : employeeData) {
            model.addRow(employee);
        }
    }
}
