import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String name){
        this.name = name;
    };
    public void addRental(Rental arg) {
        this.rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        double totalAmount = 0;
        int renterPoints = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String result = String.format("Rental Record for %s\n", this.getName());
        result += "\tTitle\t\tDays\tAmount\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = each.getRentalPrice();
            // add frequent renter points
            renterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == PriceCode.NEW_RELEASE) && each.getDaysRented() > 1) 
                renterPoints ++;
            //show figures for this rental
            result += String.format("\t%s\t\t%s\t%s\n", each.getMovie().getTitle(), each.getDaysRented(), String.valueOf(thisAmount));
            totalAmount += thisAmount;
        }
        //add footer lines
        result +=  String.format("Amount owed is %s\n", String.valueOf(totalAmount));
        result += String.format("You earned %s frequent renter points", String.valueOf(renterPoints));
        return result;
    }

}
    