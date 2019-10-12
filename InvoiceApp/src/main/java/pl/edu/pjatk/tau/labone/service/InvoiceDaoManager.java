package pl.edu.pjatk.tau.labone.service;

import pl.edu.pjatk.tau.labone.domain.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceDaoManager<T> {
    Invoice get(int id);

    List<T> getAll();

    void create(T t);

    void update(T t, int id);

    void delete(T t);
}
