
import javax.swing.*;

public class AddFrame extends JFrame {

    private ChoosePanel choosePanel = new ChoosePanel();
    private DataController DC;
    public JButton add;

    AddFrame(DataController DC){
        super("Add Window");
        this.DC = DC;
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add = new JButton("Add");
        add(choosePanel);

        add(add);

        setSize(600, 150);
        setResizable(false);
    }


    public void addStudent(){
        String tempName = choosePanel.getName();
        String tempManufacturerName = choosePanel.getManufacturerName();
        int tempYnp = Integer.parseInt(choosePanel.getYnpOfManufacture());
        int tempQuantity = Integer.parseInt(choosePanel.getQuantity());
        String tempAddress = choosePanel.getAddress();
        DC.Add(new MyData(tempName, tempManufacturerName, tempYnp, tempQuantity, tempAddress));
    }

}




