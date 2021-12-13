package ru.gb.hello.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.hello.entity.Product;
import ru.gb.hello.service.ProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

        private final ProductService productService;

        @GetMapping("/create")
        public String showSimpleForm(Model model){
            Product product = new Product();
            model.addAttribute("product", product);
            return "create-product";
        }

        @PostMapping("/create")
        public String processForm(Product product){
            if(product.getId() == 0){
                productService.save(product);
            } else{
                productService.edit(product);
            }
            return "redirect:/product/all";
        }

        @GetMapping("/{id}")
        public String getProductById(Model model,
                                     @PathVariable Integer id){
                Product product = productService.findById(id);
            model.addAttribute("product", product);
            return "product";
        }

        @GetMapping("/all")
        public String getAllProduct(Model model){
            model.addAttribute("products", productService.findAll());
            return "product-list";
        }

        @GetMapping("/delete")
        public String deleteById(@RequestParam Integer id){
            productService.deleteById(id);
            return "redirect:/product/all";
        }

        @GetMapping("/edit")
        public String editById(Model model, @RequestParam Integer id){
            Product product = productService.findById(id);
            model.addAttribute("product", product);
            return "create-product";
        }

}
