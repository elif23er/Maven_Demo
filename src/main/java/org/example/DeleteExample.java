package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExample {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/veritabani_adi";
        String kullaniciadi = "postgres";// postgresql kullanıcı adı
        String sifre ="root"; // postresql default şifresi
        try {
            Connection conn = DriverManager.getConnection(jdbcURL,kullaniciadi,sifre);
            String deleteSQL = "DELETE FROM tablo_adi WHERE name = ?";
            PreparedStatement deleteStatment=conn.prepareStatement(deleteSQL);
            deleteStatment.setString(1,"Elif");
            int affectedRows =deleteStatment.executeUpdate();
            System.out.println("DELETE  işlemi sonucunda etkilenen satır sayısı : " + affectedRows);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
