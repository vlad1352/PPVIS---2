

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.List;

public class Dom {

    String  pathTo;
    private static List<MyData> products;
    public  void setProducts(List<MyData> products, String path){
        this.products = products;
        pathTo = path;
    }

    public static List<MyData> getProducts() {
        return products;
    }


    private  Node createBookElement(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));

        return node;
    }

    private  Node createBook(Document document, String name, String manufacturerName, Integer ynp, Integer quantity, String address) {
        Element product = document.createElement("product");

        product.appendChild(createBookElement(document, "ProductName", name));

        product.appendChild(createBookElement(document, "ManufacturerName", manufacturerName));

        product.appendChild(createBookElement(document, "YnpOfManufacturer", ynp.toString()));

        product.appendChild(createBookElement(document, "QuantityOnStock", quantity.toString()));

        product.appendChild(createBookElement(document, "WarehouseAddress", address));

        return product;
    }

    public  void addBook(MyData product){
        products.add(product);
    }

    public  void setBooks() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElementNS("", "Products");
            document.appendChild(root);
            for (MyData product : products) {
                root.appendChild(createBook(document, product.getName(), product.getManufacturerName(), product.getYnpOfManufacturer(), product.getQuantityOnStock(), product.getWarehouseAddress()));
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transf = null;
            try {
                transf = transformerFactory.newTransformer();
                transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transf.setOutputProperty(OutputKeys.INDENT, "yes");
                transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

                DOMSource source = new DOMSource(document);

                File myFile = new File(pathTo);

                StreamResult file = new StreamResult(myFile);

                transf.transform(source, file);
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}



