import {StageAction, StageReviewType, StageStatus} from '../_data/pipeline.enum';
import {IPipeline, IStage} from './pipeline.model';

export class Pipeline implements IPipeline {
    id: string = '';
    title: string = '';
    hierarchy: number = 1;
    stages: Set<Stage> = new Set<Stage>([]);

    constructor() {
    }

    addStage(stage: Stage): void {
        if (this.stages.size < 5) {
            this.stages.add(stage);
            // this.stages = [...this.stages, stage];
        }
    }

    removeStage(args: { stage: Stage, pipeline: Pipeline }): void {
        console.log('removing stage ', args.stage);
        console.log('removing stage from this pipeline', args.pipeline);

        this.stages.delete(args.stage);

        // if (this.stages?.size > 0) {
        //     console.log('yes removed, ', stage);
        //     const b = this.stages.delete(stage);
        //     console.log(b);
        //     // this.stages = [...this.stages.filter(existingStage => existingStage !== stage)];
        // }
    }

}

export class Stage implements IStage {
    action: StageAction = StageAction.FILE_UPLOAD;
    hierarchy: number = 0;
    reviewType: StageReviewType = StageReviewType.MANUAL;
    stageValue: string = '';
    status: StageStatus = StageStatus.OPEN;
    title: string = '';

    constructor(title = '') {
        this.title = title;
    }
}
