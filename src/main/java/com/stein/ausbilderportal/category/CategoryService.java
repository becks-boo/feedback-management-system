package com.stein.ausbilderportal.category;

import com.stein.ausbilderportal.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryService extends BaseService<Category, UUID, CategoryRepository> {
    public CategoryService(CategoryRepository categoryRepository) {
        super(categoryRepository);
    }
}
