package chain;

public class PornFilter extends AbstractFilter {
    @Override
    public String doFilter(String text) {
        if (text.contains("fuck")) {
            return "404";
        } else if (nextFilter != null) {
            return nextFilter.doFilter(text);
        }
        return text;
    }
}
