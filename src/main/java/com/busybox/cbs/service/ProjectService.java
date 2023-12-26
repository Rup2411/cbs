package com.busybox.cbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProjectService<T, ID> {

	List<T> getAll();
    Optional<T> getById(ID id);
    T create(T entity);
    T update(ID id, T entity);
    void delete(ID id);
    Page<T> findAllPaginated(Pageable pageable);
    List<T> search(String query);
}
