package com.ofaul.business.ui.forms.client.view;

import org.springframework.stereotype.Component;

import com.ofaul.business.util.ConstMessagesEN;

import javax.swing.*;

@Component
public class TableBtnPanel extends JPanel {

    private JButton addBtn;
    private JButton removeBtn;

    public TableBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        addBtn = new JButton(ConstMessagesEN.Labels.ADD_BTN);
        add(addBtn);

        removeBtn = new JButton(ConstMessagesEN.Labels.REMOVE_BTN);
        add(removeBtn);
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getRemoveBtn() {
        return removeBtn;
    }

}
