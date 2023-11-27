import {Injectable} from '@angular/core';
import {Query} from '@datorama/akita';
import {Observable} from 'rxjs';
import {PageView} from '../data/shared.enum';
import {PipelineUIState, UIState, UIStore} from './shared.store';

@Injectable({providedIn: 'root'})
export class UIQuery extends Query<UIState> {
    pipelinePref$: Observable<PipelineUIState> = this.select('pipeline');

    constructor(protected store: UIStore) {
        super(store);

    }

    getPipelineView(): PageView {
        return this.getState().pipeline.currentView ?? PageView.TABLE;
    }

    updatePipelineView(newView: PageView) {
        this.store.update({
            pipeline: {
                currentView: newView,
            },
        });
        this.persistStateInLocal();
    }

    private getState(): UIState {
        return this.store.getValue();
    }

    private persistStateInLocal() {
        localStorage.setItem('uiState', JSON.stringify(this.store.getValue()));
    }
}
