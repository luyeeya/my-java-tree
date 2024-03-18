package chain;

public class HeadFilter extends AbstractFilter {
    @Override
    public String doFilter(String text) {
        if (nextFilter != null) {
            return nextFilter.doFilter(text);
        }
        return text;
    }
}
