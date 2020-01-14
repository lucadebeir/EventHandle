package controller.collaborator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.event.MessageListViewCell;
import facade.LoginFacade;
import facade.exception.DisconnectedUserException;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Message;
import model.User;
import ui.Router;

/*
 * @author lucadebeir
 */

public class MyCollaborators {
	
	@FXML
	private Button deleteUser;
	
	@FXML
	private Button addButton;
	
	@FXML
	private Button buttonDisplay;
	
	LoginFacade lF = null;
	
	int idEvent = (int) Router.getInstance().getParams()[0];
	
	boolean isVolunteer;
	boolean isIntervener;
	
	@FXML
	private ListView<String> managerList;
	List<User> listManager;
	protected ListProperty<String> listPropertyManager = new SimpleListProperty<>();
	protected List<String> listManagers = new ArrayList<>();
	protected List<Integer> listManagersId = new ArrayList<>();
	private int managerSelectedId = -1;
	
	@FXML
	private ListView<String> volunteerList;
	List<User> listVolunteer;
	protected ListProperty<String> listPropertyVolunteer = new SimpleListProperty<>();
	protected List<String> listVolunteers = new ArrayList<>();
	protected List<Integer> listVolunteersId = new ArrayList<>();
	private int volunteerSelectedId = -1;
	
	@FXML
	private ListView<String> intervenerList;
	List<User> listIntervener;
	protected ListProperty<String> listPropertyIntervener = new SimpleListProperty<>();
	protected List<String> listInterveners = new ArrayList<>();
	protected List<Integer> listIntervenersId = new ArrayList<>();
	private int intervenerSelectedId = -1;
	
	@FXML
	public void goBackToEvent() {
		Router.getInstance().activate("Event", Router.getInstance().getParams());
	}
	
	private void fetchListManagerView() throws DisconnectedUserException {
		listManager = lF.getAllManagerOfAnEvent(idEvent);
		
		for(User u : listManager) {
			listManagers.add(u.getFirstNameUser() + " " + u.getLastNameUser());
			listManagersId.add(u.getId());
		}
		
		managerList.itemsProperty().bind(listPropertyManager);
		listPropertyManager.set(FXCollections.observableArrayList(listManagers));
	}
	
	private void fetchListVolunteerView() throws DisconnectedUserException {
		listVolunteer = lF.getAllVolunteerOfAnEvent(idEvent);
		
		for(User u : listVolunteer) {
			listVolunteers.add(u.getFirstNameUser() + " " + u.getLastNameUser());
			listVolunteersId.add(u.getId());
		}
		
		volunteerList.itemsProperty().bind(listPropertyVolunteer);
		listPropertyVolunteer.set(FXCollections.observableArrayList(listVolunteers));
	}
	
	private void fetchListIntervenerView() throws DisconnectedUserException {
		listIntervener = lF.getAllIntervenerOfAnEvent(idEvent);
		
		for(User u : listIntervener) {
			listInterveners.add(u.getFirstNameUser() + " " + u.getLastNameUser());
			listIntervenersId.add(u.getId());
		}
		
		
		intervenerList.itemsProperty().bind(listPropertyIntervener);
		listPropertyIntervener.set(FXCollections.observableArrayList(listInterveners));
	}
	
	@FXML
	public void displayUser() {
		
	}
	
