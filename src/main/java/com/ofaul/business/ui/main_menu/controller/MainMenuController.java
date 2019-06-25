package com.ofaul.business.ui.main_menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ofaul.business.ui.forms.login.view.LoginFrame;
import com.ofaul.business.ui.shared.controller.AbstractFrameController;

@Controller
public class MainMenuController extends AbstractFrameController {

    @Autowired
    private LoginFrame loginFrame;

    public MainMenuController() {
    }

    public void prepareAndOpenFrame() {
		loginFrame.setVisible(true); 
    }
}
