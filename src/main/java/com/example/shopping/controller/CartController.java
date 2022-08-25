package com.example.shopping.controller;

import com.example.shopping.dao.CartRepository;
import com.example.shopping.model.Cart;
import com.example.shopping.requestbodymodels.CartItem;
import com.example.shopping.requestbodymodels.CartModel;
import com.example.shopping.service.CartService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shopping/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("")
    public ResponseEntity<CartItem> getCartItems(){
        CartItem cartItem = cartService.getCartItems();
        return new ResponseEntity<>(cartItem, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody  CartModel cartModel){
        Cart cart = cartService.addCart(cartModel);
        return new ResponseEntity<>(cart,HttpStatus.CREATED);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable(value = "id") int id){
        Cart cart =  cartService.getCartById(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable(value = "id") int id, @RequestBody  CartModel cartModel){
        Cart cart = cartService.updateCartObject(id,cartModel);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cart> deleteCart(@PathVariable(value = "id") int id){
        cartService.deleteCart(id);
        return new ResponseEntity<>(new Cart(), HttpStatus.OK);
    }

    //not tested
    @DeleteMapping("/")
    public ResponseEntity<List<Cart>> deleteAllCarts(){
        cartService.deleteAllCartObjects();
        return new ResponseEntity<>(new ArrayList<Cart>(), HttpStatus.OK);
    }


}
