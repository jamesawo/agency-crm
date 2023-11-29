import {Component, Input, OnInit} from '@angular/core';
import {Pipeline, Stage} from '../../state/pipeline.class';

@Component({
    selector: 'ngx-pipeline-stage-body',
    templateUrl: './pipeline-stage-body.component.html',
    styleUrls: ['./pipeline-stage-body.component.scss'],
})
export class PipelineStageBodyComponent implements OnInit {

    @Input()
    pipeline: Pipeline;

    constructor() {
    }

    ngOnInit(): void {
    }

    onRemoveStage(arg: { stage: Stage, pipeline: Pipeline }): void {
        arg.pipeline.removeStage(arg.stage);
    }

}
