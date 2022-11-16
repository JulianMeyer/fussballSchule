package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import de.mmbbs.fussball.NotificationManager;
import de.mmbbs.fussball.model.Spieler;
import de.mmbbs.fussball.model.Vertrag;
import de.mmbbs.fussball.service.DataService;

import javax.annotation.PostConstruct;

/**
 * A Designer generated component for the vertrag-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vertrag-view")
@JsModule("./vertrag-view.ts")
@Route(value = "vertrag", layout = MainView.class)
public class VertragView extends LitTemplate {

    @Id("buttonSpeichern")
    private Button buttonSpeichern;
    @Id("comboboxSpieler")
    private ComboBox<Spieler> comboboxSpieler;
    @Id("numberfieldGehalt")
    private NumberField numberfieldGehalt;
    @Id("daGriddy")
    private Grid<Vertrag> daGriddy;
    DataService dataService;

    public VertragView(DataService dataService) {
        this.dataService = dataService;
        daGriddy.addColumn(vertrag -> vertrag.getSpieler().getName()).setHeader("Spieler");
        daGriddy.addColumn(Vertrag::getGehalt).setHeader("Gehalt");
        comboboxSpieler.setItemLabelGenerator(Spieler::getName);
        buttonSpeichern.addClickListener(buttonClickEvent -> speichernVertrag());
    }

    private void speichernVertrag() {
        Vertrag vertrag = new Vertrag();
        vertrag.setGehalt(numberfieldGehalt.getValue());
        vertrag.setSpieler(comboboxSpieler.getValue());
        if (isValid(vertrag)) {
            dataService.saveVertrag(vertrag);
            refresh();
            init();
            NotificationManager.notificationSuccessAtSaving("Vertrag");
        } else {
            NotificationManager.notificationFailureAtSaving();
        }
    }

    private void refresh() {
        comboboxSpieler.clear();
        numberfieldGehalt.clear();
    }

    private boolean isValid(Vertrag vertrag) {
        if (vertrag.getSpieler() == null || vertrag.getGehalt() < 0.0) {
            return false;
        } else {
            return true;
        }

    }

    @PostConstruct
    private void init() {
        daGriddy.setItems(dataService.getAllVertrag());
        comboboxSpieler.setItems(dataService.getAllSpieler());
    }

}
