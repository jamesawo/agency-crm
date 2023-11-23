import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {MiscellaneousRoutingModule} from './miscellaneous-routing.module';
import {MiscellaneousComponent} from './miscellaneous.component';
import {NotFoundComponent} from './not-found/not-found.component';

@NgModule({
    imports: [
        SharedModule,
        MiscellaneousRoutingModule,
    ],
    declarations: [
        MiscellaneousComponent,
        NotFoundComponent,
    ],
})
export class MiscellaneousModule {
}
