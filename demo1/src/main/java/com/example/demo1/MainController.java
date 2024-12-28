package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class MainController {

    @FXML
    private Button logoutButton;

    @FXML
    private ImageView moviePoster1, moviePoster2;

    // Book Now butonlarına tıklama işlemleri
    @FXML
    private void handleBooking(String movieName) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rezervasyon Onayı");
        alert.setHeaderText(null);
        alert.setContentText(movieName + " filmi için rezervasyonunuz onaylanmıştır.");
        alert.showAndWait();
    }

    // Logout işlemi
    @FXML
    private void handleLogout() {
        try {
            // Login ekranına yönlendirme
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        // Film posterlerini yükleme ve diğer başlangıç işlemleri buraya gelebilir
        try {
            // Örnek: Film posterlerini dinamik olarak yükleme
            // moviePoster1.setImage(new Image(getClass().getResourceAsStream("/images/movie1.jpg")));
            // moviePoster2.setImage(new Image(getClass().getResourceAsStream("/images/movie2.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}