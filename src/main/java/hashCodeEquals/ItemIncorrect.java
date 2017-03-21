package hashCodeEquals;

public class ItemIncorrect {

    private int itemNo;

    public ItemIncorrect(final int itemNo) {
        this.itemNo = itemNo;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final ItemIncorrect that = (ItemIncorrect) o;

        return itemNo == that.itemNo;

    }

    @Override
    public int hashCode() {
        return 1;
    }
}