	@FXML
	public void addCollaborator() {
		Stage nextStage = new Stage();
		nextStage.setTitle("Add a collaborator");
		Pane myPane = null;
		try {
			myPane = FXMLLoader.load(getClass().getResource("/ui/event/collaborators/AddCollaborator.fxml"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		Scene scene = new Scene(myPane);
		nextStage.setScene(scene);
		nextStage.show();
	}
	
	@FXML
	public void deleteCollaborator() throws DisconnectedUserException {
		int index = 0;
		int index2 = 0;
    	User user = null;
    	for (User m : listVolunteer) {
    		if (m.getId()==(volunteerSelectedId)) {
    			index = listVolunteer.indexOf(m);
    			user = m;
    		}
    	}
    	for (User m : listManager) {
    		if (m.getId()==(managerSelectedId)) {
    			index = listManager.indexOf(m);
    			user = m;
    			index2 = 1;
    		}
    	}
    	if (index == 0) {
    		for (User u : listIntervener) {
    			if (u.getId()==intervenerSelectedId) {
    				index = listIntervener.indexOf(u);
    				user = u;
    			}
    		}
    		listIntervener.remove(user);
    		listInterveners.remove(user.getFirstNameUser() + " " + user.getLastNameUser());
    		listIntervenersId.remove(index);
    		lF.deleteUserCollaborator(idEvent, user.getId(), "isIntervener");
    		fetchListIntervenerView();
    	} else {
    		if (index2 == 0) {
    			listVolunteer.remove(user);
        		listVolunteers.remove(user.getFirstNameUser() + " " + user.getLastNameUser());
        		listVolunteersId.remove(index);
        		lF.deleteUserCollaborator(idEvent, user.getId(), "isVolunteer");
        		fetchListVolunteerView();
    		} else {
    			listManager.remove(user);
        		listManagers.remove(user.getFirstNameUser() + " " + user.getLastNameUser());
        		listManagersId.remove(index);
        		lF.deleteUserCollaborator(idEvent, user.getId(), "isManager");
        		fetchListManagerView();
    		}
    	}
		
    	buttonDisplay.setDisable(true);
		deleteUser.setDisable(true);
	}
	
	@FXML
	public void initialize() throws DisconnectedUserException {
		lF = new LoginFacade();
		
		fetchListManagerView();
		
		fetchListVolunteerView();
		
		fetchListIntervenerView();
		
		isVolunteer = lF.isVolunteer(listVolunteer);
		isIntervener = lF.isIntervener(listIntervener);
		
		if(isVolunteer || isIntervener) {
			addButton.setVisible(false);
			buttonDisplay.setVisible(false);
			deleteUser.setVisible(false);
		}
		
		buttonDisplay.setDisable(true);
		deleteUser.setDisable(true);
		
		ChangeListener listenerManager = new ChangeListener<Object>() {  
			@Override
			public void changed(ObservableValue arg0, Object arg1, Object arg2) {
				// TODO Auto-generated method stub
				listManagers.clear();
				
				try {
					managerSelectedId = listManagersId.get(managerList.getSelectionModel().getSelectedIndex());
					buttonDisplay.setDisable(false);
					deleteUser.setDisable(false);
				}catch (Exception e) {
					// TODO: handle exception
					buttonDisplay.setDisable(false);
					deleteUser.setDisable(false);
				}
				
				try {
					fetchListManagerView();
				} catch (DisconnectedUserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}  
		};
		
		managerList.getSelectionModel().selectedIndexProperty().addListener(
				listenerManager
				 );
		
		ChangeListener listenerVolunteer = new ChangeListener<Object>() {  
			@Override
			public void changed(ObservableValue arg0, Object arg1, Object arg2) {
				// TODO Auto-generated method stub
				listVolunteers.clear();
				
				try {
					volunteerSelectedId = listVolunteersId.get(volunteerList.getSelectionModel().getSelectedIndex());
					buttonDisplay.setDisable(false);
					deleteUser.setDisable(false);
				}catch (Exception e) {
					// TODO: handle exception
					buttonDisplay.setDisable(false);
					deleteUser.setDisable(false);
				}
				
				try {
					fetchListVolunteerView();
				} catch (DisconnectedUserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}  
		};
		
		volunteerList.getSelectionModel().selectedIndexProperty().addListener(
				listenerVolunteer
				 );
		
		ChangeListener listenerIntervener = new ChangeListener<Object>() {  
			@Override
			public void changed(ObservableValue arg0, Object arg1, Object arg2) {
				// TODO Auto-generated method stub
				listInterveners.clear();
				
				try {
					intervenerSelectedId = listIntervenersId.get(intervenerList.getSelectionModel().getSelectedIndex());
					buttonDisplay.setDisable(false);
					deleteUser.setDisable(false);
				}catch (Exception e) {
					// TODO: handle exception
					buttonDisplay.setDisable(false);
					deleteUser.setDisable(false);
				}
				
				try {
					fetchListIntervenerView();
				} catch (DisconnectedUserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}  
		};
		
		intervenerList.getSelectionModel().selectedIndexProperty().addListener(
				listenerIntervener
				 );
	}

}
