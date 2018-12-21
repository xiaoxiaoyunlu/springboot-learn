package oz.mano.online.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ch.qos.logback.core.joran.conditional.IfAction;

/**
 * https://blog.csdn.net/hgc0907/article/details/80756730
 * @author USER
 *
 */

public class TestJava8List {

	public static void main(String[] args) {
//		List<String> asList = Arrays.asList("a","b","c","d");
//		List<String> collect = asList.stream().map(String::toUpperCase).collect(Collectors.toList());
//		
//		System.out.println(asList);
//		
//		System.out.println(collect);
		testJDK8ForEach();
	}
	
	public static void testJDK8ForEach(){
		List<String> asList = Arrays.asList("a","b","a","d");
		int i=0;
		//1 
		for(String s:asList){
			if(s.equals("a")){
				++i;
			}
		}
		//2
		asList.forEach(s -> {
			if(s.equals("a")){
				++i;  // 提示 final 或者 final 实际效果
			}
		});
		System.out.println(i);
		//3
		long count = asList.stream().filter(s -> s.equalsIgnoreCase("a")).count();
		System.out.println(count);
	}
	
	

}
