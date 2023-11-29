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
        }
    }

    removeStage(stage: Stage): void {
        this.stages.delete(stage);
    }

}

export class Stage implements IStage {
    action: StageAction = StageAction.FILE_UPLOAD;
    hierarchy: number = 0;
    reviewType: StageReviewType = StageReviewType.MANUAL;
    stageValue: string = '';
    status: StageStatus = StageStatus.OPEN;
    title: string = '';
    id: string = '';

    constructor(title = '') {
        this.title = title;
    }
}
