package com.workintech.s18d1.controller;

import com.workintech.s18d1.controller.util.BurgerValidation;
import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/burger")
public class BurgerController {

    private BurgerDao burgerDao;
    @Autowired
    public BurgerController(BurgerDao burgerDao){
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> getBurgers(){
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger getByIdBurger(@PathVariable int id){
        return burgerDao.findById(id);
    }

    @PostMapping
    public Burger saveBurger(@RequestBody Burger burger){
        BurgerValidation.checkName(burger.getName());
        burgerDao.save(burger);
        return burger;
    }

    @PutMapping
    public Burger updateBurger(@RequestBody Burger burger){
        BurgerValidation.checkName(burger.getName());

        burgerDao.update(burger);
        return burger;
    }

    @DeleteMapping("/{id}")
    public void deleteBurger(@PathVariable int id){
        burgerDao.remove(id);
    }

    @GetMapping("/price/{price}")
    public List<Burger> getByPriceBurgers(@PathVariable("price") Integer price){
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> getByBreadTypeBurgers(@PathVariable("breadType") String breadType){
        BreadType breadType1 = BreadType.valueOf(breadType);
        return burgerDao.findByBreadType(breadType1);
    }
    @GetMapping("/content/{content}")
    public List<Burger> getByContentBurgers(@PathVariable("content") String content){
        return burgerDao.findByContent(content);
    }



}
