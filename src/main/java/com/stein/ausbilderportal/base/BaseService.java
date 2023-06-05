package com.stein.ausbilderportal.base;

import com.stein.ausbilderportal.exception.ApiRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@AllArgsConstructor
public class BaseService<Type extends BaseEntity, UUID, Repo extends JpaRepository<Type, UUID>> {
    protected final Repo repo;

    public Type get(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> {
                    throw new ApiRequestException("ID not found.");
                });
    }

    public List<Type> getAll() {
        return repo.findAll();
    }

//    public void delete(UUID id) {
//        repo.deleteById(id);
//    }
}
