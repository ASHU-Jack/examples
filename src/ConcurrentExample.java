import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new ConcurrentHashMap();
		 map.put("Value1", 11);
		 map.put("Value2", 22);
		 map.put("Value3", 33);
		 map.put("Value4", 44);
		 map.put("Value5", 55);
		 map.put("Value6", 66);
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> itr = entrySet.iterator();
		
		map.put("Value7", 77);
		while (itr.hasNext()) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) itr.next();
			System.out.println("Key is: "+entry.getKey() + " & " + " value is: "+entry.getValue());
		}
		
	}
}
