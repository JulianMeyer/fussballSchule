import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/grid/src/vaadin-grid.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/text-field/src/vaadin-text-field.js';

@customElement('mannschaft-view')
export class MannschaftView extends LitElement {
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
 <h2>Mannschaft</h2>
 <vaadin-grid id="daGriddy" style="height: 30%;" is-attached multi-sort-priority="prepend"></vaadin-grid>
 <vaadin-vertical-layout style="height: 100%; width: 100%; padding: var(--lumo-space-s);">
  <h2>Anlegen</h2>
  <vaadin-horizontal-layout style="padding: var(--lumo-space-s); justify-content: space-around; align-items: stretch; width: 100%;" theme="spacing-s">
   <vaadin-text-field id="textFieldName" type="text" label="Name"></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="width: 100%; justify-content: flex-end;" theme="spacing-xl">
   <vaadin-button id="buttonSpeichern" tabindex="0">
     Speichern 
   </vaadin-button>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="width: 100%;">
   <vaadin-vertical-layout style="height: 50%; width: 100%; padding: var(--lumo-space-s);">
    <h2>Vertrag </h2>
    <vaadin-horizontal-layout style="padding: var(--lumo-space-s); justify-content: space-around; align-items: stretch; width: 100%;" theme="spacing-s">
     <vaadin-grid id="GridVertrag" is-attached multi-sort-priority="prepend"></vaadin-grid>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout style="width: 100%; justify-content: flex-end;" theme="spacing-xl">
     <vaadin-button id="buttonHinzufügen" tabindex="0">
       Hinzufügen 
     </vaadin-button>
    </vaadin-horizontal-layout>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
  }
}
