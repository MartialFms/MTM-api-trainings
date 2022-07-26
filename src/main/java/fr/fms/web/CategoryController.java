package fr.fms.web;

import fr.fms.entities.Category;
import fr.fms.exceptions.RecordNotFoundException;
import fr.fms.service.ImplCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CategoryController {
    @Autowired
    private ImplCategoryService implCategoryService;

    @GetMapping("/categories")
    public List<Category> allCategories(){return implCategoryService.getCategories();}

    @PostMapping("/categories")
    public Category saveCategory(@RequestBody Category t){
        return implCategoryService.saveCategory(t);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable("id")Long id){
        implCategoryService.deleteCategory(id);
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable("id") Long id) {
        return implCategoryService.readCategory(id)
                .orElseThrow(() -> new RecordNotFoundException("Id de categorie " + id + "  n'existe pas"));
    }
}
