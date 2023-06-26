package model;

public class Item_GRN_Report {

    public Item_GRN_Report(int pid, String name, String type, String category, int qty, double bprice, double sprice, String MFD, String EXD, double total) {
        this.pid = pid;
        this.name = name;
        this.type = type;
        this.category = category;
        this.qty = qty;
        this.bprice = bprice;
        this.sprice = sprice;
        this.MFD = MFD;
        this.EXD = EXD;
        this.total = total;
    }

    /**
     * @return the pid
     */
    public int getPid() {
        return pid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @return the bprice
     */
    public double getBprice() {
        return bprice;
    }

    /**
     * @return the sprice
     */
    public double getSprice() {
        return sprice;
    }

    /**
     * @return the MFD
     */
    public String getMFD() {
        return MFD;
    }

    /**
     * @return the EXD
     */
    public String getEXD() {
        return EXD;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }
    private int pid;
    private String name;
    private String type;
    private String category;
    private int qty;
    private double bprice;
    private double sprice;
    private String MFD;
    private String EXD;
    private double total;
}
