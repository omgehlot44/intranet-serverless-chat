package com.ofaul.business.ui.forms.client.model;

import org.springframework.stereotype.Component;

import com.ofaul.business.entity.Client;
import com.ofaul.business.ui.shared.model.DefaultTableModel;
import com.ofaul.business.util.ConstMessagesEN;

@Component
public class ClientTableModel extends DefaultTableModel<Client> {

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.NAME,
                ConstMessagesEN.Labels.SURNAME,
                ConstMessagesEN.Labels.PESEL,
                ConstMessagesEN.Labels.PHONE_NUMBER,
                ConstMessagesEN.Labels.EMAIL,
                ConstMessagesEN.Labels.ADDRESS};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client client = entities.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return client.getName();
            case 1:
                return client.getSurname();
            case 2:
                return client.getPesel();
            case 3:
                return client.getPhoneNumber();
            case 4:
                return client.getEmail();
            default:
                return "";
        }
    }
}
