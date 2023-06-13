package com.stein.ausbilderportal.category;

import com.stein.ausbilderportal.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class CategoryController extends BaseController<Category, CategoryRepository, CategoryService> {
    public CategoryController(CategoryService categoryService) {
        super(categoryService);
    }

    @GetMapping("/categories/")
    public String listCategory(Model model) {
        model.addAttribute("categories", service.getAll());

        return "categories";
    }

    @GetMapping("/categories/new/")
    public String createCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);

        return "create_category";
    }

    @PostMapping("/categories/")
    public String addCategory(@ModelAttribute("category") Category category) {
        service.postCategory(category);

        return "redirect:/categories/";
    }

    @PutMapping("/categories/{id}")
    public String editCategoryForm(@PathVariable UUID id, Model model) {
        model.addAttribute("category", service.get(id));

        return "edit_category";
    }

    @PostMapping("/categories/{id}")
    public String editCategory(@PathVariable UUID id, @ModelAttribute("category") Category category) {
        Category existingCategory = service.get(id);
        existingCategory.setName(category.getName());

        service.updateCategory(existingCategory);

        return "redirect:/categories/";
    }

    @DeleteMapping("/categories/{id}")
    public String deleteApprentice(@PathVariable UUID id) {
        service.deleteCategoryById(id);

        return "redirect:/categories/";
    }
}
