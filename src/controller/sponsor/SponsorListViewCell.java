package controller.sponsor;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import model.Resource;
import model.Sponsor;

public class SponsorListViewCell extends ListCell<Sponsor>{
	
	@FXML private Label nameSponsor;
	@FXML private Label numSiretSponsor;
	@FXML private Label lastNameSponsor;
	@FXML private Label firstNameSponsor;
	@FXML private Label emailSponsor;
	FXMLLoader mLLoader;
	@FXML private BorderPane sponsorCell;
	
	@Override
	protected void updateItem(Sponsor sponsor, boolean empty) {
        super.updateItem(sponsor, empty);
        
        if(empty || sponsor == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../../ui/event/sponsors/SponsorListViewCell.fxml"));
                mLLoader.setController(this);
                try {
					mLLoader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }
            
            this.nameSponsor.setText(String.valueOf(sponsor.getNameSponsor()));
            this.numSiretSponsor.setText(String.valueOf(sponsor.getNumSiretSponsor()));
            System.out.println(sponsor.getLastNameContactSponsor());
            this.lastNameSponsor.setText(String.valueOf(sponsor.getLastNameContactSponsor()));

            //this.numSiretSponsor.maxWidth(USE_COMPUTED_SIZE);
            
            setText(null);
            setGraphic(sponsorCell);
        }

    }
	
}
