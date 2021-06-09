package io.sys1.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void LambdaTest1() {
		File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isHidden();
			}
		});

		// 줄여서 사용
		// 메서드 참조 기능 활용.
		File[] hiddenFiles1 = new File(".").listFiles(File::isHidden);
	}

	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color) {
			this.weight = weight;
			this.color = color;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		@SuppressWarnings("boxing")
		@Override
		public String toString() {
			return String.format("Apple{color='%s', weight=%d}", color, weight);
		}
	}

	public static boolean isGreenApple (Apple apple) {
		return "green".equals(apple.getColor());
	}

	public static boolean isHeavyApple (Apple apple) {
		return apple.getWeight() > 150;
	}

	@Test
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		return result;
	}

	@Test
	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result1 = new ArrayList<>();
		for(Apple apple : inventory) {
			if(p.test(apple)) {
				result1.add(apple);
			}
		}
		return result1;
	}

	@Test
	public static void applesFunction() {
		List<Apple> inventory = Arrays.asList(
				new Apple(80, "green"),
				new Apple(155, "green"),
				new Apple(120, "red")
		);

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples = filterApples(inventory, TestApplicationTests::isGreenApple);
		System.out.println(greenApples);

		// [Apple{color='green', weight=155}]
		List<Apple> heavyApples = filterApples(inventory, TestApplicationTests::isHeavyApple);
		System.out.println(heavyApples);

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
		System.out.println(greenApples2);

		// [Apple{color='green', weight=155}]
		List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
		System.out.println(heavyApples2);

		// []
		List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
		System.out.println(weirdApples);
	}
}
