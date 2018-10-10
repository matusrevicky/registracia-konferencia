package sk.upjs.registracia_konferencia;


import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class ParticipantsListController {

	@FXML
	private ParticipantDao participantDao = new ParticipantDao();
	private ObservableList<ParticipantFxModel> participantsModel;

	@FXML
	private ListView<ParticipantFxModel> participantsListView;
	
    @FXML
    private TableView<ParticipantFxModel> participantsTableView;
    

	@FXML
	void initialize() {
		List<ParticipantFxModel> models = new ArrayList<>();
		for (Participant p : participantDao.getAll()) {
			models.add(new ParticipantFxModel(p));
		}
		
		
		participantsModel = FXCollections.observableArrayList(models);
		participantsListView.setItems(participantsModel);
		
		TableColumn<ParticipantFxModel, Long> idCol = new TableColumn<>("ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		participantsTableView.getColumns().add(idCol);
		
		TableColumn<ParticipantFxModel, String> nameCol = new TableColumn<>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
		participantsTableView.getColumns().add(nameCol);
		
		TableColumn<ParticipantFxModel, String> surnameCol = new TableColumn<>("Surname");
		surnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
		participantsTableView.getColumns().add(surnameCol);
		
		TableColumn<ParticipantFxModel, String> emailCol = new TableColumn<>("email");
		emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
		emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
		emailCol.setEditable(true);
		participantsTableView.getColumns().add(emailCol);
		
		
		
		participantsTableView.setItems(participantsModel);
	}
}
