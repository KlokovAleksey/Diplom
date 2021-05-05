package ru.netology.data;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

    static String url = System.getProperty("url");
    static String user = "app";
    static String password = "pass";


    public static void cleanDataBase() {

        val cleanCredit = "DELETE FROM credit_request_entity";
        val cleanOrder = "DELETE FROM order_entity";
        val cleanPayment = "DELETE FROM payment_entity";
        val runner = new QueryRunner();

        try (
                val conn = DriverManager.getConnection(
                        url, user, password)
        ) {
            runner.update(conn, cleanOrder);
            runner.update(conn, cleanCredit);
            runner.update(conn, cleanPayment);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String getStatus(String codeSql) {

        String data = "";
        val runner = new QueryRunner();

        try (
                val conn = DriverManager.getConnection(url, user, password)) {
            data = runner.query(conn, codeSql, new ScalarHandler<>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static String getPaymentStatus(){
        val codeSql = "SELECT status FROM payment_entity;";
        return getStatus(codeSql);
    }

    public static String getCreditStatus(){
        val codeSql = "SELECT status FROM credit_request_entity;";
        return getStatus(codeSql);
    }


}
