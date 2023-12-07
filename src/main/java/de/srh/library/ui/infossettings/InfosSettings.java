package de.srh.library.ui.infossettings;

import de.srh.library.ui.login.LoginWindow;
import de.srh.library.ui.mainmenu.MainMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InfosSettings extends JFrame {

    private static final Logger logger = LoggerFactory.getLogger(LoginWindow.class);
    private JPanel infosSettings;
    private JLabel pageTitle;
    private JTextField userEmail;
    private JTextField userAddress;
    private JTextField userID;
    private JTextField userRole;
    private JButton changeInformationButton;
    private JButton resetPasswordButton;
    private JLabel emailLabel;
    private JLabel addressLabel;
    private JLabel userIDLabel;
    private JLabel roleLabel;
    private JButton safeButton;
    private JButton returnButton;

    //Testing only
    private String testemail = "test.test@gmail.com";
    private String testaddress = "hauptstraße 3";
    private long testid = 110110110;
    private String testrole = "gigachad";

    public InfosSettings() {

        setAutoRequestFocus(false);
        setContentPane(infosSettings);
        setTitle("Infos and Settings");
        setSize(1280, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        logger.info("Opening infos and settings window ...");

        // ! Fill with correct user data from saved users in database
        initUserInformation(testemail, testaddress, testid, testrole);

        changeInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                safeButton.setEnabled(true);
                userEmail.setEditable(true);
                userAddress.setEditable(true);
                userID.setEditable(true);
                userRole.setEditable(true);
            }
        });
        safeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent safe) {
                userEmail.setEditable(false);
                userAddress.setEditable(false);
                userID.setEditable(false);
                userRole.setEditable(false);
                safeButton.setEnabled(false);

                //Save new user data, overwrite old user data from database
                // ! Check for valid data input !
                updateUserInformation(userEmail.getText(), userAddress.getText(), Long.parseLong(userID.getText()), userRole.getText());
            }
        });
        resetPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Open change password window POPUP, able to close without closing the programm
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
            }
        });
    }

    public void initUserInformation(String currentUserEmail, String currentUserAddress, long currentUserNumber, String currentUserRole) {
        userEmail.setText(currentUserEmail);
        userAddress.setText(currentUserAddress);
        userID.setText(String.valueOf(currentUserNumber));
        userRole.setText(currentUserRole);
    };

    public void updateUserInformation(String newUserEmail, String newUserAddress, long newUserNumber, String newUserRole) {
        userEmail.setText(newUserEmail);
        userAddress.setText(newUserAddress);
        userID.setText(String.valueOf(newUserNumber));
        userRole.setText(newUserRole);
    };

    //Testing Only
    public static void main(String[] args) {
        InfosSettings infosSettings = new InfosSettings();
    }
}