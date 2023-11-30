import {IValidationStatus} from '../../shared/data/shared.interface';
import {StageAction, StageReviewType, StageStatus} from '../_data/pipeline.enum';
import {IPipeline, IStage} from './pipeline.model';

export class Pipeline implements IPipeline {
    id: string = '';
    title: string = '';
    hierarchy: number = 0;
    // stages: Set<Stage> = new Set<Stage>();
    stages: Stage[] = [];

    constructor() {
    }

    addStage(stage: Stage): void {
        // if (this.stages.size < 5) {
        //     this.stages.add(stage);
        // }

        if (this.stages.length < 5) {
            this.stages.push(stage);
        }

    }

    removeStage(stage: Stage): void {
        // this.stages.delete(stage);
        this.stages = this.stages.filter(value => value !== stage);
    }

    reset(): void {
        // this.stages = new Set<Stage>();
        this.stages = [];
        this.title = '';
        this.id = '';
        this.hierarchy = 0;
    }

}

export class Stage implements IStage {
    id: string = '';
    hierarchy: number = 0;
    action: StageAction = StageAction.FILE_UPLOAD;
    reviewType: StageReviewType = StageReviewType.MANUAL;
    stageValue: string = '';
    status: StageStatus = StageStatus.OPEN;
    title: string = '';
    validation: IValidationStatus = {status: true, message: ''};

    constructor(title = '') {
        this.title = title;
    }
}
