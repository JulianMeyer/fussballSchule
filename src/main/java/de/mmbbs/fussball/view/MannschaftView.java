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
import de.mmbbs.fussball.model.Mannschaft;
import de.mmbbs.fussball.model.Vertrag;
import de.mmbbs.fussball.service.DataService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    @Id("GridVertrag")
    private Grid<Vertrag> gridVertrag;
    List<Vertrag> vertragList = new ArrayList<>();

    public MannschaftView(DataService dataService) {
        this.dataService = dataService;

        daGriddy.addColumn(Mannschaft::getName).setHeader("Mannschaftsname");
        daGriddy.addColumn(Mannschaft::getVertragAnzahl).setHeader("Spieler unter Vertrag");
        daGriddy.addItemClickListener(event -> {
            textFieldName.setValue(event.getItem().getName());
            vertragList = event.getItem().getVertragList();
        });
        daGriddy.addItemDoubleClickListener(event -> {
            dataService.deleteMannschaft(event.getItem());
            init();
        });
        gridVertrag.addColumn(vertrag -> vertrag.getSpieler().getName()).setHeader("Spieler");
        gridVertrag.addColumn(Vertrag::getGehalt).setHeader("Gehalt");
        gridVertrag.setSelectionMode(Grid.SelectionMode.MULTI);
        buttonHinzufügen.addClickListener(buttonClickEvent -> vertragHinzufuegen());
        buttonSpeichern.addClickListener(buttonClickEvent -> mannschaftSpeichern(daGriddy.asSingleSelect().getValue()));
    }

    private void mannschaftSpeichern(Mannschaft mannschaft) {
        if (mannschaft == null) {
            mannschaft = new Mannschaft();
        }
        mannschaft.setName(textFieldName.getValue());
        mannschaft.setVertragList(vertragList);

        if (isValid(mannschaft)) {
            dataService.saveMannschaft(mannschaft);
            init();
            NotificationManager.notificationSuccessAtSaving("Mannschaft");
        } else {
            NotificationManager.notificationFailureAtSaving();
        }
    }

    private boolean isValid(Mannschaft mannschaft) {
        return !mannschaft.getName().isEmpty();
    }

    private void vertragHinzufuegen() {
        Set<Vertrag> selectedItems = gridVertrag.getSelectedItems();
        if (selectedItems.isEmpty()) {
            NotificationManager.notificationFailureAtSaving();
        } else {
            vertragList.addAll(selectedItems);
            NotificationManager.customSuccess("Die Verträge wurde ausgewählt");
        }
    }

    @PostConstruct
    private void init() {
        daGriddy.setItems(dataService.getAllMannschaft());
        gridVertrag.setItems(dataService.getAllVertrag());
    }

}
