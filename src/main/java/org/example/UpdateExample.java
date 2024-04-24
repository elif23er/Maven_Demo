package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExample {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/veritabani_adi";
        String kullaniciadi = "postgres";// postgresql kullanıcı adı
        String sifre = "root"; // postresql default şifresi
        try {
            Connection conn = DriverManager.getConnection(jdbcURL, kullaniciadi, sifre);
            //UPDATE  İŞLEMİ
            String updataSQL = "UPDATE  tablo_adi SET name = ? WHERE  surname=?";
            PreparedStatement updateStatement = conn.prepareStatement(updataSQL);
            updateStatement.setString(1, "Yeni Isim");
            updateStatement.setString(2, "Özdemir");
            int affectedRows = updateStatement.executeUpdate();
            System.out.println("UPDATE  işlemi sonucunda etkilenen satır sayısı : " + affectedRows);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
