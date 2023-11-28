import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {NbWindowService} from '@nebular/theme';
import {environment} from '../../../../environments/environment';
import {IPipeline} from './pipeline.model';
import {PipelineStore} from './pipeline.store';

@Injectable({providedIn: 'root'})
export class PipelineService {
    private url = environment.baseApiUrl + '/pipelines/';

    constructor(
        private store: PipelineStore,
        private http: HttpClient,
        private nbWindowService: NbWindowService
    ) {
    }

    static onAddButtonClick(): void {
        console.log('This is a static function.');
    }

    getAll() {
        return this.http.get<IPipeline[]>(`${this.url}/all`);
    }

    update(id: string, pipeline: Partial<IPipeline>) {
        this.store.update('', pipeline);
    }
}
