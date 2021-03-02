import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> result = new ArrayList<>();
		HashMap<Integer, Integer> frequencies = new HashMap<>();

		for (List<Integer> query : queries) {
			Integer operation = query.get(0);
			Integer value = query.get(1);

			switch (operation) {
				case 1 -> addOrIncreaseFrequency(frequencies, value);
				case 2 -> decreaseFrequency(frequencies, value);
				case 3 -> checkFrequency(result, frequencies, value);
			}
		}

		return result;
	}

	private static void addOrIncreaseFrequency(HashMap<Integer, Integer> frequencies, Integer value) {
		frequencies.put(value, frequencies.getOrDefault(value, 0) + 1);
	}
	
	private static void decreaseFrequency(HashMap<Integer, Integer> frequencies, Integer value) {
		if (frequencies.containsKey(value)) {
			Integer valueFrequency = frequencies.get(value);
			frequencies.put(value, --valueFrequency);
		}
	}
		
	private static void checkFrequency(List<Integer> result, HashMap<Integer, Integer> frequencies, Integer value) {
		if (frequencies.values().stream().anyMatch(x -> x.equals(value))) {
			result.add(1);
		} else {
			result.add(0);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(
						Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
								.map(Integer::parseInt)
								.collect(toList())
				);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> ans = freqQuery(queries);

		bufferedWriter.write(
				ans.stream()
						.map(Object::toString)
						.collect(joining("\n"))
						+ "\n"
		);

		bufferedReader.close();
		bufferedWriter.close();
	}
}