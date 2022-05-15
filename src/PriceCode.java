public enum PriceCode {
    REGULAR(0),
    NEW_RELEASE(1),
    CHILDRENS(2);    

    private int id;

    PriceCode(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }
}