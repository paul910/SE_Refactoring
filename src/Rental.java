class Rental {
    private Movie movie;
    private int daysRented;
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
    public int getDaysRented() {
        return this.daysRented;
    }
    public Movie getMovie() {
        return this.movie;
    }

    public double getRentalPrice() {
        switch (movie.getPriceCode()) {
            case REGULAR: {
                return 2 + (daysRented > 2 ? (daysRented - 2) * 1.5 : 0);
            }
            case NEW_RELEASE: {
                return daysRented * 3;
            }
            case CHILDRENS: {
                return 1.5 + (daysRented > 3 ? (daysRented - 3) * 1.5 : 0);
            }
            default: {
                return 0;
            }
        }
    }
}