import {Type} from '@angular/core';
import {
    NbButtonModule,
    NbCardModule,
    NbIconModule,
    NbLayoutModule,
    NbMenuModule,
    NbPopoverModule,
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
];
