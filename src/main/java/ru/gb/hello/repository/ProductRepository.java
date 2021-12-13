package ru.gb.hello.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.hello.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductRepository {
    List<Product> products = new ArrayList();

    public Product save(Product product) {
        products.add(product);
        product.setId(products.size() - 1);
        return Product.builder()
                .id(product.getId())
                .title(product.getTitle())
                .cost(product.getCost())
                .build();
    }
    public Product edit(Product product){
        return products.set(product.getId(), product);
    }

    public Optional<Product> findById(int id){
        if(id < products.size()){
            return Optional.ofNullable(products.get(id));
        }else{
            return Optional.empty();
        }
    }

    public Iterable<Product> findAll(){
        return new ArrayList<>(products);
    }

    public long count(){
        return  products.size();
    }

    public void deleteById(Integer id){
        if(id < products.size()){
            products.remove(id.intValue());
        }
    }

}
