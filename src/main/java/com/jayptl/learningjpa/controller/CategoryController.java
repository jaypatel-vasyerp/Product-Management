package com.jayptl.learningjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayptl.learningjpa.dto.ResponseDto;
import com.jayptl.learningjpa.model.Category;
import com.jayptl.learningjpa.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseDto getAllCategory() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(categoryService.getAllCategory());
        return responseDto;
    }

    @GetMapping("/{id}")
    public ResponseDto getCategoryById(@PathVariable(name = "id") long id) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(categoryService.getCategoryById(id));
        return responseDto;
    }

    @PostMapping("/")
    public ResponseDto addNewCategory(@RequestBody Category category) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(categoryService.addCategory(category));
        return responseDto;
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteCategoryById(@PathVariable(name = "id") long id) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(categoryService.deleteCategoryById(id));
        return responseDto;
    }

}
