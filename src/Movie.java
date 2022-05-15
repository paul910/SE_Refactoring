public class Movie {
    private String title;
    private PriceCode priceCode;
    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }
    public PriceCode getPriceCode() {
        return this.priceCode;
    }
    public void setPriceCode(PriceCode arg) {
        this.priceCode = arg;
    }
    public String getTitle (){
        return this.title;
    };
}