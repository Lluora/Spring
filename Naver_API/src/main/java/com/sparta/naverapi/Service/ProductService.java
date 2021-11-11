package com.sparta.naverapi.Service;

import com.sparta.naverapi.repository.ProductRepository;
import com.sparta.naverapi.model.Product;
import com.sparta.naverapi.Dto.ProductMypriceRequestDto;
import com.sparta.naverapi.Dto.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;


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


    public List<Product> getProducts()  {
        //ProductRepository productRepository = new ProductRepository(); //중복제거
        return productRepository.findAll(); //멤버 변수 사용
    }

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Product createProduct(ProductRequestDto requestDto)  {
        //ProductRepository productRepository = new ProductRepository(); //중복제거
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto);
        productRepository.save(product);
        return product;
    }

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto)  {
        //ProductRepository productRepository = new ProductRepository(); //중복제거
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

        int myPrice = requestDto.getMyprice();

        product.updateMyPrice(myPrice);
        return product;
    }
}