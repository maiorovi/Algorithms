package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClasspathResourceReader {
	public static void main(String[] args) throws IOException {
		System.out.println(Arrays.stream(new ClasspathResourceReader().readFile("quicksort.txt"))
				.map(i -> i.toString())
				.collect(Collectors.joining("\n")));

	}

	public Integer[] readFile(String fileName) {
		Integer[] arr = null;

		try {
			arr = Files.lines(Paths.get(this.getClass().getClassLoader().getResource(fileName).getPath().substring(1)))
					.map(l -> Integer.valueOf(l))
					.toArray(size -> new Integer[size]);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return arr;
	}

	public List<String> readFileAsString(String fileName) {
		List<String> file = null;
		try {
			 file = Files.readAllLines(Paths.get(this.getClass().getClassLoader().getResource(fileName).getPath().substring(1)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}
}
