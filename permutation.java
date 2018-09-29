package algo;

/**
 * This program is for printing all the permutations of a string
 * using recursion
 * n characters string has n! combinations
 * It also checks if any combination presents in another string
 * @author Azmain
 *
 */
public class permutation {
	public static void main(String[] args) {
		permute("","use");
	}
	/**
	 * fix is which is set
	 * rest is which need to be permuted
	 * @param fix
	 * @param rest
	 */
	public static void permute(String fix,String rest) {
		if(rest.isEmpty()) {
			System.out.println(fix);
			if("quest".contains(fix)) {
				System.out.println("True");
			}
		}
		/**
		 * Below recursive call does -
		 * a(bc)->ab(c)->ac(b)
		 * b(ac)->ba(c)->bc(a)
		 * c(ab)->ca(b)->cb(a)
		 */
		else {
			for(int i = 0; i < rest.length(); i++) {
				permute(fix+rest.charAt(i),rest.substring(0, i)+rest.substring(i+1, rest.length()));
			}
		}
		
	}
}
