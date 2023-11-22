import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NotFoundComponent} from '../miscellaneous/not-found/not-found.component';

const routes: Routes = [
    {
        path: 'agents',
        component: NotFoundComponent,
    }, {
        path: 'tasks',
        component: NotFoundComponent,
    }, {
        path: 'teams',
        component: NotFoundComponent,
    }, {
        path: 'clients',
        component: NotFoundComponent,
    }, {
        path: 'view-performances',
        component: NotFoundComponent,
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class AgentRoutingModule {
}
