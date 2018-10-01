package mysite.jr.exceptions;

import java.sql.SQLException;

public class ConnectionException extends Throwable {
    public ConnectionException(SQLException e) {
    }
}
