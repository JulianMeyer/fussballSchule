package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import de.mmbbs.fussball.NotificationManager;
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
    @Id("position")
    private ComboBox<String> position;
    List<Treffer> trefferList = new ArrayList<>();

    public SpielerView(DataService dataService) {
        this.dataService = dataService;
        buttonHinzufügen.addClickListener(buttonClickEvent -> hinzufuegenTreffer());
        buttonSpeichern.addClickListener(buttonClickEvent -> speichernSpieler());
        init();
        daGriddy.addColumn(Spieler::getName).setHeader("Name");
        daGriddy.addColumn(Spieler::getTrikotnummer).setHeader("Trikotnummer");
        daGriddy.addColumn(Spieler::getPosition).setHeader("Position");
        daGriddy.addColumn(Spieler::getTrefferanzahl).setHeader("Trefferanzahl");
        daGriddy.addColumn(Spieler::getElfmeterGehalten).setHeader("Elfmeter gehalten");
        position.setItems("Stürmer", "Mittelfeld", "Defensive", "Torwart");
        position.setAllowCustomValue(false);
    }

    private void speichernSpieler() {
        Spieler spieler = new Spieler();
        spieler.setName(textFieldSpieler.getValue());
        if (elfmeter.getValue() != null) {
            spieler.setElfmeterGehalten(elfmeter.getValue().intValue());
        }
        if (trikotnummer.getValue() != null) {
            spieler.setTrikotnummer(trikotnummer.getValue().intValue());
        }
        spieler.setPosition(position.getValue());
        spieler.setTreffer(trefferList);
        if (isValid(spieler)) {
            dataService.saveTreffer(trefferList);
            dataService.saveSpieler(spieler);
            refresh();
            NotificationManager.notificationSuccessAtSaving("Spieler");
        } else {
            NotificationManager.notificationFailureAtSaving();
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
        if (minute.getValue() != null) {
            treffer.setMinute(minute.getValue().intValue());
        }
        if (isValid(treffer)) {
            trefferList.add(treffer);
            init();
            checkboxTreffer.clear();
            minute.clear();
            NotificationManager.notificationSuccessAtSaving("Treffer");
        } else {
            NotificationManager.notificationFailureAtSaving();
        }
    }

    private boolean isValid(Treffer treffer) {
        return treffer.getMinute() > 0;
    }

    @PostConstruct
    private void init() {
        List<Spieler> allSpieler = dataService.getAllSpieler();
        daGriddy.setItems(allSpieler);

    }

    private void refresh() {
        textFieldSpieler.clear();
        elfmeter.clear();
        trikotnummer.clear();
        position.clear();
        minute.clear();
        checkboxTreffer.clear();
        daGriddy.setItems(dataService.getAllSpieler());
        trefferList = new ArrayList<>();
    }
}
