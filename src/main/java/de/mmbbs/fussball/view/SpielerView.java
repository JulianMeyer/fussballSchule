package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import de.mmbbs.fussball.model.Spieler;
import de.mmbbs.fussball.model.Treffer;
import de.mmbbs.fussball.service.DataService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * A Designer generated component for the spieler-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("spieler-view")
@JsModule("./spieler-view.ts")
@Route(value = "spieler", layout = MainView.class)
public class SpielerView extends LitTemplate {

    @Id("trikotnummer")
    private NumberField trikotnummer;
    @Id("buttonHinzufügen")
    private Button buttonHinzufügen;
    @Id("checkboxTreffer")
    private Checkbox checkboxTreffer;
    @Id("minute")
    private NumberField minute;
    @Id("buttonSpeichern")
    private Button buttonSpeichern;
    @Id("textFieldSpieler")
    private TextField textFieldSpieler;
    @Id("elfmeter")
    private NumberField elfmeter;
    @Id("daGriddy")
    private Grid<Spieler> daGriddy;
    DataService dataService;
    List<Treffer> trefferList = new ArrayList<>();


    public SpielerView(DataService dataService) {
        this.dataService = dataService;
        buttonHinzufügen.addClickListener(buttonClickEvent -> hinzufuegenTreffer());
        buttonSpeichern.addClickListener(buttonClickEvent -> speichernSpieler());

        daGriddy.addColumn(Spieler::getName);
        daGriddy.addColumn(Spieler::getTrikotnummer);
        daGriddy.addColumn(Spieler::getPosition);
        daGriddy.addColumn(Spieler::getTrefferanzahl);
        daGriddy.addColumn(Spieler::getElfmeterGehalten);
    }

    private void speichernSpieler() {
        Spieler spieler = new Spieler();
        spieler.setName(textFieldSpieler.getValue());
        spieler.setElfmeterGehalten(elfmeter.getValue().intValue());
        spieler.setTrikotnummer(trikotnummer.getValue().intValue());
        spieler.setPosition("");
        if (isValid(spieler)) {
            dataService.saveSpieler(spieler);
            Notification notification = Notification
                    .show("Spieler Hinzugefügt!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } else {
            Notification notification = Notification
                    .show("Fehler beim Speichern!");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }

    }

    private boolean isValid(Spieler spieler) {
        if (spieler.getName().isEmpty() ||
                spieler.getElfmeterGehalten() < 0 ||
                spieler.getPosition().isEmpty() ||
                spieler.getTrikotnummer() < 0) {
            return false;
        } else {
            return true;
        }
    }

    private void hinzufuegenTreffer() {
        Treffer treffer = new Treffer();
        treffer.setEigentor(checkboxTreffer.getValue());
        treffer.setMinute(minute.getValue().intValue());

        trefferList.add(treffer);
        init();
        checkboxTreffer.clear();
        minute.clear();
        Notification notification = Notification
                .show("Treffer Hinzugefügt!");
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    }

    @PostConstruct
    private void init() {
        daGriddy.setItems(dataService.getAllSpieler());

    }
}
