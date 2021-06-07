package pl.kietlinski.teai2.Service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.kietlinski.teai2.Model.Product;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service
public class ShopService {

    private Logger logger;
    private List<Product> productList;
    private int sumPrices;

    public ShopService() {
        logger = LoggerFactory.getLogger(ShopService.class);
        productList = new ArrayList<>();
        init();
        getSumPricesValue();
    }

    private void init() {
        Product product1 = new Product("Banany", 4);
        Product product2 = new Product("Jabłko", 2);
        Product product3 = new Product("Arbuzy", 1);
        Product product4 = new Product("Melony", 8);
        Product product5 = new Product("Jagody", 6);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        if (productList.isEmpty()) {
            logger.error("Prepare data was not created");
        } else {
            logger.info("Prepare data was created");
        }
    }

    protected void getProductListForeach() {
        productList.forEach(System.out::println);
    }

    protected void getSumPricesValue() {
        for(Product product : productList){
            sumPrices += product.getPrice();
        }
        logger.info("Sum of prices was counted");
    }

}
