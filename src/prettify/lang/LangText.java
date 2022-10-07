package prettify.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import prettify.parser.Prettify;

public class LangText extends Lang {

  public LangText() {
    List<List<Object>> _shortcutStylePatterns = new ArrayList<List<Object>>();
    List<List<Object>> _fallthroughStylePatterns = new ArrayList<List<Object>>();

    _fallthroughStylePatterns.add(Arrays.asList(new Object[]{Prettify.PR_PLAIN, Pattern.compile(".", Pattern.CASE_INSENSITIVE)}));

    setShortcutStylePatterns(_shortcutStylePatterns);
    setFallthroughStylePatterns(_fallthroughStylePatterns);
  }

  public static List<String> getFileExtensions() {
    return Arrays.asList(new String[]{"txt", "TXT"});
  }

}
