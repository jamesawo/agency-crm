import {Type} from '@angular/core';
import {
    NbAccordionModule,
    NbButtonGroupModule,
    NbButtonModule,
    NbCardModule,
    NbCheckboxModule,
    NbDatepickerModule,
    NbIconModule,
    NbInputModule,
    NbLayoutModule,
    NbMenuModule,
    NbPopoverModule,
    NbSelectModule,
    NbTooltipModule,
    NbTreeGridModule,
} from '@nebular/theme';
import {ThemeModule} from '../../@theme/theme.module';

export const SHARED_NEBULA_MODULES: Array<Type<void>> = [
    ThemeModule,
    NbMenuModule,
    NbLayoutModule,
    NbCardModule,
    NbButtonModule,
    NbIconModule,
    NbPopoverModule,
    NbCheckboxModule,
    NbInputModule,
    NbAccordionModule,
    NbDatepickerModule,
    NbButtonGroupModule,
    NbTooltipModule,
    NbTreeGridModule,
    NbSelectModule,
];
