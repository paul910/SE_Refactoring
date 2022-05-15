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
            thisAmount = amountFor(each);
            // add frequent renter points
            renterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) 
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

    private double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2)
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3)
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

}
    