import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.Map;
import java.util.TreeMap;


import static org.mockito.ArgumentMatchers.anyString;
import static ru.netology.entity.Country.RUSSIA;

public class MessageSenderTest {
    @Test
    void send_test_rus(){
        GeoServiceImpl geoService= Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(anyString()))
                .thenReturn(new Location("Moscow", RUSSIA, "Lenina", 15));
        LocalizationServiceImpl localizationService=Mockito.mock(LocalizationServiceImpl.class);


        MessageSenderImpl messageSender=new MessageSenderImpl(geoService,localizationService);
        Map<String,String> testmap=new TreeMap<>();
        testmap.put("x-real-ip","172.0.32.11");
        messageSender.send(testmap);
    }
    
    @Test
    void send_test_eng(){
        GeoServiceImpl geoService= Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(anyString()))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        LocalizationServiceImpl localizationService=Mockito.mock(LocalizationServiceImpl.class);
        
        MessageSenderImpl messageSender=new MessageSenderImpl(geoService,localizationService);
        Map<String,String> testmap=new TreeMap<>();
        testmap.put("x-real-ip","96.44.183.149");
        messageSender.send(testmap);
    }

}
