package com.busybox.cbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.busybox.cbs.dto.response.MemberResponseDto;
import com.busybox.cbs.model.MemberDetails;

@Component
public interface ProjectService<T, ID> {

	List<T> getAll();
    Optional<T> getById(ID id);
    void create(T entity);
    void delete(ID id);
    Page<T> findAllPaginated(Pageable pageable);
    List<T> search(String query);
    T update(ID id, T entity);
}
