package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import de.mmbbs.fussball.NotificationManager;
import de.mmbbs.fussball.model.Schiri;
import de.mmbbs.fussball.service.DataService;

import javax.annotation.PostConstruct;

/**
 * A Designer generated component for the schiri-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("schiri-view")
@JsModule("./schiri-view.ts")
@Route(value = "schiri", layout = MainView.class)
public class SchiriView extends LitTemplate {

    @Id("daGriddy")
    private Grid<Schiri> daGriddy;
    @Id("textFieldName")
    private TextField textFieldName;
    @Id("buttonSpeichern")
    private Button buttonSpeichern;

    DataService dataService;

    public SchiriView(DataService dataService) {
        this.dataService = dataService;
        daGriddy.addColumn(Schiri::getName);
        daGriddy.addItemClickListener(event -> {
            textFieldName.setValue(event.getItem().getName());
        });
        daGriddy.addItemDoubleClickListener(event -> {
            dataService.deleteSchiri(event.getItem());
            init();
        });
        buttonSpeichern.addClickListener(buttonClickEvent -> speichern(daGriddy.asSingleSelect().getValue()));
    }

    private void speichern(Schiri schiri) {
        if (schiri == null) {
            schiri = new Schiri();
        }
        String fieldNameValue = textFieldName.getValue();
        schiri.setName(fieldNameValue);

        if (isValid(schiri)) {
            dataService.saveSchiri(schiri);
            refreshPage();
            NotificationManager.notificationSuccessAtSaving("Schiri");
        } else {
            NotificationManager.notificationFailureAtSaving();
        }
    }

    private void refreshPage() {
        daGriddy.setItems(dataService.getAllSchiri());
        textFieldName.clear();
    }

    private boolean isValid(Schiri neuerSchiri) {
        return !neuerSchiri.getName().isEmpty();
    }

    @PostConstruct
    private void init() {
        daGriddy.setItems(dataService.getAllSchiri());
    }
}
