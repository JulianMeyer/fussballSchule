import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/grid/src/vaadin-grid.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/checkbox/src/vaadin-checkbox.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/combo-box/src/vaadin-combo-box.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/number-field/src/vaadin-number-field.js';

@customElement('spieler-view')

export class SpielerView extends LitElement {
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
 <h2>Spieler</h2>
 <vaadin-grid id="daGriddy" style="height: 30%;" is-attached multi-sort-priority="prepend"></vaadin-grid>
 <vaadin-vertical-layout style="height: 50%; width: 100%; padding: var(--lumo-space-s);">
  <h2>Anlegen</h2>
  <vaadin-horizontal-layout style="padding: var(--lumo-space-s); justify-content: space-around; align-items: stretch; width: 100%;" theme="spacing-s">
   <vaadin-text-field id="textFieldSpieler" type="text" label="Name"></vaadin-text-field>
   <vaadin-number-field id="trikotnummer" type="number" label="Trikotnummer"></vaadin-number-field>
   <vaadin-combo-box id="position" label="Position"></vaadin-combo-box>
   <vaadin-number-field id="elfmeter" style="align-self: center;" dir="numberfieldMinute" type="number" label="Elfmeter gehalten"></vaadin-number-field>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="width: 100%; justify-content: flex-end;" theme="spacing-xl">
   <vaadin-button id="buttonSpeichern" tabindex="0">
     Speichern 
   </vaadin-button>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="width: 100%;">
   <vaadin-vertical-layout style="height: 50%; width: 100%; padding: var(--lumo-space-s);">
    <h2>Treffer</h2>
    <vaadin-horizontal-layout style="padding: var(--lumo-space-s); justify-content: space-around; align-items: stretch; width: 100%;" theme="spacing-s">
     <vaadin-number-field id="minute" style="align-self: center;" dir="numberfieldMinute" type="number" label="Minute"></vaadin-number-field>
     <vaadin-checkbox id="checkboxTreffer" style="align-self: center;" label="Eigentor?" type="checkbox" value="on"></vaadin-checkbox>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout style="width: 100%; justify-content: flex-end;" theme="spacing-xl">
     <vaadin-button id="buttonHinzuf??gen" tabindex="0">
       Hinzuf??gen 
     </vaadin-button>
    </vaadin-horizontal-layout>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
  }
}
