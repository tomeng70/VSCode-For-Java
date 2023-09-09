public class CompareStrings {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hell";
		String s3 = s1.substring(0, s1.length() - 1);

		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);

		if (s1.equals(s1)) {
			System.out.println("s1 equals itself;");
		}

		if (s2.equals(s3)) {
			System.out.println("s2 equals s3.");
		}
	}
}