
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChoosePanel extends JPanel {

    private JPanel textPanel;
    private JTextField name;

    private JTextField manufacturerName;
    private JTextField ynpOfManufacture;
    private JTextField quantity;
    private JTextField warehouseAddress;

    ChoosePanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createLabels();
        createText();

    }

    public void createLabels(){
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));

        JLabel name = new JLabel("name");
        JLabel manufacturerName = new JLabel("manufacturer name");
        JLabel ynpOfManufacture = new JLabel("ynp of manufacture");
        JLabel quantity = new JLabel("quantity");
        JLabel warehouseAddress = new JLabel( "warehouse address");

        labelPanel.add(name);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(manufacturerName);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(ynpOfManufacture);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(quantity);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(warehouseAddress);

        add(labelPanel);
    }

    public void createText(){
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.LINE_AXIS));

        final int WIDTH = 200;
        final int HEIGHT = 20;


        name = new JTextField();
        name.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        name.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        manufacturerName = new JTextField();
        manufacturerName.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        manufacturerName.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        ynpOfManufacture = new JTextField();
        ynpOfManufacture.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        ynpOfManufacture.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        quantity = new JTextField();
        quantity.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        quantity.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        warehouseAddress = new JTextField();
        warehouseAddress.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        warehouseAddress.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        textPanel.add(name);
        textPanel.add(manufacturerName);
        textPanel.add(ynpOfManufacture);
        textPanel.add(quantity);
        textPanel.add(warehouseAddress);

        add(textPanel);
    }

    public List<String> getProductFromFields(){
        List<String> result = new ArrayList<>();
        result.add(getName());
        result.add(getManufacturerName());
        int ynp= -1;
        int quantity = -1;
        if(!getYnpOfManufacture().equals("")){
            ynp = Integer.parseInt(getYnpOfManufacture());
        }
        if(!getQuantity().equals("")){
            quantity = Integer.parseInt(getQuantity());
        }
        result.add(String.valueOf(ynp));
        result.add(String.valueOf(quantity));
        result.add(getAddress());
        return result;
    }

    public String getName() {
        return name.getText();
    }

    public String getManufacturerName() {
        return manufacturerName.getText();
    }

    public String getYnpOfManufacture() {
        return ynpOfManufacture.getText();
    }

    public String getQuantity() {
        return quantity.getText();
    }

    public String getAddress() {
        return warehouseAddress.getText();
    }
}
