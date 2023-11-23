import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PipelinesComponent} from './pipelines/pipelines.component';
import {StagesComponent} from './stages/stages.component';

const routes: Routes = [
    {
        path: 'steps',
        component: StagesComponent,
    },
    {
        path: 'pipelines',
        component: PipelinesComponent,
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class PipelineRoutingModule {
}
