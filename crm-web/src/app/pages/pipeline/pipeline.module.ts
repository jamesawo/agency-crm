import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {PIPELINE_COMPONENTS} from './pipeline-component-import';
import {PipelineRoutingModule} from './pipeline-routing.module';
import {PipelineStore} from './state/pipeline.store';


@NgModule({
    declarations: [
        ...PIPELINE_COMPONENTS,
    ],
    imports: [
        SharedModule,
        PipelineRoutingModule,
    ],
    exports: [
        SharedModule,
        ...PIPELINE_COMPONENTS,
    ],
    providers: [
        PipelineStore,
    ],
})
export class PipelineModule {
}
