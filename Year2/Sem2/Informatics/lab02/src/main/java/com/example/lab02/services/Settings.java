package com.example.lab02.services;

import com.example.lab02.models.Admin;
import com.example.lab02.models.User;
import task2.annotations.Component;

import static com.example.lab02.utils.DefaultCommands.*;

@Component
public class Settings {

    public Admin admin;
    public User user;

    public Settings() {
        admin = new Admin();
        user = new User();
    }

    //Application Settings
    //Default value is "/" in linux and "/c" in windows
    public String directory = System.getProperty("user.home");

    //Private key data
    public String algorithmName = "rsa";
    public int algorithmLength = 2048;

    //Organization commands
    public String getPrivateKeyCommand(String keyName) {
        return String.format(GenPKCommand, algorithmName, directory, keyName, algorithmLength);
    }

    public String getOrganizationCertificateCommand() {
        return String.format(OrganizationCertificateCommand, directory, admin.organization,
                directory, admin.organization, admin.getDataInCommandFormat());
    }

    //User commands
    public String getUserCertificateRequestCommand() {
        return String.format(UserCertificateRequestCommand, directory, user.username,
                directory, user.username, user.getDataInCommandFormat());
    }

    public String getUserCertificateCommand() {
        return String.format(UserCertificateCommand, directory, user.username, user.adminCertificateFile,
                user.adminKeyFile, directory, user.username);
    }

}
