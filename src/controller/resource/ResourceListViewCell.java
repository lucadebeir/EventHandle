package controller.resource;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import model.Resource;

public class ResourceListViewCell extends ListCell<Resource> {
	
	@FXML private Label resourceName;
	@FXML private Label resourceLocalisation;
	@FXML private Label resourceQuantity;
	FXMLLoader mLLoader;
	@FXML private BorderPane resourceCell;
	
	@Override
	protected void updateItem(Resource resource, boolean empty) {
        super.updateItem(resource, empty);
        
        if(empty || resource == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../../ui/event/resources/ResourceListViewCell.fxml"));
                mLLoader.setController(this);
                try {
					mLLoader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }
            
            this.resourceName.setText(String.valueOf(resource.getNameResource()));
            this.resourceLocalisation.setText(String.valueOf(resource.getLocationResource()));
            this.resourceQuantity.setText(String.valueOf(resource.getQuantityResource()));
           
            this.resourceLocalisation.maxWidth(USE_COMPUTED_SIZE);
            
            setText(null);
            setGraphic(resourceCell);
        }

    }

}
