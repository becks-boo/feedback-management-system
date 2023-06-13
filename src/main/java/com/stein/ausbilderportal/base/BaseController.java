package com.stein.ausbilderportal.base;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@AllArgsConstructor
public class BaseController<Type extends BaseEntity, Repo extends JpaRepository<Type, UUID>,
        Service extends BaseService<Type, UUID, Repo>> {

    protected final Service service;
}
