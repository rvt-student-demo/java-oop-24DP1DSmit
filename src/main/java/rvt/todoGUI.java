package rvt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class todoGUI extends JFrame {
    private todo todoList;
    private JTextArea taskDisplayArea;
    private JTextField taskInputField;
    private JSpinner idSpinner;
    private JPanel mainPanel;

    public todoGUI(todo todoList) {
        this.todoList = todoList;
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Todo List Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(true);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Todo List Manager");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        taskDisplayArea = new JTextArea();
        taskDisplayArea.setEditable(false);
        taskDisplayArea.setFont(new Font("Courier New", Font.PLAIN, 12));
        taskDisplayArea.setLineWrap(true);
        taskDisplayArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(taskDisplayArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 1, 5, 5));

        JPanel addPanel = new JPanel();
        addPanel.setLayout(new BorderLayout(5, 5));
        addPanel.setBorder(BorderFactory.createTitledBorder("Add New Task"));
        taskInputField = new JTextField();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
        addPanel.add(taskInputField, BorderLayout.CENTER);
        addPanel.add(addButton, BorderLayout.EAST);
        controlPanel.add(addPanel);

        JPanel listRemovePanel = new JPanel();
        listRemovePanel.setLayout(new GridLayout(1, 2, 5, 5));
        listRemovePanel.setBorder(BorderFactory.createTitledBorder("View & Remove Tasks"));

        JButton listButton = new JButton("Refresh List");
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTasks();
            }
        });
        listRemovePanel.add(listButton);

        JPanel removePanel = new JPanel();
        removePanel.setLayout(new BorderLayout(5, 5));
        removePanel.add(new JLabel("Remove Task ID:"), BorderLayout.WEST);
        
        idSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        removePanel.add(idSpinner, BorderLayout.CENTER);
        
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTask();
            }
        });
        removePanel.add(removeButton, BorderLayout.EAST);
        listRemovePanel.add(removePanel);

        controlPanel.add(listRemovePanel);

        // Exit button panel
        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitPanel.add(exitButton);
        controlPanel.add(exitPanel);

        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);

        displayTasks();
    }

    private void addTask() {
        String task = taskInputField.getText().trim();
        if (task.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a task.", "Empty Task", JOptionPane.WARNING_MESSAGE);
            return;
        }
        todoList.add(task);
        taskInputField.setText("");
        JOptionPane.showMessageDialog(this, "Task added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        displayTasks();
    }

    private void displayTasks() {
        taskDisplayArea.setText("");
        try (Scanner reader = new Scanner(new File("data/todo.csv"))) {
            int id = 1;
            StringBuilder tasks = new StringBuilder();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                tasks.append(id).append(": ").append(line).append("\n");
                id++;
            }
            if (tasks.length() == 0) {
                taskDisplayArea.setText("No tasks yet. Add a new task to get started!");
            } else {
                taskDisplayArea.setText(tasks.toString());
            }
        } catch (Exception e) {
            taskDisplayArea.setText("Error loading tasks: " + e.getMessage());
        }
    }

    private void removeTask() {
        int id = (Integer) idSpinner.getValue();
        ArrayList<String> tasks = new ArrayList<>();
        try (Scanner reader = new Scanner(new File("data/todo.csv"))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                tasks.add(line);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error reading tasks: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (id < 1 || id > tasks.size()) {
            JOptionPane.showMessageDialog(this, "Invalid ID. Please enter a valid task number.", "Invalid ID", JOptionPane.WARNING_MESSAGE);
            return;
        }

        todoList.remove(id);
        JOptionPane.showMessageDialog(this, "Task removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        displayTasks();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new todoGUI(new todo());
            }
        });
    }
}
