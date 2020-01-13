package controller.chat;

import java.io.IOException;

import facade.LoginFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import model.Chat;

/*
 * @author lucadebeir
 */

public class ChatListViewCell extends ListCell<Chat> {

	@FXML
	private TextArea chatContent;
	@FXML
	private Label cellNameSender;
	@FXML
	private BorderPane cellLayout;

	FXMLLoader mLLoader;

	ChatController controller;
	
	LoginFacade lF = new LoginFacade();

	public ChatListViewCell() {
		super();
	}

	@Override
	protected void updateItem(Chat chat, boolean empty) {
		super.updateItem(chat, empty);
		
		if (empty || chat == null) {

			setText(null);
			setGraphic(null);

		} else {
			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass().getResource("../../ui/event/chat/ChatListViewCell.fxml"));
				mLLoader.setController(this);
				try {
					mLLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			
			
			this.cellNameSender.setText(String.valueOf((lF.find(chat.getIdSender()).getFirstNameUser())));
			this.chatContent.setText(String.valueOf(chat.getContentMessage()));
			this.chatContent.setEditable(false);
			
			setText(null);
			setGraphic(cellLayout);

		}

	}

}
