package user.dao;

import user.domain.User;

import java.sql.*;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;

    }

    public void add(User user) throws ClassNotFoundException, SQLException {

        Connection con = connectionMaker.makeConnection();

        PreparedStatement ps = con.prepareStatement("INSERT INTO USERS(ID, NAME, PASSWORD) VALUES(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        con.close();

    }


    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection con = connectionMaker.makeConnection();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE ID = ?");

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();

        rs.next();
        User user = new User();
        user.setId(rs.getString("ID"));
        user.setName(rs.getString("NAME"));
        user.setPassword(rs.getString("PASSWORD"));


        rs.close();
        ps.close();
        con.close();

        return user;
    }

}
