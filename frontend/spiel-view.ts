import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/grid/src/vaadin-grid.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/checkbox/src/vaadin-checkbox.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/date-picker/src/vaadin-date-picker.js';
import '@vaadin/combo-box/src/vaadin-combo-box.js';

@customElement('spiel-view')
export class SpielView extends LitElement {
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
 <h2>Vertrag</h2>
 <vaadin-grid id="daGriddy" style="height: 50%;" is-attached multi-sort-priority="prepend"></vaadin-grid>
 <vaadin-vertical-layout style="height: 50%; width: 100%; padding: var(--lumo-space-s);">
  <h2>Anlegen</h2>
  <vaadin-horizontal-layout style="padding: var(--lumo-space-s); justify-content: space-around; align-items: stretch; width: 100%;" theme="spacing-s">
   <vaadin-date-picker id="datepicker" label="Datum"></vaadin-date-picker>
   <vaadin-combo-box id="comboboxAusw" label="Auswärts-Mannschaft"></vaadin-combo-box>
   <vaadin-combo-box id="schiribox" label="Schiri"></vaadin-combo-box>
   <vaadin-combo-box id="comboboxHeim" label="Heim-Mannschaft"></vaadin-combo-box>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="width: 100%; justify-content: flex-end;" theme="spacing-xl">
   <vaadin-button id="buttonSpeichern" tabindex="0">
     Speichern 
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
  }
}
