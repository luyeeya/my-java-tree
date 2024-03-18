package chain;

public class GamblingFilter extends AbstractFilter {
    @Override
    public String doFilter(String text) {
        if (text.contains("gamble")) {
            return "404";
        } else if (nextFilter != null) {
            return nextFilter.doFilter(text);
        }
        return text;
    }
}
