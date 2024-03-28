package br.com.nicolasmelos.loja_varejo.controller;

import br.com.nicolasmelos.loja_varejo.dto.ProductDto;
import br.com.nicolasmelos.loja_varejo.model.Product;
import br.com.nicolasmelos.loja_varejo.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity<ProductDto> insert(@RequestBody ProductDto productDto){
        var productModel = new Product();
        BeanUtils.copyProperties(productDto,productModel);
        productModel = productService.insert(productModel);
        return new ResponseEntity<>(convertToDto(productModel), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProductDto> findAll(){
        return productService.findAll().stream().map(
                model -> convertToDto(model)
        ).collect(Collectors.toList());
    }

    private static ProductDto convertToDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getProvider(),
                product.getCost()
        );
    }
}
