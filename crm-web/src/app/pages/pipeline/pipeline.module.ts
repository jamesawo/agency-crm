import {NgModule, Type} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {PipelineFilterComponent} from './_components/pipeline-filter/pipeline-filter.component';
import {PipelineTableComponent} from './_components/pipeline-table/pipeline-table.component';

import {PipelineRoutingModule} from './pipeline-routing.module';
import {PipelinesComponent} from './pipelines/pipelines.component';
import {StagesComponent} from './stages/stages.component';

const COMPONENTS: Array<Type<any>> = [
    StagesComponent,
    PipelinesComponent,
    PipelineFilterComponent,
    PipelineTableComponent,
];

@NgModule({
    declarations: [
        ...COMPONENTS,
    ],
    imports: [
        SharedModule,
        PipelineRoutingModule,
    ],
    exports: [
        SharedModule,
        ...COMPONENTS,
    ],
})
export class PipelineModule {
}
