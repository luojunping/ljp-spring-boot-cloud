package com.ljp.test;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class JdbcTest {

    @Test
    public void testDriver() throws ClassNotFoundException, SQLException {
        // Class.forName("com.mysql.jdbc.Driver");
        Driver.class.getClass();
        // new Driver();
        List<String> list = List.class.cast(new Object());
    }

}
