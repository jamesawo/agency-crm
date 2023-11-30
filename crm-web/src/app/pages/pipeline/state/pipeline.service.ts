import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {IResponse} from '../../shared/data/shared.interface';
import {Pipeline} from './pipeline.class';
import {IPipeline} from './pipeline.model';
import {PipelineStore} from './pipeline.store';

@Injectable({providedIn: 'root'})
export class PipelineService {
    private url = environment.baseApiUrl + '/pipelines';

    constructor(
        private store: PipelineStore,
        private http: HttpClient,
    ) {
    }

    create(pipeline: Pipeline) {
        return this.http.post<IResponse<Pipeline>>(`${this.url}`,
            pipeline, {observe: 'response'});
    }


    update(id: string, pipeline: Partial<IPipeline>) {
        this.store.update('', pipeline);
    }
}
