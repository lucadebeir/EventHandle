package controller.chat;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import model.Chat;

public class ChatListViewCell extends ListCell<Chat> {
	
	@FXML private TextArea chatContent;
	@FXML private BorderPane cellLayout;

	FXMLLoader mLLoader;
	
	ChatController controller;
	

	public ChatListViewCell(ChatController controller) {
		super();
		this.controller = controller;
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
			
			this.chatContent.setText(String.valueOf(chat.getContentMessage()));
			
			setText(null);
			setGraphic(cellLayout);

		}

	}

}
