import {Injectable} from '@angular/core';
import {QueryEntity} from '@datorama/akita';
import {PipelineState, PipelineStore} from './pipeline.store';

@Injectable({providedIn: 'root'})
export class PipelineQuery extends QueryEntity<PipelineState> {
    constructor(protected store: PipelineStore) {
        super(store);
    }

}
