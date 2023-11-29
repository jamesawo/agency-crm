import {Component, Input, OnInit} from '@angular/core';
import {Stage} from '../../state/pipeline.class';

@Component({
    selector: 'ngx-pipeline-stage',
    templateUrl: './pipeline-stage.component.html',
    styleUrls: ['./pipeline-stage.component.scss'],
})
export class PipelineStageComponent implements OnInit {
    @Input()
    stage?: Stage;

    constructor() {
    }

    ngOnInit(): void {
    }

}
