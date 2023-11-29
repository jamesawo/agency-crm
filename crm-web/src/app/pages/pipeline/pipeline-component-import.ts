import {Type} from '@angular/core';
import {PipelineDataRendererComponent} from './_components/pipeline-data-renderer/pipeline-data-renderer.component';
import {PipelineFilterComponent} from './_components/pipeline-filter/pipeline-filter.component';
import {PipelineGridComponent} from './_components/pipeline-grid/pipeline-grid.component';
import {PipelineListComponent} from './_components/pipeline-list/pipeline-list.component';
import {PipelineSaveComponent} from './_components/pipeline-save/pipeline-save.component';
import {PipelineStageBodyComponent} from './_components/pipeline-stage-body/pipeline-stage-body.component';
import {PipelineStageHeaderComponent} from './_components/pipeline-stage-header/pipeline-stage-header.component';
import {PipelineStageComponent} from './_components/pipeline-stage/pipeline-stage.component';
import {PipelineTableComponent} from './_components/pipeline-table/pipeline-table.component';
import {PipelinesComponent} from './pipelines/pipelines.component';
import {StagesComponent} from './stages/stages.component';

export const PIPELINE_COMPONENTS: Array<Type<any>> = [
    StagesComponent,
    PipelinesComponent,
    PipelineFilterComponent,
    PipelineTableComponent,
    PipelineDataRendererComponent,
    PipelineGridComponent,
    PipelineListComponent,
    PipelineSaveComponent,
    PipelineStageComponent,
    PipelineStageHeaderComponent,
    PipelineStageBodyComponent
];
