import {Injectable} from '@angular/core';
import {EntityState, EntityStore, QueryEntity, StoreConfig} from '@datorama/akita';
import {IPipeline} from './pipeline.model';

export interface PipelineState extends EntityState<IPipeline, string> {
}


@Injectable({providedIn: 'root'})
@StoreConfig({name: 'pipelines'})
export class PipelineStore extends EntityStore<PipelineState> {
    constructor() {
        super();
    }
}

@Injectable({providedIn: 'root'})
export class PipelineQuery extends QueryEntity<PipelineState> {

    constructor(protected store: PipelineStore) {
        super(store);
    }

}

