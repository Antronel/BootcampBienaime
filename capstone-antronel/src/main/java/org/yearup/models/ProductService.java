package org.yearup.models;

import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.util.Set;

public class ProductService {
    public Set<ModuleReference> findAll() {
        ModuleFinder productRepository = null;
        return productRepository.findAll(); // ← Might return empty list or throw error
}

}
