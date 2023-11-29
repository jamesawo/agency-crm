import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {CoreModule} from './@core/core.module';
import {ThemeModule} from './@theme/theme.module';
import {NB_ROOT_MODULES} from './app-nb-modules';
import {AppRoutingModule} from './app-routing.module';
import {THIRD_MODULES} from './app-third-modules';
import {AppComponent} from './app.component';

@NgModule({
    declarations: [AppComponent],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        HttpClientModule,
        AppRoutingModule,
        CoreModule.forRoot(),
        ThemeModule.forRoot(),
        ...NB_ROOT_MODULES,
        ...THIRD_MODULES,
    ],
    bootstrap: [AppComponent],
})
export class AppModule {
}
