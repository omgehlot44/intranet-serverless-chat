package com.ofaul.business.ui.forms.client.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ofaul.business.entity.Client;
import com.ofaul.business.service.ClientService;
import com.ofaul.business.ui.forms.client.model.AddressComboBoxModel;
import com.ofaul.business.ui.forms.client.model.ClientTableModel;
import com.ofaul.business.ui.forms.client.view.ClientFrame;
import com.ofaul.business.ui.forms.client.view.TableBtnPanel;
import com.ofaul.business.ui.forms.client.view.modal.AddClientFrame;
import com.ofaul.business.ui.forms.client.view.modal.FormBtnPanel;
import com.ofaul.business.ui.forms.client.view.modal.FormPanel;
import com.ofaul.business.ui.shared.controller.AbstractFrameController;
import com.ofaul.business.util.ConstMessagesEN;
import com.ofaul.business.util.Notifications;
import com.ofaul.business.validation.ClientValidator;
import com.ofaul.business.validation.ValidationError;

@Controller
public class ClientController extends AbstractFrameController {

    private ClientFrame clientFrame;
    private AddClientFrame addClientFrame;
    private ClientTableModel clientTableModel;
    private ClientService clientService;
    private ClientValidator clientValidator;
    private AddressComboBoxModel addressComboBoxModel;

    @Autowired
    public ClientController(ClientFrame clientFrame,
                            AddClientFrame addClientFrame,
                            ClientTableModel clientTableModel,
                            ClientService clientService,
                            ClientValidator clientValidator,
                            AddressComboBoxModel addressComboBoxModel) {
        this.clientFrame = clientFrame;
        this.addClientFrame = addClientFrame;
        this.clientTableModel = clientTableModel;
        this.clientService = clientService;
        this.clientValidator = clientValidator;
        this.addressComboBoxModel = addressComboBoxModel;
    }

    @PostConstruct
    private void prepareListeners() {
        TableBtnPanel tableBtnPanel = clientFrame.getTableBtnPanel();
        FormBtnPanel formBtnPanel = addClientFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddClientModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeClient());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveClient());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadClients();
        loadAddresses();
        showClientsFrame();
    }

    private void loadClients() {
        List<Client> users = clientService.findAll();
        clientTableModel.clear();
        clientTableModel.addEntities(users);
    }

    private void loadAddresses() {
//        List<Address> addresses = addressService.findAll();
//        addressComboBoxModel.clear();
//        addressComboBoxModel.addElements(addresses);
    }

    private void showClientsFrame() {
        clientFrame.setVisible(true);
    }

    private void showAddClientModal() {
        addClientFrame.setVisible(true);
    }

    private void saveClient() {
        FormPanel formPanel = addClientFrame.getFormPanel();
        Client client = formPanel.getClientFromForm();
        Optional<ValidationError> errors = clientValidator.validate(client);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            clientService.save(client);
            clientTableModel.addEntity(client);
            closeModalWindow();
        }
    }

    private void closeModalWindow() {
        addClientFrame.getFormPanel().clearForm();
        addClientFrame.dispose();
    }

    private void removeClient() {
        try {
            JTable clientTable = clientFrame.getTablePanel().getClientTable();
            int selectedRow = clientTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Client client = clientTableModel.getEntityByRow(selectedRow);
                clientService.remove(client);
                clientTableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}
