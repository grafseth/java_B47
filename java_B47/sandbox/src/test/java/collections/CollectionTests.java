package collections;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class CollectionTests {

    @Test
    public void arrayTests() {
       var array = new String[]{"a","b","c"};
        Assertions.assertEquals(3, array.length);
        array[0] = "a";
       Assertions.assertEquals("a", array[0]);

       array[0] = "d";
        Assertions.assertEquals("d", array[0]);
    }


    @Test
    public void listTests() {
        var list = new ArrayList<String>(List.of("a","b","c"));
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("a", list.get(0));

        list.set(0,"d");
        Assertions.assertEquals("d", list.get(0));
    }
}
