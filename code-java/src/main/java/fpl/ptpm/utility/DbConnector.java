/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpl.ptpm.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author phongtt
 */
public final class DbConnector {
    
    private String username = "sa";
    private String password = "123456";
    private String serverName = "localhost";
    private String port = "1433";
    private String databaseName = "";
    private boolean usingSsl = false;
    
    private String CONNECT_STRING;
    
    public static final int OK = 0;
    public static final int NOT_COMPATIBLE = 1;
    public static final int CANNOT_CONNECT = 2;
    public static final int SSL_ERROR = 3;
    public static final int TCP_ERROR = 4;
    public static final int AUTHEN_ERROR = 5;
    public static final int SERVERNAME_ERROR = 6;
    
    public int build() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            StringBuilder connectStringBuilder = new StringBuilder();
            connectStringBuilder.append("jdbc:sqlserver://")
                    .append(serverName).append(":").append(port).append(";")
                    .append("databaseName=").append(databaseName).append(";")
                    .append("user=").append(username).append(";")
                    .append("password=").append(password).append(";")
                    ;
            if (usingSsl) {
                connectStringBuilder.append("encrypt=true;trustServerCertificate=true;");
            }
            CONNECT_STRING = connectStringBuilder.toString();
            getConnection();
            return OK;
        } catch (ClassNotFoundException ex) {
            return NOT_COMPATIBLE;
        } catch (SQLException ex) {
            String message = ex.getMessage();
            System.out.println(message);
            if (message.contains("Connection refused")) {
                return TCP_ERROR;
            } else if (message.contains("Secure Sockets Layer (SSL)")) {
                return SSL_ERROR;
            }else if (message.contains("Login failed")) {
                return AUTHEN_ERROR;
            }else if (message.contains("No such host is known")) {
                return SERVERNAME_ERROR;
            } else {
                return CANNOT_CONNECT;
            }
        }
    }
    
    public synchronized Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECT_STRING);
    }

    public String getConnectString() {
        return CONNECT_STRING;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public boolean isUsingSsl() {
        return usingSsl;
    }

    public void setUsingSsl(boolean usingSsl) {
        this.usingSsl = usingSsl;
    }
    
    
}