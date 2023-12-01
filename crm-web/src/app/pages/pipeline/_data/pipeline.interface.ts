import {StageAction, StageReviewType, StageStatus} from './pipeline.enum';

export interface IStage {
    title: string;
    action: StageAction;
    reviewType: StageReviewType;
    status: StageStatus;
    hierarchy: number;
    stageValue: string;
}

export interface IPipeline {
    id: string;
    title: string;
    hierarchy: number;
    stages: IStage[];
}
