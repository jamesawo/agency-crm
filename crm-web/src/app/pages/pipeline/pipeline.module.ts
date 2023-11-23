import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';

import {PipelineRoutingModule} from './pipeline-routing.module';
import {PipelinesComponent} from './pipelines/pipelines.component';
import {StagesComponent} from './stages/stages.component';


@NgModule({
    declarations: [
        StagesComponent,
        PipelinesComponent,
    ],
    imports: [
        SharedModule,
        PipelineRoutingModule,
    ],
})
export class PipelineModule {
}
