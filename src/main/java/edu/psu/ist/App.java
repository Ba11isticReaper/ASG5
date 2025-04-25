package edu.psu.ist;

import edu.psu.ist.model.UtilListImpl;
import edu.psu.ist.view.SplitListView;
import edu.psu.ist.controller.SplitListController;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SplitListView view = new SplitListView();
            UtilListImpl<String> model = new UtilListImpl<>();
            new SplitListController(model, view);
            view.setVisible(true);
        });
    }
}
