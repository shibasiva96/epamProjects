package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class Interview {

	@Test
	public void duplicate() {
		List<String> hi = new ArrayList<String>();

		List<String> list = new ArrayList<String>(Arrays.asList("Siva", "Siva", "prashant"));
		//List<String> list1 = list.stream().distinct().toList();
		//System.out.println(list1);
		System.out.println(list.stream().distinct().count());

		Set<String> distinct = new HashSet<>(list);
		System.out.println("Set"+distinct);
		distinct.stream().forEach(s -> System.out.println(s + " " + Collections.frequency(list, s)));
		
		System.out.println("frequency with list");
		list.stream().forEach(s->System.out.println(s+" "+Collections.frequency(list, s)));
		
		 Map<String, Long> result
         = list.stream().collect(
             Collectors.groupingBy(
                 Function.identity(),
                 Collectors.counting()));

     // Print the result
     System.out.println(result);

	}
	@Test
	public void occurence() {
		String str="communication";
		Map<String, Long> result
        = Arrays.stream(str.split("")).collect(
            Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()));

    // Print the result
    System.out.println(result);
		
		/*Map<String,Integer> map=Arrays.stream(str.split("")).
				map(s->s.toLowerCase()).
				collect(Collectors.groupingBy(s->s, Collectors.counting());
		Set<String> distinct = new HashSet<>(list);
		distinct.stream().forEach(s -> System.out.println(s + " " + Collections.frequency(list, s)));*/
    
    List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);
    
    // Using stream.min() to get minimum
    // element according to provided Integer Comparator
    Integer var = list.stream().min(Integer::compare).get();
    System.out.println(var);

	}
	@Test
	public void removeDuplicate() {
		String str="sivasankari";
		List<String> result
        = Arrays.stream(str.split("")).distinct().collect(Collectors.toList());
		

    // Print the result
  //  System.out.println((result.toString().replace(',',' ').replace('[', '').replace(']','')));
		
		/*Map<String,Integer> map=Arrays.stream(str.split("")).
				map(s->s.toLowerCase()).
				collect(Collectors.groupingBy(s->s, Collectors.counting());
		Set<String> distinct = new HashSet<>(list);
		distinct.stream().forEach(s -> System.out.println(s + " " + Collections.frequency(list, s)));*/
    
	}
	@Test
	public void hello() {
		String str = "hello";
		String vowel = "";
		char[] strArray = str.toCharArray();
		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isVowel(strArray[i])) {
				j++;
				vowel = vowel + strArray[i];
			}

		}
		System.out.println(vowel);
		System.out.println(strArray.length);
		for (int i = 0; i < strArray.length; i++) {
			if (isVowel(str.charAt(i))) {
				strArray[i] = vowel.charAt(--j);
			}
		}
		System.out.println(String.valueOf(strArray));
	}

	static boolean isVowel(char c) {
		return (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
				|| c == 'U');
	}

}
