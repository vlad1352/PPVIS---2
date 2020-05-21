
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Sax {
    private String name;
    private int quantityOnStock;
    private String manufacturerName;
    private int ynpOfManufacturer;
    private String warehouseAddress;
    private String endEl;
    private MyData product;

    private static List<MyData> products = new ArrayList<>();


    public void parse(File file) {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bName = false;
                boolean bQuantityOnStock = false;
                boolean bManufacturerName = false;
                boolean bYnpOfManufacturer = false;
                boolean bWarehouseAddress = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

                    if (qName.equalsIgnoreCase("ProductName")) {
                        bName = true;
                    }
                    if (qName.equalsIgnoreCase("ManufacturerName")) {
                        bManufacturerName = true;
                    }
                    if (qName.equalsIgnoreCase("YnpOfManufacturer")) {
                        bYnpOfManufacturer = true;
                    }
                    if (qName.equalsIgnoreCase("QuantityOnStock")) {
                        bQuantityOnStock = true;
                    }

                    if (qName.equalsIgnoreCase("WarehouseAddress")) {
                        bWarehouseAddress = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {

                    endEl = qName;
                }

                public void characters(char[] ch, int start, int length) throws SAXException {

                    if (bName) {
                        setName(new String(ch, start, length));
                        bName = false;
                    } else if (bQuantityOnStock) {
                        setQuantity(Integer.parseInt(new String(ch, start, length)));
                        bQuantityOnStock = false;

                    } else if (bManufacturerName) {
                        setManufacturerName(new String(ch, start, length));
                        bManufacturerName = false;
                    } else if (bYnpOfManufacturer) {
                        setYnp(Integer.parseInt(new String(ch, start, length)));
                        bYnpOfManufacturer = false;
                    } else if (bWarehouseAddress) {
                        setAddress(new String(ch, start, length));
                        bWarehouseAddress = false;
                        product = new MyData(getName());
                        product.setWarehouseAddress(getWarehouseAddress());
                        product.setQuantityOnStock(getQuantityOnStock());
                        product.setYnpOfManufacturer(getYnpOfManufacturer());
                        product.setManufacturerName(getManufacturerName());
                        products.add(product);
                    }
                }
            };

            saxParser.parse(file, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantityOnStock = quantity;
    }

    public int getQuantityOnStock() {return quantityOnStock;}

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setYnp(int ynp) {
        this.ynpOfManufacturer = ynp;
    }

    public int getYnpOfManufacturer(){return ynpOfManufacturer;}

    public void setAddress(String address) {
        this.warehouseAddress = address;
    }

    public String getWarehouseAddress(){return  warehouseAddress;}

    public static List<MyData> getProducts() {
        return products;
    }



}


