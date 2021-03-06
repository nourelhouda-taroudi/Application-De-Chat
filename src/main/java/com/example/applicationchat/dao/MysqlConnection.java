package com.example.applicationchat.dao;



import java.sql.*;


public class MysqlConnection {
    private static Connection conn;

    public static Connection getConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/applicationchat?autoReconnect=true&useSSL=false", "root", "");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de connexion à la base de donnée");
            return null;
        }
    }
    public String chiffrer(String mot) {
        int k=3;
        int r;
        String resu="";
        for(int i=0;i<mot.length();i++) {
            int a=mot.charAt(i)-97;
            if(a+k<=71) {
                r = a+k+97;
            }else {
                r = a+k-71;
            }
            char c =(char)(r);
            resu+=c;
        }
        return resu;
    }
    public String dechiffrer(String mot) {
        int a;
        int  k=3;
        String resu="";
        for(int i=0;i<mot.length();i++){
            int r=mot.charAt(i);
            if(r-97<=71){
                a=r-k;
            }else{
                a=r-k-26;
            }
            char c =(char)(a);
            resu +=c;
        }
        return resu;
    }


}
