import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {UIStore} from './shared.store';

@Injectable({providedIn: 'root'})
export class UiService {
    constructor(private uiStore: UIStore, private http: HttpClient) {
    }
}
