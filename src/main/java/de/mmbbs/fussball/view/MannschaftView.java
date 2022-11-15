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
import de.mmbbs.fussball.model.Mannschaft;
import de.mmbbs.fussball.model.Vertrag;
import de.mmbbs.fussball.service.DataService;

import java.util.List;

/**
 * A Designer generated component for the mannschaft-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("mannschaft-view")
@JsModule("./mannschaft-view.ts")
@Route(value = "mannschaft", layout = MainView.class)
public class MannschaftView extends LitTemplate {

    @Id("textFieldName")
    private TextField textFieldName;
    @Id("daGriddy")
    private Grid<Mannschaft> daGriddy;
    @Id("buttonHinzufügen")
    private Button buttonHinzufügen;
    @Id("buttonSpeichern")
    private Button buttonSpeichern;
    DataService dataService;
    List<Vertrag> vertragList;

    public MannschaftView(DataService dataService) {
        this.dataService = dataService;

        daGriddy.addColumn(Mannschaft::getName).setHeader("Mannschaftsname");
        daGriddy.addColumn(Mannschaft::getVertragAnzahl).setHeader("Spiler unter Vertrag");
        init();
        buttonHinzufügen.addClickListener(buttonClickEvent -> vertragHinzufuegen());
        buttonSpeichern.addClickListener(buttonClickEvent -> mannschaftSpeichern());
    }

    private void mannschaftSpeichern() {
        Mannschaft mannschaft = new Mannschaft();
        mannschaft.setName(textFieldName.getValue());
        mannschaft.setVertragList(vertragList);

        if (isValid(mannschaft)) {
            dataService.saveMannschaft(mannschaft);
            init();
            Notification notification = Notification
                    .show("Mannschaft Hinzugefügt!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } else {
            Notification notification = Notification
                    .show("Fehler beim Speichern!");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }
    }

    private boolean isValid(Mannschaft mannschaft) {
        return !mannschaft.getName().isEmpty();
    }

    private void vertragHinzufuegen() {

    }

    private void init() {
        daGriddy.setItems(dataService.getAllMannschaft());
    }

}
