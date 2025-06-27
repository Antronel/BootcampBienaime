package org.yearup.models;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.controllers.CategoriesController;
import org.yearup.data.CategoryDao;

import java.util.List;

public class CategoriesControllerImpl extends CategoriesController {@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoriesController {

    private CategoryDao categoryDao;

    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    // GET all categories
    @GetMapping("")
    public List<Category> getAll() {
        return categoryDao.getAllCategories();
    }

    // GET category by ID
    @GetMapping("/{id}")
    public Category getById(@PathVariable int id) {
        return categoryDao.getById(id);
    }

    // POST create new category (Admin only)
    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public Category addCategory(@RequestBody Category category) {
        return categoryDao.create(category);
    }

    // PUT update category (Admin only)
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        categoryDao.update(id, category);
    }

    // DELETE category (Admin only)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCategory(@PathVariable int id) {
        categoryDao.delete(id);
    }
}
    public CategoriesControllerImpl(CategoryDao categoryDao) {
        super(categoryDao);
    }
}
