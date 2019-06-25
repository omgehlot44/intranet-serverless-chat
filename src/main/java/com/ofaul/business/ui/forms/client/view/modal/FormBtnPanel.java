package com.ofaul.business.ui.forms.client.view.modal;

import org.springframework.stereotype.Component;

import com.ofaul.business.util.ConstMessagesEN;

import javax.swing.*;

@Component
public class FormBtnPanel extends JPanel {

    private JButton saveBtn;
    private JButton cancelBtn;

    public FormBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        saveBtn = new JButton(ConstMessagesEN.Labels.ADD_BTN);
        add(saveBtn);

        cancelBtn = new JButton(ConstMessagesEN.Labels.CANCEL_BTN);
        add(cancelBtn);
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

}
