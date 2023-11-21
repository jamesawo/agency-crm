import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';

import {PagesComponent} from './pages.component';
import {NotFoundComponent} from './miscellaneous/not-found/not-found.component';
import {WelcomeComponent} from './miscellaneous/welcome/welcome.component';

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
            path: 'pipeline',
            loadChildren: () => import('./pipeline/pipeline-routing.module').then(m => m.PipelineRoutingModule),
        },
        {
            path: 'task',
            loadChildren: () => import('./task/task.module').then(m => m.TaskModule),
        },
        {
            path: 'team',
            loadChildren: () => import('./team/team.module').then(m => m.TeamModule),
        },
        {
            path: 'supervisor',
            loadChildren: () => import('./supervisor/supervisor.module').then(m => m.SupervisorModule),
        },
        {
            path: 'agent',
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
