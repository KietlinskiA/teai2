package pl.kietlinski.teai2.Service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Data
@Service
@Profile("Plus")
public class ShopPlusService extends ShopStartService implements ShopVariant{

    @Value("${vatValue}")
    private double vatValue;

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Cena produktów bez VAT: "+super.getSumPrices()*(1-vatValue));
    }
}
