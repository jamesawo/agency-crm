import {NgModule} from '@angular/core';
import {NbLayoutModule} from '@nebular/theme';
import {MiscellaneousModule} from './miscellaneous/miscellaneous.module';
import {PagesRoutingModule} from './pages-routing.module';
import {PagesComponent} from './pages.component';
import {PipelineModule} from './pipeline/pipeline.module';
import {SharedModule} from './shared/shared.module';

@NgModule({
    exports: [
        NbLayoutModule,
        SharedModule,
    ],
    imports: [
        PagesRoutingModule,
        SharedModule,
        MiscellaneousModule,
        PipelineModule,
    ],
    declarations: [
        PagesComponent,
    ],
})
export class PagesModule {
}
