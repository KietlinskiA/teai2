package pl.kietlinski.teai2.Service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("Start")
public class ShopStartService extends ShopService implements ShopVariant{
    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void getInfo() {
        super.getProductListForeach();
        System.out.println("Cena produktów: "+super.getSumPrices());
    }
}
