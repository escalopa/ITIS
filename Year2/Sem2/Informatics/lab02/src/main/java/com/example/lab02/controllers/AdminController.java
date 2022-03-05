package com.example.lab02.controllers;

import com.example.lab02.services.ExecuteCommand;
import com.example.lab02.services.Settings;
import com.example.lab02.utils.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import task2.annotations.Component;

import java.io.IOException;

@Component
public class AdminController extends MainController {

    @FXML
    public TextField countryCode;
    @FXML
    public TextField region;
    @FXML
    public TextField city;
    @FXML
    public TextField organization;
    @FXML
    public TextField department;
    @FXML
    public TextField email;
    @FXML
    public TextField username;

    @FXML
    public void createCertificate() {
        try {
            if (saveSettings()) {
                executeCommand.createPrivateKey(settings.admin.organization);
                executeCommand.createOrganizationCertificate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean saveSettings() {
        if (areValuesIntegrated()) {
            settings.admin.countryCode = countryCode.getText();
            settings.admin.region = region.getText();
            settings.admin.city = city.getText();
            settings.admin.organization = organization.getText();
            settings.admin.department = department.getText();
            settings.admin.username = username.getText();
            settings.admin.email = email.getText();
            return true;
        }
        return false;
    }

    @Override
    public boolean areValuesIntegrated() {
        if (countryCode.getText().isBlank() || region.getText().isBlank() || city.getText().isBlank() || organization.getText().isBlank() || department.getText().isBlank() || username.getText().isBlank() || email.getText().isBlank()) {
            showError("Create Certificate Error", "Fill the Admin's certificate data");
            return false;
        }
        return isCountryCodeValid(countryCode);
    }
}
