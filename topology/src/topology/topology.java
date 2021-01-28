package topology;

/**
 * 
 * @author shelbyferrier
 * A class containing a method which converts a list of similarly structured topologies
 * into LaTeX friendly input.
 * Rather, a work around to having to type 33 different topologies
 * into LaTeX
 */
public class topology {
	public static String after = "";
	/*
	 * the below is sourced from wikipedia 
	 * https://en.wikipedia.org/wiki/Finite_topological_space
	 */
	public static String before = "1. {∅, {a, b, c, d}}\n" + 
			"2. {∅, {a, b, c}, {a, b, c, d}}\n" + 
			"3. {∅, {a}, {a, b, c, d}}\n" + 
			"4. {∅, {a}, {a, b, c}, {a, b, c, d}}\n" + 
			"5. {∅, {a, b}, {a, b, c, d}}\n" + 
			"6. {∅, {a, b}, {a, b, c}, {a, b, c, d}}\n" + 
			"7. {∅, {a}, {a, b}, {a, b, c, d}}\n" + 
			"8. {∅, {a}, {b}, {a, b}, {a, b, c, d}}\n" + 
			"9. {∅, {a, b, c}, {d}, {a, b, c, d}}\n" + 
			"10. {∅, {a}, {a, b, c}, {a, d}, {a, b, c, d}}\n" + 
			"11. {∅, {a}, {a, b, c}, {d}, {a, d}, {a, b, c, d}}\n" + 
			"12. {∅, {a}, {b, c}, {a, b, c}, {a, d}, {a, b, c, d}}\n" + 
			"13. {∅, {a, b}, {a, b, c}, {a, b, d}, {a, b, c, d}}\n" + 
			"14. {∅, {a, b}, {c}, {a, b, c}, {a, b, c, d}}\n" + 
			"15. {∅, {a, b}, {c}, {a, b, c}, {a, b, d}, {a, b, c, d}}\n" + 
			"16. {∅, {a, b}, {c}, {a, b, c}, {d}, {a, b, d}, {c, d}, {a, b, c, d}}\n" + 
			"17. {∅, {b, c}, {a, d}, {a, b, c, d}}\n" + 
			"18. {∅, {a}, {a, b}, {a, b, c}, {a, b, d}, {a, b, c, d}} \n" + 
			"19. {∅, {a}, {a, b}, {a, c}, {a, b, c}, {a, b, c, d}} \n" + 
			"20. {∅, {a}, {b}, {a, b}, {a, c}, {a, b, c}, {a, b, c, d}} \n" + 
			"21. {∅, {a}, {a, b}, {a, b, c}, {a, b, c, d}} \n" + 
			"22. {∅, {a}, {b}, {a, b}, {a, b, c}, {a, b, c, d}} \n" + 
			"23. {∅, {a}, {a, b}, {c}, {a, c}, {a, b, c}, {a, b, d}, {a, b, c, d}} \n" + 
			"24. {∅, {a}, {a, b}, {a, c}, {a, b, c}, {a, b, d}, {a, b, c, d}} \n" + 
			"25. {∅, {a}, {b}, {a, b}, {a, b, c}, {a, b, d}, {a, b, c, d}} \n" + 
			"26. {∅, {a}, {b}, {a, b}, {a, c}, {a, b, c}, {a, b, d}, {a, b, c, d}} \n" + 
			"27. {∅, {a}, {b}, {a, b}, {b, c}, {a, b, c}, {a, d}, {a, b, d}, {a, b, c, d}} \n" + 
			"28. {∅, {a}, {a, b}, {a, c}, {a, b, c}, {a, d}, {a, b, d}, {a, c, d}, {a, b, c, d}} \n" + 
			"29. {∅, {a}, {b}, {a, b}, {a, c}, {a, b, c}, {a, d}, {a, b, d}, {a, c, d}, {a, b, c, d}} \n" + 
			"30. {∅, {a}, {b}, {a, b}, {c}, {a, c}, {b, c}, {a, b, c}, {a, b, d}, {a, b, c, d}} \n" + 
			"31. {∅, {a}, {b}, {a, b}, {c}, {a, c}, {b, c}, {a, b, c}, {a, d}, {a, b, d}, {a, c, d}, {a, b, c, d}} \n" + 
			"32. {∅, {a}, {b}, {a, b}, {c}, {a, c}, {b, c}, {a, b, c}, {a, b, c, d}} \n" + 
			"33. {∅, {a}, {b}, {a, b}, {c}, {a, c}, {b, c}, {a, b, c}, {d}, {a, d}, {b, d}, {a, b, d}, {c, d}, {a, c, d}, {b, c, d}, {a, b, c, d}} ";
	public static boolean interior = false;
	public static boolean innerInterior = false;
	
	
	public static String topologyToLatex(String s) {
		
		for(int i = 0; i < s.length(); i ++) {
			// would've looked prettier if I had used a switch statement
			if (s.charAt(i) == '{') {
				after += " " + "\\" + s.charAt(i);
				if (interior == false) { interior = true; }
				else { innerInterior = true; }
				
			}
			else if (s.charAt(i) == '}') {
				after += "\\" + "}";
				if (innerInterior == true) { innerInterior = false; }
				else { interior = false; after += "\\" + "\\";}
			}
			else if (s.charAt(i) == '∅'){
				after += "\\emptyset";
			}
			else if (s.charAt(i) =='n') {
				after += "\\";
			}
			else if (s.charAt(i) == 'a' || s.charAt(i) =='b' || s.charAt(i) =='c' || s.charAt(i) =='d'){
				after += " " + s.charAt(i);
			}
			else {
				after += s.charAt(i);
			}
			
			
		}
		return after;
	}
		
	public static void main(String args[]) {
			System.out.print(topologyToLatex(before));
	
		}
}
