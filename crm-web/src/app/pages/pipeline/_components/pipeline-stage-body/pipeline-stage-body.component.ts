import {Component, Input, OnInit} from '@angular/core';
import {Pipeline, Stage} from '../../_data/pipeline.class';

@Component({
    selector: 'ngx-pipeline-stage-body',
    templateUrl: './pipeline-stage-body.component.html',
    styleUrls: ['./pipeline-stage-body.component.scss'],
})
export class PipelineStageBodyComponent implements OnInit {

    @Input()
    pipeline?: Pipeline;

    constructor() {
    }

    ngOnInit(): void {
    }

    setHierarchy(hierarchy: number, stage: Stage): Stage {
        stage.hierarchy = hierarchy;
        return stage;
    }

    onRemoveStage(arg: { stage: Stage, pipeline: Pipeline }): void {
        arg.pipeline.removeStage(arg.stage);
    }

}
