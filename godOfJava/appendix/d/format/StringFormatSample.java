package d.format;

public class StringFormatSample {
    public static void main(String[] args) {
        StringFormatSample sample = new StringFormatSample();
        sample.kindSample();
        sample.checkConversions();
        sample.checkFlag();
    }

    private void checkFlag() {
        System.out.format("This is %%-20g : %-20g.\n", 3.14159227);
        System.out.format("This is %%20g : %20g.\n", 3.14159227);
        System.out.format("This is %%+20g : %+20g.\n", 3.14159227);
        System.out.format("This is %% g : [% g].\n", 3.14159227);
        System.out.format("This is %% g : [% g].\n", -3.14159227);
        System.out.format("This is %%020g : %020g.\n", 3.14159227);
        System.out.format("This is %%,20g : %,20g.\n", 3.14159227);
        System.out.format("This is %%(20g : %(20g.\n", 3.14159227);
    }

    private void checkConversions() {
        System.out.format("This is b : %b.\n", false);
        System.out.format("This is h : %h.\n", "A");
        System.out.format("This is s : %s.\n", "String");

        System.out.format("This is c : %c.\n", '한');

        System.out.format("This is d : %d.\n", 255);
        System.out.format("This is o : %o.\n", 256);
        System.out.format("This is x : %x.\n", 255);
        System.out.format("This is e : %e.\n", 3.1415927);
        System.out.format("This is g : %g.\n", 3.1415927);
        System.out.format("This is f : %f.\n", 3.1415927);
        System.out.format("This is a : %a.\n", 3.1415927);

        System.out.format("This is n : %n.\n");
        System.out.format("This is percent : %%.\n", false);
    }

    private void kindSample() {
        String explicitIndexing = String.format("%1$s %2$s %3$s", "A", "B", "C");
        System.out.println(explicitIndexing);

        String relativeIndexing = String.format("%s %<s %s %s", "A", "B", "C");
        System.out.println(relativeIndexing);

        String ordinaryIndexing = String.format("%s %s %s", "A", "B", "C");
        System.out.println(ordinaryIndexing);
    }
}
