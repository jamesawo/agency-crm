import {Component, Input, OnInit} from '@angular/core';
import {Pipeline, Stage} from '../../state/pipeline.class';

@Component({
    selector: 'ngx-pipeline-stage-header',
    templateUrl: './pipeline-stage-header.component.html',
    styles: [],
})
export class PipelineStageHeaderComponent implements OnInit {

    @Input()
    pipeline?: Pipeline;

    constructor() {
    }

    ngOnInit(): void {
    }

    onAddStage() {

        if (this.pipeline) {
            this.pipeline.addStage(new Stage());
        }

        console.log('adding stage to pipeline, ', this.pipeline);
    }
}
