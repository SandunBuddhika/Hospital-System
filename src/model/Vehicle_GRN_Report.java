package model;

public class Vehicle_GRN_Report {

    public Vehicle_GRN_Report(String v_id, String v_number, String v_name, String company, String brand, String price, String capacity, String mfd) {
        this.v_number = v_number;
        this.v_name = v_name;
        this.v_id = v_id;
        this.company = company;
        this.brand = brand;
        this.price = price;
        this.capacity = capacity;
        this.mfd = mfd;
    }

    /**
     * @return the v_number
     */
    public String getV_number() {
        return v_number;
    }

    /**
     * @return the v_name
     */
    public String getV_name() {
        return v_name;
    }

    /**
     * @return the v_id
     */
    public String getV_id() {
        return v_id;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @return the capacity
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * @return the mfd
     */
    public String getMfd() {
        return mfd;
    }

    private String v_number;
    private String v_name;
    private String v_id;
    private String company;
    private String brand;
    private String price;
    private String capacity;
    private String mfd;
}
