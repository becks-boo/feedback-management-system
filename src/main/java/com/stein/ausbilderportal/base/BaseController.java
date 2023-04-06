package com.stein.ausbilderportal.base;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@AllArgsConstructor
public class BaseController<Type extends BaseEntity, Repo extends JpaRepository<Type, UUID>,
        Service extends BaseService<Type, UUID, Repo>> {
    protected final Service service;

    @GetMapping("/{id}")
    protected Type onGet(@PathVariable(value = "id") UUID id) {
        return service.get(id);
    }
}
