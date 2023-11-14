import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * usuario
 */
public class Usuario {
    public int id;
    public String nome;
    public String email;
    public String senha;

    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void inserirUsuario() {
        try {
            Connection connManager = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:XXXX/XXXX",
                            "root",
                            "");
            System.out.println("Conexão estabelecida!");
            PreparedStatement ps = connManager.prepareStatement("insert into usuario.usuario values (?, ?, ?, ?)");
            ps.setLong(1, 0);
            ps.setString(2, this.nome);
            ps.setString(3, this.email);
            ps.setString(4, this.senha);
            ps.executeUpdate();
            connManager.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void alterarUsuario() {
        try {
            Connection connManager = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:XXXX/XXXX",
                            "root",
                            "");
            System.out.println("Conexão estabelecida!");

            PreparedStatement ps = connManager
                    .prepareStatement("update usuario.usuario set nome = ?, email = ?, senha = ? where id = ?");
            ps.setString(1, this.nome);
            ps.setString(2, this.email);
            ps.setString(3, this.senha);
            ps.setInt(4, this.id);
            ps.executeUpdate();
            connManager.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void excluirUsuario() {
        try {
            Connection connManager = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:XXXX/XXXX",
                            "root",
                            "");
            System.out.println("Conexão estabelecida!");

            PreparedStatement ps = connManager.prepareStatement("delete from usuario.usuario where id = ?");
            ps.setInt(1, this.id);
            ps.executeUpdate();
            connManager.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void buscarUsuario() {
        try {
            Connection connManager = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:XXXX/XXXX",
                            "root",
                            "");
            System.out.println("Conexão estabelecida!");

            PreparedStatement ps = connManager.prepareStatement("select * from usuario.usuario where id = ?");
            ps.setInt(1, this.id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                System.out.println("Nome: " + nome);
                System.out.println("Email: " + email);
                System.out.println("Senha: " + password);
            }
            rs.close();
            connManager.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void validarUsuario() {
        try {
            Connection connManager = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:XXXX/XXXX",
                            "root",
                            "");
            System.out.println("Conexão estabelecida!");

            PreparedStatement ps = connManager.prepareStatement("select * from usuario.usuario where id = ?");
            ps.setInt(1, this.id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString(3);
                String senha = rs.getString(4);
                if (this.email.equals(email) && this.senha.equals(senha)) {
                    System.out.println("Acesso permitido");
                } else
                    System.out.println("Acesso negado");
            }
            rs.close();
            connManager.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}