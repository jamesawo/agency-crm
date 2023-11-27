import {Injectable} from '@angular/core';
import {EntityState, EntityStore, StoreConfig} from '@datorama/akita';
import {Pipeline} from './pipeline.model';

export interface PipelineState extends EntityState<Pipeline, string> {
}


@Injectable({providedIn: 'root'})
@StoreConfig({name: 'pipelines'})
export class PipelineStore extends EntityStore<PipelineState> {
    constructor() {
        super();
    }


}
