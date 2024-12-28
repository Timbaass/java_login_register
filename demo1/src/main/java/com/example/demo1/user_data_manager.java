package com.example.demo1;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class user_data_manager {
    private static final String FILE_NAME = "User.json";  // JSON dosyasının ismi
    private List<User> users;

    public user_data_manager() {
        this.users = new ArrayList<>();
        load_users();  // Uygulama başladığında verileri yükle
    }

    // Kullanıcıyı ekle
    public void add_user(User user) {
        // Yeni kullanıcıyı listeye ekle
        users.add(user);

        // Güncellenmiş kullanıcı listesine kaydet
        save_users();
    }

    // Kullanıcı listesini dosyaya kaydet
    private void save_users() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Dosyadaki mevcut verileri oku
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();  // Eğer dosya yoksa yeni dosya oluştur
            }

            // Dosyayı üzerine yazma (dosya içeriğini koruyarak yeni veriyi ekle)
            objectMapper.writeValue(file, users);  // Bu işlem tüm listeyi günceller
            System.out.println("Kullanıcılar JSON dosyasına kaydedildi.");
        } catch (IOException e) {
            System.err.println("Dosya yazma hatası: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Kullanıcıları JSON dosyasından yükle
    private void load_users() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(FILE_NAME);

        if (file.exists()) {
            try {
                // Dosyadaki kullanıcı verilerini listeye yükle
                users = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
                System.out.println("Mevcut kullanıcılar dosyadan başarıyla yüklendi.");
            } catch (IOException e) {
                System.err.println("Dosya okuma hatası: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Dosya yoksa, boş bir liste ile başla
            System.out.println("Dosya mevcut değil, yeni kullanıcılar için boş liste oluşturuldu.");
            users = new ArrayList<>();
        }
    }

    // Kullanıcıları döndür
    public List<User> getUsers() {
        return users;
    }
}
