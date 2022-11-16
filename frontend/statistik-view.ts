import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/checkbox/src/vaadin-checkbox.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/combo-box/src/vaadin-combo-box.js';
import '@vaadin/grid/src/vaadin-grid.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';

@customElement('statistik-view')
export class StatistikView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%; margin: var(--lumo-space-xs); padding: var(--lumo-space-xs);">
 <h2>Statistik</h2>
 <vaadin-vertical-layout style="height: 100%; width: 100%; padding: var(--lumo-space-s);">
  <label>Spiel für die Statistik auswählen</label>
  <vaadin-combo-box id="comboSpielauswahl"></vaadin-combo-box>
  <vaadin-horizontal-layout style="width: 100%; justify-content: flex-end;" theme="spacing-xl">
   <vaadin-button id="buttonGenerieren" tabindex="0">
    Generieren
   </vaadin-button>
  </vaadin-horizontal-layout>
  <vaadin-vertical-layout style="width: 100%;">
   <h2>Ergebnis</h2>
   <vaadin-horizontal-layout style="width: 100%; align-self: center; justify-content: center;">
    <h2 id="labelErgebnis">Ergebnis</h2>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
  <vaadin-horizontal-layout style="width: 100%;">
   <vaadin-vertical-layout style="width: 50%;">
    <vaadin-horizontal-layout style="width: 100%; justify-content: flex-start;">
     <label id="labelHeim" style="padding: var(--lumo-space-s);">Heim</label>
     <label id="labelHeimName" style="flex-grow: 0; padding: var(--lumo-space-s);">Test</label>
    </vaadin-horizontal-layout>
    <vaadin-grid id="gridHeimSpieler" is-attached multi-sort-priority="prepend"></vaadin-grid>
    <vaadin-grid id="heimTrefferGrid" is-attached multi-sort-priority="prepend"></vaadin-grid>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout style="width: 50%;">
    <vaadin-horizontal-layout style="width: 100%;">
     <label id="labelAusw" style="padding: var(--lumo-space-s);">Auswärts</label>
     <label id="labelAuswName" style="padding: var(--lumo-space-s);">Test</label>
    </vaadin-horizontal-layout>
    <vaadin-grid id="gridAuswSpieler" is-attached multi-sort-priority="prepend"></vaadin-grid>
    <vaadin-grid id="auswTrefferGrid" is-attached multi-sort-priority="prepend"></vaadin-grid>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
  }
}
