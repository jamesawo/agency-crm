import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {PageView} from '../../../shared/data/shared.enum';
import {UIQuery} from '../../../shared/state/shared.query';

@Component({
    selector: 'ngx-pipeline-data-renderer',
    templateUrl: './pipeline-data-renderer.component.html',
    styles: [],
})
export class PipelineDataRendererComponent implements OnInit {
    currentView: Observable<PageView> = new Observable<PageView>();
    protected readonly PageView = PageView;

    constructor(private uiQuery: UIQuery) {
    }

    ngOnInit(): void {
        this.currentView = this.uiQuery.pipelinePref$
            .pipe(map(value => value.currentView));
    }
}
