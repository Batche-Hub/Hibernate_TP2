/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.model.datasource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @author Boule
 */
public class HibernateTP1DataSource {

    private static HibernateTP1DataSource instance;

    private HibernateTP1DataSource() {

    }

    //private Connection getConnectionBis() {
    //  try {
    //    connection = DriverManager.getConnection(url, user, passwd);
    //    } catch (Exception e) {
    //      System.err.println("Un problème de connexion est survenu." + e);
    //}
    //return connection;
    //}
    //Ma méthode Singleton
    public static HibernateTP1DataSource getInstance() throws Exception {
        if (instance == null) {
            instance = new HibernateTP1DataSource();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {

        Connection connection = null;
        try {
            Properties prop = new Properties();

            prop.load(new FileInputStream("C:\\Users\\Boule\\Documents\\NetBeansProjects\\Hibernate_TP1\\src\\fr\\doranco\\bdd\\dbfile.properties"));
            String user = prop.getProperty("user");
            String passwd = prop.getProperty("passwd");
            String url = prop.getProperty("url");
            connection = DriverManager.getConnection(url, user, passwd);

        } catch (Exception e) {
            System.err.println("Impossible de créer une connexion : ");
            System.err.println(e);
        }
        return connection;
    }

}
