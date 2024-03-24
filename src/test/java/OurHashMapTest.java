import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class OurHashMapTest {
    @Test
    public void testSize() {
        OurHashMap<Integer, String> ourHashMap = new OurHashMap<>();
        Assertions.assertEquals(0, ourHashMap.size());
        ourHashMap.put(1, "uno");
        Assertions.assertEquals(1, ourHashMap.size());
    }

    @Test
    public void testPutAndGet() {
        OurHashMap<Integer, String> ourHashMap = new OurHashMap<>();
        ourHashMap.put(1, "uno");
        ourHashMap.put(2, "dos");
        assertEquals("dos", ourHashMap.get(2));
    }
    @Test
    public void testContainsKey() {
        OurHashMap<Integer, String> ourHashMap = new OurHashMap<>(1000000);
        for (int i = 0; i < 1000000; i++) {
            ourHashMap.put(i, "test" + i);
        }
        Assertions.assertTrue(ourHashMap.containsKey(11234));
    }
    @Test
    public void testContainsValue() {
        OurHashMap<Integer, String> ourHashMap = new OurHashMap<>(1000000);
        for (int i = 0; i < 1000000; i++) {
            ourHashMap.put(i, "test" + i);
        }
        Assertions.assertTrue(ourHashMap.containsValue("test234"));
    }
    @Test
    public void testRemove() {
        OurHashMap<Integer, String> ourHashMap = new OurHashMap<>(1000000);
        for (int i = 0; i < 1000000; i++) {
            ourHashMap.put(i, "test" + i);
        }
        Assertions.assertTrue(ourHashMap.containsValue("test1000"));
        ourHashMap.remove(1000);
        Assertions.assertFalse(ourHashMap.containsValue("test1000"));
    }
    @Test
    public void testClear() {
        OurHashMap<Integer, String> ourHashMap = new OurHashMap<>(1000000);
        for (int i = 0; i < 1000000; i++) {
            ourHashMap.put(i, "test" + i);
        }
        ourHashMap.clear();
        Assertions.assertTrue(ourHashMap.isEmpty());
    }
}
