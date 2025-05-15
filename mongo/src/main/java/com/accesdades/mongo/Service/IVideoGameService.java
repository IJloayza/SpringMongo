package com.accesdades.mongo.Service;

import java.util.List;
import java.util.Optional;

public interface IBotigaService<S> {
    List<S> findAll();
    Optional<S> finById(Long id);
    S save(S entity);
    void deleteById(Long id);
}
