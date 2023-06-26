package model;

public class Item_Invoice_Report {

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    public Item_Invoice_Report(String p_name, String ip, String price, String itemtotal) {
        this.name = p_name;
        this.ip = ip;
        this.price = Double.parseDouble(price);
        this.total = Double.parseDouble(itemtotal);
    }

    /**
     * @return the p_name
     */
    
    private String name;
    private String ip;
    private double price;
    private double total;
}
