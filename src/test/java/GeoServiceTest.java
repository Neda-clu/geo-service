
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest extends GeoServiceImpl {

    @Test
    void byIp_test(){
        String example_ip="96.44.183.149";
        Location expected=new Location("New York", Country.USA, " 10th Avenue", 32);
        Location actual=byIp(example_ip);
        String expected_list[]={expected.getCity(),expected.getStreet()};
        String actual_list[]={actual.getCity(),actual.getStreet()};
        Assertions.assertArrayEquals(expected_list,actual_list);
    }
}
