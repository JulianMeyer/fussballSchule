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

/**
 * A Designer generated component for the statistik-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("statistik-view")
@JsModule("./statistik-view.ts")
public class StatistikView extends LitTemplate {

    @Id("gridHeimSpieler")
    private Grid gridHeim;
    @Id("gridAuswSpieler")
    private Grid gridAusw;
    @Id("buttonGenerieren")
    private Button buttonGenerieren;
    @Id("comboSpielauswahl")
    private ComboBox<String> comboSpielauswahl;
    @Id("labelErgebnis")
    private H2 labelErgebnis;
    @Id("labelHeimName")
    private Label labelHeimName;
    @Id("labelAuswName")
    private Label labelAuswName;
    @Id("heimTrefferGrid")
    private Grid heimTrefferGrid;
    @Id("auswTrefferGrid")
    private Grid auswTrefferGrid;

    /**
     * Creates a new StatistikView.
     */
    public StatistikView() {
        // You can initialise any data required for the connected UI components here.
    }

}
