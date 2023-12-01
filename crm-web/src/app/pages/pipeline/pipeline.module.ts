import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {PIPELINE_COMPONENTS} from './pipeline-component-import';
import {PipelineRoutingModule} from './pipeline-routing.module';


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
    providers: [],
})
export class PipelineModule {
}
