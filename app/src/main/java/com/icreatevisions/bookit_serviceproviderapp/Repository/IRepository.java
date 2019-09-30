package com.icreatevisions.bookit_serviceproviderapp.Repository;
import java.util.List;
import io.reactivex.Observable;

public interface IRepository <T, K> {
    Observable<List<T>> get();
    Observable getById(K id);
    Observable create(T entity);
    Observable update(T entity);
    Observable delete(T entity);
}
