import {CommonModule} from '@angular/common';
import {Type} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {UIStore} from './state/shared.store';

export const SHARED_MODULES: Array<Type<void>> = [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
];

export const SHARED_PROVIDERS: Array<Type<void>> = [
    UIStore,
];
