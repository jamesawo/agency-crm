import {Injectable} from '@angular/core';
import {EntityState, EntityStore, StoreConfig} from '@datorama/akita';
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
