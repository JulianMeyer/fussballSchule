package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;
import de.mmbbs.fussball.model.Spiel;
import de.mmbbs.fussball.model.Spieler;
import de.mmbbs.fussball.model.Treffer;
import de.mmbbs.fussball.model.Vertrag;
import de.mmbbs.fussball.service.DataService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * A Designer generated component for the statistik-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("statistik-view")
@JsModule("./statistik-view.ts")
@Route(value = "statistik", layout = MainView.class)
public class StatistikView extends LitTemplate {

    @Id("gridHeimSpieler")
    private Grid<Spieler> gridHeim;
    @Id("gridAuswSpieler")
    private Grid<Spieler> gridAusw;
    @Id("buttonGenerieren")
    private Button buttonGenerieren;
    @Id("comboSpielauswahl")
    private ComboBox<Spiel> comboSpielauswahl;
    @Id("labelErgebnis")
    private H2 labelErgebnis;
    @Id("labelHeimName")
    private Label labelHeimName;
    @Id("labelAuswName")
    private Label labelAuswName;
    @Id("heimTrefferGrid")
    private Grid<Treffer> heimTrefferGrid;
    @Id("auswTrefferGrid")
    private Grid<Treffer> auswTrefferGrid;

    DataService dataService;

    public StatistikView(DataService dataService) {
        this.dataService = dataService;
        comboSpielauswahl.getStyle().set("--vaadin-combo-box-overlay-width", "500px");
        comboSpielauswahl.setItemLabelGenerator(spiel ->
                spiel.getHeim().getName() + " "
                        + spiel.getAuswaerts().getName() + " "
                        + spiel.getDate().toString());
        buttonGenerieren.addClickListener(buttonClickEvent -> ergebnisGenerieren(comboSpielauswahl.getValue()));
        setErgebnisVisability(false);
        gridHeim.addColumn(Spieler::getName).setHeader("Name");
        gridHeim.addColumn(Spieler::getPosition).setHeader("Position");
        gridHeim.addColumn(Spieler::getTrikotnummer).setHeader("Trikotnummer");

        gridAusw.addColumn(Spieler::getName).setHeader("Name");
        gridAusw.addColumn(Spieler::getPosition).setHeader("Position");
        gridAusw.addColumn(Spieler::getTrikotnummer).setHeader("Trikotnummer");

        heimTrefferGrid.addColumn(Treffer::getMinute).setHeader("Treffer in der Minute:");
        heimTrefferGrid.addColumn(Treffer::isEigentor).setHeader("Ist Eigentor?");
        auswTrefferGrid.addColumn(Treffer::getMinute).setHeader("Treffer in der Minute:");
        auswTrefferGrid.addColumn(Treffer::isEigentor).setHeader("Ist Eigentor?");
    }

    private void setErgebnisVisability(boolean visability) {
        gridAusw.setVisible(visability);
        gridHeim.setVisible(visability);
        auswTrefferGrid.setVisible(visability);
        heimTrefferGrid.setVisible(visability);
        labelAuswName.setVisible(visability);
        labelHeimName.setVisible(visability);
        labelErgebnis.setVisible(visability);
    }

    private void ergebnisGenerieren(Spiel value) {

        //auslesen der Spieler aus dem Spiel

        List<Vertrag> vertragList = value.getHeim().getVertragList();
        List<Spieler> spielerListHeim = new ArrayList<>();
        for (Vertrag vertrag : new HashSet<>(vertragList)) {
            Spieler spieler = vertrag.getSpieler();
            spielerListHeim.add(spieler);
        }

        List<Vertrag> vertragList2 = value.getAuswaerts().getVertragList();
        List<Spieler> spielerListAusw = new ArrayList<>();
        for (Vertrag vertrag : new HashSet<>(vertragList2)) {
            Spieler spieler = vertrag.getSpieler();
            spielerListAusw.add(spieler);
        }

        //setzen der SPieler in die grids

        gridHeim.setItems(spielerListHeim);
        gridAusw.setItems(spielerListAusw);

        //Label anpassen
        labelHeimName.setText(value.getHeim().getName() +
                ":" + "                   Schiedsrichter: " + value.getSchiri().getName());
        labelAuswName.setText(value.getAuswaerts().getName() + ":");


        //TrefferListen auslesehen

        List<Treffer> trefferListHeim = new ArrayList<>();
        for (Spieler spieler : spielerListHeim) {
            trefferListHeim.addAll(spieler.getTreffer());
        }

        List<Treffer> trefferListAusw = new ArrayList<>();
        for (Spieler spieler : spielerListAusw) {
            trefferListAusw.addAll(spieler.getTreffer());
        }

        //wieder ins Grid packen

        heimTrefferGrid.setItems(trefferListHeim);
        auswTrefferGrid.setItems(trefferListAusw);

        labelErgebnis.setText(getErgebnis(trefferListHeim, trefferListAusw));
        setErgebnisVisability(true);
    }

    private String getErgebnis(List<Treffer> trefferListHeim, List<Treffer> trefferListAusw) {
        int heim = 0;
        int ausw = 0;

        for (Treffer trefferHeim : trefferListHeim) {
            if (trefferHeim.isEigentor()) {
                ausw += 1;
            } else {
                heim += 1;
            }
        }
        for (Treffer trefferAusw : trefferListAusw) {
            if (trefferAusw.isEigentor()) {
                heim += 1;
            } else {
                ausw += 1;
            }
        }


        return String.format("%s : %d", heim, ausw);
    }

    @PostConstruct
    private void init() {
        comboSpielauswahl.setItems(dataService.getAllSpiel());
    }

}
