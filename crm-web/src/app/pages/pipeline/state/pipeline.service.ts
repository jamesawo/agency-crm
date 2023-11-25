import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {Pipeline} from './pipeline.model';
import {PipelineStore} from './pipeline.store';

@Injectable({providedIn: 'root'})
export class PipelineService {
    private url = environment.baseApiUrl + '/pipelines/';

    constructor(
        private store: PipelineStore,
        private http: HttpClient,
    ) {
    }

    getAll() {
        return this.http.get<Pipeline[]>(`${this.url}/all`);
        // .pipe(tap((entries) => this.store.set(entries)));
    }

    update(id: string, pipeline: Partial<Pipeline>) {
        this.store.update('', pipeline);
    }
}
