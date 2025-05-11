import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class UniversityManagementSystem extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    // User credentials
    private String[] usernames = {"22eg105m61@anurag.edu.in", "22eg105m60@anurag.edu.in", "22eg105m58@anurag.edu.in", "23eg505m04@anurag.edu.in", "23eg505m01@anurag.edu.in"};
    private String[] passwords = {"password","password","password","password","password"};
    private String[] studentNames = {"vishva", "naresh", "sravanti", "vishnu vardhan", "shreya"};
    private String[] rollNumbers = {"22eg105m61", "22eg105m60", "22eg105m58", "23eg505m01", "23eg505m04"};
    private String[] branches = {"CSE", "cse", "cse", "CSE", "cse"};
    private String[] attendances = {"83%", "75%", "90%", "85%", "80%"};
    private String[] cgpas = {"8.5", "9.5", "9.0", "8.0", "8.8"};


    public UniversityManagementSystem() {
        setTitle("University Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 248, 255)); // Light blue background

        JLabel usernameLabel = new JLabel("Email ID:");
        usernameLabel.setBounds(50, 30, 80, 30);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 30, 200, 30);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 80, 80, 30);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 80, 200, 30);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 130, 100, 30);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        messageLabel = new JLabel("");
        messageLabel.setBounds(50, 180, 300, 30);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(messageLabel);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        boolean authenticated = false;

        for (int i = 0; i < usernames.length; i++) {
            if (username.equals(usernames[i]) && password.equals(passwords[i])) {
                new StudentDetails(studentNames[i], rollNumbers[i], branches[i], attendances[i], cgpas[i]);
                authenticated = true;
                dispose();
                break;
            }
        }

        if (!authenticated) {
            messageLabel.setText("Invalid username or password");
            messageLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UniversityManagementSystem());
    }
}

class StudentDetails extends JFrame {
    public StudentDetails(String name, String roll, String branch, String attendance, String cgpa) {
        setTitle("Student Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));
        panel.setBackground(new Color(240, 248, 255)); // Light blue background

        JLabel nameLabel = new JLabel("Student Name: " + name);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(nameLabel);

        JLabel rollLabel = new JLabel("Roll Number: " + roll);
        rollLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(rollLabel);
        
        JLabel branchLabel = new JLabel("Branch: " + branch);
        branchLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(branchLabel);
        
        JLabel attendanceLabel = new JLabel("Overall Attendance: " + attendance);
        attendanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(attendanceLabel);
        
        JLabel cgpaLabel = new JLabel("Overall CGPA: " + cgpa);
        cgpaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(cgpaLabel);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            new UniversityManagementSystem();
            dispose();
        });
        buttonPanel.add(logoutButton);
        panel.add(buttonPanel);
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu sectionsMenu = new JMenu("Sections");
        
        JMenuItem timetableItem = new JMenuItem("Timetable");
        timetableItem.addActionListener(e -> {
            // Load timetable image
            ImageIcon imageIcon = new ImageIcon("timetable.jpg");
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(600, 400,  java.awt.Image.SCALE_SMOOTH); // Resize the image
            imageIcon = new ImageIcon(newImage);
            JLabel imageLabel = new JLabel(imageIcon);
            JPanel imagePanel = new JPanel();
            imagePanel.add(imageLabel);
            JOptionPane.showMessageDialog(null, imagePanel, "Timetable", JOptionPane.PLAIN_MESSAGE);
        });
        sectionsMenu.add(timetableItem);
        
        JMenuItem examScheduleItem = new JMenuItem("Exam Schedule");
        examScheduleItem.addActionListener(e -> {
            // Load exam schedule image
            ImageIcon imageIcon = new ImageIcon("examtimetable.jpg");
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(600, 400,  java.awt.Image.SCALE_SMOOTH); // Resize the image
            imageIcon = new ImageIcon(newImage);
            JLabel imageLabel = new JLabel(imageIcon);
            JPanel imagePanel = new JPanel();
            imagePanel.add(imageLabel);
            JOptionPane.showMessageDialog(null, imagePanel, "Exam Schedule", JOptionPane.PLAIN_MESSAGE);
        });
        sectionsMenu.add(examScheduleItem);
        
        JMenuItem assignmentsItem = new JMenuItem("Assignments");
        assignmentsItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Assignments Section");
        });
        sectionsMenu.add(assignmentsItem);
        
        JMenuItem feeDetailsItem = new JMenuItem("Fee Details");
        feeDetailsItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Fee Details Section");
        });
        sectionsMenu.add(feeDetailsItem);
        
        JMenuItem libraryItem = new JMenuItem("Library");
        libraryItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Library Section");
        });
        sectionsMenu.add(libraryItem);
        
        JMenuItem moreOptionsItem = new JMenuItem("More Options");
        moreOptionsItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "More Options Section");
        });
        sectionsMenu.add(moreOptionsItem);
        
        menuBar.add(sectionsMenu);
        setJMenuBar(menuBar);

        add(panel);
        setVisible(true);
    }
}

