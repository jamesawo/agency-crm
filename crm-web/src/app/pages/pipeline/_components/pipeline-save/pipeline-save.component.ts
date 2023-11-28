import {Component, OnInit} from '@angular/core';
import {Pipeline} from '../../state/pipeline.class';

@Component({
    selector: 'ngx-pipeline-save',
    templateUrl: './pipeline-save.component.html',
    styleUrls: ['./pipeline-save.component.scss']
})
export class PipelineSaveComponent implements OnInit {

    pipeline: Pipeline;

    constructor() {
    }

    ngOnInit(): void {
        this.pipeline = new Pipeline();
    }
}
