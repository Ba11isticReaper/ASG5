package edu.psu.ist.controller;

import edu.psu.ist.model.ISplittableList;
import edu.psu.ist.model.UtilListImpl;
import edu.psu.ist.view.SplitListView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Stack;

public class SplitListController {

    private ISplittableList<String> listModel;
    private SplitListView view;
    private Stack<ISplittableList<String>> undoStack = new Stack<>();

    public SplitListController(ISplittableList<String> m, SplitListView v) {
        this.listModel = m;
        this.view = v;

        view.getListValueLabel().setText(listModel.toString());

        view.getMoveForwardButton().addActionListener(e -> {
            if (listModel.rightLength() == 0) {
                showError("Cannot move forward: right list is empty.");
                return;
            }
            saveState();
            listModel.moveForward();
            updateDisplay();
        });

        view.getAddToRightButton().addActionListener(e -> {
            String input = view.getInputField().getText();
            if (input == null || input.trim().isEmpty()) {
                showError("Cannot add: input is blank.");
                return;
            }
            saveState();
            listModel.addToRightAtFront(input.trim());
            view.getInputField().setText("");
            updateDisplay();
        });

        view.getRemoveFromRightButton().addActionListener(e -> {
            if (listModel.rightLength() == 0) {
                showError("Cannot remove: right list is empty.");
                return;
            }
            saveState();
            listModel.removeFromRightAtFront();
            updateDisplay();
        });

        view.getUndoButton().addActionListener(e -> {
            if (!undoStack.isEmpty()) {
                listModel = undoStack.pop();
                updateDisplay();
            } else {
                showError("No actions to undo.");
            }
        });

        view.getCountOfButton().addActionListener(e -> {
            String input = view.getInputField().getText();
            if (input == null || input.trim().isEmpty()) {
                showError("Please enter a value to count.");
                return;
            }
            int count = listModel.countOf(input.trim());
            JOptionPane.showMessageDialog(view,
                    "Number of times \"" + input.trim() + "\" occurs: " + count,
                    "Count Result",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        view.getMoveToBeginningButton().addActionListener(e -> {
            saveState();
            listModel.moveToVeryBeginning();
            updateDisplay();
        });

        view.getClearButton().addActionListener(e -> {
            saveState();
            listModel.clear();
            view.getLastRemovedLabel().setText("N/A");
            updateDisplay();
        });




    }

    private void updateDisplay() {
        view.getListValueLabel().setText(listModel.toString());
        view.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength());
        view.getRightLengthLabel().setText("Right Length: " + listModel.rightLength());
    }

    private void saveState() {
        undoStack.push(new UtilListImpl<>(listModel));
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
