package sk.upjs.registracia_konferencia;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ParticipantsListController {

	@FXML
	private ParticipantDao participantDao = new ParticipantDao();
	private ObservableList<Participant> participantsModel;

	@FXML
	private ListView<Participant> participantsListView;

	@FXML
	void initialize() {
		participantsModel = FXCollections.observableArrayList(participantDao.getAll());
		participantsListView.setItems(participantsModel);
	}
}
