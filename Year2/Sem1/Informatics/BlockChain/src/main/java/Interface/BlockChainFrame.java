package Interface;

import API.BlockChainAPI;
import DB.DataModel;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class BlockChainFrame extends JFrame implements ActionListener {

    BlockChainAPI api;

    //Components
    JPanel inputPanel;
    JPanel tablePanel;
    JTextField name;
    JTextField data;
    JButton buttonCreate;
    JButton buttonUpdate;
    JTable table;

    //Constants
    final int HEADER_SIZE;

    public BlockChainFrame(BlockChainAPI api) {

        this.api = api;
        HEADER_SIZE = api.headers.length;

        setFrame();
        addAllComponents();

        setVisible(true);
    }

    private void setFrame() {
        setTitle("Block Chain Manager");
        setSize(1000, 700);
        getContentPane().setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addAllComponents() {

        createInputPanel();
        setTable();
        createTablePanel();
    }

    private void setTable() {
        table = new JTable(api.chain.chainData(HEADER_SIZE),api.headers);
        table.getTableHeader().setBackground(Color.yellow);
        table.getTableHeader().setFont(new Font("HOT",Font.BOLD,20));
        table.getTableHeader().setBackground(Color.yellow);

    }

    private void createInputPanel() {
        inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(100, 50));
        inputPanel.setBackground(Color.BLACK);
        createTextContainers();
        createButton();
        add(inputPanel, BorderLayout.NORTH);
    }

    private void createTablePanel() {
        if (tablePanel != null) {
            remove(tablePanel);
        }
        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(table,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tablePanel.add(scrollPane);
        tablePanel.setVisible(true);
        add(tablePanel, BorderLayout.CENTER);
    }

    private void createTextContainers() {
        name = new JTextField();
        data = new JTextField();

        name.setPreferredSize(new Dimension(100, 25));
        data.setPreferredSize(new Dimension(100, 25));

        inputPanel.add(name);
        inputPanel.add(data);
    }

    private void createButton() {
        buttonCreate = makeButton("Create");
        buttonUpdate = makeButton("Update");
        inputPanel.add(buttonCreate);
        inputPanel.add(buttonUpdate);
    }

    private JButton makeButton(String name) {
        JButton jButton = new JButton(name);
        jButton.setBackground(Color.GRAY);
        jButton.setForeground(Color.YELLOW);
        jButton.setFont(new Font("HOT", Font.BOLD, 25));
        jButton.setPreferredSize(new Dimension(150, 25));
        jButton.addActionListener(this);
        jButton.setVisible(true);
        return jButton;
    }

    private void updateTable() throws IOException {
        api.load();
        createTablePanel();
        repaint();
        revalidate();
    }

    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {
        if (buttonCreate.equals(e.getSource())) {
            if (data.getText().length() >= 1 && name.getText().length() >= 1) {
                if (api.createBlock(new DataModel(data.getText(), name.getText())) != null) {
                    JOptionPane.showMessageDialog(null, "Block Created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    updateTable();
                } else JOptionPane.showMessageDialog(null, "Block Create Failed", "Error", JOptionPane.ERROR_MESSAGE);
                name.setText("");
                data.setText("");
            } else
                JOptionPane.showMessageDialog(null, "Text is too short", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (buttonUpdate.equals(e.getSource()))
            updateTable();
    }
}