package com.sparta.naverapi.Controller;

import com.sparta.naverapi.Service.ProductService;
import com.sparta.naverapi.model.Product;
import com.sparta.naverapi.Dto.ProductMypriceRequestDto;
import com.sparta.naverapi.Dto.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductController {

    // 멤버 변수 선언
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        // 멤버 변수 생성
        this.productService = productService;
    }


    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts() throws SQLException {
        //ProductService productService = new ProductService(); // 중복 삭제
        List<Product> products = productService.getProducts();
        // 응답 보내기
        return products;
    }

    // 신규 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {
        //ProductService productService = new ProductService(); // 중복 삭제
        Product product = productService.createProduct(requestDto);
        // 응답 보내기
        return product;
    }

    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {
        //ProductService productService = new ProductService(); // 중복 삭제
        Product product = productService.updateProduct(id, requestDto);
        return product.getId();
    }
}