package pl.edu.pjatk.tau.labone.service;

import pl.edu.pjatk.tau.labone.domain.Invoice;

import java.util.List;

public interface InvoiceDaoManager<T> {
    Invoice get(int id);

    List<T> getAll();

    Integer create(T t);

    Integer update(T t, int id);

    void delete(T t);

    void deleteAll();

  //  public Connection getConnection();
  //  public void setConnection(Connection connection) throws Exception;
}
