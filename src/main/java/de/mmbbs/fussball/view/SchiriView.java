package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
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
        buttonSpeichern.addClickListener(buttonClickEvent -> speichern());
    }

    private void speichern() {
        Schiri neuerSchiri = new Schiri();
        String fieldNameValue = textFieldName.getValue();
        neuerSchiri.setName(fieldNameValue);

        if (isValid(neuerSchiri)) {
            dataService.saveSchiri(neuerSchiri);
            refreshPage();
            Notification notification = Notification
                    .show("Schiri Hinzugefügt!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } else {
            Notification notification = Notification
                    .show("Fehler beim Speichern!");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
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
