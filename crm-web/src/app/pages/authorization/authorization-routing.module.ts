import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NotFoundComponent} from '../miscellaneous/not-found/not-found.component';

const routes: Routes = [
    {
        path: 'users',
        component: NotFoundComponent,
    },
    {
        path: 'roles',
        component: NotFoundComponent,
    },
    {
        path: 'permissions',
        component: NotFoundComponent,
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class AuthorizationRoutingModule {
}
