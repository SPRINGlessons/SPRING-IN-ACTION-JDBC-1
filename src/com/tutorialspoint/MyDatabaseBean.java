package com.tutorialspoint;


import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class MyDatabaseBean implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;
    //private SimpleJdbcTemplate jdbcTemplate;

    //private static final String SQL_INSERT_SPITTER ="SET search_path=public";

    final static char dm = (char) 34;
    private static final String query = "INSERT INTO public." + dm + "Test" + dm + " (name) VALUES (?)";
    private static final String selectQuery = "select * from public." + dm + "Test" + dm + " where id = ?";

    Object[] args = new Object[]{"Юляшенька Панферова в черненьких чулочках"};

    private DataSource dataSource;
    private User user;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void setDataSource(DataSource dataSource) {
        //this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }


    @Override
    public void add() {

        //     Connection conn = null;
        //     PreparedStatement stmt = null;

        //      try {

        //         conn = dataSource.getConnection(); // Получить соединение
//
        //          if (conn != null) {
        //              System.out.println("You made it, take control your database now!");
        //          }

        //         stmt = conn.prepareStatement(SQL_INSERT_SPITTER); // Создать запрос
        //          stmt.setString(1, "Юляшенька Панферова"); // Связать параметры
        // stmt.setString(2, spitter.getPassword());
        //stmt.setString(3, spitter.getFullName());
        //         stmt.execute(); // Выполнить запрос


        jdbcTemplate.update(query, args);


        //     } catch (SQLException e) {
        //          e.printStackTrace();
        //    } finally {
        //         try {
        //             if (stmt != null) { // Освободить ресурсы
        //                 stmt.close();
        //            }
        //              if (conn != null) {
        //                 conn.close();
        //             }
        //           } catch (SQLException e) {
// Я еще менее уверен, что тут можно сделать
        //         }


        //       }

    }

    public User getSpitterById(long id) {
        return jdbcTemplate.queryForObject(selectQuery, User.class);

        /*




                selectQuery, new ParameterizedRowMapper<User>() {
                    public User mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        User user = new User();
                        user.setId(rs.getLong(1));
                        user.setName(rs.getString(2)); // в объект
                        return user;
                    }
                },
               id // Связывание параметров

               */
        //);
    }


}
