package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class SplitListView extends JFrame {

    private JTextField inputField = new JTextField(10);
    private JButton addToRightButton = new JButton("Add to Right");
    private JButton removeFromRightButton = new JButton("Remove from Right");
    private JButton moveForwardButton = new JButton("Move Forward");
    private JButton moveBackwardButton = new JButton("Move Backward");
    private JButton moveToBeginningButton = new JButton("Move to Beginning");
    private JButton clearButton = new JButton("Clear");
    private JButton undoButton = new JButton("Undo");
    private JButton countOfButton = new JButton("Count # of");

    private JLabel listValueLabel = new JLabel("<<>>");
    private JLabel lastRemovedLabel = new JLabel("Last Removed: N/A");
    private JLabel leftLengthLabel = new JLabel("Left Length: 0");
    private JLabel rightLengthLabel = new JLabel("Right Length: 0");

    public SplitListView() {
        setTitle("ASG5 Splittable List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Input:"));
        add(inputField);
        add(addToRightButton);
        add(removeFromRightButton);

        add(new JLabel("List:"));
        add(listValueLabel);

        add(lastRemovedLabel);
        add(leftLengthLabel);
        add(rightLengthLabel);

        add(moveForwardButton);
        add(moveBackwardButton);
        add(moveToBeginningButton);
        add(clearButton);
        add(undoButton);
        add(countOfButton);

        pack();
    }

    public JTextField getInputField() { return inputField; }
    public JButton getAddToRightButton() { return addToRightButton; }
    public JButton getRemoveFromRightButton() { return removeFromRightButton; }
    public JButton getMoveForwardButton() { return moveForwardButton; }
    public JButton getMoveBackwardButton() { return moveBackwardButton; }
    public JButton getMoveToBeginningButton() { return moveToBeginningButton; }
    public JButton getClearButton() { return clearButton; }
    public JButton getUndoButton() { return undoButton; }
    public JButton getCountOfButton() { return countOfButton; }

    public JLabel getListValueLabel() { return listValueLabel; }
    public JLabel getLastRemovedLabel() { return lastRemovedLabel; }
    public JLabel getLeftLengthLabel() { return leftLengthLabel; }
    public JLabel getRightLengthLabel() { return rightLengthLabel; }
}
