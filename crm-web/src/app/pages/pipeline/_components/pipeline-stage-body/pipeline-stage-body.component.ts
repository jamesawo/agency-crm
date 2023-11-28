import {AfterViewInit, Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Pipeline, Stage} from '../../state/pipeline.class';

@Component({
    selector: 'ngx-pipeline-stage-body',
    templateUrl: './pipeline-stage-body.component.html',
    styleUrls: ['./pipeline-stage-body.component.scss'],
})
export class PipelineStageBodyComponent implements OnInit, OnChanges, AfterViewInit {

    @Input()
    pipeline: Pipeline;

    constructor() {
    }

    ngOnChanges(changes: SimpleChanges): void {
        console.log(changes);
    }

    ngOnInit(): void {
    }


    removeStage(stage: Stage) {
        console.log(this.pipeline);
        // this.pipeline.stages = new Set<Stage>([]);

        // const stages = this.pipeline?.stages;
    }

    ngAfterViewInit(): void {
        console.log(this.pipeline);
    }

}
