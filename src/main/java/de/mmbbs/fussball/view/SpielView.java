package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;
import de.mmbbs.fussball.NotificationManager;
import de.mmbbs.fussball.model.Mannschaft;
import de.mmbbs.fussball.model.Schiri;
import de.mmbbs.fussball.model.Spiel;
import de.mmbbs.fussball.service.DataService;

import java.sql.Date;

/**
 * A Designer generated component for the spiel-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("spiel-view")
@JsModule("./spiel-view.ts")
@Route(value = "spiel", layout = MainView.class)
public class SpielView extends LitTemplate {

    @Id("daGriddy")
    private Grid<Spiel> daGriddy;
    @Id("comboboxHeim")
    private ComboBox<Mannschaft> comboboxHeim;
    @Id("buttonSpeichern")
    private Button buttonSpeichern;
    @Id("schiribox")
    private ComboBox<Schiri> schiribox;
    @Id("comboboxAusw")
    private ComboBox<Mannschaft> comboboxAusw;
    @Id("datepicker")
    private DatePicker datepicker;

    DataService dataService;

    public SpielView(DataService dataService) {
        this.dataService = dataService;
        init();
        buttonSpeichern.addClickListener(buttonClickEvent -> speichern());
        daGriddy.addColumn(Spiel::getDate).setHeader("Datum");
        daGriddy.addColumn(spiel -> spiel.getAuswaerts().getName()).setHeader("Auswärts-Mannschaft");
        daGriddy.addColumn(spiel -> spiel.getHeim().getName()).setHeader("Heim-Mannschaft");
        daGriddy.addColumn(spiel -> spiel.getSchiri().getName()).setHeader("Schiedsrichter");
        comboboxAusw.setItemLabelGenerator(Mannschaft::getName);
        comboboxHeim.setItemLabelGenerator(Mannschaft::getName);
        schiribox.setItemLabelGenerator(Schiri::getName);
    }

    private void speichern() {
        Spiel spiel = new Spiel();
        if (datepicker.getValue() != null) {
            spiel.setDate(Date.valueOf(datepicker.getValue()));
        }
        spiel.setAuswaerts(comboboxAusw.getValue());
        spiel.setHeim(comboboxHeim.getValue());
        spiel.setSchiri(schiribox.getValue());

        if (isValid(spiel)) {
            dataService.saveSpiel(spiel);
            refresh();
            init();
            NotificationManager.notificationSuccessAtSaving("Spiel");
        } else {
            NotificationManager.notificationFailureAtSaving();
        }
    }

    private void refresh() {
        datepicker.clear();
        comboboxHeim.clear();
        comboboxAusw.clear();
        schiribox.clear();
    }

    private boolean isValid(Spiel spiel) {
        if (spiel.getAuswaerts() == null || spiel.getHeim() == null || spiel.getSchiri() == null) {
            return false;
        } else {
            return true;
        }
    }

    private void init() {
        comboboxHeim.setItems(dataService.getAllMannschaft());
        comboboxAusw.setItems(dataService.getAllMannschaft());
        schiribox.setItems(dataService.getAllSchiri());
        daGriddy.setItems(dataService.getAllSpiel());
    }

}
