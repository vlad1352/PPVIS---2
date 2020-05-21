
public class MyData {

    private String name;
    private int quantityOnStock;
    private String manufacturerName;
    private int ynpOfManufacturer;
    private String warehouseAddress;



    public MyData(String name) {this.name = name;}
    public MyData(String name, String manufacturerName, int ynpOfManufacturer, int quantityOnStock, String warehouseAddress){
        this.name = name;
        this.manufacturerName = manufacturerName;
        this.ynpOfManufacturer = ynpOfManufacturer;
        this.quantityOnStock = quantityOnStock;
        this.warehouseAddress = warehouseAddress;
    }

    public String getName() {return name;}

    public int getQuantityOnStock() {return quantityOnStock;}
    public void setQuantityOnStock(int quantity) { this.quantityOnStock = quantity;}

    public void setManufacturerName(String manufacturerName) {this.manufacturerName = manufacturerName;}
    public String getManufacturerName() {return manufacturerName;}

    public void setYnpOfManufacturer(int ynp) {this.ynpOfManufacturer = ynp;}
    public int getYnpOfManufacturer() {return  ynpOfManufacturer;}

    public void setWarehouseAddress(String address) {this.warehouseAddress = address;}
    public String getWarehouseAddress() {return warehouseAddress;}

}
