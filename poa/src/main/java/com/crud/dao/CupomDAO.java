package com.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crud.model.Cupom;

public class CupomDAO {
    private String url = "jdbc:h2:mem:loja;DB_CLOSE_DELAY=-1"; 
    private String user = "sa";
    private String password = "";

    public CupomDAO() {
        String sql = "CREATE TABLE IF NOT EXISTS cupom (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY, " +
                     "codigo VARCHAR(50), " +
                     "valor_desconto DOUBLE, " +
                     "quantidade_usos INT)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void salvar(Cupom cupom) {
        String sql = "INSERT INTO cupom (codigo, valor_desconto, quantidade_usos) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cupom.getCodigo());
            stmt.setDouble(2, cupom.getValorDesconto());
            stmt.setInt(3, cupom.getQuantidadeUsos());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar cupom: " + e.getMessage());
        }
    }

    public List<Cupom> buscarTodos() {
        List<Cupom> cupons = new ArrayList<>();
        String sql = "SELECT * FROM cupom";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cupom c = new Cupom(
                    rs.getString("codigo"),
                    rs.getDouble("valor_desconto"),
                    rs.getInt("quantidade_usos")
                );
                c.setId(rs.getInt("id"));
                cupons.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cupons: " + e.getMessage());
        }
        return cupons;
    }
}