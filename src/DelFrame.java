
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DelFrame extends JFrame {
    private DataController dataController;

    private ChoosePanel choosePanel = new ChoosePanel();

    private JButton delete;

    DelFrame(DataController dataController){
        super("Delete window");
        this.dataController = dataController;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        init();
        setSize(500, 120);
        setResizable(false);
    }

    private void init() {
        delete = new JButton("Delete");
        delete.setMaximumSize(new Dimension(100, 20));

        add(choosePanel);
        add(delete);
    }

    public int deleteStudents(){
        List<String> list = choosePanel.getProductFromFields();
        return  this.dataController.DeleteProducts(list.get(0), list.get(1),
                Integer.parseInt(list.get(2)), Integer.parseInt(list.get(3)), list.get(4));
    }

    public DataController getDataController() {
        return dataController;
    }

    public ChoosePanel getChoosePanel() {
        return choosePanel;
    }

    public JButton getDelete() {
        return delete;
    }
}
