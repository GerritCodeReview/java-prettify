package prettify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import prettify.parser.Job;
import prettify.parser.Prettify;
import syntaxhighlight.ParseResult;
import syntaxhighlight.Parser;

/**
 * The prettify parser for syntax highlight.
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public class PrettifyParser implements Parser {

  /**
   * The prettify parser.
   */
  protected Prettify prettify;

  /**
   * Constructor.
   */
  public PrettifyParser() {
    prettify = new Prettify();
  }

  // Note to gitiles developers: This is gitiles entry point into java-prettifier lib.
  @Override
  public List<ParseResult> parse(String fileExtension, String content) {
    Job job = new Job(0, content);
    prettify.langHandlerForExtension(fileExtension, content).decorate(job);
    List<Object> decorations = job.getDecorations();


    List<ParseResult> returnList = new ArrayList<ParseResult>();

    // apply style according to the style list
    for (int i = 0, iEnd = decorations.size(); i < iEnd; i += 2) {
      int endPos = i + 2 < iEnd ? (Integer) decorations.get(i + 2) : content.length();
      int startPos = (Integer) decorations.get(i);
      returnList.add(new ParseResult(startPos, endPos - startPos, Arrays.asList(new String[]{(String) decorations.get(i + 1)})));
    }

    return returnList;
  }
}
