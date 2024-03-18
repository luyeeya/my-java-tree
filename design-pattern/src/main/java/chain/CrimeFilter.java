package chain;

public class CrimeFilter extends AbstractFilter {
    @Override
    public String doFilter(String text) {
        if (text.contains("kill")) {
            return "404";
        } else if (nextFilter != null) {
            return nextFilter.doFilter(text);
        }
        return text;
    }
}
