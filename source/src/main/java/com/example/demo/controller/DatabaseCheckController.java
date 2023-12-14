package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class DatabaseCheckController {

    @Autowired
    private DataSource  dataSource; // Injetando o DataSource

    @GetMapping ("/check-database-connection")
    public String checkDatabaseConnection() {
        try {
            Connection  connection = dataSource.getConnection();
            return "Conexão com o banco de dados estabelecida!";
        } catch (SQLException e) {
            return "Erro ao conectar ao banco de dados: " + e.getMessage();
        }
    }
}
