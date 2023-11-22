import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {SHARED_COMPONENTS} from './shared-components';
import {SHARED_MODULES} from './shared-module';
import {SHARED_NEBULA_MODULES} from './shared-nebula-module';

@NgModule({
    declarations: [...SHARED_COMPONENTS],
    imports: [
        CommonModule,
        ...SHARED_MODULES,
        ...SHARED_NEBULA_MODULES,
    ],
    exports: [
        ...SHARED_COMPONENTS,
        ...SHARED_MODULES,
        ...SHARED_NEBULA_MODULES,
    ],
})
export class SharedModule {
}
