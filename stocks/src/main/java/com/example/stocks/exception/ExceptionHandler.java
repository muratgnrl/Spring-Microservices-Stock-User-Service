package com.example.stocks.exception;

import com.example.stocks.exception.categoryBaseResponse.CreateCategoryException;
import com.example.stocks.exception.categoryBaseResponse.DeleteCategoryException;
import com.example.stocks.exception.categoryBaseResponse.FindCategoryException;
import com.example.stocks.exception.productBaseException.AddProductException;
import com.example.stocks.exception.productBaseException.DeleteProductException;
import com.example.stocks.exception.productBaseException.FindProductException;
import com.example.stocks.response.CategoryResponse;
import com.example.stocks.response.Meta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> addCategoryException(CreateCategoryException createCategoryException, WebRequest webRequest){

        Meta meta=new Meta();
        CategoryResponse categoryResponse=new CategoryResponse();
        meta.errorCode=4001;
        meta.errorDescription="Başarısız";
        categoryResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(categoryResponse ,HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> findCategory(FindCategoryException findCategoryException, WebRequest webRequest){

        Meta meta=new Meta();
        CategoryResponse categoryResponse=new CategoryResponse();
        meta.errorCode=4002;
        meta.errorDescription="Bulunamadı";
        categoryResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(categoryResponse ,HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> delete(DeleteCategoryException deleteCategoryException, WebRequest webRequest){

        Meta meta=new Meta();
        CategoryResponse categoryResponse=new CategoryResponse();
        meta.errorCode=4003;
        meta.errorDescription="Silinemedi";
        categoryResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(categoryResponse ,HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> productException(AddProductException addProductException, WebRequest webRequest){

        Meta meta=new Meta();
        CategoryResponse categoryResponse=new CategoryResponse();
        meta.errorCode=4006;
        meta.errorDescription="Ürün eklenemedi";
        categoryResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(categoryResponse ,HttpStatus.NOT_FOUND);
        return entity;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> deleteProduct(DeleteProductException deleteProductException, WebRequest webRequest){

        Meta meta=new Meta();
        CategoryResponse categoryResponse=new CategoryResponse();
        meta.errorCode=4054;
        meta.errorDescription="Ürün Silinemedi";
        categoryResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(categoryResponse ,HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> findProduct(FindProductException findProductException, WebRequest webRequest){

        Meta meta=new Meta();
        CategoryResponse categoryResponse=new CategoryResponse();
        meta.errorCode=4007;
        meta.errorDescription="Ürün bulunamadı ";
        categoryResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(categoryResponse ,HttpStatus.NOT_FOUND);
        return entity;
    }
}
