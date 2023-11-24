import {Component, OnInit} from '@angular/core';
import {PageView} from '../../../shared/data/shared.enum';

@Component({
    selector: 'ngx-pipeline-data-renderer',
    templateUrl: './pipeline-data-renderer.component.html',
    styles: [],
})
export class PipelineDataRendererComponent implements OnInit {
    currentView: PageView = PageView.TABLE;
    protected readonly PageView = PageView;

    constructor() {
    }

    ngOnInit(): void {
    }
}
