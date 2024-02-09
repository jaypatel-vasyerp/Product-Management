package com.jayptl.learningjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayptl.learningjpa.dto.ProductDto;
import com.jayptl.learningjpa.dto.ResponseDto;
import com.jayptl.learningjpa.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseDto getProductById(@PathVariable(name = "id") long id) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(productService.getProductById(id));
        return responseDto;
    }

    @GetMapping("/")
    public ResponseDto getAllProducts() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(productService.getAllProducts());
        return responseDto;
    }

    @PostMapping("/")
    public ResponseDto addNewProduct(@RequestBody ProductDto productDto) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(productService.addNewProduct(productDto));
        return responseDto;
    }

    @GetMapping("/category/{category}")
    public ResponseDto getProductsByCategory(@PathVariable(name = "category") String category) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(productService.getProductsByCategory(category));
        return responseDto;
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteProductById(@PathVariable(name = "id") long id) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(productService.deleteProductById(id));
        return responseDto;
    }

}
