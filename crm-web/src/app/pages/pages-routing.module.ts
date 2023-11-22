import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NotFoundComponent} from './miscellaneous/not-found/not-found.component';
import {WelcomeComponent} from './miscellaneous/welcome/welcome.component';

import {PagesComponent} from './pages.component';

const routes: Routes = [{
    path: '',
    component: PagesComponent,
    children: [
        {
            path: '',
            component: WelcomeComponent,
        },
        {
            path: 'dashboard',
            loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule),
        },
        {
            path: 'pipelines',
            loadChildren: () => import('./pipeline/pipeline.module').then(m => m.PipelineModule),
        },
        {
            path: 'tasks',
            loadChildren: () => import('./task/task.module').then(m => m.TaskModule),
        },
        {
            path: 'teams',
            loadChildren: () => import('./team/team.module').then(m => m.TeamModule),
        },
        {
            path: 'supervisors',
            loadChildren: () => import('./supervisor/supervisor.module').then(m => m.SupervisorModule),
        },
        {
            path: 'agents',
            loadChildren: () => import('./agent/agent.module').then(m => m.AgentModule),
        },
        {
            path: 'authorization',
            loadChildren: () => import('./authorization/authorization.module').then(m => m.AuthorizationModule),
        },
        {
            path: '**',
            component: NotFoundComponent,
        },
    ],
}];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class PagesRoutingModule {
}
