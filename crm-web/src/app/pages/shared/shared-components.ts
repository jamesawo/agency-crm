import {Type} from '@angular/core';
import {PageButtonsComponent} from './components/page-buttons/page-buttons.component';
import {PageDrawerComponent} from './components/page-drawer/page-drawer.component';
import {PageHeaderComponent} from './components/page-header/page-header.component';
import {PageIconButtonComponent} from './components/page-icon-button/page-icon-button.component';
import {PageSearchFieldsComponent} from './components/page-search-fields/page-search-fields.component';
import {PageSpacerComponent} from './components/page-spacer/page-spacer.component';
import {PageTableComponent} from './components/page-table/page-table.component';
import {PageViewButtonsComponent} from './components/page-view-buttons/page-view-buttons.component';

export const SHARED_COMPONENTS: Array<Type<void>> = [
    PageHeaderComponent,
    PageButtonsComponent,
    PageViewButtonsComponent,
    PageSearchFieldsComponent,
    PageSpacerComponent,
    PageIconButtonComponent,
    PageTableComponent,
    PageDrawerComponent,
];
