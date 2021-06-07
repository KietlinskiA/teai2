package pl.kietlinski.teai2.Service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Data
@Service
@Profile("Pro")
public class ShopProService extends ShopPlusService implements ShopVariant{

    @Value("${discountValue}")
    private double discountValue;

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Cena produktów z rabatem 10%: "+super.getSumPrices()*(1-super.getVatValue())*(1-discountValue));
    }
}
