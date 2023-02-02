import java.util.ArrayList;

public class CustomerChecker {
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerChecker(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        double p = 0;
        for(MenuItem m : check){
            p += m.getPrice();
        }
        return p;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        for(int i = 0; i < check.size() - 1; i++){
            if(!check.get(i).isDailySpecial() || totalPrices() < 40){
                return false;
            }
        }
        return true;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        int totalPeople = 0;
        double total = totalPrices();
        for(MenuItem m : check){
            if(m.isEntree()){
                totalPeople++;
            }
        }
        if(totalPeople > 6){
            total = total * 1.2;
        }
        if(couponApplies()){
            total = total - 20;
        }

        return total;
    }
}
