import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {SHARED_COMPONENTS} from './shared-components';
import {SHARED_MODULES, SHARED_PROVIDERS} from './shared-module';
import {SHARED_NEBULA_MODULES} from './shared-nebula-module';
import {SHARED_THIRD_MODULES} from './shared-third-module';

@NgModule({
    declarations: [
        ...SHARED_COMPONENTS,
    ],
    imports: [
        CommonModule,
        ...SHARED_MODULES,
        ...SHARED_NEBULA_MODULES,
        ...SHARED_THIRD_MODULES,
    ],
    exports: [
        ...SHARED_COMPONENTS,
        ...SHARED_MODULES,
        ...SHARED_NEBULA_MODULES,
        ...SHARED_THIRD_MODULES,
    ],
    providers: [
        ...SHARED_PROVIDERS,
    ],
})
export class SharedModule {
}
