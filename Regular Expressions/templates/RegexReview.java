import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReview {

	public static void main(String[] args) {

		String hubbub = "hubbub";
		RegexHelper.printMatches(hubbub, ".*");

		String riffraff = "riffraff";
		RegexHelper.printMatches(riffraff, ".*");

		String words = "ant ape bat bee bug cat cow dog eel";
		RegexHelper.printMatches(words, ".*");

		String groups = "cookbook foolpROOF WOOD moOn schoolroom";
		String regex = ".*";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(groups);

		while (m.find()) {
			for (int i = 0; i <= m.groupCount(); i++) {
				System.out.print(i + ": [" + m.group(i) + "] ");
			}

			System.out.println();
		}
	}

}
