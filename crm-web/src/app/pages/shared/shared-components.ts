import {Type} from '@angular/core';
import {PageButtonsComponent} from './components/page-buttons/page-buttons.component';
import {PageHeaderComponent} from './components/page-header/page-header.component';
import {PageSearchFieldsComponent} from './components/page-search-fields/page-search-fields.component';
import {PageViewButtonsComponent} from './components/page-view-buttons/page-view-buttons.component';

export const SHARED_COMPONENTS: Array<Type<void>> = [
    PageHeaderComponent,
    PageButtonsComponent,
    PageViewButtonsComponent,
    PageSearchFieldsComponent,
];
