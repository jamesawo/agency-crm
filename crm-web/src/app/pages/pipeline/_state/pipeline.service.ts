import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';
import {IPaginate} from '../../shared/data/shared.interface';
import {PageResponse, UnPageResponse} from '../../shared/data/shared.types';
import {Pipeline, PipelineSearchParam} from '../_data/pipeline.class';

@Injectable({providedIn: 'root'})
export class PipelineService {
    public searchResult: BehaviorSubject<IPaginate<Pipeline[]>>;
    public searchResult$: Observable<IPaginate<Pipeline[]>>;

    private url = environment.baseApiUrl + '/pipelines';

    constructor(
        private http: HttpClient,
    ) {
        this.searchResult = new BehaviorSubject<any>(null);
        this.searchResult$ = this.searchResult.asObservable();
    }

    create(pipeline: Pipeline): Observable<UnPageResponse<Pipeline>> {
        return this.http.post<any>(`${this.url}`,
            pipeline, {observe: 'response'});
    }

    search(searchParam: PipelineSearchParam): Observable<PageResponse<Pipeline[]>> {
        return this.http.post<any>(`${this.url}/search`,
            searchParam, {observe: 'response'});
    }
}
