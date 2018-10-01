package mysite.jr.transactions;

import mysite.jr.exceptions.TransactionException;
import mysite.jr.util.UtilConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Transaction extends UtilConnectionPool {

    public static Connection startTransaction() throws TransactionException {
        Connection connection = getConnectionFromConnectionPool();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e2) {
            /*LOGGER.error("Connection->Transaction (Transaction.startTransaction()) exception : Transaction not started -> setAutocommit error!");
            throw new TransactionException(e2.getMessage());*/
        }
        return connection;
    }

    public static void rollback(Exception e, Connection connection) throws TransactionException {
        try {
            connection.rollback();
        } catch (SQLException e1) {
           /* LOGGER.error("Connection->Transaction (Transaction.rollback()) exception : Transaction was not rollback -> rollback error!");
            throw new TransactionException(e1.getMessage());/*
        } finally {
            /*LOGGER.error("Connection->Transaction (Transaction.rollback()) exception : Transaction was rollback -> before commit error!");
            throw new TransactionException(e.getMessage());*/
        }
    }

    public static void commit(Connection connection) throws TransactionException {
        try {
            connection.commit();
        } catch (SQLException e1) {
            /*LOGGER.error("Connection->Transaction (Transaction.commit()) exception : Transaction not committed -> commit error!");
            throw new TransactionException(e1.getMessage());*/
        }
    }

    public static void endTransaction(Connection connection) throws TransactionException {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e2) {
           /* LOGGER.error("Connection->Transaction (Transaction.endTransaction()) exception : Transaction not finished -> setAutocommit error!");
            throw new TransactionException(e2.getMessage());*/
        } finally {
            stopConnection(connection);
        }
    }
}
