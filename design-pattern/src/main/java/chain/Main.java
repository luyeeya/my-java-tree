package chain;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HeadFilter headFilter = new HeadFilter();
        PornFilter pornFilter = new PornFilter();
        headFilter.setNextFilter(pornFilter);
        GamblingFilter gamblingFilter = new GamblingFilter();
        pornFilter.setNextFilter(gamblingFilter);
        CrimeFilter crimeFilter = new CrimeFilter();
        gamblingFilter.setNextFilter(crimeFilter);

        List<String> messages = Arrays.asList(
                "fuck!",
                "miss u",
                "kill u",
                "good morning",
                "do u want to gamble?",
                "see you again~");
        messages.stream()
                .map(headFilter::doFilter)
                .forEach(System.out::println);
    }
}
