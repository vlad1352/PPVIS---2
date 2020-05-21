
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataController {

    private List<MyData> tableData;

    private boolean bName;
    private boolean bMabufacturerName;
    private boolean bYnp;
    private boolean bQuantity;
    private boolean bAddress;
    private File file;

    DataController(){
        tableData = new ArrayList<>();
    }

    private List<MyData> FindTemplate(String name, String manufacturerName, int ynp, int quantity, String warehouseAddress) {
        List<MyData> temp = new ArrayList<>();
        for (MyData tableDatum : tableData) {
            boolean bIsFits = (tableDatum.getName().equals(name) || bName)
                    && (tableDatum.getManufacturerName().equals(manufacturerName) || bMabufacturerName)
                    && (tableDatum.getYnpOfManufacturer() == ynp || bYnp)
                    && (tableDatum.getQuantityOnStock() == quantity || bQuantity)
                    && (tableDatum.getWarehouseAddress().equals(warehouseAddress) || bAddress);
            if(bIsFits){
                temp.add(tableDatum);
            }
        }
        return temp;
    }

    public List<MyData> FindProducts(String name, String manufacturerName, int ynp, int quantity, String warehouseAddress){

        bName = (name.equals(""));
        bMabufacturerName = manufacturerName.equals("");
        bYnp = (ynp == -1);
        bQuantity = (quantity == -1);
        bAddress = warehouseAddress.equals("");

        return FindTemplate(name, manufacturerName, ynp, quantity, warehouseAddress);
    }

    public int DeleteProducts(String name, String manufacturerName, int ynp, int quantity, String warehouseAddress){
        bName = (name.equals(""));
        bMabufacturerName = manufacturerName.equals("");
        bYnp = ynp == -1;
        bQuantity = quantity == -1;
        bAddress = warehouseAddress.equals("");

        List<MyData> temp = FindTemplate(name, manufacturerName, ynp, quantity, warehouseAddress);
        int amount = temp.size();
        tableData.removeAll(temp);
        Dom dom = new   Dom();
        dom.setProducts(tableData, file.getAbsolutePath());
        dom.setBooks();
        return amount;
    }

    public void Add(MyData product){
        tableData.add(product);
        Dom dom = new   Dom();
        dom.setProducts(tableData, file.getAbsolutePath());
        dom.setBooks();
    }

    public void Read(File file) throws ParserConfigurationException, SAXException, IOException {
        Sax sax = new Sax();
        sax.parse(file);
        this.file = file;
        tableData = sax.getProducts();
    }

    public void Write(String pathToFile){
        Dom dom = new Dom();
        dom.setProducts(tableData, pathToFile);
        dom.setBooks();
    }

    public MyData atIndex(int index){
        return tableData.get(index);
    }

    public boolean isExists(int index){
        return index < tableData.size();
    }

    public void setProducts(List<MyData> data){
        tableData = data;
    }
}
