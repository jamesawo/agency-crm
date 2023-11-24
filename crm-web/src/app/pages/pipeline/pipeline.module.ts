import {NgModule, Type} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {PipelineDataRendererComponent} from './_components/pipeline-data-renderer/pipeline-data-renderer.component';
import {PipelineFilterComponent} from './_components/pipeline-filter/pipeline-filter.component';
import {PipelineGridComponent} from './_components/pipeline-grid/pipeline-grid.component';
import {PipelineListComponent} from './_components/pipeline-list/pipeline-list.component';
import {PipelineTableComponent} from './_components/pipeline-table/pipeline-table.component';

import {PipelineRoutingModule} from './pipeline-routing.module';
import {PipelinesComponent} from './pipelines/pipelines.component';
import {StagesComponent} from './stages/stages.component';

const COMPONENTS: Array<Type<any>> = [
    StagesComponent,
    PipelinesComponent,
    PipelineFilterComponent,
    PipelineTableComponent,
    PipelineDataRendererComponent,
    PipelineGridComponent,
    PipelineListComponent,
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
