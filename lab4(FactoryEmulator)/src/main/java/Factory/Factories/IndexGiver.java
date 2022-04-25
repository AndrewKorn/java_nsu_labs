package Factory.Factories;

public class IndexGiver {
    private int index;

    public IndexGiver() {
        this.index = 0;
    }

    public int getIndex() {
        increment();
        return index - 1;
    }

    public void increment() {
        ++index;
    }
}
