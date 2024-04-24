import java.sql.*;

public class InsertAndSelect {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/veritabani_adi";
        String kullaniciadi = "postgres"; // kullanici adi
        String sifre = "root"; // postgrsql standart db sifresi

        // veritabanınnı bağlantı oluşturma
        try {
            Connection conn = DriverManager.getConnection(jdbcURL, kullaniciadi, sifre);
    //   String createSQL = "CREATE TABLE public.tablo_adi\n" +
              // "(\n" +
//               "    name character varying(255),\n" +
//               "    surname character varying(255)\n" +
//               ");";
           // PreparedStatement createStatment =conn.prepareStatement(createSQL);
           // createStatment.executeQuery();

            // INSERT ISLEMI
            String insertSQL ="INSERT INTO public.tablo_adi(\n" +
                    "\tname , surname)\n" +
                    "\tVALUES (? , ?);";
            PreparedStatement insertStatement =conn.prepareStatement(insertSQL);
            insertStatement.setString(1,"Büşra");
            insertStatement.setString(2,"Özdemir");
//            int affectedRows =insertStatement.executeUpdate();
//            System.out.println("INSERT işlemi sonucunda etkilenen satır sayisi : " + affectedRows);

            //SELECT ISLEMİ
            String selectSQL ="SELECT * FROM tablo_adi";
            PreparedStatement selectStatment =conn.prepareStatement(selectSQL);
            ResultSet resultSet = selectStatment.executeQuery();
            while (resultSet.next()){
                String sutun1Degeri = resultSet.getString("name");
                String sutun2Degeri = resultSet.getString("surname");
                System.out.println("Name : " + sutun1Degeri + "\nSurname : " + sutun2Degeri + "\n");
            }
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}