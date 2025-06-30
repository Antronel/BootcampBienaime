package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryController
{
    private final CategoryDao categoryDao;

    @Autowired
    public CategoryController(CategoryDao categoryDao)
    {
        this.categoryDao = categoryDao;
    }

    // GET all categories
    @GetMapping
    public List<Category> getAllCategories()
    {
        return categoryDao.getAllCategories();
    }

    // GET a single category by ID
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id)
    {
        return categoryDao.getById(id);
    }

    // POST a new category
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category)
    {
        return categoryDao.create(category);
    }

    // PUT (update) an existing category
    @PutMapping("/{id}")
    public void updateCategory(@PathVariable int id, @RequestBody Category category)
    {
        categoryDao.update(id, category);
    }

    // DELETE a category by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id)
    {
        categoryDao.delete(id);
    }
}

