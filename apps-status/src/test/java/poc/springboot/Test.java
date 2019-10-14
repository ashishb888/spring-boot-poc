package poc.springboot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("hdpdev1|t1,stopped^t2,stopped^t3,stopped^t4,stopped^t5,stopped");
		list.add("hdpdev6|t1,running^t2,stopped^t3,stopped^t4,stopped^t5,stopped");

		Map<String, String> f = list.stream().map(e -> e.split("\\|")).collect(Collectors.toMap(e -> e[0], e -> e[1]));
		System.out.println("f: " + f);

		Map<String, Map<Object, Object>> m2 = list.stream().map(e -> e.split("\\|"))
				.collect(Collectors.toMap(e -> e[0], e -> Arrays.stream(e[1].split("\\^")).map(d -> d.split("\\,"))
						.collect(Collectors.toMap(r -> r[0], r -> r[1]))));

		System.out.println("m2: " + m2);

		Map<String, Map<String, String>> fMap = new HashMap<String, Map<String, String>>();

		f.entrySet().stream().forEach(e -> {
			Map<Object, Object> m1 = Arrays.stream(e.getValue().split("\\^")).map(d -> d.split("\\,"))
					.collect(Collectors.toMap(r -> r[0], r -> r[1]));

			System.out.println("m1: " + m1);
			// .collect(Collectors.toMap(r->r[], valueMapper))
			// fMap.put(e.getKey(), value)
		});

		System.out.println("fMap: " + fMap);
	}

}
