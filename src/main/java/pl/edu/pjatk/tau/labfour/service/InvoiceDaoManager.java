package pl.edu.pjatk.tau.labfour.service;

import pl.edu.pjatk.tau.labfour.domain.Invoice;

import java.sql.SQLException;
import java.util.List;

public interface InvoiceDaoManager<T> {
    Invoice get(int id) throws SQLException;

    List<T> getAll();

    Integer create(T t);

    Integer update(T t) throws SQLException;

    void delete(T t);

    void deleteAll();

   //public Connection getConnection();
   //public void setConnection(Connection connection) throws Exception;
}
