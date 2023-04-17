package com.stein.ausbilderportal.category;

import com.stein.ausbilderportal.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

        // TODO: Change path
        return "redirect:/categories/";
    }

    @GetMapping("/categories/edit/{id}")
    public String editCategoryForm(@PathVariable UUID id, Model model) {
        model.addAttribute("category", service.get(id));

        return "edit_category";
    }

    public String editCategory(@PathVariable UUID id, @ModelAttribute("category") Category category) {
        Category existingCategory = service.get(id);

        service.updateCategory(existingCategory);

        return "redirect:/categories/";
    }
}
