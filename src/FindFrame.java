
import javax.swing.*;
import java.util.List;

public class FindFrame extends JFrame {
    private DataController DC;

    private JButton findButton;

    private TablePanel tablePanel;

    private ChoosePanel choosePanel = new ChoosePanel();

    FindFrame(DataController DC){
        super("Find window");
        this.DC = DC;
        setSize(500, 320);
        setResizable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        findButton = new JButton("Find");
        findButton.addActionListener(actionEvent -> {
            List<String> list = choosePanel.getProductFromFields();
            DataController temp = new DataController();
            temp.setProducts(this.DC.FindProducts(list.get(0), list.get(1),
                    Integer.parseInt(list.get(2)), Integer.parseInt(list.get(3)), list.get(4)));
            tablePanel.setProducts(temp);
            tablePanel.showTable(temp);
        });

        tablePanel = new TablePanel(DC);
        JPanel pan = new JPanel();
        pan.add(findButton);

        add(choosePanel);
        add(pan);
        add(tablePanel);
    }


}
