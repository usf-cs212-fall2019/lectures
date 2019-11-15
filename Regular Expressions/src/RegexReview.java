import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Practices regular expressions.
 *
 * @see RegexHelper
 */
public class RegexReview {

	/**
	 * Shows the matches from various text and regular expressions.
	 * @param args unused
	 */
	public static void main(String[] args) {

		String hubbub = "hubbub";

		RegexHelper.printMatches(hubbub, "h.*b"); 			// [hubbub]
		RegexHelper.printMatches(hubbub, "h.*?b"); 		// [hub]
		RegexHelper.printMatches(hubbub, "h.*bb*"); 		// [hubbub]
		RegexHelper.printMatches(hubbub, "h.*bb+"); 		// [hubb]
		RegexHelper.printMatches(hubbub, "h.*bb?"); 		// [hubbub]
		RegexHelper.printMatches(hubbub, "h.*?bb?"); 	// [hubb]

		String riffraff = "riffraff";

		RegexHelper.printMatches(riffraff, "r.ff");		// [riff, raff]
		RegexHelper.printMatches(riffraff, "r.*f");		// [riffraff]
		RegexHelper.printMatches(riffraff, "r.*?f");		// [rif, raf]

		RegexHelper.printMatches(riffraff, ".+f");			// [riffraff]
		RegexHelper.printMatches(riffraff, ".+?f");		// [rif, fraf]
		RegexHelper.printMatches(riffraff, ".+?f+");		// [riff, raff]
		RegexHelper.printMatches(riffraff, ".+?f+?");	// [rif, fraf]

		RegexHelper.printMatches(riffraff, "r[^f]?");		// [ri, ra]
		RegexHelper.printMatches(riffraff, "^r.ff?");		// [riff]
		RegexHelper.printMatches(riffraff, "^r.ff??");		// [rif]

		String words = "ant ape bat bee bug cat cow dog eel";

		RegexHelper.printMatches(words, "\\w*a\\w*"); 			// [ant, ape, bat, cat]
		RegexHelper.printMatches(words, "\\w+a\\w+"); 			// [bat, cat]
		RegexHelper.printMatches(words, "\\w+t\\b"); 			// [ant, bat, cat]
		RegexHelper.printMatches(words, "\\w*e\\b"); 			// [ape, bee]
		RegexHelper.printMatches(words, "\\w*[^e]e\\b"); 	// [ape]

		String groups = "cookbook foolpROOF WOOD moOn schoolroom";
		String regex = "(?i)((?:\\woo\\w)+)";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(groups);

		while (m.find()) {
			for (int i = 0; i <= m.groupCount(); i++) {
				System.out.print(i + ": [" + m.group(i) + "] ");
			}

			System.out.println();
		}

		// 0: [cookbook] 1: [cookbook] 2: [boo]
		// 0: [fool] 1: [fool] 2: [foo]
		// 0: [ROOF] 1: [ROOF] 2: [ROO]
		// 0: [WOOD] 1: [WOOD] 2: [WOO]
		// 0: [moOn] 1: [moOn] 2: [moO]
		// 0: [hoolroom] 1: [hoolroom] 2: [roo]
	}

}
