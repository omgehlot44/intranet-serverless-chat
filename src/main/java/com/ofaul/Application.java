package com.ofaul;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.ofaul.business.ui.main_menu.controller.MainMenuController;
import com.ofaul.business.util.LookAndFeelUtils;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true); 
		JDialog.setDefaultLookAndFeelDecorated(true); 
		try 
		{ 
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 

	        ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).headless(false).run(args);
	        MainMenuController mainMenuController = context.getBean(MainMenuController.class);
	        mainMenuController.prepareAndOpenFrame();
		}
		catch (Exception ex) 
		{ 
			System.out.println(ex);
		}
    }

}
