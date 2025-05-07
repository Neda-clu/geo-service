import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.netology.entity.Country.RUSSIA;

public class LocalizationTests {
    @ParameterizedTest
    @ValueSource(strings={"127.0.0.1","172.0.32.11","96.44.183.149"})
    void loc_by_ip_test(String a) {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location expected = new Location("Moscow", RUSSIA, "Lenina", 15);
        Location res = geoService.byIp(a);
        Assertions.assertEquals(expected.getCountry(), res.getCountry());
    }

    @Test
    void loc_by_coordinates_test() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        assertThrows(RuntimeException.class, () -> geoService.byCoordinates(56.8, 80));

    }

}
