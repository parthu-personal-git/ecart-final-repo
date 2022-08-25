package com.example.shopping.dao;

import com.example.shopping.model.Cart;
//import com.example.shopping.model.User;
import com.example.shopping.requestbodymodels.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findAll();
}
