package com.sparta.naverapi.Service;

import com.sparta.naverapi.Domain.ProductRepository;
import com.sparta.naverapi.Domain.Product;
import com.sparta.naverapi.Dto.ProductMypriceRequestDto;
import com.sparta.naverapi.Dto.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    // 멤버 변수 선언
    private final ProductRepository productRepository;

    // 생성자: ProductService() 가 생성될 때 호출됨
    @Autowired
    public ProductService(ProductRepository productRepository) {
        // 멤버 변수 생성
        this.productRepository = productRepository;
    }


    public List<Product> getProducts() throws SQLException {
        //ProductRepository productRepository = new ProductRepository(); //중복제거
        return productRepository.getProducts();
    }

    public Product createProduct(ProductRequestDto requestDto) throws SQLException {
        //ProductRepository productRepository = new ProductRepository(); //중복제거
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto);
        productRepository.createProduct(product);
        return product;
    }

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
        //ProductRepository productRepository = new ProductRepository(); //중복제거
        Product product = productRepository.getProduct(id);
        if (product == null) {
            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
        }
        int myPrice = requestDto.getMyprice();
        productRepository.updateProductMyPrice(id, myPrice);
        return product;
    }
}