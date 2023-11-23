import {CommonModule} from '@angular/common';
import {Type} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';

export const SHARED_MODULES: Array<Type<void>> = [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
];
