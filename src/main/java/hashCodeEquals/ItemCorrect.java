package hashCodeEquals;

public class ItemCorrect {

    private int itemNo;

    public ItemCorrect(final int itemNo) {
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

        final ItemCorrect that = (ItemCorrect) o;

        return itemNo == that.itemNo;

    }

    @Override
    public String toString() {
        return "ItemCorrect{" + itemNo + '}';
    }

    @Override
    public int hashCode() {
        return itemNo;
    }
}
