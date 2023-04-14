package com.stein.ausbilderportal.category;

import com.stein.ausbilderportal.base.BaseController;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController extends BaseController<Category, CategoryRepository, CategoryService> {
    public CategoryController(CategoryService categoryService) {
        super(categoryService);
    }
}
