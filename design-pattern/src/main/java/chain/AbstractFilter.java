package chain;

public abstract class AbstractFilter implements Filter {
    protected AbstractFilter nextFilter;

    public void setNextFilter(AbstractFilter filter) {
        this.nextFilter = filter;
    }
}
