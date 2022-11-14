import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/grid/src/vaadin-grid.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/number-field/src/vaadin-number-field.js';
import '@vaadin/checkbox/src/vaadin-checkbox.js';
import '@vaadin/button/src/vaadin-button.js';

@customElement('treffer-view')
export class TrefferView extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <h2>Treffer</h2>
 <vaadin-grid id="daGriddy" style="height: 50%;" is-attached multi-sort-priority="prepend"></vaadin-grid>
 <vaadin-vertical-layout style="height: 50%; width: 100%;">
  <h2>Anlegen</h2>
  <vaadin-horizontal-layout style="width: 100%; padding: var(--lumo-space-s); justify-content: space-around; align-items: stretch;" theme="spacing-s">
   <vaadin-number-field id="minute" style="align-self: center;" dir="numberfieldMinute" type="number" label="Minute"></vaadin-number-field>
   <vaadin-checkbox id="checkboxTreffer" style="align-self: center;" label="Eigentor?" type="checkbox" value="on"></vaadin-checkbox>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="width: 100%; justify-content: flex-end;" theme="spacing-xl">
   <vaadin-button id="buttonHauptseite" tabindex="0">
    Zurück zur Hauptseite
   </vaadin-button>
   <vaadin-button id="buttonSpeichern" tabindex="0">
    Speichern
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
