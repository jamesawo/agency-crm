import {Injectable} from '@angular/core';
import {Store, StoreConfig} from '@datorama/akita';
import {PageView} from '../data/shared.enum';


export interface PipelineUIState {
    currentView: PageView;
}

export interface UIState {
    key: string;
    pipeline: PipelineUIState;
}

export function createInitialUIState(state?: UIState): UIState {
    if (state) {
        return state;
    } else {
        return {
            key: '',
            pipeline: {
                currentView: PageView.TABLE,
            },
        };
    }
}

@Injectable({providedIn: 'root'})
@StoreConfig({name: 'UiStore'})
export class UIStore extends Store<UIState> {
    constructor() {
        const persistedState = JSON.parse(localStorage.getItem('uiState'));
        super(createInitialUIState(persistedState));
    }
}
