import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {IResponse} from '../../shared/data/shared.interface';
import {Pipeline, PipelineSearchParam} from '../_data/pipeline.class';

@Injectable({providedIn: 'root'})
export class PipelineService {
    private url = environment.baseApiUrl + '/pipelines';

    constructor(
        private http: HttpClient,
    ) {
    }

    create(pipeline: Pipeline) {
        return this.http.post<IResponse<Pipeline>>(`${this.url}`,
            pipeline, {observe: 'response'});
    }


    update(id: string, pipeline: Partial<Pipeline>) {
    }

    search(searchParam: PipelineSearchParam) {
        return this.http.post<any>(`${this.url}/search`, searchParam);
    }
}
