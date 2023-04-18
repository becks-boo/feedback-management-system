package com.stein.ausbilderportal.category;

import com.stein.ausbilderportal.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryService extends BaseService<Category, UUID, CategoryRepository> {
    public CategoryService(CategoryRepository categoryRepository) {
        super(categoryRepository);
    }

    public void postCategory(String name) {
        repo.save(new Category(name));
    }

    public void postCategory(Category category) {
        this.postCategory(category.getName());
    }

    public void updateCategory(Category category) {
        repo.save(category);
    }
}
