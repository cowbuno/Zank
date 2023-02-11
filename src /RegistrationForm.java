import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class RegistrationForm extends JDialog {
    private JTextField tfName;
    private JTextField tfSurname;
    private JTextField tfEmail;
    private JTextField tfUIN;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JButton btnRegister;
    private JButton btnCancel;
    private JPanel registerPanel;

    public RegistrationForm(JFrame parent) {
        super(parent);
        setTitle("Create a new account");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void registerUser() {
        String name = tfName.getText();
        String surname = tfSurname.getText();
        String email = tfEmail.getText();
        String uin = tfUIN.getText();
        String password = String.valueOf(pfPassword.getPassword());
        String confirmPassword = String.valueOf(pfConfirmPassword.getPassword());

        if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || uin.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this,
                    "Confirm Password does not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        user = addUserToDatabase(name, surname, email, uin, password);
        if (user != null) {
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Failed to register new user",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    public User user;
    public User addUserToDatabase(String name, String surname, String email, String uin, String password) {
        User user = null;
        final String DB_URL = "jdbc:postgresql://localhost:5432/";
        final String USERNAME = "postgres";
        final String PASSWORD = "1234567";

        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (name, surname, email, uin, password) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, uin);
            preparedStatement.setString(5, password);

            //Insert row into the table
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                user = new User();
                user.name = name;
                user.surname = surname;
                user.email = email;
                user.uin = uin;
                user.password = password;
            }

            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }



    public static void main(String[] args) {
        RegistrationForm myForm = new RegistrationForm(null);
        User user = myForm.user;
        if (user != null) {
            System.out.println("Successful registration of: " + user.name);
        }
        else {
            System.out.println("Registration canceled");
        }
    }
}
